package application;

import entities.LinkedList;
import entities.Movie;

public class App {
 
  public static void main(String[] args){

    LinkedList moviesList = new LinkedList();

    moviesList.add( new Movie("Titanic", "Iceberg", "Drama", 112, 4) );
    moviesList.add( new Movie("Moonlight", "Woof", "Drama", 111, 5) );
    moviesList.add( new Movie("Avengers Endgame", "Marvel", "Super Hero", 186, 5) );
    moviesList.add( new Movie("Joker", "Batman's enemy", "Suspense", 120, 4) );
    moviesList.add( new Movie("La la land", "Musical", "Romance", 95, 3) );

    if(moviesList.isEmpty()) System.out.println("The list of movies is empty!");
    
    System.out.println("Average ranting: " + moviesList.get_average());

    System.out.println("Movies about Drama:\n" + moviesList.genreSearch("Drama"));

    System.out.println("Trying to remove 'Joker' ... ");
    moviesList.remove("Joker");
    System.out.println("New Movies List:");
    System.out.println( moviesList.showList() );

  }

}
