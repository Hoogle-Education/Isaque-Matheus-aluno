package question2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import entities.Film;
import entities.MergeSort;

public class Question2B {

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
      
      
      int option;
      do {
        options();
        option = in.nextInt();

        List<Film> list = new ArrayList<>();
        MergeSort sort = new MergeSort(films, 10000);

        switch (option) {
          case 1:
            System.out.println("Sorting by Id:");
            sort.mergeSort(new Film.ById());
            list = Arrays.asList(sort.getArray());
            break;
          case 2:
            System.out.println("Sorting by Title:");
            sort.mergeSort(new Film.ByTitle());
            list = Arrays.asList(sort.getArray());
            break;
          case 3:
            System.out.println("Sorting by Genre:");
            sort.mergeSort(new Film.ByGenre());
            list = Arrays.asList(sort.getArray());
            break;
          case 4:
            System.out.println("Sorting by Release Date:");
            sort.mergeSort(new Film.ByRelease());
            list = Arrays.asList(sort.getArray());
            break;
          case 5:
            System.out.println("Sorting by Lenght:");
            sort.mergeSort(new Film.ByLenght());
            list = Arrays.asList(sort.getArray());
            break;
          case 6:
            System.out.println("Sorting by Cost:");
            sort.mergeSort(new Film.ByCost());
            list = Arrays.asList(sort.getArray());
            break;        
          default:
            System.out.println("Exit!");
            break;
        }

        for (Film film : list) {
          System.out.println(film);
        }

      } while(option != 0);

    } catch (IOException iox) {
      System.out.println("error message!");
    } catch (NumberFormatException numberExcep){
      System.out.println("Number format excetion");
    } catch(ParseException parseExcep) {
      System.out.println("Parse errror!");
    }

  }

  public static void options(){
    System.out.print("1 - to sort by id\n"
                      + "2 - to sort by Title\n"
                      + "3 - to sort by Genre\n"
                      + "4 - to sort by Release Date\n"
                      + "5 - to sort by Lenght\n"
                      + "6 - to sort by Cost\n"
                      + "0 - to get out\n"
                      + "Choose an option: ");
  }

}
