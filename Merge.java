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
			int meio = (ini + fim)/2; // divide o vetor ao meio, calcula o item do meio
			// chamo o merge sort recursivamente para ordenar a primeira metade, e a segunda metade
			//System.out.println("O elemento do meio e' %d:" meio);
			mergeSort(vetor, aux, ini, meio);
			mergeSort(vetor, aux, meio+1, fim);
			merge(vetor, aux, ini, meio, fim);
		}	
	}
	
	public static void merge(int[] vetor, int[] aux, int ini, int meio, int fim){
		int i=ini; // variavel que vai correr a primeira metade do vetor
		int j=meio+1; // variavel que vai correr a segunda metade do vetor


		for(int k=ini; k<=fim; k++){
			if(i>meio){ // verifica se o vetor esquerdo acabou
				aux[k]=vetor[j];
				j++; // se o vetor esquerdo acabou, adiciono os elementos do vetor direito
			} else if (j>fim){ // se o vetor direito acabar, adiciono os elementos do vetor esquerdo
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
			vetor[k]=aux[k]; // faço uma copia do vetor ordenado aux para o vetor original
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