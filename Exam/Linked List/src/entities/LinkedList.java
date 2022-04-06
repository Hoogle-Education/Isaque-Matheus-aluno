package entities;

public class LinkedList {

  Node first;
  Node last;

  public LinkedList(){
    first = null;
    last = null;
  }

  public boolean isEmpty(){
    return first == null ;
  }

  public int size(){
    int counter = 0;

    Node current = first;
    while(current != null){
      counter++;
      current = current.next;
    }

    return counter;
  }

  public String genreSearch(String genre){
    String aux = "";

    aux += "------------------------\n";
    Node current = first;
    while(current != null){
      if(current.movie.getGenre().equalsIgnoreCase(genre))
        aux += current.movie.toString();

      current = current.next;
    }

    return aux;
  }

  public void add(Movie movie){
    if(isEmpty()){
      first = new Node(movie);
      last = first;
    }else{
      last.next = new Node(movie);
      last = last.next;
    }
  }

  public void remove(String movieTitle){

    int counter = 0;

    Node current = first;
    while(current != null){
      if(current.movie.getTitle().equalsIgnoreCase(movieTitle)) break;
      else {
        counter++;
        current = current.next;
      }
    }

    if( counter == size() ) System.out.println("No movies found!");

    if(counter == 0){
      first = first.next;
    } else {
      current = first;
      counter = 1;
      while(!current.next.movie.getTitle().equalsIgnoreCase(movieTitle)){
        current = current.next;
        counter++;
      }

      if(counter == size()-1){
        last = current;
        last.next = null;
      }else{
        current.next = current.next.next;
      }

      System.out.println("Movie has been removed");
    }
  }

  public double get_average(){
    double total = 0;

    Node current = first;
    while(current != null){
      total += current.movie.getRating();
      current = current.next;
    }

    double average = total / (double)size();

    return average;
  }

  public String showList(){

    String aux = "------------------------\n";

    Node current = first;
    while(current != null){
      aux += current;
      current = current.next;
    }

    return aux;
  }


}
