import java.util.Arrays;
import java.util.Random;

public class Merge{
	
	public static int[] criaVetor(int n){
		int []vetor = new int[n];
		Random cria = new Random();
		for(int i=0; i<n; i++){
			vetor[i] = cria.nextInt(100);
	    }
		return vetor;
	}
	
	private static void mergeSort (int[] vetor, int[] aux, int ini, int fim){
		if(ini < fim) {
			int meio = (ini + fim)/2;
			mergeSort(vetor, aux, ini, meio);
			mergeSort(vetor, aux, meio+1, fim);
			intercalar(vetor, aux, ini, meio, fim);
		}	
	}
	
	private static void intercalar(int[] vetor, int[] aux, int ini, int meio, int fim){
		for(int k=ini; k<=fim; k++){
			aux[k]=vetor[k];
		}
		int i=ini;
		int j=meio+1;
		for(int k=ini; k<=fim; k++){
			if(i>meio) vetor[k]=aux[j++];
			else if (j>fim) vetor[k] = aux[i++];
			else if(aux[i]<aux[j]) vetor[k]=aux[i++];
			else vetor[k] = aux[j++];
		}	
		
	}
	
	public static void main(String[] args){
		int []vetor = criaVetor(10);
		int []aux = new int[vetor.length];	
				
		System.out.println("O vetor desordenado e':");
		System.out.println(Arrays.toString(vetor));
		
		mergeSort(vetor, aux, 0, vetor.length-1);
		
		System.out.println("O vetor ordenado e':");
		System.out.println(Arrays.toString(vetor));
		

	}
	

}