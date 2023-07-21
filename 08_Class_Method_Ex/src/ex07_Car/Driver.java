package ex07_Car;

public class Driver {
  
  private String name;
  private int career;   // 기준 career가 10년 이상이면 true
  private boolean bestDriver;
  
  // Getter & Setter
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public int getCareer() {
    return career;
  }
  public void setCareer(int career) {
    this.career = career;
    setBestDriver(career >= 10);
    
  }
  
  public boolean isBestDriver() {   // boolean 타입은 Getter명 지을때 get+필드명이 아닌 "is+필드명"
    return bestDriver;
  }
  private void setBestDriver(boolean bestDriver) {   // 다른 클래스에서 호출하지 못하게 하려면(잘못된 접근을 막음) -> private
    this.bestDriver = bestDriver;
  }

}
