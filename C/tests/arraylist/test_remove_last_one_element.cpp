#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <string>
#include "../../include/cpp/array_list.hpp"
#include "../../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_remove_last_one_element(ArrayList& array_list) {

    auto inicio = high_resolution_clock::now();
    
    array_list.remove(array_list.size() - 1);
    
    auto fim = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(fim - inicio);
    
    return duration.count();
}

void test_dataset_remove_last_one_element(ArrayList& array_list, int num_execucoes) {
    
    vector <int> values = {1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000};
    
    string saida = "../out/arraylist/remove_last_one_element.txt";
    
    limpar_arquivo(saida);
    
    for (int valor : values) {
        array_list.fill_array(to_string(valor));

        long long tempo_total = 0;
        
        for (int i = 0; i < num_execucoes; ++i) {
            tempo_total += test_remove_last_one_element(array_list);
        }

        double tempo_medio = static_cast<double> (tempo_total) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de remocao no fim de 1 elemento para um Data Set de tamanho " << to_string(valor)
            << " apos " << num_execucoes << " execucoes: " << tempo_medio << " microssegundos" << endl;
    }
}
