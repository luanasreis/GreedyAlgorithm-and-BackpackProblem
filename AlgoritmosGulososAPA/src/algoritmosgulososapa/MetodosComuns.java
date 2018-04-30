package algoritmosgulososapa;
import java.util.ArrayList;

/**
 *
 * @author luana
 */


public final class MetodosComuns {

    private final int qtdeVertice;
    private int[][] matrizPesos;
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas; // só utilizado pelo algoritmo de Kruskal

    public MetodosComuns(int quant, int[] entrada) {
        this.qtdeVertice = quant;
        this.metodo1(entrada);
        this.metodo2();
//        imprimirVetorAresta(arestas);
//        imprimirTabelaPeso(matrizPesos);
    }

    /**
     * Dado o vetor [] de entrada, cria-se um vetor [] de Vértices, com todos os
     * vértices do grafo e o vetor[][] Tabela de Pesos, com o valor do peso
     * entre cada dois vértice. A Tabela de Pesos é simétrica e sua diagonal
     * principal é 0.
     *
     * @param entrada
     */
    private void metodo1(int[] entrada) {
        vertices = new ArrayList<>();
        matrizPesos = new int[qtdeVertice][qtdeVertice];
        int indice = 0, inicio = 1;

        for (int lin = 0; lin < qtdeVertice; lin++) {
            // criando um vértice com nome = linha e grupo = linha 
            // e adicionando-o ao vetor de Vértices
            getVertices().add(new Vertice(lin, lin));
            for (int col = inicio; col < qtdeVertice; col++) {
                // criando a Matriz de Pesos
                if (col == lin) {
                    matrizPesos[col][lin] = 0;
                } else {
                    matrizPesos[lin][col] = entrada[indice]; // triângulo superior
                    matrizPesos[col][lin] = entrada[indice]; // triângulo inferior
                    indice++;
                }
            }
            inicio++;
        }
    }

    /**
     * Com base na TabelaAresta, cria-se o vetor de Arestas e a lista de
     * Adjacência. O vetor de Arestas só será útil para o algoritmo de Kruskal
     */
    private void metodo2() {
        ArrayList<Adjacente> adjacente;
        arestas = new ArrayList<>();
        Vertice vert1, vert2;
        int peso;

        // percorrer a matriz de Pesos (todas as colunas da linha x)
        for (int lin = 0; lin < qtdeVertice; lin++) {
            // inicializando uma nova lista de adjacentes
            adjacente = new ArrayList<>();
            // capturando o vertices do vetor de Vértices
            vert1 = vertices.get(lin);
            for (int col = 0; col < qtdeVertice; col++) {
                // e se encontrar algum elemento diferente de 0
                if (matrizPesos[lin][col] != 0) {
                    // capture um vértice e o peso dessa matriz
                    vert2 = vertices.get(col);
                    peso = matrizPesos[lin][col];
                    // crie uma adjacência e adicionando-a no vetor de adjacência
                    adjacente.add(new Adjacente(vert2, peso));
                    // crie também uma aresta entre vert1 e vert2 
                    // e a adicione no vetor de Arestas;
                    getArestas().add(new Aresta(vert1, vert2, peso));
                }
            }
            // adicionado o vetor de adjacência ao vértice correspondente (vert1)
            vert1.setAdjacente(adjacente);
            // repita todas as operações até o último vértice
        }
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void imprimirVetorAresta(ArrayList<Aresta> vetor) {
        Vertice A, B;
        int peso;
        for (int i = 0; i < vetor.size(); i++) {
            A = vetor.get(i).getA();
            B = vetor.get(i).getB();
            peso = vetor.get(i).getPeso();
            System.out.println((i + 1) + " - " + A.getNome() + " para " + B.getNome() + " = " + peso);
        }
    }

    private void imprimirTabelaPeso(int[][] vetor) {
        for (int i = 0; i < vetor.length; i++) {
             System.out.print(i + " - ");
            for (int j = 0; j < vetor.length; j++) {
                System.out.print( vetor[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

