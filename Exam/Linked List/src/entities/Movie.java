package entities;

public class Movie {
  
  private String title;
  private String description;
  private String genre;
  private int length;
  private int rating;
  
  public Movie(String title, String description, String genre, int length, int rating) {
    this.title = title;
    this.description = description;
    this.genre = genre;
    this.length = length;
    this.rating = rating;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  @Override
  public String toString() {
    return title 
          + "\nDescription: " 
          + description 
          + "\nGenre: " 
          + genre 
          + "\nLength:" 
          + length 
          + "\nRating:" 
          + rating
          + "\n------------------------\n";
  }

  

}
