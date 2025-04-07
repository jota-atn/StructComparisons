import estruturas.Linked
import kotlin.system.measureNanoTime

fun main() {
    val cargas = listOf(
        1_000, 10_000, 100_000, 250_000, 500_000, 600_000, 750_000, 1_000_000,
        1_700_000, 2_500_000, 3_700_000, 5_000_000, 6_000_000, 7_500_000, 9_000_000, 10_000_000
    )

    println("Escolha a carga:")
    cargas.forEachIndexed { i, c -> println("${i + 1} - $c") }
    val cargaIndex = readln().toIntOrNull()?.minus(1) ?: -1

    if (cargaIndex !in cargas.indices) {
        println("Índice inválido.")
        return
    }

    val carga = cargas[cargaIndex]
    val valorTeste = 42

    println("Escolha a operação:")
    println("1 - add unico")
    println("2 - add n valor")
    println("3 - acessar elemento")
    println("4 - remover unico")
    println("5 - remover n valor")
    println("6 - add all") // nova operação
    val comando = readln().toIntOrNull()

    val tempos = mutableListOf<Long>()

    repeat(30) {
        val lista = Linked()

        // Para operações exceto "add all", preenche a lista antes
        if (comando != 6) {
            repeat(carga) { lista.add(it) }
        }

        val tempo = measureNanoTime {
            when (comando) {
                1 -> {
                    lista.addMeio(lista.size() / 2, valorTeste)
                }

                2 -> {
                    val n = (carga * 0.001).toInt()
                    repeat(n) {
                        lista.addMeio(lista.size() / 2, valorTeste)
                    }
                }

                3 -> {
                    lista.getIndex(lista.size() / 2)
                }

                4 -> {
                    lista.remove(lista.size() / 2)
                }

                5 -> {
                    val n = (carga * 0.001).toInt()
                    repeat(n) {
                        if (lista.size() > 0) {
                            lista.remove(lista.size() / 2)
                        }
                    }
                }

                6 -> {
                    // add all: insere todos os elementos da carga na lista
                    repeat(carga) { lista.add(it) }
                }

                else -> {
                    println("Operação inválida.")
                    return
                }
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
