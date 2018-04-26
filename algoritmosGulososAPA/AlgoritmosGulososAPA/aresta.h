#include <iostream>

class No;
using namespace std;

class Aresta{
public:
  int valor = 0;
  No* nextNo;
  void configAresta(int, No*);
};

