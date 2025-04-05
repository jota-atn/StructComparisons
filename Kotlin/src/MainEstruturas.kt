import java.io.File
import kotlin.system.measureNanoTime

fun main() {
    val caminhoArquivo = "c:/Users/Raiiz/OneDrive/Documentos/StructComparisons-1/scripts/inputs/dataset_10000000.txt"

    val linhas = File(caminhoArquivo).readLines()
    val valores = linhas.filter { it.isNotBlank() }

    val valorParaAdicionar = valores.firstOrNull()?.toIntOrNull()

    if (valorParaAdicionar != null) {
        val tempos = mutableListOf<Long>()

        repeat(30) {
            val list = ArrayList<Int>(valores.size)

            val tempo = measureNanoTime {
                list.addFirst(valorParaAdicionar) 
            }

            tempos.add(tempo)
        }

        val mediaNano = tempos.average()
        val mediaMili = mediaNano / 1_000_000.0

        println("Valor adicionado no índice 0: $valorParaAdicionar")
        println("Capacidade reservada: ${valores.size}")
        println("Média de tempo para adicionar (30 execuções):")
        println("- $mediaNano nanosegundos")
        println("- %.3f milissegundos".format(mediaMili))
    } else {
        println("Nenhum valor válido encontrado no arquivo.")
    }
}