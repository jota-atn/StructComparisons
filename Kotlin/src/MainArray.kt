import estruturas.ArrayList
import java.io.File
import java.util.Scanner
import kotlin.math.roundToLong
import kotlin.system.measureNanoTime

fun main() {
    val scanner = Scanner(System.`in`)
    val diretorioEntrada = File("scripts/inputs")
    val diretorioSaida = File("Kotlin/out/ArrayList")
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

    val opcao = scanner.nextLine().toIntOrNull() ?: return println("Operação inválida")

    val operacao = when (opcao) {
        1 -> "insertion" to "one_element"
        2 -> "insertion" to "n_elements"
        3 -> "get" to ""
        4 -> "remove" to "one_element"
        5 -> "remove" to "n_elements"
        6 -> "addall" to ""
        else -> return println("Operação inválida")
    }

    val posicoes = mapOf("first" to 0.0, "middle" to 0.5, "last" to 1.0)

    val arquivos = diretorioEntrada.listFiles { _, name ->
        name.startsWith("dataset_") && name.endsWith(".txt")
    }?.sortedBy {
        it.name.removePrefix("dataset_").removeSuffix(".txt").toIntOrNull()
    } ?: return println("Nenhum arquivo de entrada encontrado.")

    for (arquivo in arquivos) {
        val dados = arquivo.readLines().mapNotNull { it.toIntOrNull() }
        val carga = dados.size
        val n = (carga * 0.001).toInt()

        if (opcao == 6) {
            val tempos = mutableListOf<Long>()
            repeat(30) {
                val lista = ArrayList(carga)
                val tempo = measureNanoTime {
                    for (v in dados) lista.addLast(v)
                }
                tempos.add(tempo)
            }
            val media = tempos.average().roundToLong()
            val arquivoSaida = File(diretorioSaida, "addall.txt")
            arquivoSaida.appendText("$carga;$media\n")
        } else {
            for ((nomePosicao, proporcao) in posicoes) {
                val tempos = mutableListOf<Long>()
                repeat(30) {
                    val lista = ArrayList(carga)
                    for (v in dados) lista.addLast(v)
                    val index = when (nomePosicao) {
                        "first" -> 0
                        "middle" -> lista.size() / 2
                        "last" -> lista.size() - 1
                        else -> 0
                    }
                    val tempo = measureNanoTime {
                        when (opcao) {
                            1 -> lista.add(index, dados[0])
                            2 -> repeat(n) { lista.add(index, dados[0]) }
                            3 -> lista.getIndex(index)
                            4 -> lista.remove(index)
                            5 -> repeat(n) { if (lista.size() > index) lista.remove(index) }
                        }
                    }
                    tempos.add(tempo)
                }
                val media = tempos.average().roundToLong()
                val nomeArquivo = if (opcao == 3) {
                    "get_${nomePosicao}.txt"
                } else {
                    "${operacao.first}_${nomePosicao}_${operacao.second}.txt"
                }
                val arquivoSaida = File(diretorioSaida, nomeArquivo)
                arquivoSaida.appendText("$carga;$media\n")
            }
        }
    }
    println("Resultados salvos em: ${diretorioSaida.path}")
}