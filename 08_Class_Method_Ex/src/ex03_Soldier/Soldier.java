package ex03_Soldier;

public class Soldier {
  
  private Gun gun;
  
  // 군인 생성자
  public Soldier(Gun gun) {
    this.gun = gun;
  }
  // 군인 생성자 객체생성 버전
  public Soldier(int bullet) {
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
