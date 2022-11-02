import java.util.Random;

public class App {

  public static int contador;

  public static void main(String[] args) {
    int vectorSize = 100000;
    // max 27000;
    Random random = new Random();
    int[] v = new int[vectorSize];
    // int[] v = { 12, 72, 26, 54, 98, 73, 0, 59, 30, 25, 62, 11, 61, 67, 33, 2 };
    for (int i = 0; i < v.length; i++) {
      v[i] = random.nextInt(10000);
    }

    for (int k = 0; k <= v.length - 1; k++) {
      System.out.print(v[k] + " ");
    }

    System.out.println("\n");

    /* 
    long startTime = System.nanoTime();
    insertionSort(v, 0);
    long endTime = System.nanoTime();
    for (int i = 0; i < v.length; i++) {
      System.out.print(v[i] + " ");
    }
    */


    /*
     * long startTime = System.nanoTime();
     * mergeSortRecursivo(0, v.length, v);
     * long endTime = System.nanoTime();
     * 
     * for (int k = 0; k <= v.length - 1; k++) {
     * System.out.print(v[k] + " ");
     * }
     */

    System.out.println("\n");
    System.out.println(endTime - startTime + " Nanosegundos");
    System.out.println("QUANTIDADE DE TROCAS: " + contador);

  }

  // método obtido na web, adicionando apenas contador
  private static void intercala(int[] vetor, int inicio, int meio, int fim) {
    /* Vetor utilizado para guardar os valors ordenados. */
    int novoVetor[] = new int[fim - inicio];
    /* Variavel utilizada para guardar a posicao do inicio do vetor. */
    int i = inicio;
    /* Variavel utilizada para guardar a posição do meio do vetor. */
    int m = meio;
    /*
     * Variavel utilizada para guarda a posição onde os
     * valores serão inseridos no novo vetor.
     */
    int pos = 0;

    /*
     * Enquanto o inicio não chegar até o meio do vetor, ou o meio do vetor
     * não chegar até seu fim, compara os valores entre o inicio e o meio,
     * verificando em qual ordem vai guarda-los ordenado.
     */
    while (i < meio && m < fim) {
      /*
       * Se o vetor[i] for menor que o vetor[m], então guarda o valor do
       * vetor[i] pois este é menor.
       */
      // contador++;

      if (vetor[i] <= vetor[m]) {
        // contador++;

        novoVetor[pos] = vetor[i];
        pos = pos + 1;
        i = i + 1;
        // Senão guarda o valor do vetor[m] pois este é o menor.
      } else {

        novoVetor[pos] = vetor[m];
        pos = pos + 1;
        m = m + 1;
      }
    }

    // Adicionar no vetor os elementos que estão entre o inicio e meio,
    // que ainda não foram adicionados no vetor.
    while (i < meio) {
      novoVetor[pos] = vetor[i];
      pos = pos + 1;
      i = i + 1;
    }

    // Adicionar no vetor os elementos que estão entre o meio e o fim,
    // que ainda não foram adicionados no vetor.
    while (m < fim) {
      novoVetor[pos] = vetor[m];
      pos = pos + 1;
      m = m + 1;
    }

    // Coloca no vetor os valores já ordenados.
    for (pos = 0, i = inicio; i < fim; i++, pos++) {
      // Caso o novoVetor tenha sido alterado, ficando diferente do valor do vetor
      // padrão, será feita a cópia do seu valor para o vetor padrão e então
      // contabilizada uma troca
      if (vetor[i] != novoVetor[pos]) {
        contador++;
        vetor[i] = novoVetor[pos];
      }

    }

  }

  private static void mergeSortRecursivo(int inicio, int fim, int[] vetor) {
    // System.out.println("Inicio: " + inicio + " - Fim: " + fim);
    /*
     * Se o inicio for menor que o fim menos 1, significa que tem elementos
     * dentro do vetor.
     */
    if (inicio < fim - 1) {
      // Guarda a posição do meio do vetor.
      int meio = (inicio + fim) / 2;

      /*
       * Chama este método recursivamente, indicando novas posições do
       * inicio e fim do vetor.
       */
      mergeSortRecursivo(inicio, meio, vetor);

      /*
       * Chama este método recursivamente, indicando novas posições do
       * inicio e fim do vetor.
       */
      mergeSortRecursivo(meio, fim, vetor);

      // Chama o método que intercala os elementos do vetor.
      intercala(vetor, inicio, meio, fim);
    }
  }

  // Insertion sort
  public static void insertionSort(int[] v, int i) {
    if (i == v.length)
      return;

    for (int c = i; c > 0; c--) {
      if (v[c - 1] > v[c]) {
        int aux = v[c - 1];
        v[c - 1] = v[c];
        contador++;
        v[c] = aux;

      }
    }
    insertionSort(v, ++i);

  }

}