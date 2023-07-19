package ex;

public class MainWrapper2 {
  
  public static void ex01(int a, int b) {   // 인수를 파라미터로 넘길 때 값의 복사가 이뤄지는 개념이다. 
    System.out.println(a + ", " + b);
    a++;
    b++;
    System.out.println("ex01의 a = " + a);
    System.out.println("ex01의 b = " + b);
  }

  public static void main(String[] args) {   // main의 메모리에 int a, b가 있고, ex01의 a, b가 메모리에 따로 또 복사되어 저장되는 방식이다.
    
    int a = 10;
    int b = 20;
    ex01(a, b);   // 10, 20 출력

    System.out.println("main의 a = " + a);
    System.out.println("main의 b = " + b);
  }

}
