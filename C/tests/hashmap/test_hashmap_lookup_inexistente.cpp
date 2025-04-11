#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <string>
#include "../../include/cpp/hash_map.hpp"
#include "../../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_get_inexistente(HashMap& hashmap, int chave_inexistente, int num_execucoes) {
    auto inicio = high_resolution_clock::now();

    for (int i = 0; i < num_execucoes; ++i) {
        hashmap.get(chave_inexistente); 
    }

    auto fim = high_resolution_clock::now();
    auto duracao = duration_cast<nanoseconds>(fim - inicio);

    return static_cast<double>(duracao.count()) / num_execucoes;
}

void test_lookup_inexistent(HashMap& hashmap, int num_execucoes) {
    vector<int> values = {10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000};

    string saida = "../out/hashmap/lookup_inexistent_element.txt";
    limpar_arquivo(saida);

    for (int valor : values) {
        hashmap.clear();
        for (int i = 1; i <= valor; ++i) {
            hashmap.put(i, i * 10);
        }

        int chave_inexistente = 0;
        double tempo_medio = test_get_inexistente(hashmap, chave_inexistente, num_execucoes);

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de busca pela chave inexistente " << chave_inexistente
             << " em um HashMap com " << valor << " elementos: "
             << tempo_medio << " nanossegundos" << endl;
    }
}
