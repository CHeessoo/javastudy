package ex01_Stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MainWrapper {
  
  /* 스트림 생성 & forEach() */
  public static void ex01() {
    
    /*
     * forEach() 메소드
     * 1. Stream 파이프라인의 마지막에 사용할 수 있는 메소드 중 하나이다.
     * 2. Stream 파이프라인의 각 요소를 순회할 때 사용한다.
     * 3. for문처럼 동작한다.
     * 4. 형식
     *    void forEach(Consumer<T> consumer);
     */
    
    // Stream 생성
    Stream<String> stream = Stream.of("봄", "여름", "가을", "겨울"); 
    
    // Consumer 생성 (Anonymous inner Type 생성)
    Consumer<String> consumer = new Consumer<String>() {
      @Override
      public void accept(String t) {
        System.out.println(t);
      }
    };
    
    // forEach() 메소드 호출
    stream.forEach(consumer); // stream 파이프라인에 들어있는 데이터를 forEach()메소드를 통해 순서대로 꺼낸다. consumer 파라미터를 통해 값을 전달.
    
  }
  
  public static void ex02() {
    
    // Stream 생성
    Stream<String> stream = Stream.of("봄", "여름", "가을", "겨울"); // Stream.of() 메소드 : Stream의 초기화를 위해 사용하는 메소드
    
    // Consumer 생성 (람다 표현식 생성)
    Consumer<String> consumer = (t) -> System.out.println(t);
    
    // forEach() 호출
    stream.forEach(consumer); // Stream에 속해있는 forEach() 메소드
    
  }
  
  public static void ex03() {
    
    // Stream 생성
    Stream<String> stream = Stream.of("봄", "여름", "가을", "겨울");
    
    // forEach() 메소드 호출
    stream.forEach((t) -> System.out.println(t));
    
  }
  
  /* 각종 스트림 생성 방법 */
  public static void ex04() {
    
    // 1. Integer 전용 Stream
//    IntStream iStream = IntStream.of(1,2,3,4,5);     // 1,2,3,4,5                 -- 전부 같은 방법
//    IntStream iStream = IntStream.range(1, 6);       // 1이상 6미만(1,2,3,4,5)
//    IntStream iStream = IntStream.rangeClosed(1, 5); // 1이상 5이하(1,2,3,4,5)
    
    IntStream iStream = IntStream.of(1,2,3,4,5);  // 1,2,3,4,5 
    iStream.forEach( (number) -> System.out.println(number) );
    
    
    // 2. Long 전용 Stream (range, rangeClosed 가능)
    LongStream lStream = LongStream.of(1,2,3,4,5);  
    lStream.forEach((number) -> System.out.println(number));
    
    // 3. Double 전용 Stream (range, rangeClosed 불가능)
    DoubleStream dStream = DoubleStream.of(1.1, 2.2); 
    dStream.forEach((number) -> System.out.println(number));
  }
  
  public static void ex05() {
    
    // 배열 -> Stream
    
    // 1. 일반 Stream
    String[] season = {"봄", "여름", "가을", "겨울"};
    Stream<String> stream = Arrays.stream(season);
    stream.forEach((t) -> System.out.println(t));
    
    // 2. IntStream
    int[] iNumber = {1,2,3,4,5};
    IntStream iStream = Arrays.stream(iNumber);
    iStream.forEach((number) -> System.out.println(number));
    
    // 3. DoubleStream
    double[] dNumber = {1.1, 2.2};
    DoubleStream dStream = Arrays.stream(dNumber);
    dStream.forEach((number) -> System.out.println(number));
    
    // Arrays.stream(dNumber).forEach(System.out::println);   -- 한줄로 줄여본 예시
    
  }
  
  public static void ex06() {
    
    // 컬렉션(Collection) -> Stream
    
    // List
    List<String> list = Arrays.asList("봄", "여름", "가을", "겨울");
    Stream<String> stream = list.stream();
    stream.forEach((t) -> System.out.println(t)); // 파라미터에 괄호 생략도 가능, t -> System.out.println(t)
    
    // Set -> Stream
    Set<String> set = new HashSet<String>(Arrays.asList("봄", "여름", "가을", "겨울"));
    set.stream().forEach(t -> System.out.println(t)); 
    
  }
  
  public static void ex07() {
    
    // 파일(입출력 스트림) -> Stream
    File file = new File("src/ex01_Stream/hello.txt"); // new File("hello.txt")도 가능함(동일한 경로 안에 있기 때문이다.)
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      
      // Stream 생성
      Stream<String> stream = reader.lines(); // line을 한줄씩 전부 읽어서 스트림 파이프라인에 준비 시킨다.
      
      // forEach() 호출
      StringBuilder sb = new StringBuilder();
      stream.forEach((line) -> sb.append(line + "\n")); // while문 없이 line을 모을 수 있다. (반복문 생략)
      
      // 확인
      System.out.println(sb.toString());
      
    } catch(IOException e) {
      e.printStackTrace();
    }
    
  }
  
  public static void ex08() {
    
    // Path를 이용한 Stream 처리
    
    try {
      Path path = Paths.get("src/ex01_Stream/hello.txt");
      Stream<String> stream = Files.lines(path);
      stream.forEach((line) -> System.out.println(line));
      stream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  public static void ex09() {
    
    // 디렉터리에 저장된 파일 목록 -> Stream
    
    // 배열을 Stream으로 바꾸는 과정
    File dir = new File("C:/Program Files");
    File[] files = dir.listFiles(); // 파일 배열로 dir에 있는 모든 파일을 저장
    Stream<File> stream = Arrays.stream(files);   // 배열을 Stream으로 바꾼다
    stream.forEach((file) -> System.out.println(file.getPath()));
    
  }
  
  public static void ex10() {
    
    // Path를 이용한 Stream 처리
    
    try {
      Path path = Paths.get("C:/Program Files"); // Paths 는 Path의 헬퍼 클래스
      Stream<Path> stream = Files.list(path);
      stream.forEach((p) -> System.out.println(p.getFileName()));
      stream.close(); // Path 사용 시 스트림을 닫아야 한다.
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  public static void main(String[] args) {
    ex10();
  }

}