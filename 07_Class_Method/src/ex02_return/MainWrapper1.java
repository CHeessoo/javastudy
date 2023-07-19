package ex02_return;

import java.util.Arrays;

public class MainWrapper1 {
  
  
  /*
   * 반환(return)
   * 1. 메소드의 실행 결과 값을 의미한다.
   * 2. 반환값이 없는 경우에는 void 키워드를 작성하고, 반환값이 있는 경우에는 반환값의 타입을 작성한다. 
   */

  public static void main(String[] args) {
    
    // get (getter): 반환이 있는 경우 자주 사용하는 프리픽스 값
    // getName();  // 메소드 호출
    
    // 이름을 받아온다.
    System.out.println(getName());  // 홍길동
    
    // 나이를 받아온다.
    System.out.println(getAge());   // 30
    
    // true, false 반환 (주로 is를 사용)
    System.out.println(isAlive());  // false
    
    // 취미를 3개 반환
    System.out.println(Arrays.toString(getHobbies()));  // [여행, 수영, 영화]
  }
  
  public static String[] getHobbies() {   // 배열을 만들어서 반환
    String[] hobbies = {"여행", "수영", "영화"};
    return hobbies;
  }
  
  public static boolean isAlive() {
    // 반환할 값을 지역변수로 먼저 선언
    boolean isAlive = getAge() <= 100;    // 예) 100살 이하면 살아있다는 기준으로 잡음
    return isAlive;   
  }
  
  public static int getAge() {
    // 반환할 값을 지역변수로 먼저 선언
    int age = 500; 
    return age;
  }
  
  public static String getName() {
    // 반환할 값을 지역변수로 먼저 선언
    String name = "홍길동";
    return name;   // 메소드를 호출한 곳으로 반환한다.
  }

}
