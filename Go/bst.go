package main

// NodeBST representa um nó em uma árvore binária de busca
type NodeBST struct {
	Value int
	Left  *NodeBST
	Right *NodeBST
	Parent *NodeBST
}

// NewNodeBST cria um novo nó de árvore binária de busca
func NewNodeBST(value int) *NodeBST {
	return &NodeBST{
		Value: value,
		Left:  nil,
		Right: nil,
		Parent: nil,
	}
}

// BST representa uma árvore binária de busca
type BST struct {
	root *NodeBST
	size int
}

// NewBST cria uma nova árvore binária de busca
func NewBST() *BST {
	return &BST{
		root: nil,
		size: 0,
	}
}

// Len retorna o tamanho da árvore
func (bst *BST) Len() int {
	return bst.size
}

// IsEmpty verifica se a árvore está vazia
func (bst *BST) IsEmpty() bool {
	return bst.root == nil
}

// Add adiciona um valor à árvore
func (bst *BST) Add(value int) {
	node := NewNodeBST(value)
	if bst.IsEmpty() {
		bst.root = node
	} else {
		bst.recAdd(bst.root, node)
	}
	bst.size++
}

// recAdd é uma função recursiva que adiciona um nó à árvore
func (bst *BST) recAdd(current, addNode *NodeBST) {
	if addNode.Value < current.Value {
		if current.Left == nil {
			current.Left = addNode
			addNode.Parent = current
		} else {
			bst.recAdd(current.Left, addNode)
		}
	} else {
		if current.Right == nil {
			current.Right = addNode
			addNode.Parent = current
		} else {
			bst.recAdd(current.Right, addNode)
		}
	}
}

// Get retorna o nó com o valor especificado
func (bst *BST) Get(value int) *NodeBST {
	return bst.recGet(bst.root, value)
}

// recGet é uma função recursiva que busca um valor na árvore
func (bst *BST) recGet(current *NodeBST, value int) *NodeBST {
	if current == nil || current.Value == value {
		return current
	}
	if value < current.Value {
		return bst.recGet(current.Left, value)
	}
	return bst.recGet(current.Right, value)
}

// Remove remove o nó com o valor especificado
func (bst *BST) Remove(value int) bool {
	node := bst.Get(value)
	if node == nil {
		return false
	}
	bst.removeNode(node)
	bst.size--
	return true
}

// removeNode remove um nó da árvore
func (bst *BST) removeNode(node *NodeBST) {
	if node.Left == nil && node.Right == nil { // Nó folha
		if node == bst.root {
			bst.root = nil
		} else if node.Parent.Left == node {
			node.Parent.Left = nil
		} else {
			node.Parent.Right = nil
		}
	} else if node.Left == nil { // Nó com apenas subárvore direita
		if node == bst.root {
			bst.root = node.Right
		} else if node.Parent.Left == node {
			node.Parent.Left = node.Right
		} else {
			node.Parent.Right = node.Right
		}
		node.Right.Parent = node.Parent
	} else if node.Right == nil { // Nó com apenas subárvore esquerda
		if node == bst.root {
			bst.root = node.Left
		} else if node.Parent.Left == node {
			node.Parent.Left = node.Left
		} else {
			node.Parent.Right = node.Left
		}
		node.Left.Parent = node.Parent
	} else { // Nó com duas subárvores
		successor := bst.minValueNode(node.Right)
		node.Value = successor.Value
		bst.removeNode(successor)
	}
}

// minValueNode encontra o nó com o menor valor na subárvore
func (bst *BST) minValueNode(node *NodeBST) *NodeBST {
	current := node
	for current.Left != nil {
		current = current.Left
	}
	return current
}