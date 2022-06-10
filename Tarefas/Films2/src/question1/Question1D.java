package question1;

import java.math.BigInteger;

public class Question1D {
  
  public static void main(String[] args) {
    
    BigInteger[] clifford = new BigInteger[50];
    BigInteger[] fibonacci = new BigInteger[50];

    iterativeClifford(clifford);
    iterativeFibonacci(fibonacci);
    
    int c = 0, f = 0;

    while(c <= 40 && f <= 40){
      if( fibonacci[f].equals(clifford[c]) ){
        System.out.println("Clifford[" + c + "] = Fibonacci[" + f + "] = " + fibonacci[f]);
        c++; f++;
      } 
      else if ( fibonacci[f].compareTo(clifford[c]) > 0 )
        c++;
      else 
        f++;
    }

  }

  private static void iterativeFibonacci(BigInteger[] array) {
  
    array[0] = new BigInteger("0");
    array[1] = new BigInteger("1");
  
    for(int i=2; i<=40; i++){
      array[i] = array[i-1].add(array[i-2]);
    }

  }

  public static void iterativeClifford(BigInteger[] array){

    array[0] = new BigInteger("0");
    array[1] = new BigInteger("1");

    for(int i=2; i<=40; i++){
      if(i%2 == 0){ // even canse
        array[i] = array[i-1].add( array[i-2].multiply(new BigInteger("2")) );
      } else { // odd case
        array[i] = array[i-1].multiply(array[i-2]);
      }
    } 

  }

}
