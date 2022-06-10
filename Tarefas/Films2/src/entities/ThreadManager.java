package entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadManager extends Thread {

  private Film[] films;
  private int threadNumber;

  public ThreadManager(Film[] films, int threadNumber){
    this.films = films;
    this.threadNumber = threadNumber;
  }

  @Override
  public void run() {

    MergeSort merge = new MergeSort(films, 10000);
    Film[] copy = new Film[10000];

    switch (threadNumber) {
      case 0:
        merge.mergeSort(new Film.ById());
        break;
      case 1:
        merge.mergeSort(new Film.ByTitle());
        break;
      case 2:
        merge.mergeSort(new Film.ByGenre());
        break;
      case 3:
        merge.mergeSort(new Film.ByRelease());
        break;
      case 4:
        merge.mergeSort(new Film.ByLenght());
        break;
      case 5:
        merge.mergeSort(new Film.ByCost());
        break;
    }

    try {
      copy = merge.getArray();
      print(copy); save(copy);
      Thread.sleep(2000);
      System.out.println(Thread.currentThread() + "getting out...");
    } catch (InterruptedException e) {}

  }

  private void print(Film[] array){
    int pos = 0;
    for(Film item : array){
      if(pos++ > 10) break;
      System.out.println(item);
    }
    System.out.println("--------------------------");
  }

  private void save(Film[] array){

    File file = new File("sortedFilms_" + (threadNumber+1) + ".csv");

    try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
      writer.write("film_id,title,genre,release_date,length,rental_cost\n");
      for(Film film : array){
        writer.write(film.toCSV());
      }
    } catch(IOException iox){
      System.out.println("Error to write into the file!");
    }
  }

}
