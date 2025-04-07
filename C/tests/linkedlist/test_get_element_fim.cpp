#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <random>
#include "../../include/cpp/linked_list.hpp"
#include "../../include/cpp/output.hpp"

using namespace std;
using namespace chrono;


auto test_get_fim(LinkedList& linked_list) {

    auto inicio = high_resolution_clock::now();

    int fim_val = linked_list.get_last();

    auto fim = high_resolution_clock::now();
    
    auto duration = duration_cast<nanoseconds>(fim - inicio);
    
    return duration.count();

}

void test_dataset_get_fim(LinkedList& linked_list) {

    vector<int> values = {1000, 10000, 100000, 1000000, 10000000};

    string saida = "../out/linkedlist/get_fim.txt";

    limpar_arquivo(saida);

    for (int valor : values) {
        linked_list.fill_list(to_string(valor));

        long long tempo_total = 0;

        int num_execucoes = 100000000;
        for (int i = 0; i < num_execucoes; ++i) {
            tempo_total += test_get_fim(linked_list);
        }

        double tempo_medio = static_cast<double>(tempo_total) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de get fim para um Data Set de tamanho " << to_string(valor)
             << " apos " << num_execucoes << " execucoes: " << tempo_medio << " nanosegundos" << endl;

    }

}