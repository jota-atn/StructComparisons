import estruturas.Linked
import java.io.File
import kotlin.math.roundToLong
import kotlin.system.measureNanoTime

fun main() {
    val diretorioSaida = "Kotlin/out/LinkedList"
    val operacoes = listOf(
        "insertion" to 1,
        "insertion" to 2,
        "get" to 3,
        "remove" to 4,
        "remove" to 5,
        "addall" to 6
    )

    val posicoes = mapOf("first" to 0.0, "middle" to 0.5, "last" to 1.0)
    val entradas = File("scripts/inputs").listFiles { file -> file.name.startsWith("dataset_") }?.toList() ?: emptyList()
    val cargas = entradas.mapNotNull { 
        val nome = it.name.removePrefix("dataset_")
        nome.toIntOrNull()?.let { carga -> carga to it } 
    }.toMap()

    println("Escolha a operação:")
    println("1 - Add único (início, meio, fim)")
    println("2 - Add N elementos (início, meio, fim)")
    println("3 - Get (início, meio, fim)")
    println("4 - Remove único (início, meio, fim)")
    println("5 - Remove N elementos (início, meio, fim)")
    println("6 - Add All")

    val operacaoEscolhida = readln().toIntOrNull() ?: return println("Operação inválida")
    val operacaoSelecionada = operacoes.find { it.second == operacaoEscolhida }?.first ?: return println("Operação inválida")

    for ((carga, arquivo) in cargas) {
        val valores = arquivo.readLines().mapNotNull { it.toIntOrNull() }
        val n = (carga * 0.001).toInt()

        when (operacaoEscolhida) {
            1, 2, 4, 5, 3 -> {
                for ((nomePosicao, proporcao) in posicoes) {
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
                    val quantidade = if (operacaoEscolhida in listOf(1, 4)) "one_element" else if (operacaoEscolhida in listOf(2, 5)) "n_elements" else ""
                    val nomeArquivo = if (operacaoEscolhida == 3)
                        "get_${nomePosicao}.txt"
                    else
                        "${operacaoSelecionada}_${nomePosicao}_${quantidade}.txt"

                    val arquivoSaida = File("$diretorioSaida/$nomeArquivo")
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
                val arquivo = File("$diretorioSaida/addall.txt")
                arquivo.appendText("$carga;$media\n")
            }
        }
    }
    println("Resultados salvos na pasta '$diretorioSaida'.")
}
