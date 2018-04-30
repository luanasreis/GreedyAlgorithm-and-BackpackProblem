package algoritmosgulososapa;

/**
 *
 * @author luana
 */


import java.util.Comparator;


public class Ordenar implements Comparator<Aresta> {

    @Override
    public int compare(Aresta a1, Aresta a2) {
        if (a1.getPeso() - a2.getPeso() > 0) {
            return 1;
        } else if (a1.getPeso() - a2.getPeso() < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}

