package ex05_BankAccount;

public class Bank {
  
  // 필드
  private String bank;
  private String phoneNumber;
  
  // 생성자
  public Bank(String bank, String phoneNumber) {
    this.bank = bank;
    this.phoneNumber = phoneNumber;
  }
  
  // info
  public void info() {
    System.out.println(bank + "(" + phoneNumber + ")");
  }
  

}
