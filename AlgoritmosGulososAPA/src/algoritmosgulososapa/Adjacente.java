package algoritmosgulososapa;

/**
 *
 * @author luana
 */
    

public class Adjacente {

    private final Vertice vertice;
    private final int peso;

    // recebe no final da aresta e peso da aresta
    public Adjacente(Vertice v, int p) {
        this.vertice = v; //recebe o nó
        this.peso = p;// recebe o peso da aresta
    }

    public Vertice getVertice() {
        return vertice;
    }

    public int getPeso() {
        return peso;
    }

}

