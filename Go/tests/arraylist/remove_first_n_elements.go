package main

import (
	"fmt"
	"os"
	"path/filepath"
	"strconv"
	"time"

	"github.com/jota-atn/StructComparisons/Go/arraylist"
)

// testRemoveFirstNElements mede o tempo para remover n elementos do início da lista
func testRemoveFirstNElements(lista *arraylist.ArrayList, n int) int64 {
	inicio := time.Now()

	for i := 0; i < n; i++ {
		_, _ = lista.Remover(0) // Sempre remove o índice 0 (primeiro elemento)
	}

	duracao := time.Since(inicio)
	return duracao.Nanoseconds()
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
func preencherLista(lista *arraylist.ArrayList, tamanho string) {
	n, _ := strconv.Atoi(tamanho)

	// Limpar lista atual e criar uma nova com capacidade adequada
	*lista = *arraylist.NovaLista(n)

	// Adiciona elementos na lista
	for i := 0; i < n; i++ {
		lista.Adicionar(i)
	}
}

// testDatasetRemoveFirstNElements testa a remoção dos primeiros n elementos para diferentes tamanhos de lista
func testDatasetRemoveFirstNElements(lista *arraylist.ArrayList) {
	valores := []int{1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000}

	saida := "./out/arraylist/remove_first_n_elements.txt"

	limparArquivo(saida)

	// Número de execuções para obter uma média confiável
	numExecucoes := 100 // Podemos ajustar conforme necessário

	for _, valor := range valores {
		preencherLista(lista, strconv.Itoa(valor))

		tempoTotal := int64(0)
		numElementos := int(float64(valor) * 0.001) // 0.1% do tamanho atual

		fmt.Printf("Executando teste para tamanho %d...\n", valor)

		for i := 0; i < numExecucoes; i++ {
			// Fazemos uma cópia da lista para não modificar a lista original em cada execução
			listaCopia := *lista
			tempoTotal += testRemoveFirstNElements(&listaCopia, numElementos)
		}

		tempoMedio := float64(tempoTotal) / float64(numExecucoes)

		gerarSaida(tempoMedio, strconv.Itoa(valor), saida)

		fmt.Printf("Tempo medio de remoção dos primeiros %d elementos para um Data Set de tamanho %d apos %d execucoes: %.4f nanossegundos\n",
			numElementos, valor, numExecucoes, tempoMedio)
	}
}

func main() {
	lista := arraylist.NovaLista(10000000)
	testDatasetRemoveFirstNElements(lista)
}