package ex02_Computer;

public class Computer {
  
  private String model;   // 컴퓨터 모델명
  
  // Notebook 생성자의 super(model);에 의해서 호출되는 생성자
  public Computer(String model) {
    this.model = model;
  }
  
  // Getter & Setter
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }

}
