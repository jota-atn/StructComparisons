import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final int quantOperacoes = 30;

    public static void main(String[] args) throws IOException {
        int[] tamanhos = {1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000,
        1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000};

        addTodos(tamanhos);
        addFirst(tamanhos);
        addNFirst(tamanhos);
        addMiddle(tamanhos);
        addNMiddle(tamanhos);
        addLast(tamanhos);
        addNLast(tamanhos);
        getFirst(tamanhos);
        getMiddle(tamanhos);
        getLast(tamanhos);
        removeFirst(tamanhos);
        removeNFirst(tamanhos);
        removeMiddle(tamanhos);
        removeNMiddle(tamanhos);
        removeLast(tamanhos);
        removeNLast(tamanhos);
        containsHash(tamanhos);
        searchTree(tamanhos);
        Min_Max_Tree(tamanhos);
        predecessor_sucessor_Tree(tamanhos);
    }

    public static void addTodos(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/fill_arraylist.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/fill_linkedlist.txt";
        String caminhoSaidaHasmap = "Java/out/hashmap/fill_hashmap.txt";
        String caminhoSaidaTree = "Java/out/AVLTree/fill_avltree.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        BufferedWriter bwH= new BufferedWriter(new FileWriter(caminhoSaidaHasmap));
        BufferedWriter bwT= new BufferedWriter(new FileWriter(caminhoSaidaTree));
        Array array = new Array();
        Linked linked = new Linked();
        Hash hash = new Hash();
        TreeAVL tree = new TreeAVL();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;
            long somaTemposHashmap = 0;
            long somaTemposTree = 0;

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();
                hash.clear();
                tree.clear();

                long inicioA = System.nanoTime();
                array.add(caminho);
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                long fimL = System.nanoTime();

                long inicioH = System.nanoTime();
                hash.put(caminho);
                long fimH = System.nanoTime();

                long inicioT = System.nanoTime();
                tree.insert(caminho);
                long fimT = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
                somaTemposHashmap += (fimH-inicioH);
                somaTemposTree += (fimT-inicioT);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);
            long mediaH = (somaTemposHashmap/quantOperacoes);
            long mediaT = (somaTemposTree/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Inserir todos os elementos no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Inserir todos os elementos no LL: " + tamanho + ";" + mediaL + "ns");

            bwH.write(tamanho+ ";" + mediaH + "\n");
            System.out.println("Inserir todos os elementos no Hash: " + tamanho + ";" + mediaH + "ns");

            bwT.write(tamanho+ ";" + mediaT + "\n");
            System.out.println("Inserir todos os elementos na Tree: " + tamanho + ";" + mediaT + "ns");
        }
        array.clear();
        linked.clear();
        hash.clear();
        tree.clear();
        bwA.close();
        bwL.close();
        bwH.close();
        bwT.close();
    }

    public static void addFirst(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/insertion_first_one_element.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/insertion_first_one_element.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.addFirst(1);
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.addFirst(1);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Inserir 1 elemento no início no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Inserir 1 elemento no início no LL: " + tamanho + ";" + mediaL + "ns");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void addNFirst(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/insertion_first_n_elements.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/insertion_first_n_elements.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            int n = (int) (tamanho*0.001);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.addNFirst(caminho, n);
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.addNFirst(caminho, n);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Inserir N elementos no início no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Inserir N elementos no início no LL: " + tamanho + ";" + mediaL + "ns");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void addMiddle(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/insertion_middle_one_element.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/insertion_middle_one_element.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            int middle = (int) (tamanho/2);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.addMiddle(middle, 1);
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.addMiddle(middle, 1);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Inserir 1 elemento no meio no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Inserir 1 elemento no meio no LL: " + tamanho + ";" + mediaL + "ns");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void addNMiddle(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/insertion_middle_n_elements.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/insertion_middle_n_elements.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            int n = (int) (tamanho*0.001);
            int middle = (int) (tamanho/2);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.addNMiddle(caminho, n, middle);
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.addNMiddle(caminho, n, middle);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Inserir N elementos no meio no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Inserir N elementos no meio no LL: " + tamanho + ";" + mediaL + "ns");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void addLast(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/insertion_last_one_element.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/insertion_last_one_element.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.addLast(1);
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.addLast(1);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Inserir 1 elemento no fim no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Inserir 1 elemento no fim no LL: " + tamanho + ";" + mediaL + "ns");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void addNLast(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/insertion_last_n_elements.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/insertion_last_n_elements.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            int n = (int) (tamanho*0.001);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.addNLast(caminho, n);
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.addNLast(caminho, n);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Inserir N elementos no fim no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Inserir N elementos no fim no LL: " + tamanho + ";" + mediaL + "ns");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void getFirst(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/get_first.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/get_first.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.getFirst();
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.getFirst();
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Acessar o primeiro elemento no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Acessar o primeiro elemento no LL: " + tamanho + ";" + mediaL + "ns");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void getMiddle(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/get_mid.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/get_mid.txt";
        String caminhoSaidaHashmap = "Java/out/hashmap/get.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        BufferedWriter bwH= new BufferedWriter(new FileWriter(caminhoSaidaHashmap));
        Array array = new Array();
        Linked linked = new Linked();
        Hash hash = new Hash();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;
            long somaTemposHash = 0;

            int middle = (int) (tamanho/2);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();
                hash.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.getMiddle(middle);
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.getMiddle(middle);
                long fimL = System.nanoTime();

                hash.put(caminho);
                long inicioH = System.nanoTime();
                hash.getKey(middle);
                long fimH = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
                somaTemposHash += (fimH-inicioH);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);
            long mediaH = (somaTemposHash/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Acessar o elemento do meio no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Acessar o elemento do meio no LL: " + tamanho + ";" + mediaL + "ns");

            bwH.write(tamanho+ ";" + mediaH + "\n");
            System.out.println("Acessar o elemento do meio Hash: " + tamanho + ";" + mediaH + "ns");
        }
        array.clear();
        linked.clear();
        hash.clear();
        bwA.close();
        bwL.close();
        bwH.close();
    }

    public static void getLast(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/get_last.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/get_last.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.getLast();
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.getLast();
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Acessar o último elemento no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Acessar o último elemento no LL: " + tamanho + ";" + mediaL + "ns");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void removeFirst(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/remove_first_one_element.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/remove_first_one_element.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.removeFirst();
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.removeFirst();
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Remover o primeiro elemento no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Remover o primeiro elemento no LL: " + tamanho + ";" + mediaL + "ns");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void removeNFirst(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/remove_first_n_elements.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/remove_first_n_elements.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            int n = (int) (tamanho*0.001);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.removeNFirst(n);
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.removeNFirst(n);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Remover N elementos no início no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Remover N elementos no início no LL: " + tamanho + ";" + mediaL + "ns");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void removeMiddle(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/remove_middle_one_element.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/remove_middle_one_element.txt";
        String caminhoSaidaHash = "Java/out/hashmap/remove_one_element.txt";
        String caminhoSaidaTree = "Java/out/AVLTree/remove_one_element.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        BufferedWriter bwH= new BufferedWriter(new FileWriter(caminhoSaidaHash));
        BufferedWriter bwT= new BufferedWriter(new FileWriter(caminhoSaidaTree));
        Array array = new Array();
        Linked linked = new Linked();
        Hash hash = new Hash();
        TreeAVL tree = new TreeAVL();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;
            long somaTemposHash = 0;
            long somaTemposTree = 0;

            int middle = (int) (tamanho/2);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();
                hash.clear();
                tree.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.removeMiddle(middle);
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.removeMiddle(middle);
                long fimL = System.nanoTime();

                hash.put(caminho);
                long inicioH = System.nanoTime();
                hash.remove(middle);
                long fimH = System.nanoTime();

                tree.insert(caminho);
                long inicioT = System.nanoTime();
                tree.deleteByIndex(middle);
                long fimT = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
                somaTemposHash += (fimH-inicioH);
                somaTemposTree += (fimT-inicioT);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);
            long mediaH = (somaTemposHash/quantOperacoes);
            long mediaT = (somaTemposTree/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Remover 1 elemento do meio no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Remover 1 elemento do meio no LL: " + tamanho + ";" + mediaL + "ns");

            bwH.write(tamanho+ ";" + mediaH + "\n");
            System.out.println("Remover 1 elemento do meio no Hash: " + tamanho + ";" + mediaH + "ns");

            bwT.write(tamanho+ ";" + mediaT + "\n");
            System.out.println("Remover 1 elemento do meio na Tree: " + tamanho + ";" + mediaT + "ns");
        }
        array.clear();
        linked.clear();
        hash.clear();
        tree.clear();
        bwA.close();
        bwL.close();
        bwH.close();
        bwT.close();
    }

    public static void removeNMiddle(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/remove_middle_n_elements.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/remove_middle_n_elements.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            int n = (int) (tamanho*0.001);
            int middle = (int) (tamanho/2);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.removeNMiddle(n, middle);
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.removeNMiddle(n, middle);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Remover N elementos do meio no Al: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Remover N elementos do meio no LL: " + tamanho + ";" + mediaL + "ns");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void removeLast(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/remove_last_one_element.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/remove_last_one_element.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.removeLast();
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.removeLast();
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Remover o último elemento no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Remover o último elemento no LL: " + tamanho + ";" + mediaL + "ns");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void removeNLast(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/remove_last_n_elements.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/remove_last_n_elements.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            int n = (int) (tamanho*0.001);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                array.add(caminho);
                long inicioA = System.nanoTime();
                array.removeNLast(n);
                long fimA = System.nanoTime();

                linked.add(caminho);
                long inicioL = System.nanoTime();
                linked.removeNLast(n);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes);
            long mediaL = (somaTemposLinked/quantOperacoes);

            bwA.write(tamanho + ";" + mediaA + "\n");
            System.out.println("Remover N elementos no fim no AL: " + tamanho + ";" + mediaA + "ns");

            bwL.write(tamanho+ ";" + mediaL + "\n");
            System.out.println("Remover N elementos no fim no LL: " + tamanho + ";" + mediaL + "ns");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void containsHash(int[] tamanhos) throws IOException {
        String caminhoSaidaHash = "Java/out/hashmap/contains.txt";
        BufferedWriter bwH = new BufferedWriter(new FileWriter(caminhoSaidaHash));
        Hash hash = new Hash();

        for(int tamanho: tamanhos) {
            long somaTemposHash = 0;

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                hash.clear();

                hash.put(caminho);
                long inicioH = System.nanoTime();
                hash.contains(10000000);
                long fimH = System.nanoTime();

                somaTemposHash += (fimH-inicioH);
            }
            long mediaH = (somaTemposHash/quantOperacoes);

            bwH.write(tamanho + ";" + mediaH + "\n");
            System.out.println("Verifica se contém o elemento no hashmap: " + tamanho + ";" + mediaH + "ns");
        }
        hash.clear();
        bwH.close();
    }

    public static void searchTree(int[] tamanhos) throws IOException {
        String caminhoSaidaTree = "Java/out/AVLTree/search.txt";
        BufferedWriter bwT = new BufferedWriter(new FileWriter(caminhoSaidaTree));
        TreeAVL tree = new TreeAVL();

        for(int tamanho: tamanhos) {
            long somaTemposTree = 0;

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                tree.clear();

                tree.insert(caminho);
                long inicioT = System.nanoTime();
                tree.search(10000000);
                long fimT = System.nanoTime();

                somaTemposTree += (fimT-inicioT);
            }
            long mediaT = (somaTemposTree/quantOperacoes);

            bwT.write(tamanho + ";" + mediaT + "\n");
            System.out.println("Faz uma busca no Tree AVL: " + tamanho + ";" + mediaT + "ns");
        }
        tree.clear();
        bwT.close();
    }

    public static void Min_Max_Tree(int[] tamanhos) throws IOException {
        String caminhoSaidaTreeMin = "Java/out/AVLTree/min_value.txt";
        String caminhoSaidaTreeMax = "Java/out/AVLTree/max_value.txt";
        BufferedWriter bwTMin = new BufferedWriter(new FileWriter(caminhoSaidaTreeMin));
        BufferedWriter bwTMax = new BufferedWriter(new FileWriter(caminhoSaidaTreeMax));
        TreeAVL tree = new TreeAVL();

        for(int tamanho: tamanhos) {
            long somaTemposTreeMin = 0;
            long somaTemposTreeMax = 0;

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                tree.clear();

                tree.insert(caminho);
                long inicioTMin = System.nanoTime();
                tree.MinNode();
                long fimTMin = System.nanoTime();

                long inicioTMax = System.nanoTime();
                tree.MaxNode();
                long fimTMax = System.nanoTime();

                somaTemposTreeMin += (fimTMin-inicioTMin);
                somaTemposTreeMax += (fimTMax-inicioTMax);
            }
            long mediaTMin = (somaTemposTreeMin/quantOperacoes);
            long mediaTMax = (somaTemposTreeMax/quantOperacoes);

            bwTMin.write(tamanho + ";" + mediaTMin + "\n");
            System.out.println("Busca o valor min de uma Tree AVL: " + tamanho + ";" + mediaTMin + "ns");

            bwTMax.write(tamanho + ";" + mediaTMax + "\n");
            System.out.println("Busca o valor max de uma Tree AVL: " + tamanho + ";" + mediaTMax + "ns");
        }
        tree.clear();
        bwTMin.close();
        bwTMax.close();
    }

    public static void predecessor_sucessor_Tree(int[] tamanhos) throws IOException {
        String caminhoSaidaTreePred = "Java/out/AVLTree/predecessor.txt";
        String caminhoSaidaTreeSuc = "Java/out/AVLTree/sucessor.txt";
        BufferedWriter bwTPred = new BufferedWriter(new FileWriter(caminhoSaidaTreePred));
        BufferedWriter bwTSuc = new BufferedWriter(new FileWriter(caminhoSaidaTreeSuc));
        TreeAVL tree = new TreeAVL();

        for(int tamanho: tamanhos) {
            long somaTemposTreePred = 0;
            long somaTemposTreeSuc = 0;

            int middle = (int) (tamanho/2);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                tree.clear();

                tree.insert(caminho);
                long inicioTPred = System.nanoTime();
                tree.predecessorByIndex(middle);
                long fimTPred = System.nanoTime();

                long inicioTSuc = System.nanoTime();
                tree.sucessorByIndex(middle);
                long fimTSuc = System.nanoTime();

                somaTemposTreePred += (fimTPred-inicioTPred);
                somaTemposTreeSuc += (fimTSuc-inicioTSuc);
            }
            long mediaTPred = (somaTemposTreePred/quantOperacoes);
            long mediaTSuc = (somaTemposTreeSuc/quantOperacoes);

            bwTPred.write(tamanho + ";" + mediaTPred + "\n");
            System.out.println("Busca o predecessor do elemento central da Tree AVL: " + tamanho + ";" + mediaTPred + "ns");

            bwTSuc.write(tamanho + ";" + mediaTSuc + "\n");
            System.out.println("Busca o sucessor do elemento central da Tree AVL: " + tamanho + ";" + mediaTSuc + "ns");
        }
        tree.clear();
        bwTPred.close();
        bwTSuc.close();
    }
}
