package ex09_interface;

public class Circle implements Shape {
  
  private double radius;
  
  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return PI * radius * radius;
  }

}


// 인터페이스를 구현하는 클래스는 클래스를 만들 때 구현체를 만들어주면 된다.
// 우클릭 - New - interface - add - (최초 1번은 검색을 해서 찾아야 한다.)