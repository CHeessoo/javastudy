package ex01_anonymous_inner_type;

public class GasStation {
  
  private int totalOil;
  private int payPerLiter;
  private int earning;
  
  public GasStation() {
    
  }
  
  public void sellOil(String model, int oil) {
    
    // Car 인터페이스를 구현한 별도 클래스를 만들고, 해당 클래스 객체를 만들고, addOil() 호출 --> 메모리에서 사라지지 않고 쌓이는 방식
    // Car's addOil()
    
    // Car car 지역변수(객체) 선언 (sellOil 메소드 호출 시 생성되고, sellOil 메소드 종료 시 소멸된다.)
    Car car;
    
    // Car car 지역변수(객체) 생성
    car = new Car() {
      @Override
      public void addOil() {
        totalOil -= oil;
        earning += oil * payPerLiter;
        System.out.println(model + " " + oil + "L 주유 완료");
      }
    };  // 람다식: 해당 표기법을 보다 단순한 방식으로 바꿀 수 있다.
    
    // Car car 지역변수(객체)의 addOil() 메소드 호출
    car.addOil();
  }
  
  public int getTotalOil() {
    return totalOil;
  }
  public void setTotalOil(int totalOil) {
    this.totalOil = totalOil;
  }
  public int getPayPerLiter() {
    return payPerLiter;
  }
  public void setPayPerLiter(int payPerLiter) {
    this.payPerLiter = payPerLiter;
  }
  public int getEarning() {
    return earning;
  }
  public void setEarning(int earning) {
    this.earning = earning;
  }
  
  
  
}
// 추상메소드의 본문만 다 만든다면 인터페이스도 new 로 생성이 가능하다. (인터페이스의 필수 약속: 인터페이스를 오버라이드 해야한다.)