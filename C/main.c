#include <stdio.h>
#include "pilha.h"
#include "fila.h"

int main() {
    Pilha* pilha = criarPilha();
    Fila* fila = criarFila();

    printf("--- Testando a Pilha ---\n");
    empilhar(pilha, 10);
    empilhar(pilha, 20);
    empilhar(pilha, 30);
    printf("Desempilhado: %d\n", desempilhar(pilha));
    printf("Desempilhado: %d\n", desempilhar(pilha));
    printf("Desempilhado: %d\n", desempilhar(pilha));

    printf("\n--- Testando a Fila ---\n");
    enfileirar(fila, 10);
    enfileirar(fila, 20);
    enfileirar(fila, 30);
    printf("Removido: %d\n", desenfileirar(fila));
    printf("Removido: %d\n", desenfileirar(fila));
    printf("Removido: %d\n", desenfileirar(fila));

    return 0;
}

