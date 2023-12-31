package ex07_Object;

import java.util.Objects;

/*
 * java.lang.Object 클래스
 * 1. 모든 클래스의 최상위 슈퍼 클래스
 * 2. 별도의 슈퍼 클래스를 명시하지 않은 클래스들은(extends가 없는 클래스) 모두 Object 클래스의 서브 클래스이다.
 * 3. 모든 것을 저장할 수 있는 Java의 만능 타입이다.
 * 4. Object 타입으로 저장하면 Object 클래스의 메소드만 호출할 수 있다. 이를 해결하기 위해서 "반드시" 캐스팅을 해야 한다.
 */

/*
 * 상속 관계 도식
 *  ┌--------------┐
 *  │    Object    │ 슈퍼 클래스
 *  │--------------│
 *  │   equals()   │ 두 객체의 참조값을 비교해서 같으면 true, 아니면 false 반환
 *  │   getClass() │ 어떤 클래스인지 반환
 *  │   hashCode() │ int 타입의 해시코드값, Object 클래스는 객체의 참조값을 해시코드값으로 사용함
 *  │   toString() │ "클래스이름@참조값" 형식의 문자열을 반환
 *  │   notify()   │ 스레드(thread) 관련 메소드
 *  │   wait()     │ 스레드(thread) 관련 메소드
 *  └--------------┘
 *          ▲
 *          │
 *          │
 *  ┌--------------┐
 *  │    Person    │ 서브 클래스
 *  │--------------│
 *  │   @Override  │
 *  │   equals()   │ 이름과 나이가 같으면 true, 아니면 false 반환 (하드코딩하지 않고, 자동완성한다.)
 *  │              │ 
 *  │   @Override  │
 *  │   toString() │ 이름과 나이를 확인할 수 있는 문자열 반환 (하드코딩하지 않고, 자동완성한다.)
 *  └--------------┘
 */

public class Person {
  
  private String name;
  private int age;
  
  // new Person()
  public Person() {
    
  }
  // new Person("홍길동", 20)
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  
  // 오브젝트의 메소드를 오버라이드
  @Override
  public int hashCode() {
    return Objects.hash(age, name);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)    // p1.equals(p1)
      return true;      
    if (obj == null)    // p1.equals(null)
      return false;
    if (getClass() != obj.getClass())   // p1.equals(s1) 다른 클래스 비교 == false
      return false;
    Person other = (Person) obj;        // 캐스팅
    return age == other.age && Objects.equals(name, other.name);  // 내용비교
  }
  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";   // 이름과 나이의 문자열 반환
  }
  
  
  
  /* equals 하드코딩 연습 예제 (but, equals 오버라이드 시 하드코딩X )
  @Override
  public boolean equals(Object obj) {  // p1.equals(p2) --> p2를 obj로 받아옴                // Person을 받아와서
    Person p = (Person)obj;   // p = p2                                                      // downcasting 해줌
    return (age == p.age) && name.equals(p.name);   // (p1의 age ==(비교) p2의 age) && (p1.name.문자열비교(p2.name);
  }                                                 //       나이 비교              &&           이름 비교;
   */

  
  
  // Getter & Setter
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  
  
}


// 클래스의 full name 표기법 : 패키지명.클래스명 (java.lang = 패키지명)
