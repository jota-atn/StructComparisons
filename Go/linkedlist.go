package linkedlist

import "fmt"

// NodeLinkedList representa um nó para uma lista duplamente encadeada
type NodeLinkedList struct {
	Value interface{}
	Next  *NodeLinkedList
	Prev  *NodeLinkedList
}

// NovoNoLinkedList cria um novo nó para lista encadeada
func NovoNoLinkedList(value interface{}) *NodeLinkedList {
	return &NodeLinkedList{
		Value: value,
		Next:  nil,
		Prev:  nil,
	}
}

// LinkedList implementa uma lista duplamente encadeada
type LinkedList struct {
	first *NodeLinkedList
	last  *NodeLinkedList
	size  int
}

// NovaLista cria uma nova lista encadeada vazia
func NovaLista(capacidade int) *LinkedList {
	return &LinkedList{
		first: nil,
		last:  nil,
		size:  0,
	}
}

// Tamanho retorna o tamanho da lista
func (l *LinkedList) Tamanho() int {
	return l.size
}

// EstaVazia verifica se a lista está vazia
func (l *LinkedList) EstaVazia() bool {
	return l.first == nil
}

// Adicionar adiciona um elemento ao final da lista
func (l *LinkedList) Adicionar(value interface{}) {
	node := NovoNoLinkedList(value)
	
	if l.EstaVazia() {
		l.first = node
		l.last = node
	} else {
		l.last.Next = node
		node.Prev = l.last
		l.last = node
	}
	
	l.size++
}

// Elemento retorna o elemento no índice especificado
func (l *LinkedList) Elemento(index int) (interface{}, error) {
	if l.EstaVazia() || index < 0 || index >= l.size {
		return nil, &IndexOutOfBoundsError{index}
	}
	
	aux := l.first
	for i := 0; i < index; i++ {
		aux = aux.Next
	}
	
	return aux.Value, nil
}

// Inserir adiciona um elemento na posição especificada
func (l *LinkedList) Inserir(index int, value interface{}) error {
	if index < 0 || index > l.size {
		return &IndexOutOfBoundsError{index}
	}

	// Caso especial: inserir no início
	if index == 0 {
		node := NovoNoLinkedList(value)
		if l.EstaVazia() {
			l.first = node
			l.last = node
		} else {
			node.Next = l.first
			l.first.Prev = node
			l.first = node
		}
		l.size++
		return nil
	}
	
	// Caso especial: inserir no final
	if index == l.size {
		l.Adicionar(value)
		return nil
	}
	
	// Inserir no meio
	// Encontrar o nó na posição desejada
	current := l.first
	for i := 0; i < index; i++ {
		current = current.Next
	}
	
	// Criar um novo nó e inseri-lo antes de current
	node := NovoNoLinkedList(value)
	node.Prev = current.Prev
	node.Next = current
	current.Prev.Next = node
	current.Prev = node
	
	l.size++
	return nil
}

// InserirAll adiciona todos os elementos ao final da lista
func (l *LinkedList) InserirAll(elements []interface{}) {
	for _, elem := range elements {
		l.Adicionar(elem)
	}
}

// Remover remove e retorna o elemento na posição especificada
func (l *LinkedList) Remover(index int) (interface{}, error) {
	if l.EstaVazia() || index < 0 || index >= l.size {
		return nil, &IndexOutOfBoundsError{index}
	}
	
	var removedNode *NodeLinkedList
	
	// Caso 1: Remover o primeiro elemento
	if index == 0 {
		removedNode = l.first
		if l.size == 1 {
			l.first = nil
			l.last = nil
		} else {
			l.first = l.first.Next
			l.first.Prev = nil
		}
	} else if index == l.size-1 { // Caso 2: Remover o último elemento
		removedNode = l.last
		l.last = l.last.Prev
		l.last.Next = nil
	} else { // Caso 3: Remover um elemento do meio
		// Navegar até o nó desejado
		current := l.first
		for i := 0; i < index; i++ {
			current = current.Next
		}
		
		// Atualizar as referências
		removedNode = current
		current.Prev.Next = current.Next
		current.Next.Prev = current.Prev
	}
	
	l.size--
	return removedNode.Value, nil
}

// IndexOutOfBoundsError representa um erro de índice fora dos limites
type IndexOutOfBoundsError struct {
	Index int
}

func (e *IndexOutOfBoundsError) Error() string {
	return fmt.Sprintf("índice fora dos limites: %d", e.Index)
}

// garantirCapacidade é um método vazio apenas para compatibilidade com a interface
func (l *LinkedList) garantirCapacidade(requiredCapacity int) {
	// Não faz nada, pois listas encadeadas não têm capacidade fixa
}