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

func testRemoveIndex(mapa *hashmap.HashMap, chave string) int64 {
	inicio := time.Now()
	mapa.Pop(chave)
	duracao := time.Since(inicio)
	return duracao.Nanoseconds()
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

func preencherMapa(mapa *hashmap.HashMap, tamanho string) []string {
	n, _ := strconv.Atoi(tamanho)
	*mapa = *hashmap.NewHashMap()
	chaves := make([]string, n)
	for i := 0; i < n; i++ {
		chave := gerarChaveAleatoria(10)
		valor := rand.Intn(1000000)
		mapa.Put(chave, valor)
		chaves[i] = chave
	}
	return chaves
}

func testDatasetRemoveIndex(mapa *hashmap.HashMap) {
	valores := []int{1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000}
	saida := "./out/hashmap/remove_index.txt"
	limparArquivo(saida)
	rand.Seed(time.Now().UnixNano())
	numExecucoes := 1000
	for _, valor := range valores {
		tempoTotal := int64(0)
		fmt.Printf("Executando teste para mapa de tamanho %d...\n", valor)
		for i := 0; i < numExecucoes; i++ {
			chaves := preencherMapa(mapa, strconv.Itoa(valor))
			idxChave := rand.Intn(len(chaves))
			chave := chaves[idxChave]
			tempoTotal += testRemoveIndex(mapa, chave)
		}
		tempoMedio := float64(tempoTotal) / float64(numExecucoes)
		gerarSaida(tempoMedio, strconv.Itoa(valor), saida)
		fmt.Printf("Tempo medio de remoção por chave em um HashMap de tamanho %d após %d execuções: %.4f nanossegundos\n",
			valor, numExecucoes, tempoMedio)
	}
}

func main() {
	mapa := hashmap.NewHashMap()
	testDatasetRemoveIndex(mapa)
}
