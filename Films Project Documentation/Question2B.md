# Question 1 B

```java
public static BigInteger recursiveClifford(int pos){

    // dinamic programming case
    // redution complexity from O(2^n) to O(n)
    if( !clifford[pos].equals(new BigInteger("-1")) )
      return clifford[pos];

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
  ```

  ## Casos base

  ```java
  // base case
if( pos == 0 ) return clifford[pos] = new BigInteger("0");
if( pos == 1 ) return clifford[pos] = new BigInteger("1");
```

Mesma ideia do outro problema, porém agora, nossos casos base, serão casos de parada para as sucessivas chamadas feitas pela **árvore de recursão**.

## Abordagem Top Down ↘️

Faz uma divisão e conquista, quebrando o problema de um clifford em outros dois, enquanto não forem problemas com resultado conhecido.

```java
// recursive case
if(pos%2 == 0){
  return clifford[pos] = recursiveClifford(pos-1)
                    .add( recursiveClifford(pos-2)
                    .multiply(new BigInteger("2")));
} else{
  return clifford[pos] = recursiveClifford(pos-1)
                    .multiply( recursiveClifford(pos-2) );
}
```