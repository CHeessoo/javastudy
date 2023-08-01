package ex01_try_catch;

import java.net.URL;
import java.util.Scanner;

public class MainWrapper {
  
  // try - catch(Unchecked Exception)
  public static void ex01() {
    try {
      String name = "tom";
      Integer.parseInt(name); // 발생한 NumberFormatException을 catch 블록으로 Java가 던진다.    //String을 Integer로 변환 요청 --> java.lang.NumberFormatException 발생
    } catch(NumberFormatException e) {  // RuntimeException, Exception 가능                      // 관용적으로 예외객체 이름은 e로 명칭함
      System.out.println("예외발생");
    }
    
  }
  
  // 다중 catch
  public static void ex02() {
    
    try {
      Scanner sc = new Scanner(System.in);
      System.out.println("덧셈식을 입력하세요(예 : 1+2)");
      String expr = sc.next();
      String[] numbers = expr.split("[+]"); // numbers = {"1", "2"}  // 대괄호로 묶은 +를 기준으로 문자열을 나눠서 배열식으로 저장
      int number1 = Integer.parseInt(numbers[0]);
      int number2 = Integer.parseInt(numbers[1]);
      System.out.println(number1 + number2);
      sc.close();
    } catch (NumberFormatException e) {
      System.out.println("정수 연산만 가능합니다.");
    } catch(ArrayIndexOutOfBoundsException e) {   // 사용할 수 있는 인덱스의 범위를 벗어남.
      System.out.println("덧셈식에 +를 포함해서 입력하세요.");
    } catch (Exception e) {   // NumberFormatException과 ArrayIndexOutOfBoundsException으로 처리 못하는 예외를 담당한다.
      System.out.println("알 수 없는 예외가 발생했습니다.");
    }
    // catch를 여러개 만드는 이유는 예외 사유를 하나하나 안내하기 위해서이다.
  }
  
  // Checked Exception (예: URL)
  public static void ex03() {
    
    // 반드시 try - catch가 필요한 예외를 Checked Exception이라고 한다.
    
    try {
      // 특정 url에 접속하려고 할 때 사용하는 기본 코드
      URL url = new URL("https://www.naver.com");
    } catch (Exception e) {
      System.out.println("예외발생");
    }
  }
  
  public static void main(String[] args) {
    ex02();
  }

}
// try문에서 생긴 모든 예외는 Java에 의해서 catch로 던져진다.
// 예외처리할 클래스를 모르면 모든 예외의 슈퍼클래스인 Exception으로 모든 예외를 처리 할 수 있다.
