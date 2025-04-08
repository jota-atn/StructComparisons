#include <iostream>
#include <random>
#include <fstream>
#include <vector>
#include <chrono>
#include <string>
#include "../../include/cpp/linked_list.hpp"
#include "../../include/cpp/output.hpp"

using namespace std;
using namespace chrono;

auto test_add_last_one_element(LinkedList& linked_list) {

    random_device rd;
    mt19937 gen(rd());
    uniform_int_distribution<int> distrib(1, 100);

    int numero = distrib(gen);

    auto inicio = steady_clock::now();

    linked_list.add_last(numero);
    
    auto fim = steady_clock::now();
    
    auto duration = duration_cast<nanoseconds>(fim - inicio);
    
    return duration.count();
}

void test_dataset_insertion_last_one_element(LinkedList& linked_list, int num_execucoes) {

    vector<int> values = {10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000};
        
    string saida = "../out/linkedlist/insertion_last_one_element.txt";
    
    limpar_arquivo(saida);

    for (int valor : values) {
        linked_list.fill_list(to_string(valor)); 

        long long tempo_total = 0;
        
        for (int i = 0; i < num_execucoes; ++i) {
            tempo_total += test_add_last_one_element(linked_list);
        }

        double tempo_medio = static_cast<double> (tempo_total) / num_execucoes;

        gerar_saida(tempo_medio, to_string(valor), saida);

        cout << "Tempo medio de insercao ao fim de " << 1
            << " elemento para um Data Set de tamanho " << to_string(valor)
            << " apos " << num_execucoes << " execucoes: " << tempo_medio << " nanossegundos" << endl;
    }
}