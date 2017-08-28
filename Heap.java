import java.util.Arrays;
import java.util.Random;

public class Heap {
	private static int tamanho;

	public static int[] criaVetor(int n){
		int []vetor = new int[n];
		Random cria = new Random();
		for(int i=0; i<n; i++){
			vetor[i] = cria.nextInt(100);
	    }
		return vetor;
	}
  
    
	private static void maxHeapify(int[] vetor, int pai) {
        int esq = 2 * pai + 1;
        int dir = (2 * pai) + 2;
        int maior = pai;
        if (esq <= tamanho && vetor[esq] > vetor[maior]) {
            maior = esq;
        }
        if (dir <= tamanho && vetor[dir] > vetor[maior]) {
            maior = dir;
        }
        if (maior != pai) {
            int aux = vetor[pai];
            vetor[pai] = vetor[maior];
            vetor[maior] = aux;
            maxHeapify(vetor, maior);
        }
    }

    private static void constroiHeapMax(int[] vetor) {
        tamanho = vetor.length - 1;
        for (int pai = tamanho / 2; pai >= 0; pai--) {
            maxHeapify(vetor, pai);
        }
    }

    private static void heapSort(int[] vetor) {
        constroiHeapMax(vetor);
        for (int i = tamanho; i > 0; i--) {
            int aux = vetor[i];
            vetor[i] = vetor[0];
            vetor[0] = aux;
            tamanho--;
            maxHeapify(vetor, 0);
        }
    }

	public static void main(String args[]) {
		int []vetor = criaVetor(10);

		System.out.println("O vetor desordenado e':");
		System.out.println(Arrays.toString(vetor));
		
		heapSort(vetor);
		
		System.out.println("O vetor ordenado e':");
		System.out.println(Arrays.toString(vetor));

	}
}