package ex02_OutputStream;

import java.io.Serializable;

/*
 * 직렬화(Serializable) 처리하기
 * 1. java.io.Serializable 인터페이스를 구현(implements)한다.
 * 2. long serialVersionUID 필드 값을 생성(generate)한다. 
 *    (long타입의 Serializable Version Unique ID)
 */

public class Student implements Serializable {
  
  private static final long serialVersionUID = -988261495718805568L;  // 임의의 랜던값을 자바가 생성하도록 한다.
  private String name;
  private int age;
  private double height;
  private String school;
  
  public Student() {
    
  }
  public Student(String name, int age, double height, String school) {
    super();
    this.name = name;
    this.age = age;
    this.height = height;
    this.school = school;
  }

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
  public double getHeight() {
    return height;
  }
  public void setHeight(double height) {
    this.height = height;
  }
  public String getSchool() {
    return school;
  }
  public void setSchool(String school) {
    this.school = school;
  }

  @Override
  public String toString() {
    return "Student [name=" + name + ", age=" + age + ", height=" + height + ", school=" + school + "]";
  }
  
  

}
