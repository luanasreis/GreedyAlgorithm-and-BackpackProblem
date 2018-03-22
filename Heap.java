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
        int esq = 2 * pai + 1; // posição do filho esquerdo do pai
        int dir = (2 * pai) + 2; // posição do filho direito do pai
        int maior = pai;
        //verifica qual é maior dos três (filhos ou pai)
        if (esq <= tamanho && vetor[esq] > vetor[maior]) { //verifica se o filho da esq é maior que o pai
            maior = esq; //se for, o pai agora recebe o valor do filho esq
        }
        
        if (dir <= tamanho && vetor[dir] > vetor[maior]) { // verifica se o filho direito é maior que o pai
         	  maior = dir; // se for, o pai recebe o valor do filho dir
        }
        if (maior != pai) { //se o maior continuar sendo o pai original (nem o filho esq ou dir é maior que o pai), nenhuma troca precisa ser feita, ou seja, nao entra nesse if
            int aux = vetor[pai];
            vetor[pai] = vetor[maior];
            vetor[maior] = aux;
            maxHeapify(vetor, maior); // chama a maxheapfy dos filhos, ppq ja que houve um troca ele tem que garantir que a subarvore abaixo também é heapmaxima
        }
    }

    private static void constroiHeapMax(int[] vetor) {
        tamanho = vetor.length - 1; //começa pelo pai de subarvores q tem filhos
        for (int pai = tamanho / 2; pai >= 0; pai--) {
            maxHeapify(vetor, pai);
        }
    }

    private static void heapSort(int[] vetor) {
        constroiHeapMax(vetor);
        for (int i = tamanho; i > 0; --i) {
            int aux = vetor[i]; //troca os valores do vetor colocando a pos [0] na ultima posição do vetor, e assim sucessivamente
            vetor[i] = vetor[0];
            vetor[0] = aux;
            tamanho--;
            maxHeapify(vetor, 0); //chama novamente o vetor com pos -1 para fazer novamente a arvore com heapmax
        }
    }

	public static void main(String args[]) {
		int []vetor = criaVetor(5);

		System.out.println("O vetor desordenado e':");
		System.out.println(Arrays.toString(vetor));
		
		heapSort(vetor);
		
		System.out.println("O vetor ordenado e':");
		System.out.println(Arrays.toString(vetor));

	}
}