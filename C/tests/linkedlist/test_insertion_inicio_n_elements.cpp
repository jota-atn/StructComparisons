#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <string>
#include "../../include/cpp/linked_list.hpp"
#include "../../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_insert_first(LinkedList& linked_list, int n) {
    
    auto inicio = high_resolution_clock::now();
    
    for (int i = 0; i < n; i++) {
        linked_list.add_first(i);
    }
    
    auto fim = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(fim - inicio);
    
    return duration.count();
}

void test_dataset_insertion_first_n_elements(LinkedList& linked_list, int num_execucoes) {

    vector <int> values = {10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000};
    
    string saida = "../../out/linkedlist/insertion_first_elemento_unico.txt";
    
    limpar_arquivo(saida);

    for (int valor : values) {
        linked_list.fill_list(to_string(valor));

        long long tempo_total = 0;
        
        int num_elementos = valor * 0.001; 
        for (int i = 0; i < num_execucoes; i++) {
            tempo_total += test_insert_first(linked_list, num_elementos);
        }

        double tempo_medio = static_cast<double> (tempo_total) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de insercao na Linked List sempre no inicio de " << num_elementos
            << " para um Data Set de tamanho " << to_string(valor)
            << " apos " << num_execucoes << " execucoes: " << tempo_medio << " microssegundos" << endl;
    }
}

