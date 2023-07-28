package ex04_Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainWrapper {

  public static void main(String[] args) {
    
    // 교실의 5명 학생 정보를 저장하는 HashMap 만들기
    // Key   : 학번(예: 10101)
    // Value : Student 객체
    
    Map<Integer, Student> clazz = new HashMap<Integer, Student>();
    
    clazz.put(10101, new Student("문주", new Exam(100, 100, 100)));
    clazz.put(10102, new Student("현주", new Exam(100, 100, 100)));
    clazz.put(10103, new Student("희수", new Exam(100, 100, 100)));
    clazz.put(10104, new Student("맹구", new Exam(60, 70, 80)));
    clazz.put(10105, new Student("짱구", new Exam(50, 70, 90)));
    
    /*
    Student student = new Student();
    student.setName("철수");
    student.setExam(new Exam(85, 90, 95));
    clazz.put(10106, student);
    */
    
    Integer[] stuNo = {10101, 10102, 10103, 10104, 10105};
    for(int i = 0; i < stuNo.length; i++) {
      Student student = clazz.get(stuNo[i]);
      System.out.println("이름: " + student.getName());
      System.out.println("성적: " + student.getExam());
    }
    
    
  }

}
