/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosgulososapa;

/**
 *
 * @author luana
 */


import java.util.ArrayList;


public class main {

    /**
     * @param args the command line arguments
     */
    private static int qtdeVertice;
    private static int[] entrada;
    
    
    private static void obterDados(String end) {
        LerDados ler = new LerDados(end);
        ArrayList<Integer> dados = ler.lerArquivo();

        qtdeVertice = dados.get(0);
        entrada = new int[dados.size() - 1];

        for (int i = 0; i < entrada.length; i++) {
            entrada[i] = dados.get(i + 1);
        }
    }

    public static void main(String[] args) {
        String end = "src/algoritmosgulososapa/dij50.txt";

        obterDados(end);

        int origem = 0;
        int destino = qtdeVertice - 1;
        System.out.println("\n========================= KRUSKAL ==============================\n");
        AlgoritmoKruskal kruskal = new AlgoritmoKruskal(qtdeVertice, entrada);

        System.out.println("ARVORE ESPALHADA KRUSKAL\n" + kruskal.getArvoreEspalhada());
        System.out.println("TOTAL PESOS KRUSKAL = " + kruskal.getPesoArvore());

        System.out.println("\n========================== PRIM ================================\n");
        AlgoritmoPrim prim;
        try {
            prim = new AlgoritmoPrim(qtdeVertice, entrada, origem);
            System.out.println("ARVORE ESPALHADA PRIM\n" + prim.getArvoreEspalhada());
            System.out.println("TOTAL PESOS PRIM = " + prim.getPesoArvore());
        } catch (VerticeInexistenteException ex) {
            ex.toString();
        }

        System.out.println("\n======================== DIJKSTRA ==============================\n");
        AlgoritmoDijkstra dijkstra;
        try {
            dijkstra = new AlgoritmoDijkstra(qtdeVertice, entrada, origem, destino);
            System.out.println("CAMINHO MÍNIMO DE " + origem + " para " + destino
                    + ":\n" + dijkstra.getCaminho());

            System.out.println("PESO TOTAL = " + dijkstra.getPesoCaminho());

            System.out.println("\nPESO DO CAMINHO MÍNIMO PARA TODOS OS VÉRTICES A PARTIR DO "
                    + "V" + origem + ":\n" + dijkstra.getCaminhoTodos());
        } catch (VerticeInexistenteException ex) {
        }
    }

}

