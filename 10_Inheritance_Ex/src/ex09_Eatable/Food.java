package ex09_Eatable;

public class Food {
  
  private String name;
  
  public Food(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  //참조값이 아닌 객체에 들어있는 데이터를 확인하기 위해 오버라이드
  @Override
  public String toString() {
    return "Food [name=" + name + "]";
  }

}
