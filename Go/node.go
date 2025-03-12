package main

// Node representa um nó para estruturas de dados encadeadas
type Node struct {
	Data interface{}
	Next *Node
}

// NewNode cria um novo nó com o dado fornecido
func NewNode(data interface{}) *Node {
	return &Node{
		Data: data,
		Next: nil,
	}
}