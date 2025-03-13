class Hash {
    private val hash: MutableMap<Int, Int>
    private var ind: Int

    init {
        this.hash = mutableMapOf()
        this.ind = 0
    }

    fun put(numero: Int) {
        this.hash[indice] = numero
        this.ind++
    }

    fun getKey(key: Int): Int? {
        return this.hash[key]
    }

    fun remove(ind: Int) {
        this.hash.remove(ind)
    }

    override fun toString(): String {
        return this.hash.values.joinToString(" ")
    }
}