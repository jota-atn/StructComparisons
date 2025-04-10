import estruturas.Hash
import java.io.File
import kotlin.math.roundToLong
import kotlin.system.measureNanoTime

fun main() {
    val diretorioEntrada = File("scripts/inputs")
    val diretorioSaida = File("Kotlin/out/HashMap")
    diretorioSaida.mkdirs()

    val arquivos = diretorioEntrada.listFiles { _, name ->
        name.startsWith("dataset_") && name.endsWith(".txt")
    }?.sortedBy {
        it.name.removePrefix("dataset_").removeSuffix(".txt").toIntOrNull()
    } ?: return println("Nenhum arquivo de entrada encontrado.")

    for (arquivo in arquivos) {
        val valores = arquivo.readLines().mapNotNull { it.toIntOrNull() }
        val carga = valores.size

        // Operação 1: putAll
        medirTempoHash(carga, valores, "putall") { hash ->
            for (v in valores) hash.put(v)
        }

        // Operação 2: get (busca valor 0)
        medirTempoHash(carga, valores, "get") { hash ->
            for (v in valores) hash.put(v)
            hash.getKey(0)
        }

        // Operação 3: remove (remove valor 0)
        medirTempoHash(carga, valores, "remove") { hash ->
            for (v in valores) hash.put(v)
            hash.remove(0)
        }

        // Operação 4: contains (verifica se contém o valor 0)
        medirTempoHash(carga, valores, "contains") { hash ->
            for (v in valores) hash.put(v)
            hash.containsValue(0)
        }
    }

    println("Resultados salvos em: ${diretorioSaida.path}")
}

fun medirTempoHash(
    carga: Int,
    valores: List<Int>,
    nomeOperacao: String,
    operacao: (Hash) -> Unit
) {
    val tempos = mutableListOf<Long>()
    repeat(30) {
        val hash = Hash()
        val tempo = measureNanoTime {
            operacao(hash)
        }
        tempos.add(tempo)
    }
    val media = tempos.average().roundToLong()
    val arquivoSaida = File("Kotlin/out/HashMap", "${nomeOperacao}.txt")
    arquivoSaida.appendText("$carga;$media\n")
}
