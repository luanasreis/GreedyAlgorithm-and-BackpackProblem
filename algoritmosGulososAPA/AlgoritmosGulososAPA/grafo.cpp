#include "grafo.h"

void Grafo::criaGrafo(No* no){
  this->noVetor.push_back(no);
}

int Grafo::getNoPorNome(string nome){
  for(int i=0; i<this->noVetor.size(); i++){
    if(!nome.compare(this->noVetor[i]->nome)){
      return i;
    }
  }
  return -1;
}

int Grafo::encontraNoVetor(No* no){
  if(find(this->nosVisitados.begin(), this->nosVisitados.end(), no) != this->nosVisitados.end()){
    return 0;
  }else{
    return 1;
  }
}

int Grafo::getMenorValorListaDeGrafo(int* i){
  int menorValor = 999999999;
  int index = 0;

  for(int k=0; k<this->nosVisitados.size(); k++){
    for(int j=0; j<this->nosVisitados[k]->Vetor.size(); j++){
      if(encontraNoVetor(this->nosVisitados[k]->Vetor[j].nextNo)){
        if(this->nosVisitados[k]->Vetor[j].valor < menorValor){
          // cout << "k Value: " << k << endl;
          // cout << "j Value: " << j << endl;
          // cout << "Vector name: " << this->visitedNodes[k]->name << " Going to: " << this->visitedNodes[k]->vVector[j].nextNode->name << endl;
          menorValor = this->nosVisitados[k]->Vetor[j].valor;
          index = j;
          *i = k;
        }
      }
    }
  }

  //cout << "index Value: " << index << endl;
  return index;
}

void Grafo::upgradePesoNo(No* no){
  for(int i=0; i<no->Vetor.size(); i++){
    int sumPeso = no->peso + no->Vetor[i].valor;
    if(sumPeso < no->Vetor[i].nextNo->peso){
      no->Vetor[i].nextNo->peso = sumPeso;
    }
  }
}

int Grafo::getMenorProximoNo(int* k){
  int menorValor = 999999999;
  int index = 0;

  for(int i=0; i<this->nosVisitados.size(); i++){
    for(int j=0; j<this->nosVisitados[i]->Vetor.size(); j++){
      //cout << "Visited node: " << this->visitedNodes[i]->vVector[j].nextNode->name << " weight: " << this->visitedNodes[i]->vVector[j].nextNode->weight << endl;
      if(encontraNoVetor(this->nosVisitados[i]->Vetor[j].nextNo)){
        if(this->nosVisitados[i]->Vetor[j].nextNo->peso < menorValor){
          //cout << "J Index: " << j << endl;
          menorValor = this->nosVisitados[i]->Vetor[j].nextNo->peso;
          index = j;
          *k = i;
        }
      }
    }
  }

  //cout << "MinorIndex Index: " << index << endl;
  return index;
}

void Grafo::algoritmoPrim(){
  int i = 0;
  int auxindex = 0;
  int sum = 0;

  this->nosVisitados.push_back(this->noVetor[i]);

  while(this->nosVisitados.size() < this->noVetor.size()){
    int menorIndex = getMenorValorListaDeGrafo(&i);
    //cout << "i Value: " << i << endl;
    auxindex = getNoPorNome(this->nosVisitados[i]->Vetor[menorIndex].nextNo->nome);
    //cout << "Value: " << this->visitedNodes[i]->vVector[minorIndex].value << endl;
    sum += this->nosVisitados[i]->Vetor[menorIndex].valor;
    i = auxindex;
    this->nosVisitados.push_back(this->noVetor[i]);
  }

  cout << "Caminho Prim: " << sum << endl;
  for(int i=0; i<this->nosVisitados.size(); i++){
      cout << "No visitado pelo Prim: " << this->nosVisitados[i]->nome << endl;
  }
}

void Grafo::algoritmoDijkstra(){
  int i = 0;
  int auxIndex = 0;
  int sum = 0;
  this->nosVisitados.push_back(this->noVetor[i]);
  this->nosVisitados[i]->peso = 0;


  while(this->nosVisitados.size() < this->noVetor.size()){
    upgradePesoNo(this->noVetor[auxIndex]);
    int menorIndex = getMenorProximoNo(&i);
    auxIndex = getNoPorNome(this->nosVisitados[i]->Vetor[menorIndex].nextNo->nome);
    cout << "Aux Index: " << auxIndex << endl;
    //sum += upgradePesoNo();
    this->nosVisitados.push_back(this->noVetor[auxIndex]);
  }
  //cout << "\n " << endl;
  cout << "Caminho Dijkstra: " << sum << endl;
  for(i=0;i<this->nosVisitados.size();i++){
    cout << "No Visitado pelo Dijkstra: " << this->nosVisitados[i]->nome << endl;
  }
}
/*
void Grafo::algoritmoKruskal(){
  int i = 0;
  int auxindex = 0;
  int sum = 0;

  this->nosVisitados.push_back(this->noVetor[i]);

  while(this->nosVisitados.size() < this->noVetor.size()){
    int menorIndex = getMenorValorListaDeGrafo(&i);
    //cout << "i Value: " << i << endl;
    auxindex = getNoPorNome(this->nosVisitados[i]->Vetor[menorIndex].nextNo->nome);
    //cout << "Value: " << this->visitedNodes[i]->vVector[minorIndex].value << endl;
    sum += this->nosVisitados[i]->Vetor[menorIndex].valor;
    i = auxindex;
    this->nosVisitados.push_back(this->noVetor[i]);
  }

  cout << "Caminho Prim: " << endl;
  for(int i=0; i<this->nosVisitados.size(); i++){
      cout << "No visitado pelo Prim: " << this->nosVisitados[i]->nome << endl;
  }
}
*/
