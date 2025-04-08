import estruturas.Hash
import java.io.File
import kotlin.system.measureNanoTime
import kotlin.math.roundToLong

fun main() {
    val diretorioEntrada = "scripts/inputs"
    val diretorioSaida = "Kotlin/out/HashMap"
    File(diretorioSaida).mkdirs()

    val operacoes = listOf(
        "putAll" to 1,
        "get" to 2,
        "remove" to 3,
        "contains" to 4
    )

    println("Escolha a operação:")
    println("1 - Inserir todos os elementos")
    println("2 - Acessar um elemento")
    println("3 - Remover um elemento")
    println("4 - Contains valor 0")

    val opcao = readln().toIntOrNull() ?: return println("Operação inválida")
    val operacaoSelecionada = operacoes.find { it.second == opcao }?.first ?: return println("Operação inválida")

    val arquivos = File(diretorioEntrada).listFiles { _, name -> name.startsWith("dataset_") && name.endsWith(".txt") } ?: return

    for (arquivo in arquivos) {
        val valores = arquivo.readLines().mapNotNull { it.toIntOrNull() }
        val carga = valores.size
        val tempos = mutableListOf<Long>()

        repeat(30) {
            val hash = Hash()
            when (opcao) {
                1 -> {
                    val tempo = measureNanoTime {
                        for (v in valores) {
                            hash.put(v)
                        }
                    }
                    tempos.add(tempo)
                }

                2 -> {
                    for (v in valores) hash.put(v)
                    val tempo = measureNanoTime {
                        hash.getKey(0)
                    }
                    tempos.add(tempo)
                }

                3 -> {
                    for (v in valores) hash.put(v)
                    val tempo = measureNanoTime {
                        hash.remove(0)
                    }
                    tempos.add(tempo)
                }

                4 -> {
                    for (v in valores) hash.put(v)
                    val tempo = measureNanoTime {
                        hash.containsValue(0)
                    }
                    tempos.add(tempo)
                }
            }
        }

        val media = tempos.average().roundToLong()
        val nomeArquivo = File(diretorioSaida, "${operacaoSelecionada}.txt")
        nomeArquivo.appendText("${carga};${media}\n")
    }

    println("Resultados salvos em: $diretorioSaida")
}
