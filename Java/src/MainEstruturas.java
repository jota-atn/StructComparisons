import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainEstruturas {

    public static void main(String[] args) throws FileNotFoundException {
        String[] arquivos = {
                "/scripts/inputs/dataset_1000.txt",
                "../scripts/inputs/dataset_10000.txt",
                "/scripts/inputs/dataset_100000.txt",
                "/scripts/inputs/dataset_1000000.txt",
                "/scripts/inputs/dataset_10000000.txt"
        };
        int[] cargas = {0, 1000, 10000, 100000, 1000000, 10000000};
        int repeticoes = 30;

        for (String caminho : arquivos) {
            cargas = shiftLeft(cargas);
            int meio = cargas[0] / 2;
            int n = (int) (cargas[0] * 0.001);

            File arquivo = new File(caminho);
            Scanner sc = new Scanner(arquivo);

            Array array = new Array();

            double tempoAddAll = calcularMedia(repeticoes, () -> {
                try {
                    while (sc.hasNextInt()) {
                        array.add(sc.nextInt());
                    }
                } catch (Exception e) {
                    System.err.println("Erro ao inserir elementos: " + e.getMessage());
                }
            });

            // Inserir um elemento no início
            double tempoAddFirst = calcularMedia(repeticoes, () -> array.addFirst(1));

            // Inserir um elemento no meio
            double tempoAddMeio = calcularMedia(repeticoes, () -> array.addMeio(meio, 2));

            // Inserir um elemento no final
            double tempoAddLast = calcularMedia(repeticoes, () -> array.addLast(3));

            // Inserir N elementos no início
            double tempoAddNFirst = calcularMedia(repeticoes, () -> {
                try {
                    for (int i = 0; i < n && sc.hasNextInt(); i++) {
                        array.addFirst(sc.nextInt());
                    }
                } catch (Exception e) {
                    System.err.println("Erro ao inserir N elementos no início: " + e.getMessage());
                }
            });

            // Inserir N elementos no meio
            double tempoAddNMeio = calcularMedia(repeticoes, () -> {
                try {
                    for (int i = 0; i < n && sc.hasNextInt(); i++) {
                        array.addMeio(meio, sc.nextInt());
                    }
                } catch (Exception e) {
                    System.err.println("Erro ao inserir N elementos no meio: " + e.getMessage());
                }
            });

            // Inserir N elementos no final
            double tempoAddNFinal = calcularMedia(repeticoes, () -> {
                try {
                    for (int i = 0; i < n && sc.hasNextInt(); i++) {
                        array.addLast(sc.nextInt());
                    }
                } catch (Exception e) {
                    System.err.println("Erro ao inserir N elementos no final: " + e.getMessage());
                }
            });

            sc.close();

            System.out.println("Arquivo: " + caminho);
            System.out.println("Tempo médio para adicionar todos: " + tempoAddAll + " microssegundos");
            System.out.println("Tempo médio para adicionar 1 no início: " + tempoAddFirst + " microssegundos");
            System.out.println("Tempo médio para adicionar 1 no meio: " + tempoAddMeio + " microssegundos");
            System.out.println("Tempo médio para adicionar 1 no final: " + tempoAddLast + " microssegundos");
            System.out.println("Tempo médio para adicionar N no início: " + tempoAddNFirst + " microssegundos");
            System.out.println("Tempo médio para adicionar N no meio: " + tempoAddNMeio + " microssegundos");
            System.out.println("Tempo médio para adicionar N no final: " + tempoAddNFinal + " microssegundos");
            System.out.println("---------------------------------------------------");
        }
    }

    private static double calcularMedia(int repeticoes, Runnable operacao) {
        long soma = 0;
        for (int i = 0; i < repeticoes; i++) {
            try {
                long inicio = System.nanoTime();
                operacao.run();
                long fim = System.nanoTime();
                soma += (fim - inicio);
            } catch (Exception e) {
                System.err.println("Erro durante execução da operação: " + e.getMessage());
            }
        }
        return (soma / repeticoes) / 1000.0;
    }

    private static int[] shiftLeft(int[] arr) {
        int[] novoArray = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            novoArray[i - 1] = arr[i];
        }
        novoArray[arr.length - 1] = arr[0];
        return novoArray;
    }
}
