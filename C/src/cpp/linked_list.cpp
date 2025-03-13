#include <iostream>
#include "linked_list.hpp"
using namespace std;

/**
 * Estrutura de Nó utilizada para guardar valores inteiros e um ponteiro para o próximo nó. 
 * Essa estrutura é a base de uma LinkedList.
 * 
 * @param valor: valor inteiro que será guardado no nó.
 * @param next: ponteiro para o próximo nó da lista.
 */ 

struct Node {
    int valor;
    Node* next;
    Node(int val) : valor(val), next(nullptr) {}
};

/**
 * Classe LinkedList que representa uma lista encadeada simples.
 * 
 * @param head: ponteiro para o primeiro nó da lista. 
 * @param size: O tamanho atual da lista. Facilita não percorrer a lista inteira para saber o tamanho. Reduzindo a complexidade de O(n) para O(1).
 */

class LinkedList {
private:
    Node* head;
    int size;

public:
    LinkedList() : head(nullptr), size(0) {}

    /**
     * Método responsável por adicionar um elemento no início da lista. Deve-se criar um novo nó com o valor passado e apontar o next para o head atual.
     * Por fim, o head é atualizado para o novo nó e o tamanho da lista é incrementado.
     * 
     * @param elemento: valor inteiro que será adicionado no início da lista.
     */

    void add_first(int elemento) {
        Node* newNode = new Node(elemento);
        newNode->next = head;
        head = newNode;
        size++;
    }

    /**
     * Método responsável por adicionar um elemento no final da lista. Deve-se criar um novo nó com o valor passado e percorrer a lista até o último nó.	
     * Caso a lista esteja vazia (!head/head==nullptr), o head é atualizado para o novo nó. Caso contrário, percorre a lista até o último nó.
     * Por fim, o tamanho da lista é incrementado.
     * 
     * @param elemento: valor inteiro que será adicionado no final da lista.
     */

    void add_last(int elemento) {
        Node* newNode = new Node(elemento);
        if (!head) {
            head = newNode;
        } 
        
        else {
            Node* temp = head;
            while (temp->next) temp = temp->next;
            temp->next = newNode;
        }

        size++;
    
    }

    /**
     * Método responsável por remover um elemento do início. Caso a lista esteja vazia, não faz nada. Caso contrário, remove o primeiro nó da lista.
     * Por fim, o tamanho da lista é decrementado. 
     */

    void remove_first() {
        if (!head) return;
        
        Node* temp = head;
        head = head->next;
        
        delete temp;
       
        size--;
    }

    /**
     * Método responsável por remover um elemento do final. Caso a lista esteja vazia, não faz nada. Caso contrário, remove o último nó da lista.
     * Por fim, o tamanho da lista é decrementado.
     */

    void remove_last() {
        if (!head) return;
        
        if (!head->next) {
            delete head;
            head = nullptr;
        } 

        else {
            Node* temp = head;
            while (temp->next->next) temp = temp->next;
            delete temp->next;
            temp->next = nullptr;
        }

        size--;

    }

    /**
     * Método que verifica se um elemento está contido na lista. Percorre a lista até encontrar o elemento ou até chegar no final da lista.
     * Se encontrar o elemento, retorna true. Caso contrário, false.
     */

    bool contains(int elemento) {
        Node* temp = head;
        
        while (temp) {
            if (temp->valor == elemento) return true;
            temp = temp->next;
        }

        return false;

    }

    /**
     * Método que retorna o índice de um elemento se ele estiver contido na lista. Perdorre a lista até encontrar o elemento ou até chegar no final da lista.
     * Se encontrar o elemento, retorna o índice. Caso contrário, retorna -1.
     */

    int index_of(int elemento) {
        Node* temp = head;
        int index = 0;

        while (temp) {
            if (temp->valor == elemento) return index;
            temp = temp->next;
            index++;
        }

        return -1;

    }

    /**
     * Retorna o tamanho da lista. Faz isso com uma complexidade O(1), pois o tamanho da lista é atualizado a cada inserção/remoção.
     */

    int size() {
        return size;
    }

    /**
     * Verifica se a lista está vazia. Retorna true se o tamanho da lista for 0. Caso contrário, retorna false.
     */

    bool is_empty() {
        return size == 0;
    }

    /**
     * Método que limpa a lista. Remove todos os elementos da lista até que ela esteja vazia. No caso, até que o head seja nullptr.
     */

    void clear() {
        while (head) remove_first();
    }

    /**
     * Método que imprime a lista. Percorre a lista e imprime cada elemento.
     */

    void print_list() {
        Node* temp = head;

        while (temp) {
            cout << temp->valor << " ";
            temp = temp->next;
        }

        cout << endl;

    }

    /**
     * Destrutor da classe LinkedList. Chama o método clear() para limpar a lista.
     */

    ~LinkedList() {
        clear();
    }
};