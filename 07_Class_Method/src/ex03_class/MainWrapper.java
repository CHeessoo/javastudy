package ex03_class;

public class MainWrapper {

  public static void main(String[] args) {
    // 일반적으로는 선언과 생성을 한 줄로 작성
    // Calculator 객체 선언
    Calculator myCalc;
    
    // Calculator 객체 생성(객체 == 인스턴스: 메모리에 로드된 객체)
    myCalc = new Calculator();  // 인스턴스화 : 메모리에 로드되었다.
    
    // 계산하고자 하는 실수 2개 준비
    double a = 1.5;
    double b = 1.2;
    
    // 뎃셈, 뺄셈, 곱셈, 나눗셈 메소드 호출
    System.out.println(myCalc.addition(a, b));
    System.out.println(myCalc.subtraction(a, b));
    System.out.println(myCalc.multiplication(a, b));
    System.out.println(myCalc.division(a, b));
  }

}

// 클래스의 이름이 객체의 타입이다.