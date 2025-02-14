#ifndef PILHA_H
#define PILHA_H

#define MAX 100

typedef struct {
    int dados[MAX];
    int topo;
} Pilha;

Pilha* criarPilha();
void empilhar(Pilha* pilha, int dado);
int desempilhar(Pilha* pilha);

#endif
