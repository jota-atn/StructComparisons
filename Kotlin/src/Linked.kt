data class Node<T>(var value: T, var next: Node<T>? = null)

class LinkedList<T> {
    private var head: Node<T>? = null

    //*Criação da função add */
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

    //*Criação da função remove */
    fun remove() {
        if (head != null) {
            head = head?.next
        }
    }

    //*criação da representação da linkedList em String */
    fun printList() {
        var current = head
        while (current != null) {
            print("${current.value} ")
            current = current.next
        }
        println("null")
    }
}