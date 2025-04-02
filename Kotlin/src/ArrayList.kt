class ArrayList {
    //*atributos */
    private val array = mutableListOf<Int>()

    //*criação da função add */
    fun add(num: Int) {
        array.add(num)
    }

    //*Criação da função getIndex */
    fun getIndex(ind: Int): Int {
        return array[ind]
    }

    //*Criação da função remove */
    fun remove(indR: Int) {
        array.removeAt(indR)
    }

    //*sobrescrição do toString */
    override fun toString(): String {
        return array.joinToString(" ")
    }
}