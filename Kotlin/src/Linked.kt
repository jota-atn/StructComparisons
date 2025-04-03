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
        linked.add(ind, num)
    }

    fun addLast(num: Int) {
        linked.addLast(num)
    }

    fun getIndex(ind: Int): Int {
        return linked[ind]
    }

    fun remove(meio: Int) {
        linked.removeAt(meio)
    }
}