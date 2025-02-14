#include <stdio.h>
#include <stdlib.h>
#include "fila.h"

Fila* criarFila() {
    Fila* fila = (Fila*)malloc(sizeof(Fila));
    fila->frente = fila->tras = -1;
    return fila;
}

void enfileirar(Fila* fila, int dado) {
    if (fila->tras == MAX - 1) {
        printf("Fila cheia!\n");
        return;
    }
    fila->dados[++fila->tras] = dado;
    if (fila->frente == -1) fila->frente = 0;
}

int desenfileirar(Fila* fila) {
    if (fila->frente == -1 || fila->frente > fila->tras) {
        printf("Fila vazia!\n");
        return -1;
    }
    return fila->dados[fila->frente++];
}
