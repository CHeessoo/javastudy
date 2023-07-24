package ex09_Family;

public class MainWrapper {  

  
  public static void ex01() {

    // 가족이 3명인 경우
    Family f = new Family(3);
    
    // 가족의 이름 3개, 나이 3개
    String[] name = {"나", "엄마", "언니"};
    int[] age = {20, 23, 30};
    
    // 디폴트 생성자 + Setter
    for(int i = 0; i < f.getFamily().length; i++) {   // f.getFamily().length == f.getFamilyCount()
      
      f.getFamily()[i] = new Person();    // 디폴트 생성자를 이용해서 배열 요소를 저장해 둔다.
      
      f.getFamily()[i].setName(name[i]);  // Setter를 이용해서 이름을 저장한다.
      f.getFamily()[i].setAge(age[i]);    // Setter를 이용해서 나이를 저장한다.
    }
    
    // 확인
    for(int i = 0; i < f.getFamily().length; i++) {
      System.out.println((i+1) + "번째 가족 이름: " + f.getFamily()[i].getName());
      System.out.println((i+1) + "번째 가족 나이: " + f.getFamily()[i].getAge());
    }
    
  }
  
  public static void ex02() {
    
    // Person이 3명인 Family 객체 생성
    Family f = new Family(3);
    
    // 가족의 이름 3개, 나이 3개
    String[] name = {"나", "엄마", "언니"};
    int[] age = {20, 23, 30};
    
    // 파라미터가 2개인 생성자
    for(int i = 0; i < f.getFamily().length; i++) {
      
      f.getFamily()[i] = new Person(name[i], age[i]);
    }
    
    // 확인
    for(int i = 0; i < f.getFamily().length; i++) {
      System.out.println((i+1) + "번째 가족 이름: " + f.getFamily()[i].getName());
      System.out.println((i+1) + "번째 가족 나이: " + f.getFamily()[i].getAge());
    }
  }

  public static void ex03() {
    
    // ex01() 리팩토링
    
    Family f = new Family(3);
    
    // 가족의 이름 3개, 나이 3개
    String[] name = {"나", "엄마", "언니"};
    int[] age = {20, 23, 30};
    
    Person[] family = f.getFamily();
    for(int i = 0; i < family.length; i++) {
      family[i] = new Person();
      family[i].setName(name[i]);
      family[i].setAge(age[i]);
    }
    
    // 향상 for문 이용
    for(Person p : family) {
      if(p != null) {   // NullPointExeption을 방지해서 보다 안전한 코드가 된다.
      System.out.println("가족 이름: " + p.getName());
      System.out.println("가족 나이: " + p.getAge());
      }
    }
    
  }
  
  public static void ex04() {
    
    // ex02() 리팩토링
    
    Family f = new Family(3);
    
    // 가족의 이름 3개, 나이 3개
    String[] name = {"나", "엄마", "언니"};
    int[] age = {20, 23, 30};
    
    // 리팩토
    Person[] family = f.getFamily();
    // 파라미터가 2개인 생성자
    for(int i = 0; i < family.length; i++) {
      family[i] = new Person(name[i], age[i]);
    }
    
    // for문으로 확인
    for(int i = 0; i < family.length; i++) {
      System.out.println((i+1) + "번째 가족 이름: " + family[i].getName());
      System.out.println((i+1) + "번째 가족 나이: " + family[i].getAge());
    }
    
    // 향상 for문 NullPointExeption 방지 예시 (객체는 항상 null 값을 조심해야한다.)
    family[1] = null;
    for(Person p : family) {
      if(p != null) {
        System.out.println("가족 이름:" + p.getName());
        System.out.println("가족 나이:" + p.getAge());
      }
    }
    
  }
  
  public static void main(String[] args) {
    // ex01();
    // ex02();
    // ex03();
    ex04();
    
  }

}

// 반복되는 메소드(리팩토링 포인트)는 리팩토링 하는것이 좋음
// 하지만 개발을 할 땐 리팩토링을 하는것은 좋지 않음
// 리팩토링 => SM 업무인 경우에 고려대상

// 변수는 여러번 참조해도 되지만, 메소드를 여러번 호출하는 것은 좋지 않음