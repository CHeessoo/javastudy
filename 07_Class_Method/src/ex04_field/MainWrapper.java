package ex04_field;

public class MainWrapper {

  public static void main(String[] args) {
    
    // AccCalculrator 객체의 선언 & 생성
    AccCalculrator myAcc = new AccCalculrator();
    
    // value 확인
    myAcc.showValue();
    
    // 사칙연산
    myAcc.addition(3);        // +3
    myAcc.substraction(2);    // -2
    myAcc.multiplication(3);  // *3
    myAcc.divition(2);        // /2
    
    // value 확인
    myAcc.showValue();
    
  }

}


// 객체마다 다른 값을 전달하려고 할 때 필드에 저장해서 사용한다.
// 모든 객체가 가지는 고유의 값은 필드에 저장한다.