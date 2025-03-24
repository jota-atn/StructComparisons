#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <string>
#include "../../include/cpp/array_list.hpp"
#include "../../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_remove(ArrayList& array_list, int n, bool use_reserve) {

    if (use_reserve) {
        array_list.reserve(n);
    }

    auto inicio = high_resolution_clock::now();
    
    for (int i = 0; i < n; i++) {
        array_list.remove(array_list.size() - 1);
    }
    
    auto fim = high_resolution_clock::now();
    auto duration = duration_cast<milliseconds>(fim - inicio);
    
    return duration.count();
}

void test_dataset_removal(ArrayList& array_list, int num_elementos) {
    
    vector <int> values = {1000, 10000, 100000, 1000000, 10000000};
    
    string saida = "C:/Users/jamqu/Projects/StructComparisons/C/out/remove_last.txt";
    
    limpar_arquivo(saida);
    
    for (int valor : values) {
        array_list.fill_array(to_string(valor));

        long long tempo_total = 0;
        
        int num_execucoes = 500;;
        for (int i = 0; i < num_execucoes; ++i) {
        tempo_total += test_remove(array_list, num_elementos, false);
        }

        double tempo_medio = static_cast<double> (tempo_total) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de remocao no fim de " << num_elementos
            << " para um Data Set de tamanho " << to_string(valor)
            << " apos " << num_execucoes << " execucoes: " << tempo_medio << " milissegundos" << endl;
    }
}
