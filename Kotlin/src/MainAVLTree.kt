import estruturas.AVLTree
import tree.Node
import java.io.File
import kotlin.math.roundToLong
import kotlin.system.measureNanoTime

fun main() {
    val avl = AVLTree()
    val outputDir = File("Kotlin/out/AVLTree")
    outputDir.mkdirs()

    val arquivos = File("scripts/inputs").listFiles { _, name ->
        name.startsWith("dataset_") && name.endsWith(".txt")
    }?.sortedBy {
        it.name.removePrefix("dataset_").removeSuffix(".txt").toIntOrNull()
    } ?: return println("Nenhum arquivo de entrada encontrado.")

    val operacoes = listOf(
        "inserir_all",
        "get",
        "remove",
        "sucessor",
        "predecessor",
        "min",
        "max"
    )

    for (operacao in operacoes) {
        val nomeArquivo = when (operacao) {
            "inserir_all" -> "insertion_all.txt"
            "get" -> "get_element.txt"
            "remove" -> "remove_element.txt"
            "sucessor" -> "sucessor_element.txt"
            "predecessor" -> "predecessor_element.txt"
            "min" -> "min.txt"
            "max" -> "max.txt"
            else -> continue
        }

        val arquivoSaida = File(outputDir, nomeArquivo)

        for (arquivo in arquivos) {
            val dados = arquivo.readLines().mapNotNull { it.toIntOrNull() }
            val carga = dados.size
            val valorTeste = 10000000

            val tempos = mutableListOf<Long>()
            repeat(30) {
                var root: Node? = null
                for (v in dados) {
                    root = avl.insert(root, v)
                }

                val tempo = measureNanoTime {
                    when (operacao) {
                        "inserir_all" -> {
                            var r: Node? = null
                            for (v in dados) r = avl.insert(r, v)
                        }
                        "get" -> avl.search(root, valorTeste)
                        "remove" -> avl.delete(root, valorTeste)
                        "sucessor" -> avl.sucessor(root, valorTeste)
                        "predecessor" -> avl.predecessor(root, valorTeste)
                        "min" -> avl.min(root)
                        "max" -> avl.max(root)
                    }
                }
                tempos.add(tempo)
            }

            val media = tempos.average().roundToLong()
            arquivoSaida.appendText("$carga;$media\n")
        }
    }

    println("Resultados salvos na pasta '${outputDir.path}'")
}
