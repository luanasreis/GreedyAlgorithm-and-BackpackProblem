package algoritmosgulososapa;

/**
 *
 * @author luana
 */


import java.util.ArrayList;


public class AlgoritmoKruskal {

    private int pesoArvore = 0;
    private String arvoreEspalhada = "";
    private final ArrayList<Aresta> arestas;
    private ArrayList<Aresta> floresta_Arestas;
    private final MetodosComuns metodos;

    public AlgoritmoKruskal(int qtdeVertice, int[] entrada) {
        this.metodos = new MetodosComuns(qtdeVertice, entrada);
        this.arestas = metodos.getArestas();
        this.Kruskal();
        this.ArvoreEspalhada();
    }

    private void Kruskal() {
        Vertice v1, v2;
        Aresta a1;
        floresta_Arestas = new ArrayList<>();

        // ordenar o vetor de arestas na ordem crescente
        arestas.sort(new Ordenar());

        // percorrer todo o vetor de arestas 
        for (int i = 0; i < arestas.size(); i++) {
            a1 = arestas.get(i);
            v1 = a1.getA();
            v2 = a1.getB();

            // se encontrar dois vétices em grupos diferentes
            // (inicialmente, todos são de grupos diferentes)
            if (v1.getGrupo() != v2.getGrupo()) {
                // unificar os dois vértices ao mesmo grupo
                unir(v1, v2);
                // adicionando a aresta ao vetor floresta_Aresta
                floresta_Arestas.add(a1);
            }
        }
    }

    private void unir(Vertice v1, Vertice v2) {
        int valorMenor, valorMaior;
        Vertice auxV1;
        // escolhendo o menor número do grupo, para que ao final todos fiquem com 1
        if (v1.getGrupo() < v2.getGrupo()) {
            valorMenor = v1.getGrupo();
            valorMaior = v2.getGrupo();
            v2.setGrupo(valorMenor);
            auxV1 = v2;
        } else {
            valorMenor = v2.getGrupo();
            valorMaior = v1.getGrupo();
            v1.setGrupo(valorMenor);
            auxV1 = v1;
        }

        // procurar dentre dos vértices adjacentes, o grupo antigo e alterar para o novo
        this.alterarGrupoAdjacentes(auxV1, valorMenor, valorMaior);
    }

    private void alterarGrupoAdjacentes(Vertice v1, int valorMenor, int valorMaior) {
        Vertice v2;
        for (int i = 0; i < v1.getGrau(); i++) {
            v2 = v1.getAdjacente(i).getVertice();
            if (v2.getGrupo() == valorMaior) {
                v2.setGrupo(valorMenor);
                this.alterarGrupoAdjacentes(v2, valorMenor, valorMaior);
            }
        }
    }

    private void ArvoreEspalhada() {
        Aresta aux;
        for (int i = 0; i < floresta_Arestas.size(); i++) {
            aux = floresta_Arestas.get(i);
            pesoArvore += aux.getPeso();
            arvoreEspalhada += aux.getA().getNome() + " >> "
                    + aux.getB().getNome() + " = "
                    + aux.getPeso() + "\n";
        }
    }

    public int getPesoArvore() {
        return pesoArvore;
    }

    public String getArvoreEspalhada() {
        return arvoreEspalhada;
    }
}


