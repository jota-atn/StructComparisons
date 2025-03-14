# **_Parte Go_**
#### _@autor Ícaro Gabriel - icaro.gabriel.saldanha.queiroz@ccc.ufcg.edu.br_

## _Introdutório_
* Foram implementados métodos básicos de adição, remoção e obtenção de elementos para várias estruturas de dados utilizando a linguagem Go.
* Cada estrutura de dados foi implementada do zero, sem a utilização de bibliotecas prontas da linguagem Go.

# _ArrayList_
* Utilizando uma slice interna, foi implementada uma classe que simula um ArrayList. As adições e remoções são feitas manipulando os índices de acesso direto da slice.
* Do ponto de vista de tempo de execução, as operações básicas se comportam da seguinte maneira:
  1. **Adição**:
     - O(1) amortizado
       - Na maioria dos casos, se comporta como O(1). No entanto, pelo tamanho limitado da slice, após n adições, quando estiver prestes a preencher todos os espaços, acontece o resize que aumenta a capacidade da slice.
  2. **Remoção**:
     - O(1)
       - A remoção acontece sempre em tempo constante, visto que sua implementação consiste apenas em operações primitivas.
  3. **Get**:
     - O(1)
       - O get é executado em tempo constante, visto que a slice interna possui seus índices de acesso direto, caracterizado também como uma operação primitiva.

# _LinkedList_
* Foi implementada uma LinkedList duplamente encadeada a partir da criação da classe do Nó e da própria LinkedList.
* Do ponto de vista de tempo de execução, temos os seguintes comportamentos:
  1. **Adição**:
     - O(1)
        - A operação de adição na LinkedList envolve apenas atribuições entre os nós, principalmente entre o que será adicionado e o último adicionado.
  2. **Remoção**:
     - O(1)
        - A operação de remoção também envolve apenas atribuições entre os nós, desta vez entre o último elemento, que é armazenado pela classe, e o seu antecessor na LinkedList.
  3. **Get**:
     - O(n)
        - A LinkedList não possui um índice de acesso direto. Apenas o primeiro e o último elemento são armazenados diretamente dentro da classe e podem ser acessados em O(1). Portanto, para outros casos, é necessário percorrer a lista até o índice desejado.

# _HashMap_
* Foi implementada a classe HashMap utilizando um mapa nativo da linguagem Go.
* Analisando a complexidade do tempo de execução:
  1. **Adição**:
    - O(1)
    - No pior caso O(n): Quando ocorre o resize da tabela hash.
  2. **Remoção**:
    - O(1)
    - No pior caso O(n): Quando há muitas colisões.
  3. **Get**:
    - O(1)
    - No pior caso O(n): Quando há muitas colisões.

# _Stack_
* Foi implementada a classe Stack utilizando uma slice interna para armazenar os elementos.
* Analisando a complexidade do tempo de execução:
  1. **Adição (Push)**:
    - O(1) amortizado
      - A adição é feita ao final da slice e, em caso de falta de espaço, a slice é redimensionada.
  2. **Remoção (Pop)**:
    - O(1)
      - A remoção é feita a partir do topo da pilha, que é o último elemento da slice.
  3. **Get (Peek)**:
    - O(1)
      - A operação de Peek retorna o elemento do topo da pilha sem removê-lo, que é o último elemento da slice.

# _Queue_
* Foi implementada a classe Queue utilizando uma slice interna para armazenar os elementos.
* Analisando a complexidade do tempo de execução:
  1. **Adição (Enqueue)**:
    - O(1)
      - A adição é feita ao final da slice.
  2. **Remoção (Dequeue)**:
    - O(n)
      - A remoção é feita a partir do início da slice, necessitando o deslocamento de todos os elementos subsequentes.
  3. **Get (Peek)**:
    - O(1)
      - A operação de Peek retorna o elemento do início da fila sem removê-lo, que é o primeiro elemento da slice.

# _Binary Search Tree (BST)_
* Foi implementada a classe BST (Binary Search Tree) para armazenar elementos de forma hierárquica.
* Do ponto de vista de tempo de execução, temos os seguintes comportamentos:
  1. **Adição**:
     - O(log n) em média
       - A operação de adição envolve a inserção do elemento na posição correta da árvore, o que em média exige tempo logarítmico.
  2. **Remoção**:
     - O(log n) em média
       - A operação de remoção pode variar dependendo do nó a ser removido (folha, nó com um filho ou nó com dois filhos), mas em média exige tempo logarítmico.
  3. **Get**:
     - O(log n) em média
       - A operação de busca (get) envolve percorrer a árvore para encontrar o elemento desejado, o que em média exige tempo logarítmico.