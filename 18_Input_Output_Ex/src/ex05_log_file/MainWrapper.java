package ex05_log_file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainWrapper {

  public static void main(String[] args) {

    @SuppressWarnings("resource") // sc.close()를 생략해도 경고 메시지를 보이지 말라.
    Scanner sc = new Scanner(System.in);

    while (true) {

      try {

        System.out.print("첫 번째 정수를 입력하세요 >>> ");
        int n1 = sc.nextInt();

        System.out.print("연산자를 입력하세요(+-*/%) >>> ");
        String op = sc.next();

        System.out.print("두 번째 정수를 입력하세요 >>> ");
        int n2 = sc.nextInt();

        int result = 0;
        switch (op) {
        case "+":
          result = n1 + n2;
          break;
        case "-":
          result = n1 - n2;
          break;
        case "*":
          result = n1 * n2;
          break;
        case "/":
          result = n1 / n2;
          break;
        case "%":
          result = n1 % n2;
          break;
        default:
          throw new RuntimeException("invalid operator " + op);
        }

        System.out.println(n1 + op + n2 + "=" + result);

      } catch (Exception e) {

        sc.nextLine();

        // 문제. 예외가 발생할때마다 예외가 발생한 시간과 예외 메시지(message)를 C:/storage/log.txt 파일에 기록하시오.
        // C:/storage/log.txt 파일 내용 예시)
        // 2023-08-04 15:10:30 / by zero
        // 2023-08-04 15:11:23 invalid operator ++
        // 2023-08-04 15:12:52 null
        
        File dir = new File("C:/storage");
        File logFile = new File(dir, "log.txt");
        
        BufferedOutputStream bout = null;
        
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        String strDate = sdf.format(date);
        byte[] bDate = strDate.getBytes();
        String eMessage = e.getMessage();
        byte[] bMessage = eMessage.getBytes();
        int nl = '\n';
        
        try {
          
          bout = new BufferedOutputStream(new FileOutputStream(logFile));
          
          if(bout != null) {
            bout = new BufferedOutputStream(new FileOutputStream(logFile, true));
          }
          
          bout.write(bDate);
          bout.write(bMessage);
          bout.write(nl);
          
          bout.close();
          
        } catch (Exception e2) {
          e2.printStackTrace();
        }
        
        

      }

    }

  }

}
