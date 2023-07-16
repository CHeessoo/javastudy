package ex01_branch;

import java.io.StreamCorruptedException;
import java.net.Socket;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class MainWrapper {
  
  // if문 문제
  public static void ex01() {
    
    //점수에 따른 학점(if문)
    int score = 100;
    char grade;  // 'A', 'B', 'C', 'D', 'F'
    
    if (score >= 90) {
      grade = 'A';
      
    } else if (score >= 80) {
      grade = 'B';
      
    } else if (score >= 70) {
      grade = 'C';
      
    } else if (score >= 60) {
      grade = 'D';
      
    } else {
      grade = 'F';
    }
    System.out.println(score + "점은 " + grade + "학점입니다.");
  }
  
  
  // switch문 문제
  public static void ex02() {
    
    //점수에 따른 학점(switch문)
    int score = 95;
    char grade;  // 'A', 'B', 'C', 'D', 'F'
    
    
    
    switch (score / 10) {
    case 10:
    case 9:
      grade = 'A';
      break;

    case 8:
      grade = 'B';
      break;

    case 7:
      grade = 'C';
      break;

    case 6:
      grade = 'D';
      break;

    default:
      grade = 'F';
    }
    System.out.println(score + "점은 " + grade + "학점입니다.");
    
  }
  
  
  // 3번 문제
  public static void ex03() {
    
    //점수와 학년에 따른 학점
    //1~3학년 : 60점 이상 합격, 아니면 불합격
    //4~6학년 : 70점 이상 합격, 아니면 불합격
    int score = 60; // 점수
    int scYear = 2;  // 학년
    String pass;  // "합격", "불합격"
    
      if(scYear <= 3) {
        if(score >= 60) {
          pass = "합격";
        } else {
          pass = "불합격";
        }
      } else {
        if (score >= 70) {
          pass = "합격";
        } else {
          pass = "불합격";
        }
      }
      System.out.println(scYear + "학년 " + score + "점은 \"" + pass + "\"입니다.");
  }

  
  public static void ex03_2() {
    //점수와 학년에 따른 학점
    //1~3학년 : 60점 이상 합격, 아니면 불합격
    //4~6학년 : 70점 이상 합격, 아니면 불합격
    int score = 60; // 점수
    int scYear = 4;  // 학년
    String pass;  // "합격", "불합격"
    int passScore;  // 합격의 최소 점수
    
    if(scYear <=3) {
      passScore = 60;
    } else {
      passScore = 70;
    }
    if(score >= passScore) {
      pass = "합격";
    } else {
      pass = "불합격";
    }
    System.out.println(pass);
    
  }
  
  // 4번 문제
  public static void ex04() {
    
    //메뉴에 따른 가격
    //아메리카노 : 2000
    //카페라떼 : 2500
    //밀크티 : 3000
    //기타 : 5000
    String order = "밀크티";
    int price;
    
    switch (order) {
    case "아메리카노": price = 2000; break;
    case "카페라떼": price = 2500; break;
    case "밀크티": price = 3000; break;
    default: price = 5000;
    }
    
    System.out.println(order + "는 " +  price + "원 입니다.");
    
  }
  
  
  // 5번 문제
  public static void ex05() {
    
    //월에 따른 계절    월 % 12
    //3 ~ 5 : 봄        3 ~ 5
    //6 ~ 8 : 여름      6 ~ 8
    //9 ~ 11: 가을      9 ~ 11
    //12 ~ 2: 겨울      0 ~ 2
    int month = 7;
    String season;  // "봄", "여름", "가을", "겨울"
    

    if(3 <= month && month <= 5) {
      season = "봄";
    } else if (6 <= month && month <= 8) {
      season = "여름";
    } else if (9 <= month && month <= 11) {
      season = "가을";
    } else {
      season = "겨울";
    }
    System.out.println(month + "월은 " + season + "입니다.");
    
  }
  
  
  // 5_2번 문제
  public static void ex05_2() {
    
    //월에 따른 계절    월 % 12
    //3 ~ 5 : 봄        3 ~ 5
    //6 ~ 8 : 여름      6 ~ 8
    //9 ~ 11: 가을      9 ~ 11
    //12 ~ 2: 겨울      0 ~ 2
    int month = 1;
    int mod = month % 12; //월 % 12
    String season;  // "봄", "여름", "가을", "겨울"
    if (mod <= 2) {
      season = "겨울";
    } else if (mod <= 5) {
      season = "봄";
    } else if (mod <= 8) {
      season = "여름";
    } else {
      season = "가을";
    }

    System.out.println(month + "월은 " + season + "입니다.");
    
  }
  
  
  // 6번 문제
  public static void ex06() {
    
    //월에 따른 분기
    //1 ~ 3 : 1분기
    //4 ~ 6 : 2분기
    //7 ~ 9 : 3분기
    //10 ~ 12 : 4분기
    int month = 7;
    
    if(month <= 3) {
      System.out.println("1분기");
    } else if (month <= 6) {
      System.out.println("2분기");
    } else if (month <= 9) {
      System.out.println("3분기");
    } else {
      System.out.println("4분기");
    }
    
  }
  
  
  // 6_2번 문제
  public static void ex06_2() {
    
    //월에 따른 분기        분기계산
    //1 ~ 3 : 1분기         (month - 1) / 3 + 1
    //4 ~ 6 : 2분기
    //7 ~ 9 : 3분기
    //10 ~ 12 : 4분기
    int month = 7;
    
    System.out.println((month - 1) / 3 + 1 + "분기");
    

    
  }
  
  
  // 7번 문제
  public static void ex07() {
    
    //10일 후 요일은?
    int day = 14;  // 13일은 금요일
    int nDay = 10;  // 10일
    String weekname;  // "월", "화", "수", "목", "금", "토", "일"
    
    switch ((day += nDay) % 7) {
    case 0: weekname = "금"; break;
    case 1: weekname = "토"; break;
    case 2: weekname = "일"; break;
    case 3: weekname = "월"; break;
    case 4: weekname = "화"; break;
    case 5: weekname = "수"; break;
    default: weekname = "목";
    }
    
    System.out.println(day + "일은 " + weekname + "요일 입니다.");
    
    
  }
  
  
  // 8번 문제 아스키코드
  public static void ex08() {
    
    // 대소문자 변환 (구글링으로 아스키코드 검색 후 참고)
    char ch = 'l';  // 임의의 대문자 또는 소문자
    
    if (ch >= 'A' && ch <= 'Z') {
      ch += 32;   // ch = ch 32;
    } else if (ch >= 'a' && ch <= 'z') {
      ch -= 32;   // ch = ch -32;
    }
    
    
    System.out.println(ch);
    
  }

  public static void main(String[] args) {
    
//    ex01();
//    ex02();
//    ex03();
//    ex03_2();
//    ex04();
//    ex05();
//    ex05_2();
//    ex06();
//    ex06_2();
//    ex07();
    ex08();

  }

}
