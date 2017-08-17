import java.util.Arrays;
import java.util.Random;

public class Selection{
	
	/* Idéia:  Percorrer o Vetor e executar as operações a seguir
	/  - Encontrar o menor elemento do vetor e trocar pelo elemento da primeira posição.
	/  - Encontrar o segundo menor elemento e trocar com a segunda posição
	/  - Repetir o processo até que o vetor esteja ordenado.
	*/

	public static int[] criaVetor(int n){
		int []vetor = new int[n];
		Random cria = new Random();
		for(int i=0; i<n; i++){
			vetor[i] = cria.nextInt(100);
			
	    }
		return vetor;
		
	}	
	
	private static void selectionSort(int[] vetor){		
		for(int i=0; i<vetor.length; i++){
			int menor = i;
			for(int j= i+1; j<vetor.length; j++){
				if(vetor[j] < vetor[menor]){
					menor = j;
			    }
			}
			int aux = vetor[i];
			vetor[i] = vetor[menor];
			vetor[menor] = aux;
		}
	}	
		
		
	public static void main(String[] args){
		int []vetor = criaVetor(10);
		selectionSort(vetor);
		System.out.println(Arrays.toString(vetor));
		
	}
	

}