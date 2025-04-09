import tree.Node
import estruturas.AVLTree
import java.io.File
import java.util.Scanner
import kotlin.system.measureNanoTime

fun main() {
    val avl = AVLTree()
    val scanner = Scanner(System.`in`)

    println(
        """
        Escolha a operação digitando o número:
        1 - inserir_all
        2 - get
        3 - remove
        4 - sucessor
        5 - predecessor
        6 - min
        7 - max
    """.trimIndent()
    )
    val opcao = scanner.nextLine().toInt()

    val operacao = when (opcao) {
        1 -> "inserir_all"
        2 -> "get"
        3 -> "remove"
        4 -> "sucessor"
        5 -> "predecessor"
        6 -> "min"
        7 -> "max"
        else -> throw IllegalArgumentException("Opção inválida")
    }

    val valor: Int = if (operacao != "inserir_all" && operacao != "min" && operacao != "max") {
        print("Digite o valor para a operação de $operacao: ")
        scanner.nextLine().toInt()
    } else {
        -1
    }

    val inputDir = File("scripts/inputs")
    val arquivosNaoNulos = inputDir.listFiles { _, name ->
        name.startsWith("dataset_") && name.endsWith(".txt")
    } ?: arrayOf()

    val arquivos = arquivosNaoNulos.sortedBy { file ->
        file.name.substringAfter("dataset_").substringBefore(".txt").toInt()
    }

    val outputDir = File("Kotlin/out/AVLTree")
    outputDir.mkdirs()

    val nomeArquivoSaida = when (operacao) {
        "inserir_all" -> "insertion_all.txt"
        "get" -> "get_element.txt"
        "remove" -> "remove_element.txt"
        "sucessor" -> "sucessor_element.txt"
        "predecessor" -> "predecessor_element.txt"
        "min" -> "min.txt"
        "max" -> "max.txt"
        else -> throw IllegalArgumentException("Operação inválida")
    }

    val arquivoSaida = File(outputDir, nomeArquivoSaida)
    arquivoSaida.printWriter().use { out ->
        for (arquivo in arquivos) {
            val dados = arquivo.readLines().map { it.toInt() }
            val carga = dados.size

            var tempoTotal = 0L

            repeat(30) {
                var root: Node? = null
                for (valorLista in dados) {
                    root = avl.insert(root, valorLista)
                }

                val tempo = when (operacao) {
                    "inserir_all" -> measureNanoTime {
                        var r: Node? = null
                        for (v in dados) r = avl.insert(r, v)
                    }

                    "get" -> measureNanoTime {
                        avl.search(root, valor)
                    }

                    "remove" -> measureNanoTime {
                        avl.delete(root, valor)
                    }

                    "sucessor" -> measureNanoTime {
                        avl.sucessor(root, valor)
                    }

                    "predecessor" -> measureNanoTime {
                        avl.predecessor(root, valor)
                    }

                    "min" -> measureNanoTime {
                        avl.min(root)
                    }

                    "max" -> measureNanoTime {
                        avl.max(root)
                    }

                    else -> 0L
                }

                tempoTotal += tempo
            }

            val tempoMedio = tempoTotal / 30
            out.println("$carga;$tempoMedio")
        }
    }

    println("Resultados salvos em: ${arquivoSaida.path}")
}