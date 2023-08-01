package ex02_Soldier;

public class MainWrapper {

  public static void main(String[] args) throws RuntimeException {  // main이 예외를 던지면 Java가 예외 처리한다.

    Gun gun = new Gun(30);
    Soldier s = new Soldier(gun);
    s.reload(30);
    s.reload(20);

    for (int n = 0; n < 50; n++) {
      s.shoot();
    }
    s.shoot();
  }

}
// main에서도 throws를 던질 수 있다.