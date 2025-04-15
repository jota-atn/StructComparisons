package main

import (
	"errors"
	"fmt"
)

type Queue struct {
	elements []int
}

// NewQueue cria uma nova fila
func NewQueue() *Queue {
	return &Queue{
		elements: make([]int, 0),
	}
}

// Enqueue adiciona um elemento ao final da fila
func (q *Queue) Enqueue(element int) {
	q.elements = append(q.elements, element)
}

// Dequeue remove e retorna o elemento da frente da fila
func (q *Queue) Dequeue() (int, error) {
	if q.IsEmpty() {
		return 0, errors.New("queue is empty")
	}
	element := q.elements[0]
	q.elements = q.elements[1:]
	return element, nil
}

// Peek retorna o elemento da frente sem removê-lo
func (q *Queue) Peek() (int, error) {
	if q.IsEmpty() {
		return 0, errors.New("queue is empty")
	}
	return q.elements[0], nil
}

// IsEmpty verifica se a fila está vazia
func (q *Queue) IsEmpty() bool {
	return len(q.elements) == 0
}

// String retorna a representação em string da fila
func (q *Queue) String() string {
	return fmt.Sprintf("%v", q.elements)
}

func main() {
	queue := NewQueue()

	// Adicionando elementos à fila
	queue.Enqueue(10)
	queue.Enqueue(20)
	queue.Enqueue(30)

	fmt.Println("Queue after enqueues:", queue.String())

	// Verificando o elemento da frente
	frontElement, err := queue.Peek()
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("Front element:", frontElement)
	}

	// Removendo elementos da fila
	dequeuedElement, err := queue.Dequeue()
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("Dequeued element:", dequeuedElement)
	}

	fmt.Println("Queue after dequeue:", queue.String())

	// Verificando se a fila está vazia
	fmt.Println("Is queue empty?", queue.IsEmpty())
}
