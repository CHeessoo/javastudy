package ex;

import java.util.Arrays;

public class MainWrapper3 {
  
  public static void ex01(int[] a) {    // main 과 ex01의 배열은 다른 배열이다.(메모리에 각각 저장됨)
    System.out.println(Arrays.toString(a));
    
    //ex01의 배열 a를 바꿨더니 main 의 배열 a도 바뀜. --> 메모리의 주소(참조값)를 복사했기 때문
    a[0] = 100;
    System.out.println("ex01의 배열 a = " + Arrays.toString(a));
  }

  public static void main(String[] args) {
    
    int[] a = {10, 20, 30};
    ex01(a);
    System.out.println("main의 배열 a = " + Arrays.toString(a));   // [100, 20, 30] 
    
  }

}

// 웹개발의 대부분 인수와 파라미터는 참조타입이다.

// 기본타입은 인수를 파라미터에 전달한 뒤 파라미터에서 데이터를 변경하면 변경되지 않는다. 