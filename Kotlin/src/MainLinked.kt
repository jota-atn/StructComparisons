import estruturas.Linked
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

    val resultadosAcumulados = mutableMapOf<String, Long>().withDefault { 0L }

    repeat(30) {
        val resultados = mutableMapOf<String, Long>()

        when (operacao) {
            1 -> { // Add único
                for ((nome, pos) in posicoes) {
                    val lista = Linked()
                    repeat(carga) { lista.addLast(it) }

                    val tempo = measureNanoTime {
                        lista.add(pos, valorTeste)
                    }
                    resultados[nome] = tempo
                }
            }

            2 -> { // Add N elementos
                for ((nome, pos) in posicoes) {
                    val lista = Linked()
                    repeat(carga) { lista.addLast(it) }

                    val tempo = measureNanoTime {
                        repeat(n) {
                            lista.add(pos, valorTeste)
                        }
                    }
                    resultados[nome] = tempo
                }
            }

            3 -> { // Get
                for ((nome, pos) in posicoes) {
                    val lista = Linked()
                    repeat(carga) { lista.addLast(it) }

                    val tempo = measureNanoTime {
                        lista.getIndex(pos)
                    }
                    resultados[nome] = tempo
                }
            }

            4 -> { // Remove único
                for ((nome, pos) in posicoes) {
                    val lista = Linked()
                    repeat(carga) { lista.addLast(it) }

                    val tempo = measureNanoTime {
                        lista.remove(pos)
                    }
                    resultados[nome] = tempo
                }
            }

            5 -> { // Remove N
                for ((nome, pos) in posicoes) {
                    val lista = Linked()
                    repeat(carga) { lista.addLast(it) }

                    val tempo = measureNanoTime {
                        repeat(n) {
                            if (lista.size() > pos) {
                                lista.remove(pos)
                            }
                        }
                    }
                    resultados[nome] = tempo
                }
            }

            6 -> { // Add All
                val lista = Linked()
                val tempo = measureNanoTime {
                    repeat(carga) {
                        lista.addLast(it)
                    }
                }
                resultados["Add All"] = tempo
            }

            else -> println("Operação inválida")
        }

        resultados.forEach { (local, tempo) ->
            resultadosAcumulados[local] = resultadosAcumulados.getValue(local) + tempo
        }
    }

    // Exibir médias em nanosegundos
    println("\nMédia de tempo em 30 execuções (em nanosegundos):")
    resultadosAcumulados.forEach { (local, tempoTotal) ->
        val media = tempoTotal / 30.0
        println("- $local: ${"%.2f".format(media)} ns")
    }
}
