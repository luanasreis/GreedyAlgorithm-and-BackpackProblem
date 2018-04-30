package algoritmosgulososapa;
import java.util.ArrayList;

/**
 *
 * @author luana
 */

public class AlgoritmoPrim {

    private int pesoArvore = 0;
    private String arvoreEspalhada = "";
    private final ArrayList<Vertice> vertices;
    private ArrayList<Vertice> floresta;
    private final int quantidadeVertices;
    private final MetodosComuns metodos;

    public AlgoritmoPrim(int qtdeVertice, int[] entrada, int origem) throws VerticeInexistenteException {
        this.metodos = new MetodosComuns(qtdeVertice, entrada);
        this.quantidadeVertices = qtdeVertice;
        this.vertices = metodos.getVertices();
        this.aviso(origem);
        this.Prim(origem);
        this.arvoreEspalhada();
    }


    private void Prim(int orig) {
        floresta = new ArrayList<>();
        Vertice destino;
        // valor que servirá de base para o encerramento do laço
        // não se conta o primeiro e o último vértices
        int fim = 2;

        // setando o peso e o pai da origem 
        Vertice origem = vertices.get(orig);
        origem.setPeso(0);
        origem.setPai(origem);

        // enquanto não percorrer todos os vértices do grafo conexo, faça:
        // OBS: se o grafo não for conexo, entra em loop e não termina
        while (fim <= quantidadeVertices) {
            // atribui visitado ao vertice aux e seta-o como marcado
            // OBS: começa com o vértice repassado como origem, mas depois é atualizado
            origem = vertices.get(orig);
            origem.setMarcado(true);
            // verifica se o vértice visitado tem pai
            if (origem.getPai() != null) {
                // Relaxa e extrair o vértice de menor peso dentre dos seus vértices adjacentes;
                destino = this.relaxarVertices(origem);
                // caso o vértice retornado seja ele mesmo
                if (destino == origem) {
                    // então retorna ao pai
                    destino = destino.getPai();
                } else {
                    // caso contrário, adiciona o vértice destino na florestaa e 
                    // incrementa a variável condicional do fim do laço
                    floresta.add(destino);
                    fim++;
                }
                // altera o indice do próximo vértice a ser visitado 
                orig = destino.getNome();
            }
        }
    }

    /**
     * Procura os vértices adjacentes ao vértice repassado como parâmetro que
     * não esteja marcados. Encontrando, atualiza os pesos dos vértices
     * adjacentes e retorna, dentre esses, o vértice com o menor peso. Porém se
     * todos os seus vértices adjacentes já foram marcados, retorna o próprio
     * vértice repassado no parâmetro;
     *
     * @param origem
     * @return
     */
    private Vertice relaxarVertices(Vertice origem) {
        Vertice destino, retorno = origem;
        Adjacente adjacente;
        int menorPeso = Integer.MAX_VALUE;
        int p1, p2;
        // percorrer a lista de adjacência do vetor específico (vI)
        for (int i = 0; i < origem.getGrau(); i++) {
            // retorna um objeto tipo Adjacente da lista de adjacência
            adjacente = origem.getAdjacente(i);
            // retorna o vertice de posição i na lista de adjacência
            destino = adjacente.getVertice();
            // se o vértice adjacente ainda não foi marcado
            if (destino.isMarcado() == false) {
                // valor atual do peso do vértice adjacente
                p1 = destino.getPeso();
                // valor real do peso entre os dois vértices w(origem, destino)
                p2 = adjacente.getPeso();

                // atualiza o peso e o pai do vetor adjacente que tiver tal condição
                if (p1 > p2) {
                    destino.setPeso(p2);
                    destino.setPai(origem);
                }
            }
        }

        // atribuindo o vértice de menor peso ao retorno
        for (int i = 0; i < vertices.size(); i++) {
            destino = vertices.get(i);
            if (destino.isMarcado() == false && destino.getPeso() < menorPeso) {
                menorPeso = destino.getPeso();
                destino.setPai(origem);
                retorno = destino;
            }
        }

//        System.out.println("VISITA: " + origem + "\nRETORNO: " + retorno + "\n");
        // não achando um vetor adjacente que satisfaça as condições, retorna ele mesmo;
        return retorno;
    }

    private void arvoreEspalhada() {
        Vertice vInicial, vFinal;
        String aux = "";
        for (int i = floresta.size() - 1; i >= 0; i--) {
            vFinal = floresta.get(i);
            vInicial = vFinal.getPai();
            pesoArvore += vFinal.getPeso();
            arvoreEspalhada = vInicial.getNome() + " >> "
                    + vFinal.getNome() + " = "
                    + vFinal.getPeso() + "\n" + aux;
            aux = arvoreEspalhada;
        }
    }

    public int getPesoArvore() {
        return pesoArvore;
    }

    public String getArvoreEspalhada() {
        return arvoreEspalhada;
    }

    private void aviso(int origem) throws VerticeInexistenteException {
        String mensagem;
        if (origem > quantidadeVertices - 1 || origem < 0) {
            mensagem = "ERRO: VÉRTICE ORIGEM (" + origem + ") INVÁLIDO!\n"
                    + "OS VÉRTICES DEVEM ESTAR ENTRE 0 E " + (quantidadeVertices - 1) + ".\n";
            System.out.println(mensagem);
            throw new VerticeInexistenteException(mensagem);
        }
    }    


}

