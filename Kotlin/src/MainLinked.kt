import estruturas.Linked
import java.io.File
import kotlin.math.roundToLong
import kotlin.system.measureNanoTime

fun main() {
    val diretorioEntrada = File("scripts/inputs")
    val diretorioSaida = File("Kotlin/out/LinkedList")
    diretorioSaida.mkdirs()

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

        // Operação 1: Add único
        for ((nomePosicao, _) in posicoes) {
            medirTempoLinked(carga, dados, n, "insertion", nomePosicao, "one_element") { lista, index ->
                lista.add(index, dados[0])
            }
        }

        // Operação 2: Add N elementos
        for ((nomePosicao, _) in posicoes) {
            medirTempoLinked(carga, dados, n, "insertion", nomePosicao, "n_elements") { lista, index ->
                repeat(n) { lista.add(index, dados[0]) }
            }
        }

        // Operação 3: Get
        for ((nomePosicao, _) in posicoes) {
            medirTempoLinked(carga, dados, n, "get", nomePosicao, "") { lista, index ->
                lista.getIndex(index)
            }
        }

        // Operação 4: Remove único
        for ((nomePosicao, _) in posicoes) {
            medirTempoLinked(carga, dados, n, "remove", nomePosicao, "one_element") { lista, index ->
                lista.remove(index)
            }
        }

        // Operação 5: Remove N elementos
        for ((nomePosicao, _) in posicoes) {
            medirTempoLinked(carga, dados, n, "remove", nomePosicao, "n_elements") { lista, index ->
                repeat(n) { if (lista.size() > index) lista.remove(index) }
            }
        }

        // Operação 6: AddAll
        val temposAddAll = mutableListOf<Long>()
        repeat(30) {
            val lista = Linked()
            val tempo = measureNanoTime {
                for (v in dados) lista.addLast(v)
            }
            temposAddAll.add(tempo)
        }
        val mediaAddAll = temposAddAll.average().roundToLong()
        val arquivoAddAll = File(diretorioSaida, "addall.txt")
        arquivoAddAll.appendText("$carga;$mediaAddAll\n")
    }

    println("Resultados salvos em: ${diretorioSaida.path}")
}

fun medirTempoLinked(
    carga: Int,
    dados: List<Int>,
    n: Int,
    tipo: String,
    posicao: String,
    subtipo: String,
    operacao: (Linked, Int) -> Unit
) {
    val tempos = mutableListOf<Long>()
    repeat(30) {
        val lista = Linked()
        for (v in dados) lista.addLast(v)
        val index = when (posicao) {
            "first" -> 0
            "middle" -> lista.size() / 2
            "last" -> lista.size() - 1
            else -> 0
        }
        val tempo = measureNanoTime {
            operacao(lista, index)
        }
        tempos.add(tempo)
    }
    val media = tempos.average().roundToLong()
    val nomeArquivo = if (tipo == "get") {
        "get_${posicao}.txt"
    } else {
        "${tipo}_${posicao}_${subtipo}.txt"
    }
    val arquivoSaida = File("Kotlin/out/LinkedList", nomeArquivo)
    arquivoSaida.appendText("$carga;$media\n")
}
