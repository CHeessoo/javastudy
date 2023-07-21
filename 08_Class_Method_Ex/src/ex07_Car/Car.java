package ex07_Car;

public class Car {
  
  private Driver driver;
  private int speed;
  private int fuel;
  private final int MAX_SPEED = 100;
  
  
  
  // Getter & Setter
  public Driver getDriver() {
    return driver;
  }
  public void setDriver(Driver driver) {
    this.driver = driver;
  }
  
  public int getSpeed() {
    return speed;
  }
  public void setSpeed(int speed) {
    this.speed = speed;
  }
  
  public int getFuel() {
    return fuel;
  }
  public void setFuel(int fuel) {
    this.fuel = fuel;
  }
  
  
  public void engineStart() {
    if(fuel == 0) {
      System.out.println("시동이 걸리지 않았습니다.");
    } else {
      System.out.println("시동이 걸렸습니다.");
    }
  }
  
  public void drive() {
    if(fuel == 0 || driver == null) {
      System.out.println("자동차가 운행하지 않았습니다.");
    } else {
      System.out.println("자동차가 운행하였습니다.");
    }
  }
  
  public void accel(int speed) {
    fuel--;   // accel을 밟을 때 마다 기름이 줄어든다.
    this.speed += speed;    // 고정
    
    // if문으로 처리하는 방법 (삼항 연산자도 가능)
    if(this.speed > MAX_SPEED) {
      this.speed = MAX_SPEED;
    }
    System.out.println("현재 속도는 " + this.speed + "입니다.");
  }
  
  public void brake(int speed) {
    this.speed -= speed;
    
    if(this.speed < 0) {
      this.speed = 0;
    }
    System.out.println("현재 속도는 " + this.speed + "입니다.");
  }
  
}
