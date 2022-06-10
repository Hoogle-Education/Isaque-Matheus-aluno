package entities;

import java.util.Comparator;
import java.util.Date;

public class Film implements Comparable<Object> {

  private int filmID;
  private String title;
  private String genre;
  private Date release_date;
  private float length;
  private float rental_cost;

  // constructor
  public Film(int filmID, String title, String genre, Date release_date, float length, float rental_cost) {
    super();
    this.filmID = filmID;
    this.title = title;
    this.genre = genre;
    this.release_date = release_date;
    this.length = length;
    this.rental_cost = rental_cost;
  }

  // setters and getters
  public int getFilmID() {
    return filmID;
  }

  public void setFilmID(int filmID) {
    this.filmID = filmID;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public Date getReleaseDate() {
    return release_date;
  }

  public void setReleaseDate(Date release_date) {
    this.release_date = release_date;
  }

  public float getRentalCost() {
    return rental_cost;
  }

  public void setRentalRate(float rental_cost) {
    this.rental_cost = rental_cost;
  }

  public float getLength() {
    return length;
  }

  public void setLength(float length) {
    this.length = length;
  }

  // so the film objects can be compared when sorting/searching
  // NOTE: this will only allow comparisons based on the title of the film
  @Override
  public int compareTo(Object obj) {
    Film flm = (Film) obj;

    if (length == flm.getLength())
      return 0;
    else if (length > flm.getLength())
      return 1;
    else {
      if (filmID > flm.getFilmID())
        return 1;
      else
        return -1;
    }
  }

  @Override
  public String toString() {
    return "[ID=" + filmID + ", title=" + title + ", genre=" + genre + ", release ="
        + release_date + ", length=" + length + ", cost="
        + rental_cost + "]";
  }

  public String toCSV(){
    return filmID + "," + title + "," + genre + "," + release_date + "," + length + "," + rental_cost + "\n";
  }

  public static class ById implements Comparator<Film> {
    @Override
    public int compare(Film o1, Film o2) {
      return Integer.compare(o1.filmID, o2.filmID);
    }
  }

  public static class ByTitle implements Comparator<Film> {
    @Override
    public int compare(Film o1, Film o2) {
      return o1.getTitle().compareToIgnoreCase(o2.getTitle());
    }
  }

  public static class ByGenre implements Comparator<Film>{
    @Override
    public int compare(Film o1, Film o2) {
      return o1.getGenre().compareToIgnoreCase(o2.getGenre());
    }
  }

  public static class ByRelease implements Comparator<Film>{
    @Override
    public int compare(Film o1, Film o2) {
      return o1.getReleaseDate().compareTo(o2.getReleaseDate());
    }
  }
  
  public static class ByLenght implements Comparator<Film>{
    @Override
    public int compare(Film o1, Film o2) {
      return Float.compare(o1.getLength(), o2.getLength());
    }
  }

  public static class ByCost implements Comparator<Film>{
    @Override
    public int compare(Film o1, Film o2) {
      return Float.compare(o1.getRentalCost(), o2.getRentalCost());
    }
  }

}