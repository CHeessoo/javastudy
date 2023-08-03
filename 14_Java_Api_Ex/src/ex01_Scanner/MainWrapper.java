package ex01_Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWrapper {
  
  // 문제1. Scanner 클래스의 next() 메소드를 이용해서 사용자로부터 문자열을 계속 입력 받는다.
  // 사용자가 "exit" 문자열을 입력하면 더 이상 입력 받지 않는다.
  // 총 몇 번만에 종료되었는지 그 횟수를 마지막에 출력한다.
  // 실행예시)
  // 문자열 입력 >>> apple
  // 문자열 입력 >>> exit
  // 2번만에 exit가 입력되었다.
  public static void ex01() {
    String str;
    int count = 0;
    Scanner sc = new Scanner(System.in);
    do {
      System.out.print("문자열 입력 >>> ");
      str = sc.next();
      count++;
    } while(!str.equals("exit"));
    sc.close();
    System.out.println(count + "번만에 exit가 입력되었다.");
  }

  // 문제2. "대한민국의 수도는?" 퀴즈 정답을 맞힐때까지 계속 퀴즈를 내시오.
  // "서울", "seoul", "Seoul", "SEOUL" 등을 정답으로 처리하시오.
  // 실행예시)
  // 대한민국의 수도는? >>> 인천
  // 오답입니다.
  // 대한민국의 수도는? >>> 영국
  // 오답입니다.
  // 대한민국의 수도는? >>> 서울
  // 정답입니다.
  public static void ex02() {
    Scanner sc = new Scanner(System.in);
    String capital;
    do {
      System.out.print("대한민국의 수도는? >>> ");
      capital = sc.next();
      if(!(capital.equals("서울") || capital.equalsIgnoreCase("seoul"))) {
        System.out.println("오답입니다.");
        }
      } while(!(capital.equals("서울") || capital.equalsIgnoreCase("seoul")));
    sc.close();
    System.out.println("정답입니다.");
    }
    
  // 문제3. 평점 입력 받아서 해당 평점만큼 ★을 출력하시오.
  // 평점은 1 ~ 5 사이 정수로 입력 받는데, 벗어난 범위는 다시 입력 받는다.
  // 실행예시)
  // 평점(1~5) 입력 >>> 9
  // 평점(1~5) 입력 >>> -1
  // 평점(1~5) 입력 >>> 3
  // ★★★
  public static void ex03() {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int number;
    do {
      System.out.print("평점(1~5) 입력 >>> ");
      number = sc.nextInt();
    } while(number < 1 || number > 5);
    sc.close();
    for(int n = 1; n <= number; n++) {
      sb.append("★");
    }
    String star = sb.toString();
    System.out.println(star);
  }
  
  // 문제4. 비밀번호는 "1234"이다.
  // 사용자로부터 비밀번호를 입력 받아서 "1234"와 같으면 "성공", "1234"가 아니면 다시 비밀번호를 입력 받도록 처리하시오.
  // 비밀번호 입력은 최대 5번으로 제한하고, 5번의 입력이 모두 틀리면 최종적으로 "실패"를 출력하시오.
  // 실행예시1)
  // 비밀번호? >>> 0000
  // 비밀번호? >>> 1111
  // 비밀번호? >>> 2222
  // 비밀번호? >>> 3333
  // 비밀번호? >>> 4444
  // 실패
  // 실행예시2)
  // 비밀번호? >>> 0000
  // 비밀번호? >>> 1234
  // 성공
  public static void ex04() {
    final int MAX = 5;
    Scanner sc = new Scanner(System.in);
    
    for(int n = 0; n < MAX; n++) {
      System.out.print("비밀번호? >>> ");
      int pw = sc.nextInt();
      if(pw == 1234) {
        sc.close();
        System.out.println("성공");
        return;
      }
    }
   System.out.println("실패");
  }
  
  // 문제5. 4계절이 저장되어 있는 영한 사전(2차원 배열)을 이용하여 문제를 해결하시오. 순서대로 한 번씩만 물어보는 방식으로 처리하시오.
  // 실행예시)
  // 봄을 영어로 하면? >>> spring
  // 정답
  // 여름을 영어로 하면? >>> sumer
  // 오답
  // 가을을 영어로 하면? >>> fall
  // 정답
  // 겨울을 영어로 하면? >>> win
  // 오답
  public static void ex05() {
    
    
  }
  
  public static void main(String[] args) {
    // ex01();
    // ex02();
    ex03();
    // ex04();
    ex05();
  }

}
