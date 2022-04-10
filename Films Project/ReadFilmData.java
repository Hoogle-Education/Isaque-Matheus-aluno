import java.io.File;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReadFilmData {

	public static void main(String[] args) {
		//parsing and reading the CSV file data into the film (object) array
		// provide the path here...
    File directory = new File("");
		System.out.println(directory.getAbsolutePath());
		String path = directory.getAbsolutePath() + "\\Film.csv";

		Scanner sc = null;
		Film[] films = null; 
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");

  	// String name = directory.getAbsolutePath() + "//Film.csv";
		try {

			sc = new Scanner(path);
			films = new Film[10000];
			
			// this will just print the header in CSV file
			sc.nextLine();
			
			int size = 0; String st = "";

			while (sc.hasNextLine())  //returns a boolean value
			{
				try {
					st = sc.nextLine();
					String[] data = st.split(",");

					Date release = ft.parse(data[2]);
					float filmLength = Float.parseFloat(data[4]);

					if( release.before( ft.parse("1895-12-01")))
						throw new 
							InputMismatchException("Film date older than film industry");
					else if( release.after( ft.parse("2022-04-11")) )
						throw new 
							InputMismatchException("Film date is in the future");
					else if( filmLength > 3.2 )
						throw new
							InputMismatchException("Film is too long");
					else if ( filmLength < 0.0 )
						throw new
							InputMismatchException("length = " 
																			+ filmLength 
																			+ " is not valid" );

					films[size++] = new Film(Integer.parseInt(data[0]), data[3], data[1], release , filmLength , Float.parseFloat(data[5]));
				} catch(InputMismatchException imex){
					System.out.println(imex.getMessage());
					imex.printStackTrace();
				}

			}
			// time to sort
			// We can print film details due to overridden toString method in film class
			timeToSort(films, 10);
			timeToSort(films, 100);
			timeToSort(films, 1000);
			timeToSort(films, 5000);
			timeToSort(films, 10000);

		} catch( RuntimeException rex ){
			System.out.println(rex.getMessage());
			rex.printStackTrace();
		} catch( ParseException pex ){
			System.out.println(pex.getMessage());
			pex.printStackTrace();
		} finally {
			if( sc != null )
			 sc.close(); //closes the scanner
		}

    // show sorted films by length
    for(Film film : films) 
			if(film != null)
				System.out.println(film);

		Scanner in = null;
		try {
			in = new Scanner(System.in);
			System.out.print("Whats your goal length: ");
			float goal = in.nextFloat();

			// binary search to find films
			for(Film film : binarySearching(films, goal) ) {
				System.out.println(film);
			}
		} catch (InputMismatchException imex ){
			System.out.println(imex.getMessage());
		}finally{
			if( in != null )
			 in.close();
		}
    
	}

  public static void timeToSort(Film []array, int size) throws RuntimeException{
    System.out.println("-----------------------------------");

    long start = System.currentTimeMillis(); // 0.02
		mergeSort(array, size);
    long finish = System.currentTimeMillis(); // 2.07
		
    long result = finish - start;
    System.out.println( size + " inputs || total elapsed time: " + result + "ms");
  }

	public static void mergeSort(Film[] array, int size) throws RuntimeException {

		if(size < 2) return;

		int mid = size/2;

		Film[] l = new Film[mid];
		Film[] r = new Film[size-mid];

		for(int i=0; i<size; i++){
				if( i < mid ) l[i] = array[i];
				else r[i-mid] = array[i]; 
		}

    mergeSort(l, mid);
		mergeSort(r, size-mid);

		merge(array, l, r, mid, size-mid);
  }

  public static void merge(Film[] merged, Film[] left, Film[] right, int leftSize, int rightSize) throws RuntimeException{

      int i=0, j=0, k=0;
      // i é a posição do array left
      // j é a posição do array right
      // k is for merge

      while( i < leftSize && j < rightSize ){
          if( left[i].compareTo(right[j]) > 0 ) {
              merged[k] = right[j];
              j++;
          } else {
              merged[k] = left[i];
              i++;
          } 
          k++;
      }

      while(i < leftSize){
          merged[k] = left[i];
          i++;
          k++;
      }

      while(j < rightSize){
          merged[k] = right[j];
          j++;
          k++;
      }
  }

  
  public static Film[] binarySearching( Film[] array , float goal ) throws RuntimeException{
    
    int size = array.length;
    int start = 0;
    int end = size-1;

    int firstPosition = -1;
    int lastPosition = -1;

    while( start < end ){

      int middle = (start + end) / 2;

      if( array[middle].getLength() == goal ){
        firstPosition = middle;
        lastPosition = middle;
        break;
      }else if( array[middle].getLength() < goal ) {
        start = middle+1;
      } else { 
        end = middle-1;
      } 

    }

    if(firstPosition == -1) return null;

    while( firstPosition > 0 ){
      if( array[firstPosition-1].getLength() == array[firstPosition].getLength() ) {
        firstPosition--;
      }else break;
    }

    while(lastPosition < size-1){
      if( array[lastPosition+1].getLength() == array[lastPosition].getLength() ){
        lastPosition++;
      }else break;
    }

    Film[] ans = new Film[lastPosition - firstPosition + 1];

    for(int i=firstPosition, j=0; i<=lastPosition; i++, j++){
      ans[j] = array[i];
    }

    return ans;
  }

}


class Film implements Comparable<Object>{

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

		/*
		Edit this section so it compares the appropriate
		column you wish to sort by
		*/		
		Film flm = (Film)obj;
		
		if (this == null && obj == null ) return 0;
		else if( flm == null ) return 1;
		else if( this == null ) return -1;
		else if( length == flm.getLength() ) return 0;
		else if( length > flm.getLength() ) return 1;
		else return -1;
	}

	@Override
	public String toString() {
		return "Film [filmID=" + filmID + ", title=" + title + ", genre=" + genre+ ", release date="
				+ release_date +  ", length=" + length + ", rental cost="
				+ rental_cost  + "]";
	}



}