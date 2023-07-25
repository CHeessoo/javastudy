package ex05_upcasting;

public class Person {
  
  private String name;
  
  // new Person()
  public Person() {
    
  }
  
  // new Person("홍길동")
  public Person(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void eat() {
    System.out.println("냠냠");
  }
  public void sleep() {
    System.out.println("쿨쿨");
  }
  
  // 실행이 목적이 아닌 호출이 목적인 메소드
  public void study() {
    // student에 있는 study를 호출하기 위해 추가한 메소드
  }
  public void working() {
    // Alba에 있는 working을 호출하기 위해 추가한 메소드
  }
  
  
  // information
  public void info() {
    System.out.println("이름: " + name);
  }

}
