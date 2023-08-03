package ex01_mkdirs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class MainWrapper {

  public static void main(String[] args) {
    // 현재 날짜와 시간을 이용하여 디렉터리를 만드시오.
    // C:/2023/08/03/14
    
    /* 내 답안
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH");
    String strDate = sdf.format(date);
    File dir = new File("C:/"+ strDate);
    if (dir.exists()) {
      dir.delete();
      System.out.println("C:/" + strDate + " 디렉터리 삭제 완료");
    } else {
      dir.mkdirs();
      System.out.println("C:/" + strDate + " 디렉터리 생성 완료");
    }
  */
  
  // 강사님 답안 코드
  LocalDateTime localDateTime = LocalDateTime.now();
  int year = localDateTime.getYear();
  int month = localDateTime.getMonthValue();
  int day = localDateTime.getDayOfMonth();
  int hour = localDateTime.getHour();
  
  StringBuilder sb = new StringBuilder();
  sb.append("C:");
  sb.append("/");
  sb.append(year);
  sb.append("/");
  sb.append(String.format("%02d", month));
  sb.append("/");
  sb.append(String.format("%02d", day));
  sb.append("/");
  sb.append(String.format("%02d", hour));
  
  File dir = new File(sb.toString());
  if(!dir.exists()) {
    dir.mkdirs();
  }
  System.out.println(dir.getPath() + " 디렉터리 생성 완료");
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  }
}
