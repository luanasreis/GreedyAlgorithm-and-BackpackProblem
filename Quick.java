import java.util.Arrays;
import java.util.Random;


public class Quick{

	public static int[] criaVetor(int n){
		int []vetor = new int[n];
		Random cria = new Random();
		for(int i=0; i<n; i++){
			vetor[i] = cria.nextInt(100);
	    }
		return vetor;
	}
		
	private static void quickSort(int[] vetor, int esq, int dir){
		if(esq<dir){ 
			int j = partition (vetor, esq, dir); 
			quickSort(vetor, esq, j-1); 
			quickSort(vetor, j+1, dir); 
		}
		
	}
	
	private static int partition(int[] vetor, int esq, int dir){
		int i = esq;
		int j = dir;
		int pivo = esq;
		
		while(i<j){
			while(vetor[i] <= vetor[pivo] && i<dir){
				i++; 
			}

			while(vetor[j] >= vetor[pivo] && j > esq){
				j--; 
			}
			
			if(i<j){
				int aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
				
				i++;
				j--;
			}
		}
		
		int aux = vetor[pivo];
		vetor[pivo] = vetor[j];
		vetor[j] = aux;
		
		return j;
	}
	

	public static void main(String[] args){
		int []vetor = criaVetor(10);
		
		System.out.println("O vetor desordenado e':");
		System.out.println(Arrays.toString(vetor));
		
		quickSort(vetor, 0 , vetor.length-1);
		
		System.out.println("O vetor ordenado e':");
		System.out.println(Arrays.toString(vetor));
	}
}