package estruturas
class Hash {
    //*atributos */
    private val hash: MutableMap<Int, Int>
    private var ind: Int

    //*inicializador do codigo*/
    init {
        this.hash = mutableMapOf()
        this.ind = 0
    }

    //*criação da função put */
    fun put(numero: Int) {
        this.hash[ind] = numero
        this.ind++
    }

    //*criação da função getKey */
    fun getKey(key: Int): Int? {
        return this.hash[key]
    }

    //*criação do remove */
    fun remove(ind: Int) {
        this.hash.remove(ind)
    }

    //*verifica se um valor está contido no mapa */
    fun containsValue(valor: Int): Boolean {
        return this.hash.containsValue(valor)
    }

    //*sobrescrição do toString */
    override fun toString(): String {
        return this.hash.values.joinToString(" ")
    }
}
