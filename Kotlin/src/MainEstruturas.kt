import java.io.File
import kotlin.system.measureNanoTime
import estruturas.ArrayList

fun medirOperacao(
    nomeOperacao: String,
    valores: List<Int>,
    repeticoes: Int,
    operacao: (ArrayList) -> Unit
) {
    val tempos = mutableListOf<Long>()

    repeat(repeticoes) {
        val lista = ArrayList(valores.size)
        for (v in valores) {
            lista.addLast(v)
        }

        val tempo = measureNanoTime {
            operacao(lista)
        }

        tempos.add(tempo)
    }

    val mediaNano = tempos.average()
    val mediaMili = mediaNano / 1_000_000.0

    println("→ Tempo médio de $nomeOperacao:")
    println("- %.0f ns".format(mediaNano))
    println("- %.3f ms".format(mediaMili))
    println()
}

fun main() {
    val cargas = listOf(
        1000, 10000, 100000, 250000, 500000, 600000, 750000,
        1_000_000, 1_700_000, 2_500_000, 3_700_000, 5_000_000,
        6_000_000, 7_500_000, 9_000_000, 10_000_000
    )

    val operacoes = listOf(
        "add unico",
        "add n valor (0.1% da carga)",
        "acessar elemento",
        "remover unico",
        "remover n valor (0.1% da carga)"
    )

    println("Selecione a carga que deseja testar:")
    cargas.forEachIndexed { index, carga ->
        println("${index + 1} - $carga elementos")
    }

    print("Digite o número da carga desejada: ")
    val opcaoCarga = readLine()?.toIntOrNull()
    if (opcaoCarga == null || opcaoCarga !in 1..cargas.size) {
        println("Opção inválida.")
        return
    }

    val cargaSelecionada = cargas[opcaoCarga - 1]
    val caminho = "scripts/inputs/dataset_${cargaSelecionada}.txt"
    val arquivo = File(caminho)

    if (!arquivo.exists()) {
        println("Arquivo \"$caminho\" não encontrado.")
        return
    }

    val linhas = arquivo.readLines()
    val valores = linhas.filter { it.isNotBlank() }.mapNotNull { it.toIntOrNull() }
    val valorTeste = valores.firstOrNull()
    val repeticoes = 30
    val n = (valores.size * 0.001).toInt().coerceAtLeast(1)

    if (valorTeste == null) {
        println("Arquivo não contém valores válidos.")
        return
    }

    println("\n========== CARGA SELECIONADA: $cargaSelecionada elementos ==========\n")

    println("Selecione a operação que deseja testar:")
    operacoes.forEachIndexed { i, op -> println("${i + 1} - $op") }

    print("Digite o número da operação desejada: ")
    val opcaoOperacao = readLine()?.toIntOrNull()
    if (opcaoOperacao == null || opcaoOperacao !in 1..operacoes.size) {
        println("Operação inválida.")
        return
    }

    when (opcaoOperacao) {
        1 -> {
            println("\n[ADD ÚNICO]")
            medirOperacao("addFirst", valores, repeticoes) { it.addFirst(valorTeste) }
            medirOperacao("addMeio", valores, repeticoes) { it.addMeio(valores.size / 2, valorTeste) }
            medirOperacao("addLast", valores, repeticoes) { it.addLast(valorTeste) }
        }

        2 -> {
            println("\n[ADD N VALORES - $n elementos]")
            val subvalores = valores.take(n)
            medirOperacao("adicionar $n valores", emptyList(), repeticoes) { lista ->
                for (v in subvalores) {
                    lista.addLast(v)
                }
            }
        }

        3 -> {
            println("\n[ACESSAR ELEMENTO]")
            medirOperacao("acessar início", valores, repeticoes) { it.getIndex(0) }
            medirOperacao("acessar meio", valores, repeticoes) { it.getIndex(valores.size / 2) }
            medirOperacao("acessar fim", valores, repeticoes) { it.getIndex(valores.size - 1) }
        }

        4 -> {
            println("\n[REMOVER ÚNICO]")
            medirOperacao("remover do início", valores, repeticoes) { it.remove(0) }
            medirOperacao("remover do meio", valores, repeticoes) { it.remove(valores.size / 2) }
            medirOperacao("remover do fim", valores, repeticoes) { it.remove(valores.size - 1) }
        }

        5 -> {
            println("\n[REMOVER N VALORES - $n elementos]")
            medirOperacao("remover últimos $n", valores, repeticoes) { lista ->
                repeat(n.coerceAtMost(lista.size())) {
                    lista.remove(lista.size() - 1)
                }
            }
        }
    }
}
