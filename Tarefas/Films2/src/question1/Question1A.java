package question1;

import java.math.BigInteger;

public class Question1A {
  
  public static void main(String[] args) {
    
    BigInteger[] clifford = new BigInteger[50];

    iterativeClifford(clifford);
    int pos = 0;
    for(BigInteger value : clifford){
      if( value.compareTo(new BigInteger("1000")) < 0 ){
        System.out.println("Clifford[" + pos + "] = " +value);
        pos++;
      } else break;
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
