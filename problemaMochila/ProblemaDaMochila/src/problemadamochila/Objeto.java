package problemadamochila;

/**
 *
 * @author luana
 */


public class Objeto {

    private final String nome;
    private final int valor;
    private final int peso;

    public Objeto(String n, int v, int p) {
        this.nome = n;
        this.valor = v;
        this.peso = p;
    }

    public String getNome() {
        return nome;
    }

    public int getValor() {
        return valor;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return nome + ": [" + peso + " - " + valor + "]";
    }
}

