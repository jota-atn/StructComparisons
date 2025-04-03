import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainEstruturas {
    private static final int WARMUP_ITERATIONS = 10;
    private static final int MEASUREMENT_ITERATIONS = 30;

    public static void main(String[] args) {
        String[] arquivos = {
                "scripts/inputs/dataset_1000.txt",
                "scripts/inputs/dataset_10000.txt",
                "scripts/inputs/dataset_100000.txt",
                "scripts/inputs/dataset_250000.txt",
                "scripts/inputs/dataset_500000.txt",
                "scripts/inputs/dataset_600000.txt",
                "scripts/inputs/dataset_750000.txt",
                "scripts/inputs/dataset_1000000.txt",
                "scripts/inputs/dataset_1700000.txt",
                "scripts/inputs/dataset_2500000.txt",
                "scripts/inputs/dataset_3700000.txt",
                "scripts/inputs/dataset_5000000.txt",
                "scripts/inputs/dataset_6000000.txt",
                "scripts/inputs/dataset_7500000.txt",
                "scripts/inputs/dataset_9000000.txt",
                "scripts/inputs/dataset_10000000.txt"
        };

        for (String caminho : arquivos) {
            try {
                performWarmup(caminho, new ArrayList<>());
                performWarmup(caminho, new LinkedList<>());

                System.out.println("\n=== Arquivo: " + caminho + " ===");
                executeTests(caminho, new ArrayList<>(), "ArrayList");
                executeTests(caminho, new LinkedList<>(), "LinkedList");
            } catch (FileNotFoundException e) {
                System.err.println("Erro: Arquivo não encontrado - " + caminho);
            }
        }
    }

    private static void performWarmup(String caminho, List<Integer> list) throws FileNotFoundException {
        for (int i = 0; i < WARMUP_ITERATIONS; i++) {
            list.clear();
            loadData(list, caminho);
            list.add(0, 1);
            list.add(Math.min(list.size(), list.size() / 2), 2);
            list.add(3);
        }
    }

    private static void executeTests(String caminho, List<Integer> list, String tipoLista) throws FileNotFoundException {
        loadData(list, caminho);
        int tamanho = list.size();
        int meio = tamanho / 2;
        int n = Math.max((int) (tamanho * 0.001), 1);

        System.out.println("\nTestando com " + tipoLista);
        printResult("Adicionar todos os elementos", measureAddAll(caminho, list));
        printResult("Adicionar 1 elemento no início", measureAddFirst(caminho, list));
        printResult("Adicionar 1 elemento no meio", measureAddMiddle(caminho, list, meio));
        printResult("Adicionar 1 elemento no final", measureAddLast(caminho, list));
        printResult("Adicionar " + n + " elementos no início", measureAddNFirst(caminho, list, n));
        printResult("Adicionar " + n + " elementos no meio", measureAddNMiddle(caminho, list, n, meio));
        printResult("Adicionar " + n + " elementos no final", measureAddNLast(caminho, list, n));
    }

    private static void loadData(List<Integer> list, String caminho) throws FileNotFoundException {
        list.clear();
        try (Scanner sc = new Scanner(new File(caminho))) {
            while (sc.hasNextInt()) {
                list.add(sc.nextInt());
            }
        }
    }

    private static double measureAddAll(String caminho, List<Integer> list) throws FileNotFoundException {
        long totalTime = 0;
        for (int i = 0; i < MEASUREMENT_ITERATIONS; i++) {
            list.clear();
            long start = System.nanoTime();
            loadData(list, caminho);
            long end = System.nanoTime();
            totalTime += (end - start);
        }
        return (totalTime / MEASUREMENT_ITERATIONS) / 1000.0;
    }

    private static double measureAddFirst(String caminho, List<Integer> list) throws FileNotFoundException {
        return measureAddPosition(caminho, list, 0, 1);
    }

    private static double measureAddMiddle(String caminho, List<Integer> list, int middle) throws FileNotFoundException {
        return measureAddPosition(caminho, list, Math.min(middle, list.size()), 2);
    }

    private static double measureAddLast(String caminho, List<Integer> list) throws FileNotFoundException {
        return measureAddPosition(caminho, list, list.size(), 3);
    }

    private static double measureAddPosition(String caminho, List<Integer> list, int index, int value) throws FileNotFoundException {
        long totalTime = 0;
        for (int i = 0; i < MEASUREMENT_ITERATIONS; i++) {
            loadData(list, caminho);
            long start = System.nanoTime();
            list.add(Math.min(index, list.size()), value);
            long end = System.nanoTime();
            totalTime += (end - start);
        }
        return (totalTime / MEASUREMENT_ITERATIONS) / 1000.0;
    }

    private static double measureAddNFirst(String caminho, List<Integer> list, int n) throws FileNotFoundException {
        return measureAddNPosition(caminho, list, 0, n);
    }

    private static double measureAddNMiddle(String caminho, List<Integer> list, int n, int middle) throws FileNotFoundException {
        return measureAddNPosition(caminho, list, Math.min(middle, list.size()), n);
    }

    private static double measureAddNLast(String caminho, List<Integer> list, int n) throws FileNotFoundException {
        return measureAddNPosition(caminho, list, list.size(), n);
    }

    private static double measureAddNPosition(String caminho, List<Integer> list, int index, int n) throws FileNotFoundException {
        long totalTime = 0;
        for (int i = 0; i < MEASUREMENT_ITERATIONS; i++) {
            loadData(list, caminho);
            List<Integer> tempData = new ArrayList<>(list);
            long start = System.nanoTime();
            for (int j = 0; j < n && j < tempData.size(); j++) {
                list.add(Math.min(index, list.size()), tempData.get(j));
            }
            long end = System.nanoTime();
            totalTime += (end - start);
        }
        return (totalTime / MEASUREMENT_ITERATIONS) / 1000.0;
    }

    private static void printResult(String operation, double time) {
        System.out.printf("%-40s: %8.3f μs%n", operation, time);
    }
}
