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
	
	public static void mergeSort (int[] vetor, int[] aux, int ini, int fim){
		if(ini < fim) {
			int meio = (ini + fim)/2; 
			mergeSort(vetor, aux, ini, meio);
			mergeSort(vetor, aux, meio+1, fim);
			merge(vetor, aux, ini, meio, fim);
		}	
	}
	
	public static void merge(int[] vetor, int[] aux, int ini, int meio, int fim){
		int i=ini;
		int j=meio+1; 


		for(int k=ini; k<=fim; k++){
			if(i>meio){ 
				aux[k]=vetor[j];
				j++; 
			} else if (j>fim){
			    aux[k] = vetor[i];
			    i++;
			} else if(vetor[i]<vetor[j]){
				aux[k]=vetor[i];
				i++; 
			}else{
			    aux[k] = vetor[j];
			    j++;
		    }

		}

		for(int k=ini; k<=fim; k++){
			vetor[k]=aux[k];
		}

	}
	
	public static void main(String[] args){
		int []vetor = criaVetor(5);
		int []aux = new int[vetor.length];	
				
		System.out.println("O vetor desordenado e':");
		System.out.println(Arrays.toString(vetor));
		
		mergeSort(vetor, aux, 0, vetor.length-1);
		
		System.out.println("O vetor ordenado e':");
		System.out.println(Arrays.toString(vetor));
		

	}
	

}
