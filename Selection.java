import java.util.Arrays;
import java.util.Random;

public class Selection{

	public static int[] criaVetor(int n){
		int []vetor = new int[n];
		Random cria = new Random();
		for(int i=0; i<n; i++){
			vetor[i] = cria.nextInt(100);
	    }
		return vetor;
		
	}	
	
	private static void selectionSort(int[] vetor){
		int menor, aux;	
		for(int i=0; i<vetor.length; i++){
			menor = i;
			for(int j= i+1; j<vetor.length; j++){
				if(vetor[j] < vetor[menor]){
					menor = j;
			    }
			}
			
			if (menor!=i){
				aux = vetor[i];
				vetor[i] = vetor[menor];
				vetor[menor] = aux;
			}
		}
	}	
		
		
	public static void main(String[] args){
		int []vetor = criaVetor(5);
		System.out.println("O vetor desordenado e': " + Arrays.toString(vetor));
		selectionSort(vetor);
		System.out.println("O vetor ordenado e': " + Arrays.toString(vetor));
		
	}
	

}