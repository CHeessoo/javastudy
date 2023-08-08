package ex02_api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class NaverCaptcha {

  private static final String CLIENT_ID = "i8c_oqXanvYAot3MyrU7";
  private static final String CLIENT_SECRET = "2JiF7i7Eaq";

  /**
   * 네이버개발자센터 캡차키 요청 메소드
   * 
   * @return 캡차키 반환
   */
  private static String getKey() {

    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    String result = null;

    try {

      String spec = "https://openapi.naver.com/v1/captcha/nkey?code=0"; // ?code=0 생략가능

      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();

      con.setRequestMethod("GET"); // 요청 HTTP 메서드

      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);

      int responseCode = con.getResponseCode();
      if (responseCode != HttpURLConnection.HTTP_OK) { // 정상 연결 여부 확인
        throw new RuntimeException(responseCode + "발생");
      }

      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

      StringBuilder sb = new StringBuilder();
      String line = null;
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }

//      System.out.println(sb.toString());

      JSONObject obj = new JSONObject(sb.toString());
      result = obj.getString("key");

    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (reader != null)
          reader.close();
        if (con != null)
          con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return result;

  }

  /**
   * 네이버개발자센터 캡차 이미지 요청 메소드
   */
  private static String getImage() {

    URL url = null;
    HttpURLConnection con = null;
    BufferedInputStream bin = null; // 읽어들인 이미지를
    BufferedOutputStream bout = null; // PC에 저장
    
    String key = null;

    try {
      
      key = getKey();

      String spec = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key; // 발급받은 캡차키를 다시 전달

      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();

      con.setRequestMethod("GET");

      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);

      // 응답 코드
      int responseCode = con.getResponseCode();
      if (responseCode != HttpURLConnection.HTTP_OK) { // 정상 연결 여부
        throw new RuntimeException(responseCode + " 발생");
      }

      // 입력스트림 생성
      bin = new BufferedInputStream(con.getInputStream());

      // File 객체로 디렉터리와 파일 생성
      File dir = new File("C:/storage");
      if (dir.exists() == false) {
        dir.mkdirs();
      }
      File file = new File(dir, System.currentTimeMillis() + ".jpg"); // 중복 발생 방지

      // 출력스트림 생성
      bout = new BufferedOutputStream(new FileOutputStream(file));

      byte[] b = new byte[1024]; // 1키로바이트씩 옮김
      int readByte = 0; // 실제로 읽은 바이트 수를 저장하는 변수

      while ((readByte = bin.read(b)) != -1) { // b에 읽어온 이미지를 저장
        bout.write(b, 0, readByte); // byte[] b에 저장된 정보를 출력스트림(bout)의 인텍스 0부터 readByte만큼만 전달
      }

//      System.out.println(file.getPath() + " 파일 생성");

    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (bout != null)
          bout.close();
        if (bin != null)
          bin.close();
        if (con != null)
          con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return key;
  }

  /**
   * 사용자 입력값 검증 요청<br>
   * 캡차키와 이미지를 받아온 뒤,<br>
   * 사용자가 이미지를 보고 입력한 값을 받아서 키값과 이미지 내용이 동일한지 검사한다.<br>
   * 
   * {"result":true,"responseTime":84.6}<br>
   * result : true / false 여부를 반환 <br>
   * responseTime : 응답에 걸린 시간을 반환 (7200초를 초과했을 때는 -1을 반환)
   */
  private static void validInput() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
    try {
      
      String key = getImage();
      
      Scanner sc = new Scanner(System.in);
      System.out.print("입력 >> ");
      String value = sc.next();
      
      String spec = "https://openapi.naver.com/v1/captcha/nkey?code=1&key=" + key + "&value=" + value;
      
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection();
      
      // HTTP 요청 메소드 ( GET )
      con.setRequestMethod("GET"); // 반드시 대문자로
      // 요청 헤더
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) { // responseCode != 200
        throw new RuntimeException(responseCode + "발생");
      }
      
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      // 전체 데이터 모두 읽어 들이기
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line);    
      }
      
      JSONObject obj = new JSONObject(sb.toString());
      System.out.println("응답시간: " + obj.getDouble("responseTime"));
      if(obj.getBoolean("result")) {
        System.out.println("맞습니다.");
      } else {
        System.out.println("틀립니다.");
      }
      
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
    
  }
 
  public static void main(String[] args) {
    validInput();
  }

}
