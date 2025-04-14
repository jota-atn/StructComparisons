package estruturas

import java.util.LinkedList

class Linked {
    private val linked = LinkedList<Int>()

    fun add(index: Int, value: Int) {
        linked.add(index, value)
    }

    fun addFirst(value: Int) {
        linked.addFirst(value)
    }

    fun addLast(value: Int) {
        linked.addLast(value)
    }

    fun getIndex(index: Int): Int {
        return linked[index]
    }

    fun remove(index: Int) {
        linked.removeAt(index)
    }

    fun size(): Int {
        return linked.size
    }

    override fun toString(): String {
        return linked.joinToString(" ")
    }
}

