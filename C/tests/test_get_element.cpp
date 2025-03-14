#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <random>
#include "../../include/cpp/array_list.hpp"
#include "../include/cpp/output.hpp"


using namespace std;
using namespace chrono;

auto test_get(ArrayList& array_list, const vector<int>& indices) {
    auto inicio = high_resolution_clock::now();
    
    for (int index : indices) {
        array_list.get(index);
    }

    auto fim = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(fim - inicio);

    return duration.count();
}


void test_dataset_get(ArrayList& array_list, const string& size) {
    const string entrada = "C:/Users/jamqu/Projects/StructComparisons/scripts/inputs/dataset_" + size + ".txt";
    const string saida = "C:/Users/jamqu/Projects/StructComparisons/C/out/get.txt";
    
    ifstream file(entrada);
    vector<int> dataset;
    int valor;

    while (file >> valor) {
        dataset.push_back(valor);
    }

    file.close();
    
    array_list.clear();
    for (int v : dataset) {
        array_list.add(v);
    }

    random_device rd;
    mt19937 gen(rd());
    uniform_int_distribution<> dist(0, dataset.size() - 1);

    vector<int> indices;
    for (int i = 0; i < 1000; ++i) {
        indices.push_back(dist(gen));
    }

    long long tempo_total = 0;
    int num_execucoes = 500;

    for (int i = 0; i < num_execucoes; ++i) {
        tempo_total += test_get(array_list, indices);
    }

    double tempo_medio = static_cast<double>(tempo_total) / num_execucoes;

    gerar_saida(tempo_medio, size, saida);

    cout << "Tempo medio de acesso para dataset de tamanho " << size
         << " apos " << num_execucoes << " execucoes: " << tempo_medio << " microsegundos" << endl;
}
