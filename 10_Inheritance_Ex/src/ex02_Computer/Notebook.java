package ex02_Computer;

public class Notebook extends Computer {
  
  private int battery;  // 배터리 용량
  
  // new Notebook("gram", 70)에 의해서 호출되는 생성자
  public Notebook(String model, int battery) {
    super(model);   // 항상 반드시 super 먼저 호출 (작성 위치 주의)
    this.battery = battery;
  }
  
  // Getter & Setter
  public int getBattery() {
    return battery;
  }
  public void setBattery(int battery) {
    this.battery = battery;
  }

}
