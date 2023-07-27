package ex01_Person;

import java.util.ArrayList;
import java.util.List;

public class MainWrapper {

  public static void main(String[] args) {
    
    List<Person> family = new ArrayList<Person>();
    
    // 가족 모두 저장하고 for문으로 확인하기
    
    family.add(new Person("향심이", 23));
    family.add(new Person("현지", 30));
    family.add(new Person("희수", 24));
    family.add(new Person("문주", 25));
    family.add(new Person("현주", 23));
    
    
    for(int i = 0, length = family.size(); i < length; i++) {
      System.out.println(family.get(i));  // Person의 toString() 동작
      System.out.println("이름: " + family.get(i).getName());   // String 타입 이름과
      System.out.println("나이: " + family.get(i).getAge());    // int 타입 나이 분리해서 뽑아보기
    }
    
    
    
  }

}
