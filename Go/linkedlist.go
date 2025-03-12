package main

// NodeLinkedList representa um nó para uma lista duplamente encadeada
type NodeLinkedList struct {
	Value interface{}
	Next  *NodeLinkedList
	Prev  *NodeLinkedList
}

// NewNodeLinkedList cria um novo nó para lista encadeada
func NewNodeLinkedList(value interface{}) *NodeLinkedList {
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

// NewLinkedList cria uma nova lista encadeada vazia
func NewLinkedList() *LinkedList {
	return &LinkedList{
		first: nil,
		last:  nil,
		size:  0,
	}
}

// Len retorna o tamanho da lista
func (l *LinkedList) Len() int {
	return l.size
}

// IsEmpty verifica se a lista está vazia
func (l *LinkedList) IsEmpty() bool {
	return l.first == nil
}

// Add adiciona um elemento ao final da lista
func (l *LinkedList) Add(value interface{}) {
	node := NewNodeLinkedList(value)
	
	if l.IsEmpty() {
		l.first = node
		l.last = node
	} else {
		l.last.Next = node
		node.Prev = l.last
		l.last = node
	}
	
	l.size++
}

// Remove remove e retorna o último elemento da lista
func (l *LinkedList) Remove() interface{} {
	if l.IsEmpty() {
		return nil
	}
	
	removed := l.last
	
	if l.size == 1 {
		l.first = nil
		l.last = nil
	} else {
		l.last.Prev.Next = nil
		l.last = l.last.Prev
	}
	
	l.size--
	return removed.Value
}

// Get retorna o elemento no índice especificado
func (l *LinkedList) Get(index int) interface{} {
	if l.IsEmpty() || index < 0 || index >= l.size {
		return "Index out of bounds"
	}
	
	aux := l.first
	for i := 0; i < index; i++ {
		aux = aux.Next
	}
	
	return aux.Value
}