package ex04_Singer;

public class Song {
  
  // 필드
  private String title;
  private String genre;
  private double playTime;
  
  
  //Setter
  // 노래 제목
  public void setTitle(String title) {
    this.title = title;
  }
  // 노래 장르
  public void setGenre(String genre) {
    this.genre = genre;
  }
  // 노래 재생시간
  public void setPlayTime(double playTime) {
    this.playTime = playTime;
  }
  
  // info
  public void info() {
    System.out.println("제목: " + title + ", " + "장르: " + genre + ", " + "시간: " + playTime);
    
  }

}
