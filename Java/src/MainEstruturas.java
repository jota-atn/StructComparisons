import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainEstruturas {
    public static void main(String[] args) throws FileNotFoundException {
        String[] arquivos = {
                "scripts/inputs/dataset_1000.txt",
                "scripts/inputs/dataset_10000.txt",
                "scripts/inputs/dataset_100000.txt",
                "scripts/inputs/dataset_1000000.txt",
                "scripts/inputs/dataset_10000000.txt"
        };
        int[] cargas = {0, 1000, 10000, 100000, 1000000, 10000000};

        for(String caminho: arquivos) {
            cargas = shiftLeft(cargas);
            int meio = cargas[0] / 2;
            int n = (int) (cargas[0] * 0.001);
            int cont = 0;

            File arquivo = new File(caminho);
            Scanner sc = new Scanner(arquivo);

            //inserir todos os elementos da carga.
            Array array = new Array();
            long tempoInicial1 = System.nanoTime();
            while (sc.hasNextInt()) {
                array.add(sc.nextInt());
            }
            long tempoFinal1 = System.nanoTime();
            long tempoAddAll1 = (tempoFinal1 - tempoInicial1) / 1000;

            //inserir um elemento no primeiro índice.
            long tempoInicial1_1 = System.nanoTime();
            array.addFirst(1);
            long tempoFinal1_1 = System.nanoTime();
            long tempoAddFirst1_1 = (tempoFinal1_1 - tempoInicial1_1) / 1000;

            //inserir um elemento no meio.
            long tempoInicial1_2 = System.nanoTime();
            array.addMeio(meio, 2);
            long tempoFinal1_2 = System.nanoTime();
            long tempoAddMeio1_2 = (tempoFinal1_2 - tempoInicial1_2) / 1000;

            //inserir um elemento no final.
            long tempoInicial1_3 = System.nanoTime();
            array.addLast(3);
            long tempoFinal1_3 = System.nanoTime();
            long tempoAddLast1_3 = (tempoFinal1_3 - tempoInicial1_3) / 1000;

            //inserir n elementos no inicio.
            long tempoInicial2_1 = System.nanoTime();
            while (cont < n) {
                array.addFirst(sc.nextInt());
                cont++;
            }
            long tempoFinal2_1 = System.nanoTime();
            long tempoAddNFirst= (tempoFinal2_1 - tempoInicial2_1)/1000;
            cont = 0;

            //inserir n elementos no meio.
            long tempoInicial2_2 = System.nanoTime();
            while (cont < n) {
                array.addMeio(meio, sc.nextInt());
                cont++;
            }
            long tempoFinal2_2 = System.nanoTime();
            long tempoAddNMeio= (tempoFinal2_2 - tempoInicial2_2)/1000;
            cont = 0;

            //inserir n elementos no final.
            long tempoInicial2_3 = System.nanoTime();
            while (cont < n) {
                array.addLast(sc.nextInt());
                cont++;
            }
            long tempoFinal2_3 = System.nanoTime();
            long tempoAddNFinal= (tempoFinal2_3 - tempoInicial2_3)/1000;
            cont = 0;

            System.out.println("Array.add: " + array.toString());
            System.out.println("Tempo de execução ArrayList: " + " microsegundos" + "\n");

            sc = new Scanner(arquivo);
            Linked linked = new Linked();
            long tempoInicial2 = System.nanoTime();
            while (sc.hasNextInt()) {
                linked.add(sc.nextInt());
            }
            long tempoFinal2 = System.nanoTime();
            long tempoExecucao2 = (tempoFinal2 - tempoInicial2) / 1000;
            System.out.println("Linked.add: " + linked.toString());
            System.out.println("Tempo de execução LinkedList: " + tempoExecucao2 + " microsegundos" + "\n");

            sc = new Scanner(arquivo);
            Hash hash = new Hash();
            long tempoInicial3 = System.nanoTime();
            while (sc.hasNextInt()) {
                hash.put(sc.nextInt());
            }
            long tempoFinal3 = System.nanoTime();
            long tempoExecucao3 = (tempoFinal3 - tempoInicial3) / 1000;
            System.out.println("Hash.put: " + hash.toString());
            System.out.println("Tempo de execução HashMap: " + tempoExecucao3 + " microsegundos" + "\n");

            sc = new Scanner(arquivo);
            TreeAVL tree = new TreeAVL();
            long tempoInicial4 = System.nanoTime();
            while (sc.hasNextInt()) {
                tree.delete(sc.nextInt());
            }
            long tempoFinal4 = System.nanoTime();
            long tempoExecucao4 = (tempoFinal4 - tempoInicial4) / 1000;
            System.out.println("Tree.add: " + tree.toString());
            System.out.println("Tempo de execução Tree: " + tempoExecucao4 + " microsegundos" + "\n");

            System.out.println("--------------------------------------------------------------");

            long tempoInicial5 = System.nanoTime();
            System.out.println("Valor Array: " + array.getIndex(500));
            long tempoFinal5 = System.nanoTime();
            long tempoExecucao5 = (tempoFinal5 - tempoInicial5) / 1000;
            System.out.println("Tempo de execução ArrayList: " + tempoExecucao5 + " microsegundos" + "\n");
            long tempoInicial6 = System.nanoTime();
            System.out.println("Valor Linked: " + linked.getIndex(500));
            long tempoFinal6 = System.nanoTime();
            long tempoExecucao6 = (tempoFinal6 - tempoInicial6) / 1000;
            System.out.println("Tempo de execução LinkedList: " + tempoExecucao6 + " microsegundos" + "\n");
            long tempoInicial7 = System.nanoTime();
            System.out.println("Valor Hash: " + hash.getKey(500));
            long tempoFinal7 = System.nanoTime();
            long tempoExecucao7 = (tempoFinal7 - tempoInicial7) / 1000;
            System.out.println("Tempo de execução HashMap: " + tempoExecucao7 + " microsegundos" + "\n");
            long tempoInicial8 = System.nanoTime();
            System.out.println("Valor Tree: " + tree.search(500));
            long tempoFinal8 = System.nanoTime();
            long tempoExecucao8 = (tempoFinal8 - tempoInicial8) / 1000;
            System.out.println("Tempo de execução Tree: " + tempoExecucao8 + " microsegundos" + "\n");

            System.out.println("--------------------------------------------------------------");

            long tempoInicial9 = System.nanoTime();
            array.remove(500);
            long tempoFinal9 = System.nanoTime();
            long tempoExecucao9 = (tempoFinal9 - tempoInicial9) / 1000;
            System.out.println("Array.remove: " + array.toString());
            System.out.println("Tempo de execução ArrayList: " + tempoExecucao9 + " microsegundos" + "\n");
            long tempoInicial10 = System.nanoTime();
            linked.remove(500);
            long tempoFinal10 = System.nanoTime();
            long tempoExecucao10 = (tempoFinal10 - tempoInicial10) / 1000;
            System.out.println("Linked.remove: " + linked.toString());
            System.out.println("Tempo de execução LinkedList: " + tempoExecucao10 + " microsegundos" + "\n");
            long tempoInicial11 = System.nanoTime();
            hash.remove(500);
            long tempoFinal11 = System.nanoTime();
            long tempoExecucao11 = (tempoFinal11 - tempoInicial11) / 1000;
            System.out.println("Hash.remove: " + hash.toString());
            System.out.println("Tempo de execução HashMap: " + tempoExecucao11 + " microsegundos" + "\n");
            long tempoInicial12 = System.nanoTime();
            array.remove(500);
            long tempoFinal12 = System.nanoTime();
            long tempoExecucao12 = (tempoFinal12 - tempoInicial12) / 1000;
            System.out.println("Tree.remove: " + tree.toString());
            System.out.println("Tempo de execução Tree: " + tempoExecucao12 + " microsegundos" + "\n");
        }
    }

    public static int[] shiftLeft(int[] array) {
        if (array.length == 0) return array;

        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        array[array.length - 1] = 0;

        return array;
    }
}
