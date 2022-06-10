package question1;

import java.math.BigInteger;
import java.util.Arrays;

public class Question1B {
  
  static BigInteger[] clifford = new BigInteger[50];
  public static void main(String[] args) {

    // fill the positions with -1
    Arrays.fill(clifford, new BigInteger("-1"));
    recursiveClifford(40);

    int pos = 0;
    for(BigInteger value : clifford){
      if( value.compareTo(new BigInteger("1000")) < 0 ){
        System.out.println("Clifford[" + pos + "] = " +value);
        pos++;
      } else break;
    }

  }

  public static BigInteger recursiveClifford(int pos){

    // dinamic programming case
    // redution complexity from O(2^n) to O(n)
    if( !clifford[pos].equals(new BigInteger("-1")) ) return clifford[pos];

    // base case
    if( pos == 0 ) return clifford[pos] = new BigInteger("0");
    if( pos == 1 ) return clifford[pos] = new BigInteger("1");

    // recursive case
    if(pos%2 == 0){
      return clifford[pos] = recursiveClifford(pos-1)
                        .add( recursiveClifford(pos-2).multiply(new BigInteger("2")));
    } else{
      return clifford[pos] = recursiveClifford(pos-1)
                        .multiply( recursiveClifford(pos-2) );
    }

  }

}
