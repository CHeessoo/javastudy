package ex09_Family;

public class Family {
  
  private int familyCount;  // 가족의 수, 배열의 길이
  private Person[] family;  // 가족 배열, 배열의 선언만 수행
  
  public Family(int familyCount) {
    this.familyCount = familyCount;
    family = new Person [familyCount];  // 배열의 생성이 수행
  }
  
  public int getFamilyCount() {
    return familyCount;
  }
  public void setFamilyCount(int familyCount) {
    this.familyCount = familyCount;
    Person[] temp = new Person[familyCount];
    System.arraycopy(family, 0, temp, 0, family.length);
    family = temp;  // 임시 배열의 주소값을 패밀리 배열에 복사
    
  }
  public Person[] getFamily() {
    return family;
  }
  public void setFamily(Person[] family) {
    this.family = family;
  }
  
}
