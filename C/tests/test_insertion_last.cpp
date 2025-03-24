#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <string>
#include "../include/cpp/array_list.hpp"
#include "../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_add(ArrayList& array_list, int n, bool use_reserve) {
    
    if (use_reserve) {
        array_list.reserve(n);
    }
    

    auto inicio = high_resolution_clock::now();
    
    for (int i = 0; i < n; i++) {
        array_list.add(i);
    }
    
    auto fim = high_resolution_clock::now();
    auto duration = duration_cast<milliseconds>(fim - inicio);
    
    return duration.count();
}

void test_dataset_insertion(ArrayList& array_list, string size, int num_elementos) {

    long long tempo_total = 0;
    
    int num_execucoes = 500;
    for (int i = 0; i < num_execucoes; ++i) {
       tempo_total += test_add(array_list, num_elementos, true);
    }

    double tempo_medio = static_cast<double> (tempo_total) / num_execucoes;

    string saida = "C:/Users/jamqu/Projects/StructComparisons/C/out/insertion_last.txt";
    gerar_saida(tempo_medio, size, saida);

    cout << "Tempo medio de insercao de " << num_elementos
         << " para um Data Set de tamanho " << size
         << " apos " << num_execucoes << " execucoes: " << tempo_medio << " milissegundos" << endl;
}

