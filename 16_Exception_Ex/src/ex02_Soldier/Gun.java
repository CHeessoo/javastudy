package ex02_Soldier;

public class Gun {
  // 필드
  private int bullet;
  private final int MAX_BULLET = 50;
  
  // 생성자
  public Gun(int bullet) {
    this.bullet = (bullet > MAX_BULLET ? MAX_BULLET : bullet);
  }
  
  // 장전 메소드
  public void reload(int bullet) throws RuntimeException {
    if((this.bullet + bullet) > MAX_BULLET) {
      throw new RuntimeException(bullet + "발은 장전이 불가능 합니다.");
    }
    this.bullet += bullet;
    System.out.println(bullet + "발이 장전 되었습니다. 현재 " + this.bullet + "발이 들어있습니다.");
  }
  
  // 발사 메소드
  public void shoot() throws RuntimeException {
    if(bullet == 0) {
      throw new RuntimeException("헛빵!");
    }
    bullet--;
    System.out.println("빵! 현재 " + bullet + "발이 남았습니다.");
  }

}
