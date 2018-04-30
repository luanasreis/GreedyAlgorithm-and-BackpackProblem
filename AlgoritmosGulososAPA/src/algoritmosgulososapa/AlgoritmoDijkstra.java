package algoritmosgulososapa;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author luana
 */


public class AlgoritmoDijkstra {

    private int pesoCaminho = 0;
    private String caminho = "", caminhoTodos = "";
    private final ArrayList<Vertice> vertices;
    private final int quantidadeVertices;
    private final MetodosComuns metodos;
    private LinkedList<Vertice> visitados;
    private int fimLaco = 2;

    public AlgoritmoDijkstra(int qtdeVertice, int[] entrada, int origem, int destino) throws VerticeInexistenteException {
        this.metodos = new MetodosComuns(qtdeVertice, entrada);
        this.quantidadeVertices = qtdeVertice;
        this.vertices = metodos.getVertices();
        this.aviso(origem, destino);
        this.Dijkstra(origem);
        this.caminho(origem, destino);
        this.caminhoMinimoTodos(origem);
    }

   

    private void Dijkstra(int orig) {
        visitados = new LinkedList<>();
        Vertice destino;

        // setando o peso e o pai do vértice de origem 
        Vertice origem = vertices.get(orig);
        origem.setPeso(0);
        origem.setPai(origem);

        while (todosForamMarcados()) {
//        while (fimLaco < quantidadeVertices) {
            // atribui visitado ao vertice aux e seta-o como marcado
            // na primeira iteração, é o vertice de origem, depois é atualizado
            origem = vertices.get(orig);
            origem.setMarcado(true); 
            fimLaco++;
            // verifica se o vértice visitado tem pai
            if (origem.getPai() != null) {
                // relaxando os vértices
                this.relaxarVertices(origem);
                // Extrair o vetor de menor peso, dentre dos seus vértices adjacentes;
                destino = this.extrairMinimo(origem);
                // caso vértice retornado seja ele mesmo
                if (destino == origem) {
                    // e retorna o último elemento da lista de vértices visitados
                    destino = visitados.pollLast();
                } else {
                    // adiciona o vertice à lista de vértices visitados
                    visitados.add(origem);
                }
                // altera o indice do próximo vértice a ser visitado
                orig = destino.getNome();
            }
        }
    }

    /**
     * Percorre o vetor de vértices, e se todos estiverem marcados, retorna
     * false; caso contrário, retorna true. Serve para indicar o fim do laço,
     * informando que todos os vértices foram visitados.
     *
     * @return
     */
    private boolean todosForamMarcados() {
        boolean retorno = false;
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).isMarcado() == false) {
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    /**
     * Percorre todas os vértices adjacentes do vértice passado como parâmetro
     * (denominado de 'origem'), e compara se seu peso atual é maior ou menor do
     * que a soma do peso do vértice 'origem' e o valor real da distância entre
     * os dois. Caso seja maior, faz a atualização e seta-o como não marcado.
     *
     * @param origem
     * @return
     */
    private void relaxarVertices(Vertice origem) {
        Vertice destino;
        Adjacente adjacente;
        int p0, p1, w;
        // percorrer a lista de adjacência do vetor específico (vI)
        for (int i = 0; i < origem.getGrau(); i++) {
            // retorna um objeto tipo Adjacente da lista de adjacência
            adjacente = origem.getAdjacente(i);
            // retorna o vertice de posição i na lista de adjacência
            destino = adjacente.getVertice();
            // valor do peso do vértice de origem (o repassado como parâmetro)
            p0 = origem.getPeso();
            // valor atual do peso do vértice adjacente
            p1 = destino.getPeso();
            // valor real do peso entre os dois vértices w(origem, destino)
            w = adjacente.getPeso();
            // atualiza o peso e o pai do vetor adjacente que tiver tal condição
            if (p1 > p0 + w) {
                destino.setPeso(p0 + w); //atualizo o valor do vertice pelo menor caminho
                destino.setPai(origem); //informo o predecessor (pai) daquele vertice como sendo o vertice origem que eu saí
                destino.setMarcado(false); 
                fimLaco--;
            }
        }
    }

    /**
     * Percorre a lista de vértices adjacentes ao vértice repassado como
     * parâmetro (denominado de 'origem') e retorna, dentre os ainda não
     * marcado, o que tem o menor peso. Caso não exista, retorna o próprio
     * vértice repassado como parâmetro.
     *
     * @param origem
     * @return
     */
    
    
    private Vertice extrairMinimo(Vertice origem) {
        Vertice retorno = origem, destino;
        int menorPeso = Integer.MAX_VALUE;
        for (int i = 0; i < origem.getGrau(); i++) {
            destino = origem.getAdjacente(i).getVertice();
            if (destino.isMarcado() == false && destino.getPeso() < menorPeso) {
                menorPeso = destino.getPeso();
                retorno = destino;
            }
        }
        // Inexistindo vetor adjacente que satisfaça as condições, retorna o próprio vértice;
        return retorno;
    }

    private void caminho(int origem, int destino) {
        Vertice vInicial = vertices.get(destino);
        Vertice vFinal = vertices.get(destino);
        Vertice aux;
        Adjacente adj;
        int pai, filho, peso = 0;
        String caminhoAnterior = "";

        while (vInicial.getNome() != origem) {
            vInicial = vFinal.getPai();

            pai = vFinal.getNome();
            filho = vInicial.getNome();

            for (int i = vFinal.getGrau() - 1; i >= 0; i--) {
                adj = vFinal.getAdjacente(i);
                aux = adj.getVertice();
                if (filho == aux.getNome()) {
                    peso = adj.getPeso();
                    pesoCaminho += peso;
                }
            }
            caminho = filho + " >> " + pai + " = " + peso + caminhoAnterior;
            caminhoAnterior = "\n" + caminho;
            vFinal = vInicial;
        }
    }
    
    //print do menor caminho
    private void caminhoMinimoTodos(int origem) {
        Vertice aux;
        for (int i = 0; i < vertices.size(); i++) {
            aux = vertices.get(i);
            if (aux.getNome() != origem) {
                caminhoTodos += "Peso de V" + origem + " para V"
                        + aux.getNome() + " é de " + aux.getPeso() + "\n";
            }
        }
    }

    public int getPesoCaminho() {
        return pesoCaminho;
    }

    public String getCaminho() {
        return caminho;
    }

    public String getCaminhoTodos() {
        return caminhoTodos;
    }

    private void aviso(int origem, int destino) throws VerticeInexistenteException {
        String mensagem;
        if (origem > quantidadeVertices - 1 || origem < 0) {
            mensagem = "ERRO: VÉRTICE ORIGEM (" + origem + ") INVÁLIDO!\n"
                    + "OS VÉRTICES DEVEM ESTAR ENTRE 0 E " + (quantidadeVertices - 1) + ".\n";
            System.out.println(mensagem);
            throw new VerticeInexistenteException(mensagem);
        }
        if (destino > quantidadeVertices - 1 || destino < 0) {
            mensagem = "ERRO: VÉRTICE DESTINO (" + destino + ") INVÁLIDO!\n"
                    + "OS VÉRTICES DEVEM ESTAR ENTRE 0 E " + (quantidadeVertices - 1) + ".\n";
            System.out.println(mensagem);
            throw new VerticeInexistenteException(mensagem);
        }
    }



}

