# **_Parte Python_**
#### _@author Gabriel Figueiredo - gabriel.figueiredo.batista.magalhaes@ccc.ufcg.edu.br_

## _Introdutório_
* De forma geral, foi implementado apenas métodos básicos de adição, remoção e get, sendo este em suma maioria recebendo um index como argumento e apenas no caso do HashMap recebendo um valor representando uma chave.
* Apenas HashMap e ArrayList utilizam de estruturas já implementadas da própria linguagem.

# _ArrayList_
* Utilizando a estrutura pronta de List, implementei uma classe que simula um ArrayList, a partir disso, as adições e remoções da estrutura são feitas manipulando os índices de acesso direto a lista interna, sem a utilização de appends ou pops.
* Do ponto de vista de tempo de execução, temos que, por construção de código, as operações básicas se comportando das seguintes maneiras:
  1. Adição:
     - O(1) amortizado
       - Na grande maioria dos casos, se comporta como O(1), entretanto, pelo tamanho limitado do Array, após n adições, quando estiver prestes a preencher todos os espaços, acontece o resize que vai fazer o tempo daquela execução ser O(n).
       - Além disso, adicionar um elemento no início e no meio de um ArrayList trará a necessidade de um shift, que vai ser custoso a depender do tamanho do ArrayList e sendo O(n) em seu pior caso.
  2. Remoção:
     - O(1)
       - A remoção acontece sempre em tempo constante, visto que sua implementação consiste apenas em operações primitivas.
       - Assim como na adição, a remoção no início e no meio também vão trazer a necessidade de um shift, sendo O(n) no pior caso.
  3. Get:
     - O(1)
       - O get também é executado em tempo costante, visto que a lista interna possui seus índices de acesso direto, caracterizado também como uma operação primitiva.

# _LinkedList_
* Implementei uma LinkedList duplamente encadeada a partir da criação da classe do Nó e da classe da própria LinkedList.
* Do ponto de vista de tempo de execução, teremos os seguintes comportamentos:
  1. Adição:
     - O(1)
        - A operação de adição na LinkedList envolve apenas atribuições entre os nós, principalmente entre o que será adicionado e o último adicionado.
        - A adição no meio da LinkedList tem classe de complexidade O(n), visto que é necessário percorrer pelos elementos até chegar no meio.
  2. Remoção:
     - O(1)
        - A operação de remoção também envolve apenas atribuições entre os nós, dessa vez entre o último elemento, que é armazenado pela classe, e o seu antecessor na LinkedList.
        - A operação de remoção no meio, assim como na adição, também é O(n), visto que para chegar no elemento do meio, é preciso percorrer nos elementos.
  3. Get:
     - O(n)
        - A LinkedList não possui um índice de acesso direto, apenas o primeiro e o último elemento são armazenados diretamente dentro da classe e podem ser acessados em O(1), portanto, em outros casos é necessário uma iteração sobre os elementos até que se chegue na posição esperada.

# _HashMap_
* Implementei a classe HashMap redirecionando as operações básicas para as operações da classe Dictionary de python.
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

# _AVL Tree_
* A AVL foi implementada de forma padrão, com a classe do nó e a classe da própria AVL.
* Partindo para o tempo de execução:
  1. Adição
    - O(log n)
  2. Remoção:
    - O(log n)
  3. Get:
    - O(log n)
* Pelo fato de ser uma árvore que se mantém balanceada a cada operação que muda a disposição dos seus nós, as operações tem a garantia do O(log n).
