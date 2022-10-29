import java.util.Random;

public class App {
  public static void main(String[] args) {
		int vectorSize = 27000;
    // max 27000;
    Random random = new Random();
    
    int[] v = new int [vectorSize];

   for(int i = 0; i < v.length; i++){
    v[i] = random.nextInt(10000);
   }
		
    
    
    
    
    long y = ordena(v, 0, 0);
		for(int i  = 0; i < v.length; i++){
		    System.out.print(v[i] + "  ");
		}
    System.out.println( "\n" +"Todal das Trocas:" + y);
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