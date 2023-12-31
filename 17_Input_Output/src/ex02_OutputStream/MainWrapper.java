package ex02_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
      
      // 1. 생성모드 : 언제나 새로 만든다.(덮어쓰기)                    new FileOutputStream(file)
      // 2. 추가모드 : 새로 만들거나, 기존 파일에 추가한다.(덧붙이기)   new FileOutputStream(file, true)
      fout = new FileOutputStream(file);
      
      // 출력할 데이터(파일로 보낼 데이터)
      int c = 'A';              // int
      String s = "pple";      
      byte[] b = s.getBytes();  //byte[] : String을 byte[]로 변환
      
      // 출력(파일로 데이터 보내기)
      fout.write(c);
      fout.write(b);
      
      System.out.println(file.getPath() + " 파일 크기 : " + file.length() + "바이트");

    } catch (IOException e) {
      e.printStackTrace();
    } finally {   // finally 존재 이유 : fout을 close()하기 위해서
      try {
        if(fout != null) {  // fout이 생성되지 않았을 때 발생하는 NullPointerException을 방지
          fout.close(); // 출력 스트림은 반드시 닫아줘야 함 (반드시 예외 처리가 필요한 코드)
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
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
      
      System.out.println(file.getName() + " 파일 크기 : " + file.length() + "바이트");  // 15바이트

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try { // fout.close를 위한 예외처리
        if(fout != null) {  // 만약 fout이 null값이 아니면
          fout.close();     // close();한다.
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
  }
  
  /**
   * ex03.dat 만들어보기
   * 2줄로 안녕하세요
   *       \n
   *       반갑습니다
   */
  public static void ex03() {
    
    /*
     * java.io.BufferedOutputStream 클래스
     * 1. 내부 버퍼를 가지고 있는 출력스트림이다.
     * 2. 많은 데이터를 한 번에 출력하기 때문에 속도 향상을 위해서 사용한다.
     * 3. 보조스트림이므로 메인스트림과 함께 사용한다.
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
      
      
      // 확인
      System.out.println(file.getName() + " 파일 크기 : " + file.length() + "바이트");

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(bout != null) {
          bout.close(); // bout이 null이 아니면 close
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }
  
  public static void ex04() {
    
    /*
     * java.io.DataOutputStream 클래스
     * 1. int, double, String 등의 변수를 그대로 출력하는 출력스트림이다.
     * 2. 보조스트림이므로 메인스트림과 함께 사용한다.
     */
    
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "ex04.dat");
    
    // 데이터출력스트림 선언
    DataOutputStream dout = null;
    
    try {
      // 데이터출력스트림 생성
      dout = new DataOutputStream(new FileOutputStream(file));  // 데이터출력스트림은 메인스트림을 출력한다.
      
      // 출력할 데이터
      String name = "tom";
      int age = 50;
      double height = 190.5;
      String school = "가산대학교";
      
      // 출력
      dout.writeChars(name);    // dout.writeChar('t'), dout.writeChar('o'), dout.writeChar('m')  // writeBytes(); 를 사용해도 된다.
      dout.writeInt(age);
      dout.writeDouble(height);
      dout.writeUTF(school);   // 인코딩을 바로 wrapping해서 보내기 (한글처리)
      
      System.out.println(file.getName() + " 파일 크기 : " + file.length() + "바이트");

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(dout != null) {
          dout.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void ex05() {
    
    /*
     * java.io.ObjectOutputStream 클래스
     * 1. 객체를 그대로 출력하는 출력스트림이다.
     * 2. 직렬화(Serializable)된 객체를 보낸 수 있다.
     * 3. 보조스트림이므로 메인스트림과 함께 사용한다.
     */
    
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    File file = new File(dir, "ex05.dat");
    
    // 객체출력스트림 선언
    ObjectOutputStream oout = null;
    
    try {
      
      // 객체출력스트림 생성
      oout = new ObjectOutputStream(new FileOutputStream(file));  // 객체출력스트림 또한 보조스트림으로 사용
      
      // 출력할 데이터
      String name = "tom";
      int age = 50;
      double height = 190.5;
      String school = "가산대학교";
      Student student = new Student(name, age, height, school);
      
      
      // 출력
      oout.writeObject(student);
      
      System.out.println(file.getName() + " 파일 크기 : " + file.length() + "바이트");
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (oout != null) {
          oout.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
    ex05();
  }

}
// 출력스트림은 덮어쓰기 방식으로 작동하기 때문에 부담없이 여러번 출력이 가능하다.
// 버퍼출력스트림을 자주 사용하자!
// 객체는 직렬화 과정을 거친다 : 객체를 통째로 보내는건 불가능해서 직렬화 과정을 거쳐서(객체를 분리해서) 하나씩 보낸다는 의미이다.
// 직렬화된 객체가 보이는 이유는 스트림으로 이동시키기 위해서이다.