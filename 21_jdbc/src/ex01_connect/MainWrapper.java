package ex01_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainWrapper {
  
  // 1. oracle.jdbc.OracleDriver 클래스 Load
  public static void ex01() {
    try {
      Class.forName("oracle.jdbc.OracleDriver");
    } catch (ClassNotFoundException e) {
      System.out.println("OracleDriver 클래스가 없다");
    }
  }
  
  // 2. java.sql.Connection 객체 생성 (DB 접속 생성)
  public static void ex02() {
    
    // 접속 정보
    String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 매번 필요
    String user = "GD";
    String password = "1111";
    
    // Connection 객체 선언
    Connection con = null;
    
    // Connection 객체 생성
    try {
      con = DriverManager.getConnection(url, user, password); // DriverManager를 통해서 해당 커넥션을 반환해주는 getConnection()을 불러올 수 있다.
      System.out.println("DB 접속 성공");
    } catch (SQLException e) {
      System.out.println("DB 접속 실패");
    } finally {
      
      // Connection 객체 닫기(소멸)
      try { // close를 위해 try - catch 가 필요하다.
        if(con != null) con.close();
      } catch (SQLException e) {
        System.out.println("DB 접속 닫기 실패");
      }
    }
  }
  
  public static void main(String[] args) {
    // ex01(), ex02() 두 클래스 모두 실행해야함.
    ex01(); // 클래스 Load
    ex02(); // 실제 접속
  }

}
