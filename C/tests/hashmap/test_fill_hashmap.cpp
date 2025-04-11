#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <string>
#include "../../include/cpp/hash_map.hpp"
#include "../../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_fill_hashmap(HashMap& hashmap, int n) {

    auto inicio = high_resolution_clock::now();
    
    hashmap.fill_map(to_string(n));
    
    auto fim = high_resolution_clock::now();
    auto duration = duration_cast<nanoseconds>(fim - inicio);
    
    return duration.count();
}

void test_dataset_fill_hashmap(HashMap& hashmap, int num_execucoes) {

    vector<int> values = {10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000};
        
    string saida = "../out/hashmap/fill_hashmap.txt";
    
    limpar_arquivo(saida);

    for (int valor : values) {

        long long tempo_total = 0;

        int num_elementos = valor * 0.001;
        for (int i = 0; i < num_execucoes; i++) {
            tempo_total += test_fill_hashmap(hashmap, num_elementos);
        }

        double tempo_medio = static_cast<double> (tempo_total) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de preenchimento de um HashMap para um Data Set de tamanho " << to_string(valor)
            << " apos " << num_execucoes << " execucoes: " << tempo_medio << " nanossegundos" << endl;
    }
}

