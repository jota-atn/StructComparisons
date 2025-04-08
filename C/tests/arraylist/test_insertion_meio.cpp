#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <string>
#include "../../include/cpp/array_list.hpp"
#include "../../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_insert_middle(ArrayList& array_list, int n) {
    
    auto inicio = high_resolution_clock::now();
    
    for (int i = 0; i < n; i++) {
        array_list.insert(n/2, i);
    }
    
    auto fim = high_resolution_clock::now();
    auto duration = duration_cast<nanoseconds>(fim - inicio);
    
    return duration.count();
}

void test_dataset_insertion_middle(ArrayList& array_list, int num_execucoes) {

    vector<int> values = {10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000};
        
    string saida = "../out/arraylist/insertion_middle.txt";
    
    limpar_arquivo(saida);

    for (int valor : values) {
        array_list.fill_array(to_string(valor)); 

        long long tempo_total = 0;
        
        int num_elementos = valor / 100; 
        for (int i = 0; i < num_execucoes; ++i) {
            tempo_total += test_insert_middle(array_list, num_elementos);
        }

        double tempo_medio = static_cast<double> (tempo_total) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de insercao sempre no meio de " << num_elementos
            << " para um Data Set de tamanho " << to_string(valor)
            << " apos " << num_execucoes << " execucoes: " << tempo_medio << " nanossegundos" << endl;
    }
}

