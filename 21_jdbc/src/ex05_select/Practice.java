package ex05_select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import connect.DB_Connect;

public class Practice {
  
  // select 연습용 클래스
  
  public static void main(String[] args) {
    
    // USER_NO 입력 받기
    Scanner sc = new Scanner(System.in);
    System.out.println("사용자 번호 검색 >>> ");
    int user_no = sc.nextInt();
    sc.close();
    
    // Connection 객체 선언 (DB 접속)
    Connection con = null;
    
    // PreparedStatemente 객체 선언 (쿼리문 실행)
    PreparedStatement ps = null;
    
    // ResultSet 객체 선언 (검색 결과 처리)
    ResultSet rs = null;
    
    try {
      
      // Connection 객체 생성
      con = DB_Connect.getConnection();
      
      // 쿼리문
      String sql = "";
      sql += "SELECT USER_NO, USER_ID, USER_NAME, JOINED_AT";
      sql += "  FROM USER_T";
      sql += " WHERE USER_NO = ?";  // 변수가 들어가는 자리는 ? 물음표 처리
      
      // PreparedStatemete 객체 생성
      ps = con.prepareStatement(sql);
      
      // 쿼리문에 변수 넣기
      ps.setInt(1, user_no);
      
      // 쿼리문 실행
      rs = ps.executeQuery();
      
      
    } catch (Exception e) {
      // TODO: handle exception
    }
    
    
    
    
  }

}
