#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <string>
#include "../../include/cpp/hash_map.hpp"
#include "../../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_remove(HashMap& hashmap, int chave) {
    auto inicio = high_resolution_clock::now();

    hashmap.remove(chave);

    auto fim = high_resolution_clock::now();
    auto duracao = duration_cast<nanoseconds>(fim - inicio);

    return static_cast<double>(duracao.count());
}

void test_dataset_single_removal(HashMap& hashmap, int num_execucoes) {
    vector<int> values = {10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000};

    string saida = "../out/hashmap/remove_single_element.txt";
    limpar_arquivo(saida);

    for (int valor : values) {

        hashmap.clear();

        for (int i = 0; i < valor; ++i) {
            hashmap.put(i, i * 10);
        }

        long long tempo_total = 0;

        int chave_alvo = valor / 2;
        for (int i = 0; i < num_execucoes; ++i) {
            tempo_total += test_remove(hashmap, chave_alvo);
        }

        double tempo_medio = test_remove(hashmap, chave_alvo) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de remoção da chave " << chave_alvo
             << " em um HashMap com " << valor << " elementos: "
             << tempo_medio << " nanossegundos" << endl;
    }
}
