#include <iostream>
#include <fstream>
#include <sstream>
#include "grafo.h"

using namespace std;

int main(int argc, char* argv[]){
  Grafo g1;


  ifstream file("Arquivos/dij10.txt");
  string line;
  getline(file, line);
  stringstream ss(line);

  int i;
  ss >> i;

  for(int j=0; j<i; j++){
    g1.criaGrafo(new No(to_string(j)));
  }

  int contaLinha = 0;
  int contaColuna = 1;
  while(getline(file, line)){
    int valor;
    int auxContaColuna = contaColuna;
    stringstream ss1(line);
    while(ss1 >> valor){
      g1.noVetor[contaLinha]->criaAresta(valor, g1.noVetor[auxContaColuna]);
      g1.noVetor[auxContaColuna]->criaAresta(valor, g1.noVetor[contaLinha]);
      auxContaColuna++;
    }
    contaColuna++;
    contaLinha++;
  }

     // g1.algoritmoDijkstra();
    // g1.algoritmoKruskal();
     g1.algoritmoPrim();


  return 0;
}
