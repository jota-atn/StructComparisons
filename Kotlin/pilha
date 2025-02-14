class Stack<T> {
    private val elements = mutableListOf<T>()

    fun push(item: T) {
        elements.add(item)
    }

    fun pop(): T? {
        if (isEmpty()) {
            println("A pilha está vazia!")
            return null
        }
        return elements.removeAt(elements.size - 1)
    }

    fun peek(): T? {
        return elements.lastOrNull()
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    fun size(): Int {
        return elements.size
    }
}

fun main() {
    val stack = Stack<Int>()
    
    stack.push(10)
    stack.push(20)
    stack.push(30)
    
    println("Topo da pilha: ${stack.peek()}")
    println("Removendo: ${stack.pop()}")
    println("Tamanho da pilha: ${stack.size()}")
    println("A pilha está vazia? ${stack.isEmpty()}")
}

