package main

import (
	"errors"
	"fmt"
)

type Stack struct {
	elements []int
}

// NewStack cria uma nova pilha
func NewStack() *Stack {
	return &Stack{
		elements: make([]int, 0),
	}
}

// Push adiciona um elemento ao topo da pilha
func (s *Stack) Push(element int) {
	s.elements = append(s.elements, element)
}

// Pop remove e retorna o elemento do topo da pilha
func (s *Stack) Pop() (int, error) {
	if s.IsEmpty() {
		return 0, errors.New("stack is empty")
	}
	lastIndex := len(s.elements) - 1
	element := s.elements[lastIndex]
	s.elements = s.elements[:lastIndex]
	return element, nil
}

// Peek retorna o elemento do topo sem removê-lo
func (s *Stack) Peek() (int, error) {
	if s.IsEmpty() {
		return 0, errors.New("stack is empty")
	}
	return s.elements[len(s.elements)-1], nil
}

// IsEmpty verifica se a pilha está vazia
func (s *Stack) IsEmpty() bool {
	return len(s.elements) == 0
}

// String retorna a representação em string da pilha
func (s *Stack) String() string {
	return fmt.Sprintf("%v", s.elements)
}

func main() {
	stack := NewStack()

	// Adicionando elementos à pilha
	stack.Push(10)
	stack.Push(20)
	stack.Push(30)

	fmt.Println("Stack after pushes:", stack.String())

	// Verificando o topo da pilha
	topElement, err := stack.Peek()
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("Top element:", topElement)
	}

	// Removendo elementos da pilha
	poppedElement, err := stack.Pop()
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("Popped element:", poppedElement)
	}

	fmt.Println("Stack after pop:", stack.String())

	// Verificando se a pilha está vazia
	fmt.Println("Is stack empty?", stack.IsEmpty())
}
