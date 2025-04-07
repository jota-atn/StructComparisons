package main

import (
	"fmt"
	"time"
	
	"../../arraylist" // Importação relativa
)

func main() {
	// Criar nova lista
	lista := arraylist.NovaLista(100)
	
	// Preencher a lista com alguns elementos
	lista.InserirAll([]interface{}{10, 20, 30})
	
	// Medir o tempo da operação
	inicio := time.Now()
	
	// Operação a ser testada - inserir no início
	elemento := 5
	lista.Inserir(0, elemento)
	
	duracao := time.Since(inicio)
	
	// Verificar se a operação foi bem-sucedida
	if obtido, _ := lista.Elemento(0); obtido != elemento {
		fmt.Printf("Erro: esperado %v, obtido %v\n", elemento, obtido)
	} else {
		fmt.Printf("Operação bem-sucedida: elemento %v inserido na posição 0\n", elemento)
	}
	
	fmt.Printf("Duração da operação: %v\n", duracao)
	fmt.Printf("Tamanho da lista: %d\n", lista.Tamanho())
}