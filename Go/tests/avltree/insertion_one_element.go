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

// testInsertOneElement mede o tempo para inserir um único elemento na árvore AVL
func testInsertOneElement(arvore *avltree.AVLTree) int64 {
	// Gerar um número aleatório entre 1 e 1000000
	numero := rand.Intn(1000000) + 1

	inicio := time.Now()

	arvore.Adicionar(numero)

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

// testDatasetInsertionOneElement testa a inserção de um elemento para diferentes tamanhos de árvore
func testDatasetInsertionOneElement(arvore *avltree.AVLTree) {
	valores := []int{10, 100, 1000, 2500, 5000, 600000, 750000, 1000000}

	saida := "./out/avltree/insertion_one_element.txt"

	limparArquivo(saida)

	// Inicializar o gerador de números aleatórios
	rand.Seed(time.Now().UnixNano())

	// Número de execuções para obter uma média confiável
	numExecucoes := 1000

	for _, valor := range valores {
		preencherArvore(arvore, strconv.Itoa(valor))

		tempoTotal := int64(0)

		fmt.Printf("Executando teste para árvore de tamanho %d...\n", valor)

		for i := 0; i < numExecucoes; i++ {
			// Fazemos uma cópia profunda da árvore para não afetar a árvore original
			arvoreCopia := avltree.NovaArvoreInt()
			// Preencher com os mesmos dados
			for _, v := range arvore.EmOrdem() {
				arvoreCopia.Adicionar(v)
			}
			tempoTotal += testInsertOneElement(arvoreCopia)
		}

		tempoMedio := float64(tempoTotal) / float64(numExecucoes)

		gerarSaida(tempoMedio, strconv.Itoa(valor), saida)

		fmt.Printf("Tempo medio de inserção de 1 elemento para uma Árvore AVL de tamanho %d após %d execuções: %.4f nanossegundos\n",
			valor, numExecucoes, tempoMedio)
	}
}

func main() {
	arvore := avltree.NovaArvoreInt()
	testDatasetInsertionOneElement(arvore)
}