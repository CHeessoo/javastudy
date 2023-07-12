package ex03_operator;

public class MainWrapper {
  
  // ex01 메소드 만들기(메소드 정의)
  public static void ex01() {
    hello();
    System.out.println("Hello World");
    hello();
  }
  
  public static void main(String[] args) {
    // ex01 메소드 실행 부탁(메소드 호출)
    ex01();  
    
  }

  // "안녕 자바"를 출력하는 hello 메소드를 만들고 실행해 보기
  public static void hello() {
    System.out.println("안녕 자바");
  }
  
}
