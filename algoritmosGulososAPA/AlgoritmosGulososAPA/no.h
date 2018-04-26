#include <string>
#include <iostream>
#include <vector>
#include "aresta.h"

using namespace std;

class No{
  public:
    string nome;
    int peso = 999999999;
    vector<Aresta> Vetor;
    No(string nome);
    void criaAresta(int, No*);
    void criaNo(int valor);
  };

