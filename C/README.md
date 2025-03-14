# **_Parte C++_**
#### _@author João Antonio de Melo Queiroz - joao.antonio.melo.queiroz@ccc.ufcg.edu.br_

## _Introdutório_
* Foi implementado diversos métodos relacionados a busca, inserção e remoção. Para as Estruturas de Dados, utilizei coleções disponíveis no stdlib do C++ e implementei apenas unindo tudo em uma classe relacionada à estrutura. Para todas elas, são necessários os arquivos de cabeçalhos correspondentes.

# _ArrayList_
* Como em C++ temos o vector, há apenas a necessidade de criar uma classe ArrayList para unificar as adições, acessos e remoções da estruturas, que são todas feitas manipulando os índices de acesso direto ao valor interno, sempre utilizando os métodos prontos da STL (caso seja possível):
  1. Adição:
     - O(1) amortizado
       - Em geral a operação de inserção no final do vetor ocorre em O(1), mas quando for haver um resize, sua classe de complexidade sobe para O(n).
  2. Remoção:
     - O(n)
       - A remoção em uma posição arbitrária do vetor exige o deslocamento dos elementos subsequentes, tornando o pior caso O(n).
  3. Get:
     - O(1)
       - O acesso a um elemento específico é feito diretamente pelo índice, caracterizando uma operação O(1).

  4. Verificação de existência (contains):
     - O(n)
        - Como o vector não possui busca otimizada para elementos arbitrários, a verificação percorre a estrutura, resultando em O(n).

  5. Esvaziamento (clear):
     - O(1)
        - A operação de limpeza é otimizada pela STL, esvaziando rapidamente a estrutura sem percorrer seus elementos individualmente.

# _LinkedList_
* Utilizando a estrutura pronta de list, implementei uma classe que simula uma LinkedList. As adições e remoções da estrutura são feitas manipulando os ponteiros internos da lista duplamente encadeada da STL.
* Do ponto de vista de tempo de execução, teremos os seguintes comportamentos:
  1. Adição:
     - O(1)
        - Tanto a inserção no início (push_front) quanto no final (push_back) ocorrem em tempo constante, pois a estrutura da list permite manipulação eficiente dos ponteiros.
  2. Remoção:
     - O(1)
        - Remover o primeiro (pop_front) ou o último elemento (pop_back) também ocorre em tempo constante, pois não há necessidade de realocar elementos.
  3. Get:
     - O(n)
        - A busca por um elemento percorre a lista linearmente, resultando em O(n) no pior caso.

# _HashMap_
* Utilizando a estrutura pronta de unordered_map, implementei uma classe que simula um HashMap. As operações são realizadas diretamente na estrutura de tabela hash da STL, garantindo eficiência nas operações básicas.
* Analisando a complexidade do tempo de execução:
  1. Adição:
    - O(1)
    - No pior caso O(n): Quando se tem resize da tabela hash.
  2. Remoção:
    - O(1)
    - No pior caso O(n): Quando se tem muitas colisões.
  3. Get:
    - O(1)
    - No pior caso O(n): Quando se tem muitas colisões.

# _Binary Search Tree_
* Implementei a BST a partir da criação das classes do Nó e da própria BST.
* Partindo para o tempo de execução:
  1. Adição
    - O(log n)
    - O(n) pior caso
  2. Remoção:
    - Clear O(n)
  3. Get:
    - O(log n)
    - O(n) no pior caso
