#include "../../include/cpp/avl_tree.hpp"
#include "../../include/cpp/output.hpp"
#include <vector>
#include <string>
#include <chrono>
#include <iostream>

using namespace std;
using namespace chrono;

auto test_single_access(AVLTree& avl, int valor) {
    auto inicio = high_resolution_clock::now();

    volatile bool found = avl.search(valor);

    auto fim = high_resolution_clock::now();

    auto duration = duration_cast<microseconds>(fim - inicio);
    return duration.count();
}

void test_dataset_single_element_access(AVLTree& avl, int num_execucoes) {
    vector<int> values = {10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000};

    string saida = "../out/avltree/access_single_element.txt";

    limpar_arquivo(saida);

    for (int valor : values) {
        avl.clear();
        for (int i = 0; i < valor; ++i) {
            avl.insert(i);
        }

        long long tempo_total = 0;

        for (int i = 0; i < num_execucoes; ++i) {
            tempo_total += test_single_access(avl, valor - 1); 
        }

        double tempo_medio = static_cast<double>(tempo_total) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de acesso de 1 elemento na AVL com " << valor
             << " elementos apos " << num_execucoes
             << " execucoes: " << tempo_medio << " nanossegundos" << endl;
    }
}
