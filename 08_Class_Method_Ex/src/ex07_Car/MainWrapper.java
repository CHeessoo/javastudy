package ex07_Car;

public class MainWrapper {

  public static void main(String[] args) {
    
    Driver driver = new Driver();
    
    driver.setName("홍길동");
    driver.setCareer(20);
    
    Car mCar = new Car();
    mCar.setDriver(driver);
    mCar.setFuel(50);
    
    mCar.engineStart(); // 시동이 걸렸습니다.    시동이 걸리지 않았습니다.
    mCar.drive();   // 자동차가 운행하였습니다.  자동차가 운행하지 않았습니다.
    mCar.accel(50); // 기존 속도에 50이 추가, 현재 속도는 50입니다.
    mCar.accel(60); // 기존 속도에 60이 추가(최대 속도는 100), 현재 속도는 100입니다.
    mCar.brake(50); // 기존 속도가 50만큼 감속, 현재 속도는 50입니다.
    mCar.brake(60); // 기존 속도가 60만큼 감속(최저 속도는 0), 현재 속도는 0입니다.
    
    
  }

}
