# Question 1 A

```java
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
```

## Base case

```java
  array[0] = new BigInteger("0");
  array[1] = new BigInteger("1");
```

Casos base determinam o ponto de partida para construir os próximos elementos da sequência, já que na fórmula existe uma dependência dos dois anteriores.

## Abordagem Bottom-Up ↗️

definidos os casos base, agora podemos escalar e preencher as próximas casas, até chegarmos na posição desejada.

```java
for(int i=2; i<=40; i++){ 
  if(i%2 == 0){ // even canse
    array[i] = array[i-1].add( array[i-2].multiply(new BigInteger("2")) );
  } else { // odd case
    array[i] = array[i-1].multiply(array[i-2]);
  }
}
```

O `for` caminha até alcançar a posição desejada.