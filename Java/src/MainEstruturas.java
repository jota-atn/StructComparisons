import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainEstruturas {
    private static final int quantOperacoes = 30;
    private static final String[] arquivos = {
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

    public static void main(String[] args) throws FileNotFoundException {
        for (String caminho : arquivos) {
            Array arrayList = new Array();
            Linked linkedList = new Linked();

            ArrayList<Integer> dados = carregarDados(caminho);

            System.out.println("\n======= Testes com arquivo: " + caminho + " =======");

            System.out.println("\n-- ArrayList --");
            executarTestesEstrutura(arrayList, new ArrayList<>(dados));

            System.out.println("\n-- LinkedList --");
            executarTestesEstrutura(linkedList, new ArrayList<>(dados));
        }
    }

    private static void executarTestesEstrutura(Object estrutura, ArrayList<Integer> dadosOriginais) {
        int n = Math.max(1, dadosOriginais.size() / 1000);
        System.out.printf("Adicionar todos os elementos          : %.3f μs\n", medirTempo(() -> {
            limpar(estrutura);
            adicionarTodos(estrutura, new ArrayList<>(dadosOriginais));
        }));

        // ---- Adição ----
        System.out.printf("Adicionar 1 elemento no início        : %.3f μs\n", medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            adicionarInicio(estrutura, 1);
        }));
        System.out.printf("Adicionar 1 elemento no meio          : %.3f μs\n", medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            adicionarMeio(estrutura, 2);
        }));
        System.out.printf("Adicionar 1 elemento no fim           : %.3f μs\n", medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            adicionarFim(estrutura, 3);
        }));

        System.out.printf("Adicionar %d elementos no início      : %.3f μs\n", n, medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            adicionarInicioVarios(estrutura, 1, n);
        }));
        System.out.printf("Adicionar %d elementos no meio        : %.3f μs\n", n, medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            adicionarMeioVarios(estrutura, 2, n);
        }));
        System.out.printf("Adicionar %d elementos no fim         : %.3f μs\n", n, medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            adicionarFimVarios(estrutura, 3, n);
        }));

        // ---- Acesso ----
        System.out.printf("Acessar elemento no início            : %.3f μs\n", medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            acessarInicio(estrutura);
        }));
        System.out.printf("Acessar elemento no meio              : %.3f μs\n", medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            acessarMeio(estrutura);
        }));
        System.out.printf("Acessar elemento no fim               : %.3f μs\n", medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            acessarFim(estrutura);
        }));

        System.out.printf("Acessar %d elementos no início        : %.3f μs\n", n, medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            acessarInicioVarios(estrutura, n);
        }));
        System.out.printf("Acessar %d elementos no meio          : %.3f μs\n", n, medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            acessarMeioVarios(estrutura, n);
        }));
        System.out.printf("Acessar %d elementos no fim           : %.3f μs\n", n, medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            acessarFimVarios(estrutura, n);
        }));

        // ---- Remoção ----
        System.out.printf("Remover elemento no início            : %.3f μs\n", medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            removerInicio(estrutura);
        }));
        System.out.printf("Remover elemento no meio              : %.3f μs\n", medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            removerMeio(estrutura);
        }));
        System.out.printf("Remover elemento no fim               : %.3f μs\n", medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            removerFim(estrutura);
        }));

        System.out.printf("Remover %d elementos no início        : %.3f μs\n", n, medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            removerInicioVarios(estrutura, n);
        }));
        System.out.printf("Remover %d elementos no meio          : %.3f μs\n", n, medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            removerMeioVarios(estrutura, n);
        }));
        System.out.printf("Remover %d elementos no fim           : %.3f μs\n", n, medirTempo(() -> {
            carregar(estrutura, new ArrayList<>(dadosOriginais));
            removerFimVarios(estrutura, n);
        }));
    }

    private static ArrayList<Integer> carregarDados(String caminho) throws FileNotFoundException {
        ArrayList<Integer> dados = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(caminho))) {
            while (sc.hasNextInt()) {
                dados.add(sc.nextInt());
            }
        }
        return dados;
    }

    private static double medirTempo(Runnable operacao) {
        long total = 0;
        for (int i = 0; i < quantOperacoes; i++) {
            long inicio = System.nanoTime();
            operacao.run();
            long fim = System.nanoTime();
            total += (fim - inicio);
        }
        return total / (quantOperacoes * 1000.0);
    }

    private static void limpar(Object estrutura) {
        if (estrutura instanceof Array a) a.clear();
        else if (estrutura instanceof Linked l) l.clear();
    }

    private static void adicionarTodos(Object estrutura, ArrayList<Integer> dados) {
        if (estrutura instanceof Array a) a.addAll(dados);
        else if (estrutura instanceof Linked l) l.addAll(new LinkedList<>(dados));
    }

    private static void carregar(Object estrutura, ArrayList<Integer> dados) {
        limpar(estrutura);
        adicionarTodos(estrutura, dados);
    }

    private static void adicionarInicio(Object estrutura, int valor) {
        if (estrutura instanceof Array a) a.addFirst(valor);
        else if (estrutura instanceof Linked l) l.addFirst(valor);
    }
    private static void adicionarInicioVarios(Object estrutura, int valor, int n) {
        for (int i = 0; i < n; i++) adicionarInicio(estrutura, valor);
    }

    private static void adicionarMeio(Object estrutura, int valor) {
        if (estrutura instanceof Array a) a.addMiddle(valor);
        else if (estrutura instanceof Linked l) l.addMiddle(valor);
    }
    private static void adicionarMeioVarios(Object estrutura, int valor, int n) {
        for (int i = 0; i < n; i++) adicionarMeio(estrutura, valor);
    }

    private static void adicionarFim(Object estrutura, int valor) {
        if (estrutura instanceof Array a) a.addLast(valor);
        else if (estrutura instanceof Linked l) l.addLast(valor);
    }
    private static void adicionarFimVarios(Object estrutura, int valor, int n) {
        for (int i = 0; i < n; i++) adicionarFim(estrutura, valor);
    }

    private static void acessarInicio(Object estrutura) {
        if (estrutura instanceof Array a) a.getFirst();
        else if (estrutura instanceof Linked l) l.getFirst();
    }
    private static void acessarInicioVarios(Object estrutura, int n) {
        for (int i = 0; i < n; i++) acessarInicio(estrutura);
    }

    private static void acessarMeio(Object estrutura) {
        if (estrutura instanceof Array a) a.getMiddle();
        else if (estrutura instanceof Linked l) l.getMiddle();
    }
    private static void acessarMeioVarios(Object estrutura, int n) {
        for (int i = 0; i < n; i++) acessarMeio(estrutura);
    }

    private static void acessarFim(Object estrutura) {
        if (estrutura instanceof Array a) a.getLast();
        else if (estrutura instanceof Linked l) l.getLast();
    }
    private static void acessarFimVarios(Object estrutura, int n) {
        for (int i = 0; i < n; i++) acessarFim(estrutura);
    }

    private static void removerInicio(Object estrutura) {
        if (estrutura instanceof Array a) a.removeFirst();
        else if (estrutura instanceof Linked l) l.removeFirst();
    }
    private static void removerInicioVarios(Object estrutura, int n) {
        for (int i = 0; i < n; i++) removerInicio(estrutura);
    }

    private static void removerMeio(Object estrutura) {
        if (estrutura instanceof Array a) a.removeMiddle();
        else if (estrutura instanceof Linked l) l.removeMiddle();
    }
    private static void removerMeioVarios(Object estrutura, int n) {
        for (int i = 0; i < n; i++) removerMeio(estrutura);
    }

    private static void removerFim(Object estrutura) {
        if (estrutura instanceof Array a) a.removeLast();
        else if (estrutura instanceof Linked l) l.removeLast();
    }
    private static void removerFimVarios(Object estrutura, int n) {
        for (int i = 0; i < n; i++) removerFim(estrutura);
    }
}
