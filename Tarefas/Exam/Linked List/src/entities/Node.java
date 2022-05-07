package entities;

public class Node {
  
  Movie movie;
  Node next;

  public Node(Movie movie, Node node) {
    this.movie = movie;
    this.next = node;
  }


  public Node(Movie movie) {
    this.movie = movie;
    next = null;
  }


  @Override
  public String toString() {
    return movie.toString();
  }  

}
