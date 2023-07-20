package ex03_Soldier;

public class Gun {
  // 필드
  private int bullet;
  private final int MAX_BULLET = 50;
  
  // 생성자
  public Gun(int bullet) {
    this.bullet = (bullet > MAX_BULLET ? MAX_BULLET : bullet);
  }
  
  // 장전 메소드
  public void reload(int bullet) {
    if((this.bullet + bullet) > MAX_BULLET) {
      System.out.println(bullet + "발은 장전이 불가능 합니다.");
      return;
    }
    this.bullet += bullet;
    System.out.println(bullet + "발이 장전 되었습니다. 현재 " + this.bullet + "발이 들어있습니다.");
  }
  
  // 발사 메소드
  public void shoot() {
    if(bullet == 0) {
      System.out.println("헛빵!");
      return;
    }
    bullet--;
    System.out.println("빵! 현재 " + bullet + "발이 남았습니다.");
  }

}
