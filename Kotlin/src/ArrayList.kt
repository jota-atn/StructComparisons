package estruturas

class ArrayList(tamanho: Int) {
    private val array = kotlin.collections.ArrayList<Int>(tamanho)

    fun add(ind: Int, numero: Int) {
        array.add(ind, numero)
    }

    fun addFirst(numero: Int) {
        array.add(0, numero)
    }

    fun addMeio(index: Int, numero: Int) {
        array.add(index, numero)
    }

    fun addLast(numero: Int) {
        array.add(array.size, numero)
    }

    fun getIndex(index: Int): Int {
        return array[index]
    }

    fun remove(index: Int) {
        array.removeAt(index)
    }

    override fun toString(): String {
        return array.joinToString(" ")
    }

    fun size(): Int {
        return array.size
    }
}