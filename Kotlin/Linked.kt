data class Node<T>(var value: T, var next: Node<T>? = null)

class LinkedList<T> {
    private var head: Node<T>? = null

    fun add(value: T) {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    fun remove() {
        if (head != null) {
            head = head?.next
        }
    }

    fun printList() {
        var current = head
        while (current != null) {
            print("${current.value} ")
            current = current.next
        }
        println("null")
    }
}