package main

// ArrayList implementa uma lista dinâmica usando array
type ArrayList struct {
	array []interface{}
	last  int
	size  int
}

// NewArrayList cria uma nova lista com a capacidade inicial especificada
func NewArrayList(size int) *ArrayList {
	return &ArrayList{
		array: make([]interface{}, size),
		last:  -1,
		size:  0,
	}
}

// Len retorna o tamanho da lista
func (a *ArrayList) Len() int {
	return a.size
}

// IsEmpty verifica se a lista está vazia
func (a *ArrayList) IsEmpty() bool {
	return a.size == 0
}

// Add adiciona um elemento ao final da lista
func (a *ArrayList) Add(value interface{}) {
	a.EnsureCapacity(len(a.array) + 1)
	
	if a.IsEmpty() {
		a.last = 0
	} else {
		a.last++
	}
	
	a.array[a.last] = value
	a.size++
}

// Remove remove e retorna o último elemento da lista
func (a *ArrayList) Remove() interface{} {
	if a.IsEmpty() {
		return nil
	}
	
	removed := a.array[a.last]
	
	if a.size == 1 {
		a.last = -1
	} else {
		a.last--
	}
	
	a.size--
	return removed
}

// Get retorna o elemento no índice especificado
func (a *ArrayList) Get(index int) interface{} {
	if a.IsEmpty() || index < 0 || index >= a.size {
		return "Index out of bounds"
	}
	
	return a.array[index]
}

// Resize dobra o tamanho do array interno
func (a *ArrayList) Resize() {
	newArray := make([]interface{}, len(a.array)*2)
	copy(newArray, a.array)
	a.array = newArray
}

// EnsureCapacity garante que o array tenha pelo menos a capacidade especificada
func (a *ArrayList) EnsureCapacity(requiredCapacity int) {
	if requiredCapacity > len(a.array) {
		a.Resize()
	}
}