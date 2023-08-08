package ex04_text_copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainWrapper {

  public static void ex01() {

    // 문제1. 다음과 같이 알파벳 대문자가 입력된 C:/storage/alphabet.txt 파일을 만드시오.
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ

    // 선생님 답안
    // File 객체
    File dir = new File("C:/storage/");
    if(dir.exists() == false) {
      dir.mkdirs();
    }
    File file = new File(dir, "alphabet.txt");

    // 버퍼출력스트림 생성(close가 필요 없는 try-catch-resources문)
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
      
      // 알파벳 순차적으로 하나씩 저장
      for(char ch = 'A'; ch <= 'Z'; ch++) {
        writer.write(ch);
      }
      // 버퍼출력스트림에 (혹시) 남아 있는 모든 데이터를 보내기
      writer.flush();
      
      // 결과 메시지
      System.out.println(file.getPath() + " 파일 생성 완료");
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    /*  
     * 내가 언제 써놓은지 모르게 써놓은 답안
     * 
    // 출력스트림 선언
    BufferedOutputStream bout = null;

    try {

      // 출력스트림 생성
      bout = new BufferedOutputStream(new FileOutputStream(file));

      // 출력할 데이터
      StringBuilder sb = new StringBuilder();
      for (int n = 'A'; n <= 'Z'; n++) {
        int c1 = n;
        char c2 = (char) c1;
        sb.append(c2);
      }
      byte[] b = sb.toString().getBytes(); // String을 byte[] 로 변환

      // 출력
      bout.write(b);

      System.out.println(file.getPath() + " 파일 생성 완료");

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (bout != null) {
          bout.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    */

  }

  public static void ex02() {

    // 문제2. C:/storage/alphabet.txt 파일을 복사하여 C:/storage/alphabet2.txt 파일을 만드시오.
    
    // 디렉터리 File 객체
    File dir = new File("C:/storage");
    if(dir.exists() == false) {
      dir.mkdirs();
    }
    
    // 원본 File 객체
    File src = new File(dir, "alphabet.txt");
    
    // 복사할 File 객체
    File cp = new File(dir, "alphabet2.txt");
    
    // try - catch - resources
    try (BufferedReader br = new BufferedReader(new FileReader(src)); 
         BufferedWriter bw = new BufferedWriter(new FileWriter(cp))) {
      
      // 복사 단위 5 char
      char[] cbuf = new char[5];
      
      // 실제로 읽은 byte수
      int readChar = 0;
      
      // 복사
      while((readChar = br.read(cbuf)) != -1) {
        bw.write(cbuf, 0, readChar);
      }
      bw.flush(); 
      
      // 결과 메시지
      System.out.println(cp.getPath() + " 파일 생성 완료");
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    /* 내 답안
    // File cp = new File(dir, src.getName().substring(0, src.getName().indexOf(".")) + "2.txt");
   
    // 원본 입력스트림 선언
    BufferedInputStream bin = null;
    
    // 복사본을 만드는 출력스트림 선언
    BufferedOutputStream bout = null;
      
      // 문자 입력스트림으로 읽기
      BufferedReader br = null;
      
      try {
        
        // 원본 입력스트림 생성
        bin = new BufferedInputStream(new FileInputStream(src));
        
        // 복사본을 만드는 출력스트림 생성
        bout = new BufferedOutputStream(new FileOutputStream(cp));
        
        br = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
        
        String line = null;
        StringBuilder sb = new StringBuilder();
        
        // 반복문으로 line 에 br로 읽은 문자 넣기
        // line을 sb에 누적
        while((line = br.readLine()) != null) {
          sb.append(line);
        }
        byte[] b = sb.toString().getBytes();
        bout.write(b);
        
        System.out.println(src.getPath() + " → " + cp.getPath());
        
        
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if(bout != null) bout.close();
          if(bin != null) bin.close();
        } catch (IOException e) {
          e.printStackTrace();

        }
      }
      */
    }

  public static void main(String[] args) {
    ex01();
    ex02();
  }
}
