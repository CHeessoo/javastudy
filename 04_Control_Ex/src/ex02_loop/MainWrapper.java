package ex02_loop;

import java.util.Iterator;

import javax.swing.RowFilter;

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
      System.out.println(dan + "x" + i + "=" + (dan * i));
    }
    */
    
    
    // 2 ~ 9 단
    for(dan = 2; dan <=9; dan++) {
      System.out.println("==" + dan + "단==");
      for(int i = 1; i <= 9; i++) {
        System.out.println(dan + "x" + i + "=" + dan * i);
      }
    }
    
    
    
    
    
  }
  
  public static void ex02() {
    // 100000원 넘을 때까지 60원씩 모금하면서 과정 출력하기
    // 1회 모금액 60원, 현재 모금액 60원
    // 2회 모금액 60원, 현재 모금액 120원
    // 3회 모금액 60원, 현재 모금액 180원
    // ...
    // 1667회 모금액 60원, 현재 모금액 100020원
    final int GOAL = 100000;  // 목표 모금액
    int money = 60;  // 1회당 모금액
    int total = 0;  // 모금액 합계
    int nth = 0;  // 회차
    
    /*
    for(nth = 1; total <= GOAL; nth++) {
      total += money;
      System.out.println(nth + "회 모금액 " + money + "원, 현재 모금액 " + total + "원");
      */
      
    while (total <= GOAL) {
      total += money;
      nth++;
      System.out.println(nth + "회 모금액 " + money + "원, 현재 모금액 " + total + "원");
    }
  }
  
  
  public static void ex03() {
    // 전체 구구단 출력하기 - 1
    // 2 x 1 = 2
    // ...
    // 9 x 9 = 81
    // 고정 값 : 바깥 LOOP에 배치
    // ex01();
    
    
    for(int i = 2; i <= 9; i++) {
      System.out.println();
      for(int j = 1; j <= 9; j++) {
        System.out.println(i + "x" + j + "=" + i*j);
      }
    }
    

    
  }
  
  public static void ex04() {
    // 전체 구구단 출력하기 - 2
    // 2x1=2  3x1=3  4x1=4  ... 9x1=9
    // ...
    // 2x9=18 3x9=27 4x9=36 ... 9x9=81
    
    // 참고할코드
    // System.out.print("2x1=2");  // 2x1=2를 출력한 뒤 줄을 바꾸지 않는다.
    
    /* 탭키를 이용한 줄 맞춤
    for(int n = 1; n <= 9; n++) {
      for(int dan = 2; dan <= 9; dan++) {
        System.out.print(dan + "x" + n + "=" + (dan*n) + "\t");   // 탭 키 : 고정된 간격으로 나눠진 구역을 옮겨다닐 수 있음.
      }
      System.out.println();   // 줄 바꿈
    }
    */
    
    /* 줄 맞춤 예제
    String str1 = String.format("%d", 10);    // %d  = 정수
    String str2 = String.format("%3d", 10);   // %3d = 두자리 정수
    String str3 = String.format("%4d", 10);   // %4d = 네자리 정수  : 네자리로 출력하라
    
    String str4 = String.format("%-3d", 10);  // -가 붙으면 오른쪽 공백
    String str5 = String.format("%-4d", 10);

    System.out.print(str3 + str2 + str1);
    System.out.println();
    System.out.print(str5 + str4);
     */
    
    
    for(int n = 1; n <= 9; n++) {
      for(int dan = 2; dan <= 9; dan++) {
        System.out.print(dan + "x" + n + "=" + String.format("%-4d", (dan*n)));   // dan*n값을 4자리 폭으로 줄 맞춰서 숫자 먼저 출력  
      }
      System.out.println();   // 줄 바꿈
    }
    
  }
  
  public static void ex05() {
    // 삼각별 출력하기 - 1 (2중 loop)
    //     star=12345 
    // row=1    *
    // row=2    **
    // row=3    ***
    // row=4    ****
    // row=5    *****
    //
    // row = 1, star = 1~1
    // row = 2, star = 1~2
    // row = 3, star = 1~3
    // row = 4, star = 1~4
    // row = 5, star = 1~5
    
    // 참고할 코드
    // System.out.print("*");  // *를 출력한 뒤 줄을 바꾸지 않는다.
    // System.out.println();   // 줄 바꾸기
    
    // 5줄 출력
    for(int row = 1; row <= 5; row++) { 
      // 별 반복 출력
      for(int star = 1; star <= row; star++) {
        System.out.print("*");  // 줄바꿈X
      }
      // 줄 바꿈
      System.out.println();
    }
    
  }
  
  public static void ex06() {
    // 삼각별 출력하기 - 2 (2중 loop)
    //     satr=12345
    // row=1    *****
    // row=2    ****
    // row=3    ***
    // row=4    **
    // row=5    *
    //
    // row = 1, star = 1~5
    // row = 2, star = 1~4
    // row = 3, star = 1~3
    // row = 4, star = 1~2
    // row = 5, star = 1~1
    
    for(int row = 1; row <= 5; row++) {
      for(int star = 1; star <= 6 - row; star++) {
        System.out.print("*");
      }
      System.out.println();
    }
    
  }
  
  public static void ex07() {
    // 삼각별 출력하기 - 3 (2중 loop)
    //     space/star=123456789
    // row=1              *
    // row=2             ***
    // row=3            *****
    // row=4           *******
    // row=5          *********
    //
    // row=1, space=1~4, star=5~5
    // row=2, space=1~3, star=4~6
    // row=3, space=1~2, star=3~7
    // row=4, space=1~1, star=2~8
    // row=5, space=1~0, star=1~9
    
    /*
    // 줄 출력
    for(int row = 1; row <= 5; row++) {
      //공백 출력
      for(int space = 1; space <= 5 - row; space++) {
        System.out.print(" ");
      } 
      // 별 출력
      for(int star = 1; star <= (row*2)-1; star++) {
        System.out.print("*");
      }
      System.out.println();
    }
    */
    
    // 줄 출력
    for(int row = 1; row <= 5; row++) {
      //공백 출력
      for(int space = 1; space <= 5 - row; space++) {
        System.out.print(" ");
      } 
      // 별 출력
      for(int star = 6-row; star <= row+4; star++) {
        System.out.print("*");
      }
      System.out.println();
    }
    
    
    
  }
  
  public static void ex08() {
    // 삼각별 출력하기 - 4 (2중 loop)
    //     space/star=123456789
    // row=1          *********
    // row=2           *******
    // row=3            *****
    // row=4             ***
    // row=5              *
    //
    // row=1, space=1~0, star=1~9
    // row=2, space=1~1, star=2~8
    // row=3, space=1~2, star=3~7
    // row=4, space=1~3, star=4~6
    // row=5, space=1~4, star=5~5
    
    // row 출력
    for(int row=1; row <=5; row++) {
      // 공백 출력
      for(int space=1; space <= row-1; space++) {
        System.out.print(" ");
      }
      // 별 출력
      for(int star=row; star <= 10-row; star++) {
        System.out.print("*");
      }
      // 줄 바꿈
      System.out.println();
    }
    
    
    // 첫번째 방법
    //5줄 출력 (순차)
//    for(int i = 1; i <= 5; i++) {   // 1-2-3-4-5
//      
//      // 공백 - 순차출력
//      for(int j = 1; j < i; j++) {  
//        System.out.print(" ");
//      }
//      // 별 - 역순
//      for(int k = 9; k >= (i*2)-1; k--) { 
//        System.out.print("*");
//      }
//      //줄바꿈
//      System.out.println();
//    }
//    
//    
//    
//    // 2번째 방법
//    // 5줄 출력 (역순)
//    for(int i = 5; i >= 1; i--) {   // 5-4-3-2-1
//      
//      //공백 순차출력
//      for(int j = 0; j < 5-i; j++) {  
//        System.out.print("@");
//      }
//      //별 (5줄 끝나면 반복도 끝나도록)
//      for(int k = 1; k <= (i*2)-1; k++) { 
//        System.out.print("*");
//      }
//      // 줄 바꾸기
//      System.out.println();
//    }

  }
  
  public static void main(String[] args) {
    
    // ex01();
    // ex02();
    // ex03();
    // ex04();
    // ex05();
    // ex06();
    // ex07();
     ex08();
    
  }


//  단축키 ctrl + shift + x : 대문자 변환
}
