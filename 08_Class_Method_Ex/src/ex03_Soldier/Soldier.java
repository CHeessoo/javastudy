package ex03_Soldier;

public class Soldier {
  
  private Gun gun;
  
  // 군인 생성자
  public Soldier(int bullet) {
    // 총 객체 생성
    gun = new Gun(bullet);
    
  }
  
  // 군인 장전
  public void reload(int bullet) {
    gun.reload(bullet);
  }
  
  // 군인 발사
  public void shoot() {
    gun.shoot();
  }

}
