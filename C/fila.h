#ifndef FILA_H
#define FILA_H

#define MAX 100

typedef struct {
    int dados[MAX];
    int frente, tras;
} Fila;

Fila* criarFila();
void enfileirar(Fila* fila, int dado);
int desenfileirar(Fila* fila);

#endif
