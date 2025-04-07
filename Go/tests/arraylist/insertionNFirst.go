package main

import (
	"fmt"
	"time"
	
	"../../arraylist"
)

func main() {
	carga := 1000
	n := carga / 1000 // 0,1% da carga
	if n < 1 {
		n = 1
	}

	lista := arraylist.NovaLista(carga + n)
	
	// Preencher a lista
	for i := 0; i < carga; i++ {
		lista.Adicionar(i)
	}
	
	tamanhoInicial := lista.Tamanho()
	
	// Medir o tempo das operações
	inicio := time.Now()
	
	// Inserir n elementos no início
	for i := 0; i < n; i++ {
		valor := -i - 1 // Valores negativos para diferenciar
		lista.Inserir(0, valor)
	}
	
	duracao := time.Since(inicio)
	
	// Verificações
	if lista.Tamanho() != tamanhoInicial + n {
		fmt.Printf("Erro: tamanho esperado %d, obtido %d\n", tamanhoInicial+n, lista.Tamanho())
	} else {
		fmt.Printf("Operação bem-sucedida: %d elementos inseridos no início\n", n)
	}
	
	fmt.Printf("Duração da operação: %v\n", duracao)
	fmt.Printf("Número de elementos inseridos: %d\n", n)
	fmt.Printf("Tamanho final da lista: %d\n", lista.Tamanho())
}