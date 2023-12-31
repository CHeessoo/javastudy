package ex;

public class MainWrapper {

  public static void main(String[] args) {
    
    // 초 -> 분/초
    int second = 90;
    int m = second / 60;  // 1
    int s = second % 60;  // 30
    System.out.println(second + "초는 " + m + "분 " + s + "초 입니다.");

    
    // x와 y값을 교환
    int x = 10;
    int y = 20;
    int temp;
    
    temp = x;   // temp = 10
    x = y;      // x = 20
    y = temp;   // y = 10
    
    System.out.println("x = " + x);
    System.out.println("y = " + y);

 
    // 5% 이자를 받으면 통장잔액이  얼마?(소수 이하는 버림)
    long balance = 123456L;  // 통장잔액
    double pct = 0.05;  // 5%
    // balance = balance + balance * pct;
    // balance = balance * (1 + pct);   // 타입이 다르기 때문에 오류가 남(casting 필요)
    // balance = (long)(balance * (1 + pct));   // balance *= (1 + pct); 와 같은 풀이 개념
    
    balance *= (1 + pct);               
    System.out.println("통장잔고는 " + balance + "원 입니다.");

  
    // 90점대 점수이면 true, 아니면 false         //더블..? 불리언...? 더블로.. 트루 펄스..? 어떻게..?
    int score1 = 95;
    boolean result1 = (score1 >= 90) && (score1 < 100);  // true
    int score2 = 75;
    boolean result2 = (score2 / 10) == 9;  // false
    System.out.println("result1 : " + result1);
    System.out.println("result2 : " + result2);
    


    // n의 "짝수", "홀수" 여부 출력
    int n = 3;
    String res1 = (n % 2) == 0 ? "짝수" : "홀수";  // "홀수"
    System.out.println(n + "은(는) " + res1 + "입니다.");
    

    
    // num의 "짝수", "홀수", "3의배수" 여부 출력
    int num = 3;
    String res2 = (num != 0) && (num % 3 == 0) ? "3의 배수" : (num % 2 == 0) ? "짝수" : "홀수";  // "3의배수"
    System.out.println(num + "은(는) " + res2 + "입니다.");
    
  }

}
