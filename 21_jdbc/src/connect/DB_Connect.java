package connect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB_Connect {
  
  public static Connection getConnection() {  // static 처리해준 클래스 메소드 (new 없이 호출 가능)
    
    // Connection 객체 선언
    Connection con = null;
    
    try (BufferedReader reader = new BufferedReader(new FileReader("src/db.properties"))){
      
      // 오라클드라이버 클래스 로드
      Class.forName("oracle.jdbc.OracleDriver"); 
      
      // 프로퍼티 파일 -> 프로퍼티 객체
      Properties p = new Properties();
      p.load(reader);  
      
      // Connection 
      con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));
      
    } catch (Exception e) {
      e.printStackTrace();
    } 
     return con;
  }

  
  
}
