package ex02_return;

public class MainWrapper2 {
  
  /*
   * void 메소드의 return
   * 1. 반환값이 없는 메소드는 void 키워드를 사용한다.
   * 2. 이런 경우 return; 키워드를 이용해서 메소드 실행을 종료할 수 있다.
   * 3. return 키워드만 작성해야 한다.
   * 4. void 메소드에서만 사용할 수 있다.
   */

  public static void main(String[] args) {  
    //(positive number : 양수) 
    positivePrint(10);  
    positivePrint(-10);
  }

  // 전달된 인수가 양수이면 출력하고 아니면 출력하지 않는 positivePrint 메소드
  public static void positivePrint(int a) {
    /*  (실행되는것과 상관없이 코드 스타일 상 좋은 코드 스타일이 아니다.)
    if(a >= 0) {
      System.out.println(a);
    }
    */
    
    // 좋은 예시) 0보다 작으면 실행되지 않는다.
    if(a < 0) {   // 메소드의 종료 조건만 설정
      return;   
      // return 키워드를 메소드를 종료시키는 용도로 사용하는 경우 return 뒤에 값이 없다. (void 메소드의 return 에서만 사용 가능)
    }
    System.out.println(a);
  }

}
