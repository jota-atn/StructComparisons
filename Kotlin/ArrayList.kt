class ArrayList {
    private val array = mutableListOf<Int>()

    fun add(num: Int) {
        array.add(num)
    }

    fun getIndex(ind: Int): Int {
        return array[ind]
    }

    fun remove(indR: Int) {
        array.removeAt(indR)
    }

    override fun toString(): String {
        return array.joinToString(" ")
    }
}