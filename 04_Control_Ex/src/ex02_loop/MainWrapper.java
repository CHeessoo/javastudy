package ex02_loop;

import java.util.Iterator;

public class MainWrapper {
  
  public static void ex01() {
    // 구구단 출력하기
    // 2 x 1 = 2
    // 2 x 2 = 4
    // ...
    // 2 x 9 = 17
    int dan = 2;  // 이 곳에 원하는 구구단을 넣으면 된다.
    
    /* 2단만 출력
    for(int i = 1; i <= 9; i++) {
      System.out.println(dan + "*" + i + "=" + (dan * i));
    }
    */
    
    
    // 2 ~ 9 단
    for(dan = 2; dan <=9; dan++) {
      System.out.println("==" + dan + "단==");
      for(int i = 1; i <= 9; i++) {
        System.out.println(dan + "*" + i + "=" + dan * i);
      }
    }
    
    
    
    
    
  }
  
  public static void ex02() {
    // 100000 넘을 때까지 60원씩 모금하면서 과정 출력하기
    // 1회 모금액 60원, 현재 모금액 60원
    // 2회 모금액 60원, 현재 모금액 120원
    // 3회 모금액 60원, 현재 모금액 180원
    // ...
    // 1667회 모금액 60원, 현재 모금액 100020원
    int goal = 100000;  // 목표 모금액
    int money = 60;  // 1회당 모금액
    int total = 0;  // 모금액 합계
    int nth = 0;  // 회차
    
    
    for(nth = 1; total <= goal; nth++) {
      total = money * nth;
      System.out.println(nth + "회 모금액 " + money + "원, 현재 모금액 " + total + "원");
    }
    
    
    
  }
  
  public static void ex03() {
    // 전체 구구단 출력하기 - 1
    // 2 x 1 = 2
    // ...
    // 9 x 9 = 81
    // ex01();
    
    
    for(int i = 2; i <= 9; i++) {
      System.out.println();
      for(int j = 1; j <= 9; j++) {
        System.out.println(i + "*" + j + "=" + i*j);
      }
    }
    

    
  }
  
  public static void ex04() {
    // 전체 구구단 출력하기 - 2
    // 2x1=2  3x1=3  4x1=4  ... 9x1=9
    // ...
    // 2x9=18 3x9=27 4x9=36 ... 9x9=81
    
    // 참고할코드
//    System.out.print("2x1=2");  // 2x1=2를 출력한 뒤 줄을 바꾸지 않는다.
    
    for(int i = 2; i <= 9; i++) {
      System.out.println();
      for(int j = 1; j <= 9; j++) {
        System.out.print(i + "*" + j + "=" + i*j + "  ");
      }
    }
    
    
  }
  
  public static void ex05() {
    // 삼각별 출력하기 - 1 (2중 loop)
    //     b=12345 
    // a=1   *
    // a=2   **
    // a=3   ***
    // a=4   ****
    // a=5   *****
    
    // 참고할 코드
    // System.out.print("*");  // *를 출력한 뒤 줄을 바꾸지 않는다.
    // System.out.println();   // 줄 바꾸기
    
    for(int a = 1; a <= 5; a++) {
      System.out.println();
      for(int b = 1; b <= a; b++) {
        System.out.print("*");
      }
    }
    
  }
  
  public static void ex06() {
    // 삼각별 출력하기 - 2 (2중 loop)
    //     b=12345
    // a=1   *****
    // a=2   ****
    // a=3   ***
    // a=4   **
    // a=5   *
    
    
    for(int a = 1; a <= 5; a++) {
      for(int b = 5; b >= a; b--) {
        System.out.print("*");
      }
      System.out.println();
    }
    
  }
  
  public static void ex07() {
    // 삼각별 출력하기 - 3 (2중 loop)
    //     b=123456789
    // a=1       *
    // a=2      ***
    // a=3     *****
    // a=4    *******
    // a=5   *********
    
    
    for(int i = 1; i <= 5; i++) {
      for(int j = 1; j <= 5-i; j++) {
        System.out.print(" ");
      } 
      for(int k = 1; k <= (i*2)-1; k++) {
        System.out.print("*");
      }
      System.out.println();
    }
    
  }
  
  public static void ex08() {
    // 삼각별 출력하기 - 4 (2중 loop)
    //     b=123456789
    // a=1   *********
    // a=2    *******
    // a=3     *****
    // a=4      ***
    // a=5       *
    
    
    // 첫번째 방법
    //5줄 출력 (순차)
    for(int i = 1; i <= 5; i++) {   // 1-2-3-4-5
      
      // 공백 - 순차출력
      for(int j = 1; j < i; j++) {  
        System.out.print(" ");
      }
      // 별 - 역순
      for(int k = 9; k >= (i*2)-1; k--) { 
        System.out.print("*");
      }
      //줄바꿈
      System.out.println();
    }
    
    
    
    // 2번째 방법
    // 5줄 출력 (역순)
    for(int i = 5; i >= 1; i--) {   // 5-4-3-2-1
      
      //공백 순차출력
      for(int j = 0; j < 5-i; j++) {  
        System.out.print("@");
      }
      //별 (5줄 끝나면 반복도 끝나도록)
      for(int k = 1; k <= (i*2)-1; k++) { 
        System.out.print("*");
      }
      // 줄 바꾸기
      System.out.println();
    }

  }
  
  public static void main(String[] args) {
    
//    ex01();
//    ex02();
//    ex03();
//    ex04();
//    ex05();
//    ex06();
//    ex07();
    ex08();
    
    
  }


}
