#include "../../include/cpp/avl_tree.hpp"
#include "../../include/cpp/output.hpp"
#include <vector>
#include <string>
#include <chrono>
#include <iostream>

using namespace std;
using namespace chrono;

auto test_single_removal(AVLTree& avl, int valor) {
    auto inicio = high_resolution_clock::now();
    
    avl.remove(valor);
    
    auto fim = high_resolution_clock::now();

    auto duration = duration_cast<nanoseconds>(fim - inicio);
    return duration.count();
}

void test_dataset_single_element_remotion(AVLTree& avl, int num_execucoes) {
    vector<int> values = {10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000};

    string saida = "../out/avltree/removal_single_element.txt";

    limpar_arquivo(saida);

    for (int valor : values) {
        long long tempo_total = 0;

        for (int i = 0; i < num_execucoes; ++i) {
            avl.clear();
            for (int j = 0; j < valor; ++j) {
                avl.insert(j);
            }

            tempo_total += test_single_removal(avl, valor - 1);
        }

        double tempo_medio = static_cast<double>(tempo_total) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de remocao de 1 elemento na AVL com " << valor
             << " elementos apos " << num_execucoes
             << " execucoes: " << tempo_medio << " nanossegundos" << endl;
    }
}
