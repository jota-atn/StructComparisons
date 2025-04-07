package main

import (
    "fmt"
    "os"
    "path/filepath"
    "strconv"
    "time"
    
    "github.com/jota-atn/StructComparisons/Go/arraylist"
)

// testInsertFirst mede o tempo para inserir n elementos no início da lista
func testInsertFirst(lista *arraylist.ArrayList, n int) int64 {
    inicio := time.Now()
    
    // Inserir n elementos no início da lista
    for i := 0; i < n; i++ {
        lista.Inserir(0, i)
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
    
    // Limpar lista atual
    *lista = *arraylist.NovaLista(n)
    
    // Adiciona elementos na lista
    for i := 0; i < n; i++ {
        lista.Adicionar(i)
    }
}

// testDatasetInsertionFirstNElements testa inserção de elementos no início para diferentes tamanhos
func testDatasetInsertionFirstNElements(lista *arraylist.ArrayList, numExecucoes int) {
    valores := []int{10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000}
    
    saida := "./out/arraylist/insertion_first_n_elements.txt"
    
    limparArquivo(saida)
    
    for _, valor := range valores {
        preencherLista(lista, strconv.Itoa(valor))
        
        tempoTotal := int64(0)
        
        // Calcular o número de elementos a inserir (0.1% do tamanho)
        numElementos := int(float64(valor) * 0.001)
        
        fmt.Printf("Executando teste para tamanho %d com inserção de %d elementos...\n", valor, numElementos)
        
        for i := 0; i < numExecucoes; i++ {
            tempoTotal += testInsertFirst(lista, numElementos)
            // Recriar a lista para cada execução para manter condições consistentes
            preencherLista(lista, strconv.Itoa(valor))
        }
        
        tempoMedio := float64(tempoTotal) / float64(numExecucoes)
        
        gerarSaida(tempoMedio, strconv.Itoa(valor), saida)
        
        fmt.Printf("Tempo medio de inserção de %d elementos sempre no inicio para um Data Set de tamanho %d apos %d execucoes: %.4f nanossegundos\n", 
            numElementos, valor, numExecucoes, tempoMedio)
    }
}

func main() {
    // Criar a estrutura inicial
    lista := arraylist.NovaLista(10000000)
    
    // Número de execuções para cada tamanho (menos que os exemplos anteriores 
    // porque cada execução já faz muitas inserções)
    numExecucoes := 10
    
    // Testar inserção de elementos no início
    testDatasetInsertionFirstNElements(lista, numExecucoes)
}