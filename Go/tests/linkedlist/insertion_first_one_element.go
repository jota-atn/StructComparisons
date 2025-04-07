package main

import (
	"fmt"
	"os"
	"path/filepath"
	"strconv"
	"time"
	
	"github.com/jota-atn/StructComparisons/Go/linkedlist"
)

// testInsertFirstOneElement mede o tempo para inserir um elemento no início da lista
func testInsertFirstOneElement(lista *linkedlist.LinkedList, n int) int64 {
	inicio := time.Now()
	
	lista.Inserir(0, n)
	
	duracao := time.Since(inicio)
	return duracao.Nanoseconds() // Em vez de Microseconds()
}

// limparArquivo limpa o conteúdo de um arquivo
func limparArquivo(caminho string) {
	// Criar diretório se não existir
	dir := filepath.Dir(caminho)
	if _, err := os.Stat(dir); os.IsNotExist(err) {
		os.MkdirAll(dir, 0755)
	}
	
	arquivo, err := os.Create(caminho)
	if err != nil {
		fmt.Println("Erro ao limpar arquivo:", err)
		return
	}
	defer arquivo.Close()
}

// gerarSaida escreve os resultados em um arquivo
func gerarSaida(tempoMedio float64, tamanho string, caminho string) {
	conteudo := fmt.Sprintf("%s;%.4f\n", tamanho, tempoMedio)
	
	arquivo, err := os.OpenFile(caminho, os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Println("Erro ao abrir arquivo:", err)
		return
	}
	defer arquivo.Close()
	
	if _, err := arquivo.WriteString(conteudo); err != nil {
		fmt.Println("Erro ao escrever no arquivo:", err)
	}
}

// preencherLista carrega dados para a lista
func preencherLista(lista *linkedlist.LinkedList, tamanho string) {
    n, _ := strconv.Atoi(tamanho)
    
    // Limpar lista atual
    *lista = *linkedlist.NovaLista(n)
    
    // Adiciona elementos na lista
    for i := 0; i < n; i++ {
        lista.Adicionar(i)
    }
}

// testDatasetInsertionFirstOneElement testa inserção no início para diferentes tamanhos de dataset
func testDatasetInsertionFirstOneElement(lista *linkedlist.LinkedList, numExecucoes int) {
	valores := []int{1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000}
	
	saida := "./out/linkedlist/insertion_first_one_element.txt"
	
	limparArquivo(saida)
	
	for _, valor := range valores {
		preencherLista(lista, strconv.Itoa(valor))
		
		tempoTotal := int64(0)
		
		elemento := 50
		for i := 0; i < numExecucoes; i++ {
			tempoTotal += testInsertFirstOneElement(lista, elemento)
		}
		
		tempoMedio := float64(tempoTotal) / float64(numExecucoes)
		
		gerarSaida(tempoMedio, strconv.Itoa(valor), saida)
		
		fmt.Printf("Tempo medio de insercao sempre no inicio de um unico elemento, %d para um Data Set de tamanho %d apos %d execucoes: %.2f nanossegundos\n", 
            elemento, valor, numExecucoes, tempoMedio)
	}
}

func main() {
	lista := linkedlist.NovaLista(10000000)
	// Testar com 5 execuções para cada tamanho de dataset
	testDatasetInsertionFirstOneElement(lista, 1000) // Em vez de 5
}