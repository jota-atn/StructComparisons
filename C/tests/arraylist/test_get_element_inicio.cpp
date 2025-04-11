#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <random>
#include "../../include/cpp/array_list.hpp"
#include "../../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_get_inicio(ArrayList& array_list, int n) {

    auto inicio = high_resolution_clock::now();

    int inicio_val = array_list.get(0);
        
    auto fim = high_resolution_clock::now();
    
    auto duration = duration_cast<nanoseconds>(fim - inicio);
    
    return duration.count();
}

void test_dataset_get_inicio(ArrayList& array_list, int num_execucoes) {
    vector<int> values = {10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 90000000, 10000000};
    
    string saida = "../out/arraylist/get_first.txt";
    
    limpar_arquivo(saida);

    for (int valor : values) {
        array_list.fill_array(to_string(valor));
        
        long long tempo_total = 0;
        
        for (int i = 0; i < num_execucoes; ++i) {
            tempo_total += test_get_inicio(array_list, valor);
        }

        double tempo_medio = static_cast<double>(tempo_total) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de get para um Data Set de tamanho " << to_string(valor)
             << " apos " << num_execucoes << " execucoes: " << tempo_medio << " nanosegundos" << endl;
    }
}