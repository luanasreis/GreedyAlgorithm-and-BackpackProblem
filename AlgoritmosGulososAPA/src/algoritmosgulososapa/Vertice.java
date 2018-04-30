package algoritmosgulososapa;
import java.util.ArrayList;

/**
 *
 * @author luana
 */


public class Vertice {

    private final int nome;
    private int peso;
    private int grupo;
    private Vertice pai;
    private ArrayList<Adjacente> adjacente;
    private boolean marcado;

    public Vertice(int n, int g) {
        this.nome = n;
        this.peso = Integer.MAX_VALUE;
        this.grupo = g;
        this.pai = null;
        this.marcado = false;
    }

    public Vertice(int n) {
        this(n, 0);
    }

    public void setAdjacente(ArrayList<Adjacente> adj) {
        this.adjacente = adj;
    }

    public Adjacente getAdjacente(int i) {
        return this.adjacente.get(i);
    }

    public int getGrau() {
        return adjacente.size();
    }

    public int getNome() {
        return nome;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marca) {
        this.marcado = marca;
    }

    @Override
    public String toString() {
        if (pai == null) {
            return "Vértice " + nome + " - Peso: " + peso + " - Pai: " + null
                    + " - Marcado: " + marcado + " - Grupo: " + grupo;
        } else {
            return "Vértice " + nome + " - Peso: " + peso + " - Pai: " + pai.getNome()
                    + " - Marcado: " + marcado + " - Grupo: " + grupo;
        }
    }
}

