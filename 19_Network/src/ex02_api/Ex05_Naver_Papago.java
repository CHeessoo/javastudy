package ex02_api;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;


// 네이버 파파고 번역 api 적용
public class Ex05_Naver_Papago {

  public static void main(String[] args) {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedOutputStream bout = null; // 서버로 POST 데이터 보내는 용도
    BufferedReader reader = null;
    
    try {
      
      Scanner sc = new Scanner(System.in);
      System.out.print("번역할 한국어 입력 >>> ");
      String text = sc.nextLine();
      
      String spec = "https://openapi.naver.com/v1/papago/n2mt";
      String clientId = "i8c_oqXanvYAot3MyrU7";
      String clientSecret = "2JiF7i7Eaq";
      
      String params = "source=ko&target=en&text=" + text; 
      
      url = new URL(spec);
      con = (HttpURLConnection) url.openConnection(); // 서버측 주소
      
      // 요청 메소드 POST (생략할 수 없다.)
      con.setRequestMethod("POST");
      
      // 요청 헤더 (clientId, clientSecret)
      con.setRequestProperty("X-Naver-Client-Id", clientId);
      con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
      
      // OutputStream을 이용해서 POST 데이터를 보내겠다.
      con.setDoOutput(true);  // POST로 데이터를 보내려면 setDoOutput(); 메소드가 필요하다.
      
      // OutputStream을 이용해서 POST 데이터 보내기
      bout = new BufferedOutputStream(con.getOutputStream()); // 서버로 데이터를 보낸다.
      bout.write(params.getBytes());  // String params를 byte[] 로 변환해서 데이터를 보냄
      bout.flush(); // 버퍼에 혹시 모르게 남아있는 데이터를 모두 처리하라는 의미
      
      // Write()함수를 cpu가 처리했다고 해도 모든 데이터가 물리적으로 디스크에 전부 저장되지 않을 수도 있다. 
      // Write()한 파일을 다시 읽거나 할때는 반드시 Flush()해주는게 좋다.
      
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      
      JSONObject obj = new JSONObject(sb.toString());
      JSONObject message = obj.getJSONObject("message");
      JSONObject result = message.getJSONObject("result");
      String translatedText = result.getString("translatedText");
      
      System.out.println("번역 결과");
      System.out.println("---------");
      System.out.println(translatedText);
      
      
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(bout != null) bout.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }

}
// POST 방식: 출력스트림을 이용해서 서버로 데이터(파라미터)를 보낸다.
// 보안이 필요할 때 POST방식을 사용한다.
// 요청메소드(RequestProperty) 생략이 불가능하다.