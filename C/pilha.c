#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

Pilha* criarPilha() {
    Pilha* pilha = (Pilha*)malloc(sizeof(Pilha));
    pilha->topo = -1;
    return pilha;
}

void empilhar(Pilha* pilha, int dado) {
    if (pilha->topo == MAX - 1) {
        printf("Pilha cheia!\n");
        return;
    }
    pilha->dados[++pilha->topo] = dado;
}

int desempilhar(Pilha* pilha) {
    if (pilha->topo == -1) {
        printf("Pilha vazia!\n");
        return -1;
    }
    return pilha->dados[pilha->topo--];
}

