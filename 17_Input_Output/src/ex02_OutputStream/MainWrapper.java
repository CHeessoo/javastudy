package ex02_OutputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainWrapper {
  
  /*
   * java.io.OutputStream 클래스
   * 1. 바이트 기반의 출력 스트림이다.
   * 2. 출력 단위
   *    1) int
   *    2) byte[]
   */
  
  
  public static void ex01() {
    // 디렉터리를 File 객체로 만들기(File 객체를 이용해서 디렉터리 생성)
    File dir = new File("C:/storage");  // 선언
    if(!dir.exists()) {  // 만약 storage 디렉터리가 없으면
      dir.mkdirs();      // storage 디렉터리 생성
    }
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex01.dat");
    
    // 파일출력스트림 선언
    FileOutputStream fout = null;
    try {
      // 파일출력스트림 생성(반드시 예외처리가 필요한 코드) (scope 조정을 위해 선언과 생성을 분리)
      fout = new FileOutputStream(file);
      
      // 출력할 데이터(파일로 보낼 데이터)
      int c = 'A';              // int
      String s = "pple";      
      byte[] b = s.getBytes();  //byte[] : String을 byte[]로 변환
      
      // 출력(파일로 데이터 보내기)
      fout.write(c);
      fout.write(b);
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {   // finally 존재 이유 : fout을 close()하기 위해서
      try {
        if(fout != null) {  // fout이 생성되지 않았을 때 발생하는 NullPointerException을 방지
          fout.close(); // 출력 스트림은 반드시 닫아줘야 함 (반드시 예외 처리가 필요한 코드)
        }
      } catch (IOException e2) {
        e2.printStackTrace();
      }
    }
    
    System.out.println(file.getPath() + " 파일 크기 : " + file.length() + "바이트");
  }

  // ex01과 동일한 코드(복습)
  public static void ex02() {
    
    // C:\storage\ex02.dat 파일로 "안녕하세요" 보내기, 파일 크기 확인
    
    // File 객체를 이용해서 디렉터리 생성
    File dir = new File("C:/storage");
    if(!dir.exists()) { // 만약 storage 폴더(디렉터리)가 없으면
      dir.mkdirs();     // 폴더 만들기
    }
    
    // File 객체를 이용해서 파일 생성
    File file = new File(dir, "ex02.dat");
    
    // 파일출력스트림 선언(만)
    FileOutputStream fout = null;  
    
    try { // 파일출력스트림을 위한 예외처리
      // 파일출력스트림 생성
      fout = new FileOutputStream(file);
      
      // 출력할 데이터 (파일로 보낼 데이터 생성)
      String hello = "안녕하세요";
      byte[] byteHello = hello.getBytes("UTF-8");  // String hello 를 byte[] 타입으로 변환
      // getBytes();는 인코딩을 지정할 수 있다.(char, String)
      
      // 출력 (파일로 데이터 보내기)
      fout.write(byteHello);
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try { // fout.close를 위한 예외처리
        if(fout != null) {  // 만약 fout이 null값이 아니면
          fout.close();     // close();한다.
        }
      } catch (IOException e2) {
        e2.printStackTrace();
      }
    }
    System.out.println(file.getName() + " 파일 크기 : " + file.length() + "바이트");  // 15바이트
    
  }
  
  
  /*
   * java.io.BufferedOutputStream 클래스
   * 1. 내부 버퍼를 가지고 있는 출력스트림이다.
   * 2. 많은 데이터를 한 번에 출력하기 때문에 속도 향상을 위해서 사용한다.
   * 3. 보조스트림이므로 메인스트림과 함께 사용한다.
   */
  public static void ex03() {
    
    /*
     * ex03.dat 만들어보기
     * 2줄로 안녕하세요
     *       \n
     *       반갑습니다
     */
    
    // 디렉터리 생성
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    // 파일 생성
    File file = new File(dir, "ex03.dat");
    
    // 버퍼출력스트림 선언 (속도향상) 
    // 버퍼를 가지고 있어서 출력속도가 빠르다. 내보내는 속도는 동일하지만 버퍼에 실어서 한번에 여러개를 내보내는 방식이다.
    BufferedOutputStream bout = null;   // scope 조정을 위해 선언과 생성 나눔
    
    try {
      // 버퍼출력스트림 생성 (반드시 예외 처리가 필요한 코드)
      bout = new BufferedOutputStream(new FileOutputStream(file)); // 버퍼출력스트림은 스트림을 출력한다
      
      /*
       * 내가 작성한 데이터 출력 코드
       * String hello = "안녕하세요\n반갑습니다";  // 2줄로 생성
       * byte[] byteHello = hello.getBytes("UTF-8"); //UTF-8로 인코딩
       */
      
      /*
       * 내가 작성한 출력코드
       * fout.write(byteHello);
       */

      
      // 출력할 데이터
      // 강사님 코드
      String s1 = "안녕하세요";
      String s2 = "반갑습니다";
      int c = '\n';   // 이스케이프 문자 1바이트
      
      // 출력
      // 강사님 코드
      bout.write(s1.getBytes("UTF-8"));
      bout.write(c);
      bout.write(s2.getBytes(StandardCharsets.UTF_8));  // getBytes("UTF-8")과 동일하다.
      
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(bout != null) {
          bout.close(); // bout이 null이 아니면 close
        }
      } catch (IOException e2) {
        e2.printStackTrace();
      }
    }
    // 확인
    System.out.println(file.getName() + " 파일 크기 : " + file.length() + "바이트");

  }
  
  public static void main(String[] args) {
    ex03();
  }

}
// 출력스트림은 덮어쓰기 방식으로 작동하기 때문에 부담없이 여러번 출력이 가능하다.
// 버퍼출력스트림을 자주 사용하자!