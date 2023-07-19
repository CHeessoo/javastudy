package ex03_advanced_for;    // 향상 for문 : 인덱스를 명시하지 않는 for문

import java.util.Arrays;

public class MainWrapper {
  
  // 1차원 배열의 advanced-for문
  public static void ex01() {
    
    // 1차원 배열의 초기화
    int[] a = {10, 20, 30};
    
    // advanced-for (인덱스가 필요 없을 때, 단순 조회용도로 사용하기 용이) / 사용하면 안 되는 경우 : 배열에 저장된 값이 변할 때
    for(int number : a) {    // for(배열요소를저장할변수 : 배열명)   // 배열요소 : 배열에 저장된 각각의 변수
      System.out.println(number);   // 배열 a의 모든 요소를 순차적으로 number로 넘김
    }
  }
  
  // advanced-for문을 사용하지 못하는 대표적인 경우 : 배열요소의 값이 변하는 경우
  public static void ex02() {
    
    // 1차원 배열 초기화
    int[] a = {10, 20, 30};
    
    // 모든 배열요소를 1씩 증가시키기 - 1 : advanced-for문 (불가능)
    // for(int number : a) {
    //   number++;
    // }
    
    // 모든 배열요소를 1씩 증가시키기 -2 : 일반 for문 (가능)
    for(int i = 0; i < a.length; i++) {
      a[i]++;
    }
    
    // 배열요소 확인
    System.out.println(Arrays.toString(a));     // [11, 21, 31]  //Arrays. : 배열의 유틸을 저장하는 클래스 이름
  }
  // 배열값을 바꾸지 않는 단순 참조의 경우에는 향상 for문을 사용해도 괜찮지만 그렇지 않은 경우 주의해서 사용해야 한다.
  // 향상 for문은 배열요소를 순차적으로 자동 정렬 하되, 배열을 복사해와서 사용하는것. 그래서 배열을 직접 수정하는건 안 됨.
  
  
  // 2차원 배열의 advanced-for문
  public static void ex03() {
    
    // 2차원 배열의 초기화
    int[][] a = {
        {10, 20},
        {30, 40},
        {50, 60}
    };
    
    // advanced-for
    // for(배열요소 : 배열) {
    // }
    for(int[] b : a) {    // 배열요소 -> int의 배열타입
      for(int number : b) {
        System.out.print(String.format("%4d", number));
      }
      System.out.println();
    }
    
  }

  public static void main(String[] args) {
    
    // ex01();
    // ex02();
    // ex03();
    
    // 2차원 배열은 서비스에 따라 다르겠지만, 웹 개발보단 게임개발에서 사용됨.

  }

}
