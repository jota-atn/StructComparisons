package avltree

// No representa um nó na árvore AVL
type No struct {
	Valor      interface{}
	Altura     int
	Esquerda   *No
	Direita    *No
}

// AVLTree implementa uma árvore binária de busca autobalanceada
type AVLTree struct {
	raiz *No
	comparador func(a, b interface{}) int
	tamanho int
}

// NovaArvore cria uma nova árvore AVL com o comparador especificado
// O comparador deve retornar:
// - valor negativo se a < b
// - zero se a == b
// - valor positivo se a > b
func NovaArvore(comparador func(a, b interface{}) int) *AVLTree {
	return &AVLTree{
		raiz: nil,
		comparador: comparador,
		tamanho: 0,
	}
}

// NovaArvoreInt cria uma nova árvore AVL para números inteiros
func NovaArvoreInt() *AVLTree {
	return NovaArvore(func(a, b interface{}) int {
		return a.(int) - b.(int)
	})
}

// Tamanho retorna o número de nós na árvore
func (t *AVLTree) Tamanho() int {
	return t.tamanho
}

// EstaVazia verifica se a árvore está vazia
func (t *AVLTree) EstaVazia() bool {
	return t.tamanho == 0
}

// altura retorna a altura de um nó, ou -1 se nulo
func altura(no *No) int {
	if no == nil {
		return -1
	}
	return no.Altura
}

// atualizarAltura atualiza a altura de um nó com base em seus filhos
func (t *AVLTree) atualizarAltura(no *No) {
	if no == nil {
		return
	}
	alturaEsquerda := altura(no.Esquerda)
	alturaDireita := altura(no.Direita)
	if alturaEsquerda > alturaDireita {
		no.Altura = alturaEsquerda + 1
	} else {
		no.Altura = alturaDireita + 1
	}
}

// fatorBalanceamento retorna a diferença de altura entre subárvores (esquerda - direita)
func (t *AVLTree) fatorBalanceamento(no *No) int {
	if no == nil {
		return 0
	}
	return altura(no.Esquerda) - altura(no.Direita)
}

// rotacaoEsquerda realiza uma rotação à esquerda no nó dado
func (t *AVLTree) rotacaoEsquerda(no *No) *No {
	filhoDireita := no.Direita
	no.Direita = filhoDireita.Esquerda
	filhoDireita.Esquerda = no
	
	t.atualizarAltura(no)
	t.atualizarAltura(filhoDireita)
	
	return filhoDireita
}

// rotacaoDireita realiza uma rotação à direita no nó dado
func (t *AVLTree) rotacaoDireita(no *No) *No {
	filhoEsquerda := no.Esquerda
	no.Esquerda = filhoEsquerda.Direita
	filhoEsquerda.Direita = no
	
	t.atualizarAltura(no)
	t.atualizarAltura(filhoEsquerda)
	
	return filhoEsquerda
}

// balancear reequilibra a árvore se necessário
func (t *AVLTree) balancear(no *No) *No {
	if no == nil {
		return nil
	}
	
	t.atualizarAltura(no)
	balanco := t.fatorBalanceamento(no)
	
	// Caso de desbalanceamento à esquerda (balanceamento > 1)
	if balanco > 1 {
		// Verificar se é rotação simples ou dupla
		if t.fatorBalanceamento(no.Esquerda) < 0 {
			// Rotação dupla: esquerda-direita
			no.Esquerda = t.rotacaoEsquerda(no.Esquerda)
		}
		// Rotação direita
		return t.rotacaoDireita(no)
	}
	
	// Caso de desbalanceamento à direita (balanceamento < -1)
	if balanco < -1 {
		// Verificar se é rotação simples ou dupla
		if t.fatorBalanceamento(no.Direita) > 0 {
			// Rotação dupla: direita-esquerda
			no.Direita = t.rotacaoDireita(no.Direita)
		}
		// Rotação esquerda
		return t.rotacaoEsquerda(no)
	}
	
	return no
}

// Adicionar insere um novo valor na árvore
func (t *AVLTree) Adicionar(valor interface{}) {
	t.raiz = t.adicionarRecursivo(t.raiz, valor)
	t.tamanho++
}

// adicionarRecursivo insere recursivamente um valor na árvore
func (t *AVLTree) adicionarRecursivo(no *No, valor interface{}) *No {
	if no == nil {
		return &No{
			Valor:  valor,
			Altura: 0,
		}
	}
	
	comp := t.comparador(valor, no.Valor)
	
	if comp < 0 {
		no.Esquerda = t.adicionarRecursivo(no.Esquerda, valor)
	} else {
		no.Direita = t.adicionarRecursivo(no.Direita, valor)
	}
	
	return t.balancear(no)
}

// Buscar verifica se um valor existe na árvore
func (t *AVLTree) Buscar(valor interface{}) bool {
	return t.buscarRecursivo(t.raiz, valor)
}

// buscarRecursivo busca recursivamente um valor na árvore
func (t *AVLTree) buscarRecursivo(no *No, valor interface{}) bool {
	if no == nil {
		return false
	}
	
	comp := t.comparador(valor, no.Valor)
	
	if comp == 0 {
		return true
	} else if comp < 0 {
		return t.buscarRecursivo(no.Esquerda, valor)
	} else {
		return t.buscarRecursivo(no.Direita, valor)
	}
}

// encontrarMenorValor encontra o nó com o menor valor na subárvore
func (t *AVLTree) encontrarMenorValor(no *No) *No {
	atual := no
	for atual != nil && atual.Esquerda != nil {
		atual = atual.Esquerda
	}
	return atual
}

// encontrarMaiorValor encontra o nó com o maior valor na subárvore
func (t *AVLTree) encontrarMaiorValor(no *No) *No {
	atual := no
	for atual != nil && atual.Direita != nil {
		atual = atual.Direita
	}
	return atual
}

// Min retorna o menor valor da árvore
func (t *AVLTree) Min() (interface{}, bool) {
	if t.EstaVazia() {
		return nil, false
	}
	return t.encontrarMenorValor(t.raiz).Valor, true
}

// Max retorna o maior valor da árvore
func (t *AVLTree) Max() (interface{}, bool) {
	if t.EstaVazia() {
		return nil, false
	}
	return t.encontrarMaiorValor(t.raiz).Valor, true
}

// Sucessor encontra o próximo valor maior que o valor fornecido
func (t *AVLTree) Sucessor(valor interface{}) (interface{}, bool) {
	if t.EstaVazia() {
		return nil, false
	}
	
	sucessor, encontrado := t.encontrarSucessor(t.raiz, valor, nil)
	if !encontrado {
		return nil, false
	}
	return sucessor.Valor, true
}

// encontrarSucessor busca recursivamente o sucessor de um valor
func (t *AVLTree) encontrarSucessor(no *No, valor interface{}, potencialSucessor *No) (*No, bool) {
	if no == nil {
		return potencialSucessor, potencialSucessor != nil
	}
	
	comp := t.comparador(valor, no.Valor)
	
	if comp < 0 {
		// Se o valor atual é maior que o valor buscado, pode ser um sucessor
		return t.encontrarSucessor(no.Esquerda, valor, no)
	} else if comp >= 0 {
		// Se o valor atual é menor ou igual, o sucessor está à direita
		return t.encontrarSucessor(no.Direita, valor, potencialSucessor)
	}
	
	return potencialSucessor, potencialSucessor != nil
}

// Predecessor encontra o maior valor menor que o valor fornecido
func (t *AVLTree) Predecessor(valor interface{}) (interface{}, bool) {
	if t.EstaVazia() {
		return nil, false
	}
	
	predecessor, encontrado := t.encontrarPredecessor(t.raiz, valor, nil)
	if !encontrado {
		return nil, false
	}
	return predecessor.Valor, true
}

// encontrarPredecessor busca recursivamente o predecessor de um valor
func (t *AVLTree) encontrarPredecessor(no *No, valor interface{}, potencialPredecessor *No) (*No, bool) {
	if no == nil {
		return potencialPredecessor, potencialPredecessor != nil
	}
	
	comp := t.comparador(valor, no.Valor)
	
	if comp > 0 {
		// Se o valor atual é menor que o valor buscado, pode ser um predecessor
		return t.encontrarPredecessor(no.Direita, valor, no)
	} else if comp <= 0 {
		// Se o valor atual é maior ou igual, o predecessor está à esquerda
		return t.encontrarPredecessor(no.Esquerda, valor, potencialPredecessor)
	}
	
	return potencialPredecessor, potencialPredecessor != nil
}

// Remover remove um valor da árvore, se existir
func (t *AVLTree) Remover(valor interface{}) bool {
	if t.EstaVazia() {
		return false
	}
	
	// Verificar primeiro se o valor existe
	if !t.Buscar(valor) {
		return false
	}
	
	t.raiz = t.removerRecursivo(t.raiz, valor)
	t.tamanho--
	return true
}

// removerRecursivo remove recursivamente um valor da árvore
func (t *AVLTree) removerRecursivo(no *No, valor interface{}) *No {
	if no == nil {
		return nil
	}
	
	comp := t.comparador(valor, no.Valor)
	
	if comp < 0 {
		no.Esquerda = t.removerRecursivo(no.Esquerda, valor)
	} else if comp > 0 {
		no.Direita = t.removerRecursivo(no.Direita, valor)
	} else {
		// Encontramos o nó a ser removido
		
		// Caso 1: nó folha ou com apenas um filho
		if no.Esquerda == nil {
			return no.Direita
		} else if no.Direita == nil {
			return no.Esquerda
		}
		
		// Caso 2: nó com dois filhos
		// Encontrar o sucessor (menor valor na subárvore direita)
		sucessor := t.encontrarMenorValor(no.Direita)
		no.Valor = sucessor.Valor
		
		// Remover o sucessor
		no.Direita = t.removerRecursivo(no.Direita, sucessor.Valor)
	}
	
	return t.balancear(no)
}

// EmOrdem percorre a árvore em ordem (esquerda, raiz, direita)
func (t *AVLTree) EmOrdem() []interface{} {
	resultado := make([]interface{}, 0, t.tamanho)
	t.emOrdemRecursivo(t.raiz, &resultado)
	return resultado
}

func (t *AVLTree) emOrdemRecursivo(no *No, resultado *[]interface{}) {
	if no != nil {
		t.emOrdemRecursivo(no.Esquerda, resultado)
		*resultado = append(*resultado, no.Valor)
		t.emOrdemRecursivo(no.Direita, resultado)
	}
}

// PreOrdem percorre a árvore em pré-ordem (raiz, esquerda, direita)
func (t *AVLTree) PreOrdem() []interface{} {
	resultado := make([]interface{}, 0, t.tamanho)
	t.preOrdemRecursivo(t.raiz, &resultado)
	return resultado
}

func (t *AVLTree) preOrdemRecursivo(no *No, resultado *[]interface{}) {
	if no != nil {
		*resultado = append(*resultado, no.Valor)
		t.preOrdemRecursivo(no.Esquerda, resultado)
		t.preOrdemRecursivo(no.Direita, resultado)
	}
}

// PosOrdem percorre a árvore em pós-ordem (esquerda, direita, raiz)
func (t *AVLTree) PosOrdem() []interface{} {
	resultado := make([]interface{}, 0, t.tamanho)
	t.posOrdemRecursivo(t.raiz, &resultado)
	return resultado
}

func (t *AVLTree) posOrdemRecursivo(no *No, resultado *[]interface{}) {
	if no != nil {
		t.posOrdemRecursivo(no.Esquerda, resultado)
		t.posOrdemRecursivo(no.Direita, resultado)
		*resultado = append(*resultado, no.Valor)
	}
}

// Limpar remove todos os elementos da árvore
func (t *AVLTree) Limpar() {
	t.raiz = nil
	t.tamanho = 0
}