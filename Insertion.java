import java.util.Arrays;
import java.util.Random;
	

public class Insertion{

	public static int[] criaVetor(int n){
		int []vetor = new int[n];
		Random cria = new Random();
		for(int i=0; i<n; i++){
			vetor[i] = cria.nextInt(100);
	    }
		return vetor;
	}


	private static void insertionSort(int[] vetor){
		int aux;
		for (int i=1; i<vetor.length; i++){
			aux = vetor[i];
			for(int j=i-1; j>=0 && vetor[j]>aux; j--){
				vetor[j+1] = vetor[j];
				vetor[j] = aux;
			}

		}

	}
	
	public static void main(String[] args){
		int []vetor = criaVetor(5);
		System.out.println("O vetor desordenado e': " + Arrays.toString(vetor));
		insertionSort(vetor);
		System.out.println("O vetor ordenado e': " + Arrays.toString(vetor));
		
	}
}	