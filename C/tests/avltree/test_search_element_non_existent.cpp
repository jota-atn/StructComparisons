#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <string>
#include "../../include/cpp/avl_tree.hpp"
#include "../../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_search_element(AVLTree& avl_tree, int element) {
    auto inicio = high_resolution_clock::now();
    
    avl_tree.search(element);
    
    auto fim = high_resolution_clock::now();
    auto duration = duration_cast<nanoseconds>(fim - inicio);
    
    return duration.count();
}

void test_dataset_search_element_non_existent(AVLTree& avl_tree, int num_execucoes) {
    
    vector<int> values = {10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000};
        
    string saida = "../out/avltree/search.txt";
    
    limpar_arquivo(saida);
    
    for (int valor : values) {
        avl_tree.fill_tree(to_string(valor)); 

        long long tempo_total = 0;
        
        int elemento_alvo = -1; 
        
        for (int i = 0; i < num_execucoes; ++i) {
            tempo_total += test_search_element(avl_tree, elemento_alvo);
        }

        double tempo_medio = static_cast<double>(tempo_total) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de busca para elemento " << elemento_alvo
             << " em Data Set de tamanho " << to_string(valor)
             << " apos " << num_execucoes << " execucoes: " << tempo_medio << " nanossegundos" << endl;
    }
}
