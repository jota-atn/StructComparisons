package main

import (
	"fmt"
	"math/rand"
	"os"
	"path/filepath"
	"strconv"
	"time"
	"github.com/jota-atn/StructComparisons/Go/hashmap"
)

func testInsertionAll(mapa *hashmap.HashMap, numElementos int) int64 {
	chaves := make([]string, numElementos)
	valores := make([]interface{}, numElementos)
	for i := 0; i < numElementos; i++ {
		chaves[i] = gerarChaveAleatoria(10)
		valores[i] = rand.Intn(1000000)
	}
	inicio := time.Now()
	for i := 0; i < numElementos; i++ {
		mapa.Put(chaves[i], valores[i])
	}
	return time.Since(inicio).Nanoseconds()
}

func limparArquivo(caminho string) {
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

func gerarChaveAleatoria(tamanho int) string {
	const letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
	chave := make([]byte, tamanho)
	for i := range chave {
		chave[i] = letras[rand.Intn(len(letras))]
	}
	return string(chave)
}

func testDatasetInsertionAll(mapa *hashmap.HashMap) {
	valores := []int{1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000}
	saida := "./out/hashmap/insertion_all.txt"
	limparArquivo(saida)
	rand.Seed(time.Now().UnixNano())
	numExecucoes := 10
	for _, valor := range valores {
		tempoTotal := int64(0)
		numElementos := int(float64(valor) * 0.01)
		fmt.Printf("Executando teste para inserir %d elementos...\n", numElementos)
		for i := 0; i < numExecucoes; i++ {
			mapaTemp := hashmap.NewHashMap()
			tempoTotal += testInsertionAll(mapaTemp, numElementos)
		}
		tempoMedio := float64(tempoTotal) / float64(numExecucoes)
		gerarSaida(tempoMedio, strconv.Itoa(numElementos), saida)
		fmt.Printf("Tempo medio de inserção de %d elementos em um HashMap após %d execuções: %.4f nanossegundos\n", numElementos, numExecucoes, tempoMedio)
	}
}

func main() {
	mapa := hashmap.NewHashMap()
	testDatasetInsertionAll(mapa)
}
