#include <iostream>
#include <fstream>
#include <vector>
#include "../../include/cpp/output.hpp"

using namespace std;

void gerar_saida(const double tempo_medio, const string& size, const string& caminho) {
    ofstream arquivo(caminho, ios::app);

    if (!arquivo) {
        printf("Erro ao abrir o arquivo.\n");
        return;
    }

    arquivo << size << ";" << tempo_medio << "\n";

    arquivo.close();
}

void limpar_arquivo(const string& caminho) {
    ofstream arquivo(caminho, ios::trunc);
    if (!arquivo) {
        cout << "Erro ao tentar limpar o arquivo." << endl;
    }
    arquivo.close();
}