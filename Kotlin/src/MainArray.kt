import kotlin.system.measureNanoTime

fun main() {
    val cargas = listOf(
        1_000, 10_000, 100_000, 250_000, 500_000, 600_000, 750_000, 1_000_000,
        1_700_000, 2_500_000, 3_700_000, 5_000_000, 6_000_000, 7_500_000, 9_000_000, 10_000_000
    )

    println("Escolha a carga:")
    cargas.forEachIndexed { i, c -> println("${i + 1} - $c") }
    val cargaIndex = readln().toIntOrNull()?.minus(1) ?: return println("Índice inválido.")
    val carga = cargas[cargaIndex]

    println("Escolha a operação:")
    println("1 - add unico")
    println("2 - add n valor")
    println("3 - acessar elemento")
    println("4 - remover unico")
    println("5 - remover n valor")
    println("6 - add all")
    val comando = readln().toIntOrNull() ?: return println("Comando inválido.")

    val tempos = mutableListOf<Long>()
    val valorTeste = 42

    repeat(30) {
        val lista = when (comando) {
            6 -> arrayListOf<Int>() // Lista vazia para addAll
            else -> arrayListOf<Int>().apply { repeat(carga) { add(it) } }
        }

        val tempo = measureNanoTime {
            when (comando) {
                1 -> lista.add(carga / 2, valorTeste)
                2 -> repeat((carga * 0.001).toInt()) { lista.add(carga / 2, valorTeste) }
                3 -> lista[carga / 2]
                4 -> lista.removeAt(carga / 2)
                5 -> repeat((carga * 0.001).toInt()) {
                    if (lista.isNotEmpty()) lista.removeAt(lista.size / 2)
                }
                6 -> lista.addAll(List(carga) { it })
                else -> return println("Operação inválida.")
            }
        }

        tempos.add(tempo)
    }

    val mediaNano = tempos.average()
    val mediaMili = mediaNano / 1_000_000.0

    println("\nResultado para carga de $carga elementos:")
    println("Operação escolhida: $comando")
    println("Média de tempo em 30 execuções:")
    println("- %.2f nanosegundos".format(mediaNano))
    println("- %.3f milissegundos".format(mediaMili))
}
