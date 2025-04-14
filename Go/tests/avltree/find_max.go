package main

import (
	"fmt"
	"math/rand"
	"os"
	"path/filepath"
	"strconv"
	"time"

	"github.com/jota-atn/StructComparisons/Go/avltree"
)

// testFindMax mede o tempo para encontrar o valor máximo na árvore AVL
func testFindMax(arvore *avltree.AVLTree) int64 {
	inicio := time.Now()

	_, _ = arvore.Max()

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

// preencherArvore carrega dados para a árvore
func preencherArvore(arvore *avltree.AVLTree, tamanho string) {
	n, _ := strconv.Atoi(tamanho)
	
	// Limpar árvore atual
	arvore.Limpar()
	
	// Adiciona elementos na árvore
	for i := 0; i < n; i++ {
		arvore.Adicionar(rand.Intn(1000000))
	}
}

// testDatasetFindMax testa a busca do valor máximo para diferentes tamanhos de árvore
func testDatasetFindMax(arvore *avltree.AVLTree) {
	valores := []int{1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000}

	saida := "./out/avltree/find_max.txt"

	limparArquivo(saida)

	// Inicializar o gerador de números aleatórios
	rand.Seed(time.Now().UnixNano())

	// Número de execuções para obter uma média confiável
	numExecucoes := 30

	for _, valor := range valores {
		preencherArvore(arvore, strconv.Itoa(valor))

		tempoTotal := int64(0)

		fmt.Printf("Executando teste para árvore de tamanho %d...\n", valor)

		for i := 0; i < numExecucoes; i++ {
			tempoTotal += testFindMax(arvore)
		}

		tempoMedio := float64(tempoTotal) / float64(numExecucoes)

		gerarSaida(tempoMedio, strconv.Itoa(valor), saida)

		fmt.Printf("Tempo medio de busca do valor máximo em uma Árvore AVL de tamanho %d após %d execuções: %.4f nanossegundos\n",
			valor, numExecucoes, tempoMedio)
	}
}

func main() {
	arvore := avltree.NovaArvoreInt()
	testDatasetFindMax(arvore)
}
