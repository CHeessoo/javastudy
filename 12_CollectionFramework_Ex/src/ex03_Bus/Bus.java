package ex03_Bus;

import java.util.ArrayList;
import java.util.List;

public class Bus {
  
  private List<Seat> seats;
  private final int LIMIT = 25;   // 25인승
  
  public Bus() {
    seats = new ArrayList<Seat>();
    for(int cnt = 0; cnt < LIMIT; cnt++) {
      seats.add(new Seat());
    }
  }
  
  
  public void getOn(int seatNo, Person person) {
    if(seatNo < 1 || seatNo > LIMIT) {
      System.out.println("존재하지 않는 좌석번호입니다.");
      return;
    }
    if(seats.get(seatNo - 1).getPerson() != null) {
      System.out.println("이미 점유된 좌석번호입니다.");
      return;
    }
    seats.get(seatNo - 1).setPerson(person);
    System.out.println(seatNo + "번 좌석에 " + person + " 탑승했습니다.");
  }
  
  
  public void getOff(int seatNo) {
    if(seatNo < 1 || seatNo > LIMIT) {
      System.out.println("존재하지 않는 좌석번호입니다.");
      return;
    }
    if(seats.get(seatNo - 1).getPerson() == null) {
      System.out.println("해당 좌석에 착석한 사람이 없습니다.");
      return;
    }
    System.out.println(seatNo + "번 좌석에 앉은 " + seats.get(seatNo - 1).getPerson() + "하차했습니다.");
    seats.get(seatNo - 1).setPerson(null);
  }
  
  public void info() {
    for(int i = 0; i < LIMIT; i++) {
      System.out.print((i+1) + "번 좌석: ");
      if(seats.get(i).getPerson() != null) {
        System.out.println(seats.get(i).getPerson());
      } else {
        System.out.println("빈 좌석");
      }
    }
  }

}
