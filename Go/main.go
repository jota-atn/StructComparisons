package main

import "fmt"

func main() {
	stack := NewStack()
	queue := NewQueue()
	
	stack.Push(5)
	fmt.Println(stack.Peek())
	fmt.Println(stack)
	stack.Pop()
	fmt.Println(stack.Peek())
	fmt.Println(stack)
	
	fmt.Println("---\n---\n---")
	
	queue.Push(4)
	fmt.Println(queue.Peek())
	fmt.Println(queue)
	queue.Pop()
	fmt.Println(queue.Peek())
	fmt.Println(queue)
}