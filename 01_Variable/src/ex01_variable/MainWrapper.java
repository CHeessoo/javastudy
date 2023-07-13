package ex01_variable;

public class MainWrapper {
  
public static void main(String[] args) {

  // single comment (한 줄 주석)
  /*
     multiple comment
     여러 줄 주석
   */
  
  /*
   * 키워드 규칙
   * 1. 프로젝트 : 맘대로
   * 2. 패키지   : 모두 소문자로 작성(실무는 회사 도메인을 거꾸로 작성 : com.samsung.xxx)
   * 3. 클래스   : Upper Camel Case(첫 글자가 대문자인 Camel Case)
   * 4. 메소드   : Lower Camel Case(첫 글자가 소문자인 Camel Case)
   * 5. 변수     : Lower Camel Case(첫 글자가 소문자인 Camel Case)
   * 6. 상수     : Snake Case (대문자를 밑줄로 연결)
   */
  
  // 들여쓰기는 필수이다. 코드가 개발자의 얼굴이다.
  
  //변수명을 정할 때 : 의미전달이 잘 되도록 하는게 좋다.
  
  // 변수 선언하기
  
  // primitive type - 1 : 논리타입
  boolean isGood = true;        
  boolean isAlive = false;
  System.out.println(isGood);
  System.out.println(isAlive);

  
  // primitive type - 2 : 문자타입
  char ch1 = 'A';
  char ch2 = '가';
  System.out.println(ch1);
  System.out.println(ch2);
  
  // primitive type - 3 : 정수타입
  int score = 100;
  long money = 10000000000L;    // 앞에 선언된 변수타입을 보고 L을 붙이는게 아니라 값으로 들어간 수를 보고 L을 지정한 것.
  System.out.println(score);
  System.out.println(money);
  
  
  // pimitive type - 4 : 실수타입
  double commission = 0.5;
  System.out.println(commission);
  
  
  // 상수
  final double PI = 3.141592;   // 상수의 변수명은 대문자로 작성 하는 규칙이 있다.
  System.out.println(PI);
  
  
  
  // reference type : 참조타입
  //
  //       ┌--------------┐
  //   name│  0x12345678  │
  //       │--------------│
  //       │      ...     │
  //       │--------------│
  //       │      tom     │0x12345678  (= tom의 메모리 주소)
  //       │--------------│
  //       │      ...     │
  //       └--------------┘
  
  String name = "tom";
  System.out.println(name);
  
  }

}







