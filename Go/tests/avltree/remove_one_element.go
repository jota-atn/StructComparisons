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

// testRemoveOneElement mede o tempo para remover um elemento da árvore AVL
func testRemoveOneElement(arvore *avltree.AVLTree, elemento interface{}) int64 {
	inicio := time.Now()

	arvore.Remover(elemento)

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

// preencherArvore carrega dados para a árvore e retorna um slice com os elementos inseridos
func preencherArvore(arvore *avltree.AVLTree, tamanho string) []int {
	n, _ := strconv.Atoi(tamanho)
	
	// Limpar árvore atual
	arvore.Limpar()
	
	// Lista para rastrear elementos adicionados
	elementos := make([]int, n)
	
	// Adiciona elementos na árvore
	for i := 0; i < n; i++ {
		valor := rand.Intn(1000000)
		elementos[i] = valor
		arvore.Adicionar(valor)
	}
	
	return elementos
}

// testDatasetRemoveOneElement testa a remoção de um elemento para diferentes tamanhos de árvore
func testDatasetRemoveOneElement(arvore *avltree.AVLTree) {
	valores := []int{1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000}

	saida := "./out/avltree/remove_one_element.txt"

	limparArquivo(saida)

	// Inicializar o gerador de números aleatórios
	rand.Seed(time.Now().UnixNano())

	// Número de execuções para obter uma média confiável
	numExecucoes := 1000

	for _, valor := range valores {
		tempoTotal := int64(0)

		fmt.Printf("Executando teste para árvore de tamanho %d...\n", valor)

		for i := 0; i < numExecucoes; i++ {
			// Preencher a árvore e obter os elementos inseridos
			elementos := preencherArvore(arvore, strconv.Itoa(valor))
			
			// Seleciona um elemento aleatório para remover
			elementoParaRemover := elementos[rand.Intn(len(elementos))]
			
			tempoTotal += testRemoveOneElement(arvore, elementoParaRemover)
		}

		tempoMedio := float64(tempoTotal) / float64(numExecucoes)

		gerarSaida(tempoMedio, strconv.Itoa(valor), saida)

		fmt.Printf("Tempo medio de remoção de 1 elemento para uma Árvore AVL de tamanho %d após %d execuções: %.4f nanossegundos\n",
			valor, numExecucoes, tempoMedio)
	}
}

func main() {
	arvore := avltree.NovaArvoreInt()
	testDatasetRemoveOneElement(arvore)
}