package ex03_Rectangle;

// is a 관계
public class Square extends Rectangle{
  
  // new Square()
  public Square() {
    super();  // 생략가능
  }
  
  // new Square(6)
  public Square(int width) {
    super(width, width);  // new Rectangle(6, 6)
  }

}
