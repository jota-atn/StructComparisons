package arraylist

import "fmt"

// ArrayList implementa uma lista dinâmica usando array
type ArrayList struct {
	array []interface{}
	last  int
	size  int
}

// NovaLista cria uma nova lista com a capacidade inicial especificada
func NovaLista(size int) *ArrayList {
	return &ArrayList{
		array: make([]interface{}, size),
		last:  -1,
		size:  0,
	}
}

// Tamanho retorna o tamanho da lista
func (a *ArrayList) Tamanho() int {
	return a.size
}

// EstaVazia verifica se a lista está vazia
func (a *ArrayList) EstaVazia() bool {
	return a.size == 0
}

// Adicionar adiciona um elemento ao final da lista
func (a *ArrayList) Adicionar(value interface{}) {
	a.garantirCapacidade(a.size + 1)
	
	if a.EstaVazia() {
		a.last = 0
	} else {
		a.last++
	}
	
	a.array[a.last] = value
	a.size++
}

// Inserir adiciona um elemento na posição especificada
func (a *ArrayList) Inserir(index int, value interface{}) error {
	if index < 0 || index > a.size {
		return &IndexOutOfBoundsError{index}
	}
	
	a.garantirCapacidade(a.size + 1)
	
	// Se a inserção for no final, chama Adicionar
	if index == a.size {
		a.Adicionar(value)
		return nil
	}
	
	// Move elementos para abrir espaço
	for i := a.size; i > index; i-- {
		a.array[i] = a.array[i-1]
	}
	
	a.array[index] = value
	a.size++
	a.last++
	return nil
}

// InserirAll adiciona todos os elementos ao final da lista
func (a *ArrayList) InserirAll(elements []interface{}) {
	for _, elem := range elements {
		a.Adicionar(elem)
	}
}

// Remover remove e retorna o elemento na posição especificada
func (a *ArrayList) Remover(index int) (interface{}, error) {
	if a.EstaVazia() || index < 0 || index >= a.size {
		return nil, &IndexOutOfBoundsError{index}
	}
	
	removed := a.array[index]
	
	// Move elementos para preencher a lacuna
	for i := index; i < a.size-1; i++ {
		a.array[i] = a.array[i+1]
	}
	
	a.size--
	if a.size == 0 {
		a.last = -1
	} else if index == a.size { // Se removemos o último elemento
		a.last--
	}
	return removed, nil
}

// Elemento retorna o elemento no índice especificado
func (a *ArrayList) Elemento(index int) (interface{}, error) {
	if a.EstaVazia() || index < 0 || index >= a.size {
		return nil, &IndexOutOfBoundsError{index}
	}
	
	return a.array[index], nil
}

// redimensionar dobra o tamanho do array interno
func (a *ArrayList) redimensionar() {
	newArray := make([]interface{}, len(a.array)*2)
	copy(newArray, a.array)
	a.array = newArray
}

// garantirCapacidade garante que o array tenha pelo menos a capacidade especificada
func (a *ArrayList) garantirCapacidade(requiredCapacity int) {
	if requiredCapacity > len(a.array) {
		a.redimensionar()
	}
}

// IndexOutOfBoundsError representa um erro de índice fora dos limites
type IndexOutOfBoundsError struct {
	Index int
}

func (e *IndexOutOfBoundsError) Error() string {
	return fmt.Sprintf("índice fora dos limites: %d", e.Index)
}