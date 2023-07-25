package ex05_upcasting;

/*
 * upcasting
 * 1. 서브 클래스 객체를 슈퍼 클래스 타입으로 저장할 수 있다.
 * 2. 강제로 캐스팅(형변환)할 필요가 없다. 자동으로 변환된다.
 * 3. 장점
 *    1) 슈퍼 클래스 타입으로 모든 서브 클래스 객체를 저장할 수 있다.
 *    2) 서로 다른 타입의 객체를 하나의 타입으로 관리할 수 있다.
 * 4. 단점
 *    1) 슈퍼 클래스 타입으로 저장하기 때문에 슈퍼 클래스의 메소드만 호출할 수 있다.
 *    2) 이 단점을 해결하기 위해서 메소드 오버라이드(method override)를 이용할 수 있다. (or downcasting)
 */


public class MainWrapper {

  public static void main(String[] args) {
    
    // upcasting 활용 방법
    Person p1 = new Student("고길동", "강원대학교");      // subclass 객체를 superclass타입으로 저장 == upcasting
    Person p2 = new Alba("홍길동", "가산대학교", "투썸"); // 서로 다른 타입의 Student 와 Alba라는 객체를 Person이라는 하나의 타입으로 관리할 수 있게된다.
                                                          // *** 자식 객체를 부모의 타입으로 저장할 수 있다.***
    // Student에만 있던 study 메소드를 Person에 추가하여 오버라이드 함.
    p1.eat();
    p1.sleep();
    p1.study();
    
    // Alba에만 있던 working 메소드를 Person에 추가하여 오버라이드 함.
    p2.eat();
    p2.sleep();
    p2.study();
    p2.working();
    
    
    /* 상속 개념 복습
    Student s1 = new Student();
    s1.setName("홍길동");
    s1.setSchool("가산대학교");
    s1.eat();
    s1.sleep();
    s1.Study();
    System.out.println(s1.getName());
    System.out.println(s1.getSchool());
    
    Student s2 = new Student("홍길동", "가산대학교");
    s2.eat();
    s2.sleep();
    s2.Study();
    System.out.println(s2.getName());
    System.out.println(s2.getSchool());
    */
    
    /* 오버라이드 복습
    Alba alba = new Alba("홍길동", "가산대학교", "투썸");
    alba.info();
    */
    
    
  }

}
