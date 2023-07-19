package ex05_access_modifier;

/*
 * 접근 제어 지시자(Access Modifier)
 * 1. private : 같은 클래스 내부에서만 접근할 수 있다.
 * 2. default : 동일한 패키지 에서만 접근할 수 있다. (access modifier를 작성하지 않는 경우)
 *              - 아무것도 안 적은 상태를 디폴트라고 한다.
 * 3. protected : 동일한 패키지 or 다른 패키지에 있는 상속 관계의 클래스만 접근할 수 있다.
 * 4. public : 어디서든 접근할 수 있다.
 */

/*
 * 정보 은닉(Information Hiding)
 * 1. 객체가 가진 내부 정보(필드)를 외부에 직접 노출하지 않는다.
 * 2. 외부로부터 내부 정보(필드)를 숨김으로써 정보를 안전하게 관리할 수 있다.
 * 3. Java에서는 정보 은닉을 위해서 필드는 private 처리하고, 메소드는 public 처리한다.
 * 4. Java에서는 메소드를 통해서 필드에 접근한다.(필드에 직접 접근할 수 없다.)
 */

/*
 * Getter와 Setter(게터와 세터)
 * 1. Getter 
 *    1) 필드값을 외부로 반환(return)하는 메소드이다.
 *    2) "get + 필드명" 형식의 이름을 가지는 메소드이다.
 *    3) 메소드 이름을 마음대로 바꾸면 안 된다.
 * 2. Setter
 *    1) 외부로부터 받아 온 값(파라미터)을 필드에 저장하는 메소드이다.
 *    2) "set + 필드명" 형식의 이름을 가지는 메소드이다.
 *    3) 메소드 이름을 마음대로 바꾸면 안 된다.
 * 3. 참고. boolean 타입의 필드는 Getter/Setter의 이름 형식이 다르다.
 */

public class User {
  
  // field
  // 객체를 만들고, 객체를 이용해서 호출한다.
  private String id;   
  private int age;
  // private을 사용하지 않아서 정보은닉이 깨지면 아무나, 어디서든 필드값을 변경해버릴 수 있다.
  
  
  // method
  
  // getter : 필드값을 외부로 반환(return)하는 메소드
  public String getId() {
    return id;
  }
  public int getAge() {
    return age;
  }
  
  // setter : 외부로부터 전달된 값(파라미터)를 필드에 저장하는 메소드
  public void setId(String param) {
    id = param;
  }
  public void setAge(int param) {
    age = param;
  }
  
  
  
  
  /* 연습
  // 1) 파라미터로 특정 id를 받아옴. 2) id를 필드값에 저장.
  public void setId(String userId) {
    id = userId;
  }
  
  // 3) getId를 호출하면 id를 반환한다.
  public String getId() {
    return id;
  }

  // age값을 받아서 필드에 저장한다.
  public void setAge(int userAge) {
    age = userAge;
  }
  
  // 나이만 반환시켜준다.
  public int getAge() {
    return age;
  }
  */

}
