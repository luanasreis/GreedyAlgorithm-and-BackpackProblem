package algoritmosgulososapa;

/**
 *
 * @author luana
 */

public class Aresta {

    private Vertice A, B;
    private int peso;
    // recebe vertice inicial, vertice final e peso da aresta
    public Aresta(Vertice A, Vertice B, int peso) {
        this.A = A;
        this.B = B;
        this.peso = peso;
    }

    public Vertice getA() {
        return A;
    }

    public void setA(Vertice A) {
        this.A = A;
    }

    public Vertice getB() {
        return B;
    }

    public void setB(Vertice B) {
        this.B = B;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return A.getNome() + " - " + B.getNome() + " - Peso: " + peso;
    }

}

