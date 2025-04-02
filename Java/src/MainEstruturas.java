import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainEstruturas {
    public static void main(String[] args) throws FileNotFoundException {
        String[] arquivos = {
                "../../scripts/inputs/dataset_1000.txt",
                "../../scripts/inputs/dataset_10000.txt",
                "../../scripts/inputs/dataset_100000.txt",
                "../../scripts/inputs/dataset_1000000.txt",
                "../../scripts/inputs/dataset_10000000.txt"
        };
        int[] cargas = {0, 1000, 10000, 100000, 1000000, 10000000};
        int repeticoes = 30;

        for (String caminho : arquivos) {
            cargas = shiftLeft(cargas);
            int meio = Math.max(cargas[0] / 2, 1);
            int n = Math.max((int) (cargas[0] * 0.001), 1);
            
            Array array = new Array();
            double tempoAddAll = calcularMedia(repeticoes, () -> carregarArray(array, caminho));
            double tempoAddFirst = calcularMedia(repeticoes, () -> array.addFirst(1));
            double tempoAddMeio = calcularMedia(repeticoes, () -> array.addMeio(meio, 2));
            double tempoAddLast = calcularMedia(repeticoes, () -> array.addLast(3));
            double tempoAddNFirst = calcularMedia(repeticoes, () -> adicionarN(array, caminho, n, "first"));
            double tempoAddNMeio = calcularMedia(repeticoes, () -> adicionarN(array, caminho, n, "meio", meio));
            double tempoAddNFinal = calcularMedia(repeticoes, () -> adicionarN(array, caminho, n, "last"));

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
        int execucoesValidas = 0;
        for (int i = 0; i < repeticoes; i++) {
            try {
                long inicio = System.nanoTime();
                operacao.run();
                long fim = System.nanoTime();
                soma += (fim - inicio);
                execucoesValidas++;
            } catch (Exception ignored) {}
        }
        return execucoesValidas > 0 ? (soma / execucoesValidas) / 1000.0 : 0;
    }

    private static int[] shiftLeft(int[] arr) {
        int[] novoArray = new int[arr.length];
        System.arraycopy(arr, 1, novoArray, 0, arr.length - 1);
        novoArray[arr.length - 1] = arr[0];
        return novoArray;
    }

    private static void carregarArray(Array array, String caminho) {
        try (Scanner sc = new Scanner(new File(caminho))) {
            while (sc.hasNextInt()) {
                array.add(sc.nextInt());
            }
        } catch (FileNotFoundException ignored) {}
    }

    private static void adicionarN(Array array, String caminho, int n, String tipo) {
        adicionarN(array, caminho, n, tipo, -1);
    }

    private static void adicionarN(Array array, String caminho, int n, String tipo, int meio) {
        try (Scanner sc = new Scanner(new File(caminho))) {
            for (int i = 0; i < n && sc.hasNextInt(); i++) {
                int valor = sc.nextInt();
                switch (tipo) {
                    case "first": array.addFirst(valor); break;
                    case "meio": array.addMeio(meio, valor); break;
                    case "last": array.addLast(valor); break;
                }
            }
        } catch (FileNotFoundException ignored) {}
    }
}