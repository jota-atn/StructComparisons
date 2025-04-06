import java.io.*;

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

    }

    public static void addTodos(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/insertionAll.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/insertionAll.txt";
        String caminhoSaidaHasmap = "Java/out/hashmap/insertionAll.txt";
        String caminhoSaidaTree = "Java/out/AVLTree/insertionAll.txt";
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
                //tree.insert(caminho);
                long fimT = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
                somaTemposHashmap += (fimH-inicioH);
                somaTemposTree += (fimT-inicioT);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;
            long mediaH = (somaTemposHashmap/quantOperacoes)/1000;
            long mediaT = (somaTemposTree/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");

            bwH.write(tamanho+ ";" + mediaH + "µs\n");
            System.out.println(tamanho + ";" + mediaH + "µs");

            bwT.write(tamanho+ ";" + mediaT + "µs\n");
            System.out.println(tamanho + ";" + mediaT + "µs");
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
        String caminhoSaidaArray = "Java/out/arraylist/insertionFirst.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/insertionFirst.txt";
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

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.addFirst(1);
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.addFirst(1);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void addNFirst(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/insertionNFirst.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/insertionNFirst.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            int n = (int) (tamanho*0.1);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.addNFirst(caminho, n);
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.addNFirst(caminho, n);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void addMiddle(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/insertionMiddle.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/insertionMiddle.txt";
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

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.addMiddle(middle, 1);
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.addMiddle(middle, 1);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void addNMiddle(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/insertionNMiddle.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/insertionNMiddle.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            int n = (int) (tamanho*0.1);
            int middle = (int) (tamanho/2);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.addNMiddle(caminho, n, middle);
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.addNMiddle(caminho, n, middle);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void addLast(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/insertionLast.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/insertionLast.txt";
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

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.addLast(1);
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.addLast(1);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void addNLast(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/insertionNLast.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/insertionNLast.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            int n = (int) (tamanho*0.1);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.addNLast(caminho, n);
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.addNLast(caminho, n);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void getFirst(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/getFirst.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/getFirst.txt";
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

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.getFirst();
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.getFirst();
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void getMiddle(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/getMiddle.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/getMiddle.txt";
        String caminhoSaidaHashmap = "Java/out/hashmap/getIndex.txt";
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

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.getMiddle(middle);
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.getMiddle(middle);
                long fimL = System.nanoTime();

                long inicioH = System.nanoTime();
                hash.put(caminho);
                hash.getKey(middle);
                long fimH = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
                somaTemposHash += (fimH-inicioH);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;
            long mediaH = (somaTemposHash/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");

            bwH.write(tamanho+ ";" + mediaH + "µs\n");
            System.out.println(tamanho + ";" + mediaH + "µs");
        }
        array.clear();
        linked.clear();
        hash.clear();
        bwA.close();
        bwL.close();
        bwH.close();
    }

    public static void getLast(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/getLast.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/getLast.txt";
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

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.getLast();
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.getLast();
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void removeFirst(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/removeFirst.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/removeFirst.txt";
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

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.removeFirst();
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.removeFirst();
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void removeNFirst(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/removeNFirst.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/removeNFirst.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            int n = (int) (tamanho*0.1);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.removeNFirst(n);
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.removeNFirst(n);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void removeMiddle(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/removeMiddle.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/removeMiddle.txt";
        String caminhoSaidaHash = "Java/out/hashmap/removeIndex.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        BufferedWriter bwH= new BufferedWriter(new FileWriter(caminhoSaidaHash));
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

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.removeMiddle(middle);
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.removeMiddle(middle);
                long fimL = System.nanoTime();

                long inicioH = System.nanoTime();
                hash.put(caminho);
                hash.remove(middle);
                long fimH = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
                somaTemposHash += (fimH-inicioH);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;
            long mediaH = (somaTemposHash/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");

            bwH.write(tamanho+ ";" + mediaH + "µs\n");
            System.out.println(tamanho + ";" + mediaH + "µs");
        }
        array.clear();
        linked.clear();
        hash.clear();
        bwA.close();
        bwL.close();
        bwH.close();
    }

    public static void removeNMiddle(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/removeNMiddle.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/removeNMiddle.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            int n = (int) (tamanho*0.1);
            int middle = (int) (tamanho/2);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.removeNMiddle(n, middle);
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.removeNMiddle(n, middle);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void removeLast(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/removeLast.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/removeLast.txt";
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

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.removeLast();
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.removeLast();
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }

    public static void removeNLast(int[] tamanhos) throws IOException {
        String caminhoSaidaArray = "Java/out/arraylist/removeNLast.txt";
        String caminhoSaidaLinked = "Java/out/linkedlist/removeNLast.txt";
        BufferedWriter bwA = new BufferedWriter(new FileWriter(caminhoSaidaArray));
        BufferedWriter bwL= new BufferedWriter(new FileWriter(caminhoSaidaLinked));
        Array array = new Array();
        Linked linked = new Linked();

        for(int tamanho: tamanhos) {
            long somaTemposArray = 0;
            long somaTemposLinked = 0;

            int n = (int) (tamanho*0.1);

            String caminho = "scripts/inputs/dataset_" + tamanho + ".txt";

            for (int i = 0; i < quantOperacoes; i++) {
                array.clear();
                linked.clear();

                long inicioA = System.nanoTime();
                array.add(caminho);
                array.removeNLast(n);
                long fimA = System.nanoTime();

                long inicioL = System.nanoTime();
                linked.add(caminho);
                linked.removeNLast(n);
                long fimL = System.nanoTime();

                somaTemposArray += (fimA-inicioA);
                somaTemposLinked += (fimL-inicioL);
            }
            long mediaA = (somaTemposArray/quantOperacoes)/1000;
            long mediaL = (somaTemposLinked/quantOperacoes)/1000;

            bwA.write(tamanho + ";" + mediaA + "µs\n");
            System.out.println(tamanho + ";" + mediaA + "µs");

            bwL.write(tamanho+ ";" + mediaL + "µs\n");
            System.out.println(tamanho + ";" + mediaL + "µs");
        }
        array.clear();
        linked.clear();
        bwA.close();
        bwL.close();
    }
}
