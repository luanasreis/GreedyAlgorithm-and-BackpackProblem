#include <vector>
#include <string>
#include <algorithm>
#include "no.h"

using namespace std;

class Grafo{
  public:
    vector<No*> noVetor;
    vector<No*> nosVisitados;
    //Graph();
    void criaGrafo(No*);
    int encontraNoVetor(No*);
    int getNoPorNome(string);
    int getMenorValorListaDeGrafo(int*);
    void upgradePesoNo(No* no);
    int getMenorProximoNo(int*);
    void algoritmoPrim();
    void algoritmoDijkstra();
};

