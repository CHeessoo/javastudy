package ex02_convert_type;

public class MainWrapper {
  
  public static void main(String[] args) {
    
    /*
     * 자동 변환(promotion)
     * 1. 작은 크기 -> 큰 크기
     * 2. 정수      -> 실수
     */
    
    
    byte num1 = 127;  // byte는 -128 ~ 127 가능
    int num2 = num1;  // 1바이트 크기를 가진 num1을 4바이트 크기로 자동 변환
    System.out.println(num2);
    
    double addResult = 1.5 + 5;   // 5를 5.0으로 자동 변환
    System.out.println(addResult);
    
    /*
     * 강제 변환(castiog)
     * 1. 큰 크기 -> 작은 크기
     * 2. 실수 -> 정수
     */
    
    int bigNum = 256;
    byte smallNum = (byte)bigNum;   // 4바이트 bigNum을 강제로 1바이트로 변환
    System.out.println(smallNum);   // 원본이 훼손될 수 있다. (캐스팅을 잘못하면 100% 개발자 책임이 됨)
    
    
    
    
    
    
  }

}

















