package application;

public class App {  
  public static void main(String[] args) {
    
    int[] array = {3, 32, 5, 354, 139, 2345, 113};
    
    System.out.println("Iteractive answer:");
    System.out.println(showIteractive(array));

    System.out.println("Recursive answer:");
    System.out.println(showRecursive(array, 0, array.length-1));
    
  }

  public static String showIteractive(int[] array){
    String aux = "";

    // just make a bottom to up tests finding multiples
    for(int i=0; i<array.length; i++){
      if(array[i]%3 == 0){
        aux += array[i];
        aux += " ";
      } 
    }

    return aux;
  }
  
  public static String showRecursive(int[] array, int begin, int end){
    
    // initialize a empty string
    String aux = "";
    
    // base case of recursion
    if (begin == end){
      if(array[begin]%3 == 0) aux += array[begin];
      return aux;
    }

    // divide a string and return de multiples of each side
    int middle = (begin + end)/2;
    String left =  showRecursive(array, begin, middle);
    String right = showRecursive(array, middle+1, end);

    // concatenate settings if both sides return numbers or not
    if(left!="" && right!="") return left + " " + right;
    else if(left == "") return right;
    else return left;
  }
  
}
