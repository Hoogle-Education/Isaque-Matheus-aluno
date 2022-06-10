package question2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Film;

public class Question2A {

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
      
      mergeSort(films, 10000);
      
      for(Film film : films){
        System.out.println(film);
      }

    } catch (IOException iox) {
      System.out.println("error message!");
    } catch (NumberFormatException numberExcep){
      System.out.println("Number format excetion");
    } catch(ParseException parseExcep) {
      System.out.println("Parse errror!");
    }

  }


  public static void mergeSort(Film[] array, int size) throws RuntimeException {

    if (size < 2)
      return;

    int mid = size / 2;

    Film[] l = new Film[mid];
    Film[] r = new Film[size - mid];

    for (int i = 0; i < size; i++) {
      if (i < mid)
        l[i] = array[i];
      else
        r[i - mid] = array[i];
    }

    mergeSort(l, mid);
    mergeSort(r, size - mid);

    merge(array, l, r, mid, size - mid);
  }

  public static void merge(Film[] merged, Film[] left, Film[] right, int leftSize, int rightSize) {

    int i = 0, j = 0, k = 0;
    // i position array left
    // j position array right
    // k is for merge

    while (i < leftSize && j < rightSize) {
      if (left[i].compareTo(right[j]) > 0) {
        merged[k] = right[j];
        j++;
      } else {
        merged[k] = left[i];
        i++;
      }
      k++;
    }

    while (i < leftSize) {
      merged[k] = left[i];
      i++;
      k++;
    }

    while (j < rightSize) {
      merged[k] = right[j];
      j++;
      k++;
    }
  }

}
