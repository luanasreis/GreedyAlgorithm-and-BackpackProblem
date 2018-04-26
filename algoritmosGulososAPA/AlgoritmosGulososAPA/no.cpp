#include "no.h"

No::No(string c){
  nome = c;
}

void No::criaAresta(int valor, No* nextNo){
  Aresta v1;
  v1.configAresta(valor, nextNo);
  Vetor.push_back(v1);

}

void No::criaNo(int valor){
  cout << "No criado com valor: " << valor << endl;
}

