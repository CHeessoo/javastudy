package ex03_intermedia;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainWrapper {
  
  public static void ex01() {
    
    // 필터 : 원하는 요소만 사용
    
    // Stream 생성
    // Stream<Integer> stream =Stream.of(1,2,3,4,5,6,7,8,9,10);
    
    // List (대부분 데이터는 ArrayList나 배열에서 시작한다.)
    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    
    // 홀수만 출력하기 (filter에서 Predicate를 사용한다.)
    list.stream()     // list에는 stream() 메소드가 있다.
    .filter((number) -> number % 2 == 1)   // 조건
    .forEach(n -> System.out.println(n));  // 할일
    
  }

  public static void ex02() {
    
    // 필터
    
    // List
    List<Person> list = Arrays.asList(
        new Person("홍자", 20),
        new Person("영미", 10),
        new Person("미희", 30),
        new Person("숙자", 15)
    );
    
    // age가 20이상인 Person을 List로 생성
    List<Person> adult = list.stream()
                             .filter((person) -> person.getAge() >= 20)
                             .collect(Collectors.toList());
    
    // adult 확인
    adult.stream()
         .forEach((person) -> System.out.println(person.getName() + ", " + person.getAge())); // 하나로 합칠수도 있음. 연습용으로 두개로 분리해서 확인.
    
  }
  
  public static void ex03() {
    
    // 변환 (값을 바꿈)
    
    // List
    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    
    // 1씩 증가시키기
    list.stream()
        .map((number) -> number + 1)   // map은 Function을 사용한다. (filter도 이어붙여서 사용 가능하다.)
        .forEach((number) -> System.out.println(number));
  }
  
  public static void ex04() {
   
    // List
    List<Person> list = Arrays.asList(
        new Person("홍자", 20),
        new Person("영미", 10),
        new Person("미희", 30),
        new Person("숙자", 15)
    );
    
    List<Person> adult = list.stream()   // ArrayList를 Stream으로 바꿔줌
        .filter((person) -> person.getAge() >= 20)
        .map((person) -> new Person(person.getName() + "님", person.getAge() + 1))  // 20살 이상인 사람의 나이만 +1
        .collect(Collectors.toList());
   
    System.out.println(adult);
    
    
  }
  
  public static void main(String[] args) {
    ex04();
  }

}
