# Merge Sort Analysis

Na merge sort usamos um algoritmo de **divisão e conquista** que irá subdividir o array e parte do seguinte princípio:

> Em um array ordenado, todos os subarrays estão ordenados também.

Dito isto, iremos:

1. Dividir o array em  2 até que se tenha apenas um elemento em cada subconjunto.
2. Reconstruir o array escolhendo o menor elemento dentre os subconjuntos para compor ordenadamente o array maior.

## Complexidade
 
A complexidade da **Merge Sort** é `O(n*log(n))`, obtemos esse cálculo usando a altura da árvore e a ideia de sempre termos divisões sucessivas por 2.

# Binary Searching

Neste algoritmo, iremos melhorar a nossa tradicional busca sequencial normalmente implementada para achar um elemento numa sequência. A busca sequencial percorre todo o array em seu pior caso, isto é, complexidade `O(n)`.

Aqui iremos pressupor que o *array* já está ordenado, isto é um pré-requisito para que se possa fazer a binary. Tendo o vetor ordenado iremos buscar seu meio e verificar se ele é maior, menor ou igual ao nosso objetivo.

1. Se for igual, encontrei meu objetivo.
2. Se for maior, meu objetivo está na primeira metade do array.
3. Se for menor, meu objetivo está na segunda metade do array.

## Análise de complexidade

 Por ser mais um algoritmo de **divisão e conquista**, fazemos divisões sucessivas por 2 e temos uma complexidade `O(log(n))` ao invés da tradicional `O(n)` obtida por uma busca sequencial.

 A complexidade pode assumir `n*log(n)` devido a ordenação ter um custo maior que a *binary searching*.