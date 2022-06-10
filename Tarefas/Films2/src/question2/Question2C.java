package question2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import entities.Film;
import entities.ThreadManager;

public class Question2C {

  public static void main(String[] args) {
    // parsing and reading the CSV file data into the film (object) array
    // provide the path here...
    File directory = new File("");
    System.out.println(directory.getAbsolutePath());
    String path = directory.getAbsolutePath() + "\\Film.csv";

    File file = new File(path);

    System.out.println(directory.getAbsolutePath());

    Scanner in = new Scanner(System.in);
    Film[] films = new Film[10000];

    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

    // this will just print the header in CSV file
    // this will just print the header in CSV file
    int i = 0;
    String st = "";
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {

      br.readLine();

      while ((st = br.readLine()) != null) // returns a boolean value
      {
        String[] data = st.split(",");
        films[i++] = new Film(Integer.parseInt(data[0]), data[3], data[1], ft.parse(data[2]), Float.parseFloat(data[4]),
            Float.parseFloat(data[5]));
      }
      
      ThreadManager[] thread = new ThreadManager[6];

      for(i=0; i<6; i++){
        thread[i] = new ThreadManager(films, i);
        thread[i].start();
        try{
          Thread.sleep(1000);
        } catch(InterruptedException exception) {}
      }

      System.out.println("I'm finishing..." + Thread.currentThread());

    } catch (IOException iox) {
      System.out.println("error message!");
    } catch (NumberFormatException numberExcep){
      System.out.println("Number format excetion");
    } catch(ParseException parseExcep) {
      System.out.println("Parse errror!");
    }

  }

}
