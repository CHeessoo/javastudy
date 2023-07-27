package ex03_Bus;

public class Student extends Person{

  // new Student("홍길동")
  public Student(String name) {
    super(name);
  }
  
}
// 필드가 없는데 생성자가 필요한 경우는 상속관계밖에 없음