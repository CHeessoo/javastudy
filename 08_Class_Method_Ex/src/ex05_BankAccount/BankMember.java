package ex05_BankAccount;


public class BankMember {
  
  // 필드
  private String name;
  private BankAccount acc;
  
  // 생성자
  public BankMember(String name, BankAccount acc) {
    this.name = name;
    this.acc = acc;
  }
  public BankMember() {}

  
  // Setter
  public void setName(String name) {
    this.name = name;
  }
  public void setAcc(BankAccount acc) {
    this.acc = acc;
  }
  
  // Getter
  public String getName() {
    return name;
  }
  public BankAccount getAcc() {
    return acc;
  }
  
  
  // info
  public void info() {
    System.out.println("고객명: " + name);
    acc.info();
  }
  
  
  // 입금
  public void deposit(long money) {
    acc.deposit(money);
  }
  
  // 출금
  public long withdrawal(long money) {
    return acc.withdrawal(money);
  }
  
  

  // 이체
  public void transfer(BankMember member, long money) {
    member.deposit(withdrawal(money));
  }
}
