#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <string>
#include "../include/cpp/array_list.hpp"
#include "../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_add(ArrayList& array_list, const string& filename) {
    ifstream file(filename);
    int valor;

    array_list.clear();
    
    auto inicio = high_resolution_clock::now();
    
    while (file >> valor) {
        array_list.add(valor);
    }
    
    auto fim = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(fim - inicio);
    
    return duration.count();
}

void test_dataset_insertion(ArrayList& array_list, string size) {
    const string filename = "C:/Users/jamqu/Projects/StructComparisons/scripts/inputs/dataset_" + size + ".txt"; 
    long long tempo_total = 0;
    
    int num_execucoes = 500;
    for (int i = 0; i < num_execucoes; ++i) {
       tempo_total += test_add(array_list, filename);
    }

    double tempo_medio = static_cast<double> (tempo_total) / num_execucoes;

    string saida = "C:/Users/jamqu/Projects/StructComparisons/C/out/insertion_end.csv";
    gerar_saida(tempo_medio, size, saida);

    cout << "Tempo medio de insercao para um Data Set de tamanho " << size
         << " apos " << num_execucoes << " execucoes: " << tempo_medio << " microsegundos" << endl;
}

