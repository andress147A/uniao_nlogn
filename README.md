Visão Geral

O projeto UniaaoLog tem como objetivo avaliar o desempenho de dois algoritmos de ordenação: Quick Sort e Merge Sort. 
Ele gera diferentes tipos de arrays (ordenados crescentemente, ordenados decrescentemente e aleatórios) e mede o tempo de execução de cada algoritmo ao ordenar esses arrays. 
Os tempos de execução são então exibidos para fins comparativos.

Estrutura do Código

O código está organizado da seguinte forma:

Geração de Arrays: São criados cinco tipos de arrays para testar a eficiência dos algoritmos:

Array ordenado em ordem crescente.

Array ordenado em ordem decrescente.

Três arrays preenchidos aleatoriamente.

Execução dos Testes: Cada array gerado passa por dois métodos de ordenação:

Quick Sort: Algoritmo de ordenação eficiente baseado no conceito de dividir e conquistar.

Merge Sort: Algoritmo que divide recursivamente o array e o mescla de forma ordenada.

Medição de Tempo: O tempo de execução de cada algoritmo é medido utilizando a classe Instant e a diferença entre os tempos de início e fim é calculada com Duration.

Implementação

1. Função main

A função principal realiza os seguintes passos:

Gera os arrays de entrada com diferentes características.

Chama o método testSortingAlgorithms para testar ambos os algoritmos em cada um dos arrays.

Exibe os tempos de execução obtidos.

2. Método testSortingAlgorithms

Este método recebe um array e executa os algoritmos de ordenação Quick Sort e Merge Sort, clonando o array original para evitar que um algoritmo afete os testes do outro.

3. Implementação do Quick Sort

O Quick Sort funciona da seguinte maneira:

Seleciona um elemento como pivô.

Particiona o array, movendo os menores que o pivô para um lado e os maiores para outro.

Recursivamente aplica esse processo às duas partições até que o array esteja ordenado.

4. Implementação do Merge Sort

O Merge Sort segue um método de divisão e conquista:

Divide o array ao meio até que as partes tenham apenas um elemento.

Mescla as partes de forma ordenada até reconstruir o array completo e ordenado.

5. Métodos de Geração de Arrays

Para testar a eficiência dos algoritmos, os seguintes métodos geram diferentes tipos de arrays:

generateAscendingArray(int size): Cria um array ordenado de 0 até size - 1.

generateDescendingArray(int size): Cria um array ordenado decrescentemente de size até 1.

generateRandomArray(int size): Cria um array com valores aleatórios.

6. Método printTimeElapsed

Este método calcula e imprime o tempo decorrido para cada algoritmo de ordenação, exibindo o nome do algoritmo e o tempo em milissegundos.

Resultados Esperados

O Quick Sort normalmente apresenta melhor desempenho para arrays grandes com distribuição aleatória.

O Merge Sort pode ter melhor desempenho para arrays ordenados ou quase ordenados, devido à sua complexidade O(n log n) estável.

O tempo de execução pode variar dependendo do tamanho do array e das condições iniciais dos elementos.

Conclusão

O projeto UniaaoLog fornece uma comparação eficaz entre Quick Sort e Merge Sort, permitindo entender melhor a performance de cada algoritmo em diferentes cenários. Isso pode ser útil para aplicações que necessitam de otimização na ordenação de grandes volumes de dados.
