#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <string>
#include "../../include/cpp/avl_tree.hpp"
#include "../../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_max(AVLTree& tree) {
    auto inicio = high_resolution_clock::now();
    
    volatile int maximo = tree.max();

    auto fim = high_resolution_clock::now();
    auto duration = duration_cast<nanoseconds>(fim - inicio);
    
    return duration.count();
}

void test_dataset_max(AVLTree& tree, int num_execucoes) {
    vector<int> values = {10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000};

    string saida = "../out/avltree/max_value.txt";

    limpar_arquivo(saida);

    for (int valor : values) {
        tree.clear();

        for (int i = 0; i < valor; ++i) {
            tree.insert(i);
        }

        long long tempo_total = 0;
        for (int i = 0; i < num_execucoes; ++i) {
            tempo_total += test_max(tree);
        }

        double tempo_medio = static_cast<double>(tempo_total) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo médio para pegar o valor máximo em uma AVL com "
             << valor << " elementos após " << num_execucoes
             << " execuções: " << tempo_medio << " nanossegundos" << endl;
    }
}
