package ex02_api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class NaverCaptcha {
  
  private static final String CLIENT_ID = "i8c_oqXanvYAot3MyrU7";
  private static final String CLIENT_SECRET = "2JiF7i7Eaq";
  
  /**
   * 네이버개발자센터 캡차키 요청 메소드
   * @return 캡차키 반환
   */
  private static String getKey() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    String result = null;
    
    try {
      
      String spec = "https://openapi.naver.com/v1/captcha/nkey?code=0";  // ?code=0 생략가능
      
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      con.setRequestMethod("GET"); // 요청 HTTP 메서드
      
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = con.getResponseCode();
      if (responseCode != HttpURLConnection.HTTP_OK) {  // 정상 연결 여부 확인
        throw new RuntimeException(responseCode + "발생");
      }
      
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      
      System.out.println(sb.toString());
      
      JSONObject obj = new JSONObject(sb.toString());
      result = obj.getString("key");
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    return result;
    
  }
  
  /**
   * 네이버개발자센터 캡차 이미지 요청 메소드
   */
  private static void getImage() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedInputStream bin = null;   // 읽어들인 이미지를
    BufferedOutputStream bout = null; // PC에 저장
    
    
    try {

      String key = getKey();
      String spec = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key; // 발급받은 캡차키를 다시 전달
      
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      con.setRequestMethod("GET");
      
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      // 응답 코드
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {   // 정상 연결 여부 
        throw new RuntimeException(responseCode + " 발생");
      }
      
      // 입력스트림 생성
      bin = new BufferedInputStream(con.getInputStream());
      
      // File 객체로 디렉터리와 파일 생성
      File dir = new File("C:/storage");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      File file = new File(dir, System.currentTimeMillis() + ".jpg"); // 중복 발생 방지
      
      // 출력스트림 생성
      bout = new BufferedOutputStream(new FileOutputStream(file));
      
      byte[] b = new byte[1024];  // 1키로바이트씩 옮김
      int readByte = 0; // 실제로 읽은 바이트 수를 저장하는 변수
      
      while((readByte = bin.read(b)) != -1) { // b에 읽어온 이미지를 저장
        bout.write(b, 0, readByte);  // byte[] b에 저장된 정보를 출력스트림(bout)의 인텍스 0부터 readByte만큼만 전달
      }
      
      System.out.println(file.getPath() + " 파일 생성");
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
    getImage();
    
  }

}
