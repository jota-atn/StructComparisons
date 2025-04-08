import estruturas.Linked
import java.io.File
import java.util.Scanner
import kotlin.math.roundToLong
import kotlin.system.measureNanoTime

fun main() {
    val scanner = Scanner(System.`in`)
    val diretorioSaida = File("Kotlin/out/LinkedList")
    diretorioSaida.mkdirs()

    println(
        """
        Escolha a operação digitando o número:
        1 - Add único (início, meio, fim)
        2 - Add N elementos (início, meio, fim)
        3 - Get (início, meio, fim)
        4 - Remove único (início, meio, fim)
        5 - Remove N elementos (início, meio, fim)
        6 - Add All
    """.trimIndent()
    )

    val operacaoEscolhida = scanner.nextLine().toIntOrNull() ?: return println("Operação inválida")
    val operacoes = mapOf(
        1 to "insertion",
        2 to "insertion",
        3 to "get",
        4 to "remove",
        5 to "remove",
        6 to "addall"
    )
    val operacaoSelecionada = operacoes[operacaoEscolhida] ?: return println("Operação inválida")

    val posicoes = mapOf("first" to 0.0, "middle" to 0.5, "last" to 1.0)
    val entradas = File("scripts/inputs").listFiles { file -> file.name.startsWith("dataset_") }?.toList() ?: emptyList()
    val cargas = entradas.mapNotNull {
        val nome = it.name.removePrefix("dataset_").removeSuffix(".txt")
        nome.toIntOrNull()?.let { carga -> carga to it }
    }.sortedBy { it.first }

    for ((carga, arquivo) in cargas) {
        val valores = arquivo.readLines().mapNotNull { it.toIntOrNull() }
        val n = (carga * 0.001).toInt()

        when (operacaoEscolhida) {
            in 1..5 -> {
                for ((nomePosicao, _) in posicoes) {
                    val tempos = mutableListOf<Long>()
                    repeat(30) {
                        val lista = Linked()
                        for (v in valores) lista.addLast(v)

                        val index = when (nomePosicao) {
                            "first" -> 0
                            "middle" -> lista.size() / 2
                            "last" -> lista.size() - 1
                            else -> 0
                        }

                        val tempo = measureNanoTime {
                            when (operacaoEscolhida) {
                                1 -> lista.add(index, valores[0])
                                2 -> repeat(n) { lista.add(index, valores[0]) }
                                3 -> lista.getIndex(index)
                                4 -> lista.remove(index)
                                5 -> repeat(n) { if (lista.size() > index) lista.remove(index) }
                            }
                        }
                        tempos.add(tempo)
                    }

                    val media = tempos.average().roundToLong()
                    val quantidade = when (operacaoEscolhida) {
                        1, 4 -> "one_element"
                        2, 5 -> "n_elements"
                        else -> ""
                    }

                    val nomeArquivo = if (operacaoEscolhida == 3)
                        "get_${nomePosicao}.txt"
                    else
                        "${operacaoSelecionada}_${nomePosicao}_${quantidade}.txt"

                    val arquivoSaida = File(diretorioSaida, nomeArquivo)
                    arquivoSaida.appendText("$carga;$media\n")
                }
            }

            6 -> {
                val tempos = mutableListOf<Long>()
                repeat(30) {
                    val lista = Linked()
                    val tempo = measureNanoTime {
                        for (v in valores) lista.addLast(v)
                    }
                    tempos.add(tempo)
                }
                val media = tempos.average().roundToLong()
                val arquivoSaida = File(diretorioSaida, "addall.txt")
                arquivoSaida.appendText("$carga;$media\n")
            }
        }
    }

    println("Resultados salvos na pasta '${diretorioSaida.path}'.")
}
