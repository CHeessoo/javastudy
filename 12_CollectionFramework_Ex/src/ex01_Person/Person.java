package ex01_Person;

public class Person {
  
  private String name;
  private int age;
  
  // 디폴트 생성자
  public Person() {
    
  }

  // new Person(name, age) 생성자
  public Person(String name, int age) {
    super();  // object
    this.name = name;
    this.age = age;
  }

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

  // name 과 age에 입력된 데이터 반환
  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }
  
  

}
