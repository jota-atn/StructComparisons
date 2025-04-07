import estruturas.ArrayList
import kotlin.system.measureNanoTime

fun main() {
    val cargas = listOf(
        1_000, 10_000, 100_000, 250_000, 500_000, 600_000, 750_000, 1_000_000,
        1_700_000, 2_500_000, 3_700_000, 5_000_000, 6_000_000, 7_500_000, 9_000_000, 10_000_000
    )

    println("Escolha a carga:")
    cargas.forEachIndexed { i, c -> println("${i + 1} - $c") }
    val carga = cargas.getOrNull(readln().toIntOrNull()?.minus(1) ?: -1) ?: return println("Índice inválido")

    val valorTeste = 42
    val n = (carga * 0.001).toInt()

    val opcoes = listOf(
        "1 - Add único (início, meio, fim)",
        "2 - Add N elementos (início, meio, fim)",
        "3 - Get (início, meio, fim)",
        "4 - Remove único (início, meio, fim)",
        "5 - Remove N elementos (início, meio, fim)",
        "6 - Add All"
    )

    println("Escolha a operação:")
    opcoes.forEach { println(it) }
    val operacao = readln().toIntOrNull() ?: return println("Operação inválida")

    val posicoes = listOf(
        "Início" to 0,
        "Meio" to carga / 2,
        "Fim" to carga - 1
    )

    val acumulador = mutableMapOf<String, Long>()
    posicoes.forEach { (nome, _) -> acumulador[nome] = 0L }
    if (operacao == 6) acumulador["Add All"] = 0L

    repeat(30) {
        when (operacao) {
            1 -> for ((nome, pos) in posicoes) {
                val lista = ArrayList(carga)
                repeat(carga) { lista.addLast(it) }
                val tempo = measureNanoTime { lista.add(pos, valorTeste) }
                acumulador[nome] = acumulador[nome]!! + tempo
            }

            2 -> for ((nome, pos) in posicoes) {
                val lista = ArrayList(carga)
                repeat(carga) { lista.addLast(it) }
                val tempo = measureNanoTime {
                    repeat(n) { lista.add(pos, valorTeste) }
                }
                acumulador[nome] = acumulador[nome]!! + tempo
            }

            3 -> for ((nome, pos) in posicoes) {
                val lista = ArrayList(carga)
                repeat(carga) { lista.addLast(it) }
                val tempo = measureNanoTime { lista.getIndex(pos) }
                acumulador[nome] = acumulador[nome]!! + tempo
            }

            4 -> for ((nome, pos) in posicoes) {
                val lista = ArrayList(carga)
                repeat(carga) { lista.addLast(it) }
                val tempo = measureNanoTime { lista.remove(pos) }
                acumulador[nome] = acumulador[nome]!! + tempo
            }

            5 -> for ((nome, pos) in posicoes) {
                val lista = ArrayList(carga)
                repeat(carga) { lista.addLast(it) }
                val tempo = measureNanoTime {
                    repeat(n) { if (lista.size() > pos) lista.remove(pos) }
                }
                acumulador[nome] = acumulador[nome]!! + tempo
            }

            6 -> {
                val lista = ArrayList(carga)
                val tempo = measureNanoTime {
                    repeat(carga) { lista.addLast(it) }
                }
                acumulador["Add All"] = acumulador["Add All"]!! + tempo
            }
        }
    }

    println("\nResultado para carga de $carga elementos:")
    if (operacao == 6) {
        val media = acumulador["Add All"]!! / 30.0
        println("Média Add All: %.0f ns".format(media))
    } else {
        acumulador.forEach { (local, totalTempo) ->
            val media = totalTempo / 30.0
            println("Tempo médio em $local: %.0f ns".format(media))
        }
    }
}
