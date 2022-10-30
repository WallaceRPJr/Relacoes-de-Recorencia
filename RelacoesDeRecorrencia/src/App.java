
import java.util.Random;

public class App {

  public static void main(String[] args) {
	int vectorSize = 100000;
    // max 27000;
    Random random = new Random();
    int[] v = new int [vectorSize];
    for(int i = 0; i < v.length; i++){
     v[i] = random.nextInt(1000);
     }

	for(int k = 0; k<= v.length -1; k++){
		System.out.print(v[k] + " ");
	}

	System.out.println("\n");
		
    //long y = ordena(v, 0, 0);
	//	for(int i  = 0; i < v.length; i++){
	//	    System.out.print(v[i] + "  ");
	//}
    //	System.out.println( "\n" +"Todal das Trocas:" + y);
	
	mergeSortRecursivo(0, v.length , v);	
	
	for(int k = 0; k<= v.length -1; k++){
		System.out.print(v[k] + " ");
	}

	System.out.println("\n");
}

private static void intercala(int[] vetor, int inicio, int meio, int fim) {
    /* Vetor utilizado para guardar os valors ordenados. */
    int novoVetor[] = new int[fim - inicio];
    /* Variavel utilizada para guardar a posicao do inicio do vetor. */
    int i = inicio;
    /* Variavel utilizada para guardar a posição do meio do vetor. */
    int m = meio;
    /* Variavel utilizada para guarda a posição onde os
      valores serão inseridos no novo vetor. */
    int pos = 0;
    
    /* Enquanto o inicio não chegar até o meio do vetor, ou o meio do vetor
      não chegar até seu fim, compara os valores entre o inicio e o meio,
      verificando em qual ordem vai guarda-los ordenado.*/
    while(i < meio && m < fim) {
      /* Se o vetor[i] for menor que o vetor[m], então guarda o valor do
        vetor[i] pois este é menor. */
      if(vetor[i] <= vetor[m]) {
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
    while(i < meio) {
      novoVetor[pos] = vetor[i];
      pos = pos + 1;
      i = i + 1;
    }
    
    // Adicionar no vetor os elementos que estão entre o meio e o fim,
    // que ainda não foram adicionados no vetor.
    while(m < fim) {
      novoVetor[pos] = vetor[m];
      pos = pos + 1;
      m = m + 1;
    }
    
    // Coloca no vetor os valores já ordenados.
    for(pos = 0, i = inicio; i < fim; i++, pos++) {
      vetor[i] = novoVetor[pos];
    }
  }


  private static void mergeSortRecursivo(int inicio, int fim, int[] vetor) {
    System.out.println("Inicio: " + inicio + " - Fim: " + fim);
    /* Se o inicio for menor que o fim menos 1, significa que tem elementos
		  dentro do vetor. */
    if(inicio < fim - 1) {
      // Guarda a posição do meio do vetor.
      int meio = (inicio + fim) / 2;
      
      /* Chama este método recursivamente, indicando novas posições do
			  inicio e fim do vetor. */
      mergeSortRecursivo(inicio, meio, vetor);
      
      /* Chama este método recursivamente, indicando novas posições do
			  inicio e fim do vetor. */
      mergeSortRecursivo(meio, fim, vetor);
      
      // Chama o método que intercala os elementos do vetor.
      intercala(vetor, inicio, meio, fim);
    }
  }






	public static long ordena(int[] v, int i ,long trades) {
	    if(i == v.length)
	        return 0;
	        
	    for(int c = i; c > 0; c--){
	        if(v[c-1] > v[c]){
	            int aux = v[c-1];
	            v[c-1] = v[c];
	            v[c] = aux;
              trades++;
	        }
	    }
	    long x = ordena(v, ++i , 0);
	    trades = trades + x;
      return trades; 
	}


    
}