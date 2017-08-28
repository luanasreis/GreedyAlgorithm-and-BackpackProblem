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
			int j = separar (vetor, esq, dir); //separa o vetor em menores pra dir do pivo e maiores p esq
			quickSort(vetor, esq, j-1); //ordenar da esq ate j-1
			quickSort(vetor, j+1, dir); // ordenar os da dir ate o final
		}
		
	}
	
	private static int separar(int[] vetor, int esq, int dir){
		int i = esq;
		int j = dir;
		
		while(i<j){
			while(i<dir && vetor[i] <= vetor[esq])i++; // varrer com o i para a direita tentando achar um elemento maior q o pivo
			while(j>esq && vetor[j] >= vetor[esq])j--; // varrer o j para esquerda tentando achar um elemento menor q o pivo
			if(i<j){
				trocar(vetor, i, j); // se ainda não se cruzaram, troco para os menores ficarem na esq e os maiores na direira
				i++;
				j--;
			}
		}
		trocar(vetor, esq, j);
		return j;
	}
	
	private static void trocar(int[] vetor, int i, int j){
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
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