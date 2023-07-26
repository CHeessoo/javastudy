package ex09_Eatable;

public class MainWrapper {

  public static void main(String[] args) {
    
    Person p = new Person();
    
    p.eatEverything(new AppleMango("애플망고"));  // 애플망고 먹는다.
    p.eatEverything(new Coriander("고수"));  // 고수 먹는다.
    
    p.eatPossible(new AppleMango("애플망고"));  // 애플망고 먹는다.       -- 타입체크
    // p.eatPossible(new Coriander("고수"));  // 컴파일 오류 발생         -- 타입체크
    
  }

}

// 인터페이스 타입체크 : 주로 이름에 able이 붙음.