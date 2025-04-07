package estruturas

import java.util.LinkedList

class Linked {
    private val linked: LinkedList<Int> = LinkedList()

    fun add(num: Int) {
        linked.add(num)
    }

    fun addFirst(num: Int) {
        linked.addFirst(num)
    }

    fun addMeio(ind: Int, num: Int) {
        if (ind in 0..linked.size) {
            linked.add(ind, num)
        }
    }

    fun addLast(num: Int) {
        linked.addLast(num)
    }

    fun getIndex(ind: Int): Int? {
        return if (ind in 0 until linked.size) linked[ind] else null
    }

    fun remove(ind: Int) {
        if (ind in 0 until linked.size) {
            linked.removeAt(ind)
        }
    }

    fun size(): Int {
        return linked.size
    }

    override fun toString(): String {
        return linked.joinToString(" ")
    }
}
