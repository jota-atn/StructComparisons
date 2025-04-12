#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <string>
#include "../../include/cpp/hash_map.hpp"
#include "../../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_put(HashMap& hashmap, int n) {
    auto inicio = high_resolution_clock::now();

    for (int i = 0; i < n; i++) {
        hashmap.put(i, i * 2);
    }

    auto fim = high_resolution_clock::now();
    auto duracao = duration_cast<microseconds>(fim - inicio);

    return duracao.count();
}

void test_dataset_insertion(HashMap& hashmap, int num_execucoes) {
    vector<int> values = {10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000};
    
    string saida = "../out/hashmap/insertion.txt";
    limpar_arquivo(saida);

    for (int valor : values) {
        long long tempo_total = 0;

        for (int i = 0; i < num_execucoes; ++i) {
            hashmap.clear();
            tempo_total += test_put(hashmap, valor);
        }

        double tempo_medio = static_cast<double>(tempo_total) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de insercao de " << valor
             << " elementos apos " << num_execucoes << " execucoes: "
             << tempo_medio << " microssegundos" << endl;
    }
}
