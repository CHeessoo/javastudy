package ex04_text_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainWrapper {

  public static void ex01() {

    // 문제1. 다음과 같이 알파벳 대문자가 입력된 C:/storage/alphabet.txt 파일을 만드시오.
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ

    File dir = new File("C:/storage/");
    File file = new File(dir, "alphabet.txt");

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

  }

  public static void ex02() {

    // 문제2. C:/storage/alphabet.txt 파일을 복사하여 C:/storage/alphabet2.txt 파일을 만드시오.
    
    // 원본 File 객체 생성
    File dir = new File("C:/storage");
    File src = new File(dir, "alphabet.txt");
    
    // 복사할 File 객체 생성
    File cp = new File(dir, src.getName().substring(0, src.getName().indexOf(".")) + "2.txt");
    
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
    }

  public static void main(String[] args) {
    ex01();
    ex02();
  }
}
