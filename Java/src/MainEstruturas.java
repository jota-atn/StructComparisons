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
        for(String caminho: arquivos) {
            File arquivo = new File(caminho);
            Scanner sc = new Scanner(arquivo);

            Array array = new Array();
            long tempoInicial1 = System.nanoTime();
            while (sc.hasNextInt()) {
                array.add(sc.nextInt());
            }
            long tempoFinal1 = System.nanoTime();
            long tempoExecucao1 = tempoFinal1 - tempoInicial1;
            System.out.println("Array.add: " + array.toString());
            System.out.println("Tempo de execução ArrayList: " + tempoExecucao1 + " nanosegundos" + "\n");

            sc = new Scanner(arquivo);
            Linked linked = new Linked();
            long tempoInicial2 = System.nanoTime();
            while (sc.hasNextInt()) {
                linked.add(sc.nextInt());
            }
            long tempoFinal2 = System.nanoTime();
            long tempoExecucao2 = tempoFinal2 - tempoInicial2;
            System.out.println("Linked.add: " + linked.toString());
            System.out.println("Tempo de execução LinkedList: " + tempoExecucao2 + " nanosegundos" + "\n");

            sc = new Scanner(arquivo);
            Hash hash = new Hash();
            long tempoInicial3 = System.nanoTime();
            while (sc.hasNextInt()) {
                hash.put(sc.nextInt());
            }
            long tempoFinal3 = System.nanoTime();
            long tempoExecucao3 = tempoFinal3 - tempoInicial3;
            System.out.println("Hash.put: " + hash.toString());
            System.out.println("Tempo de execução HashMap: " + tempoExecucao3 + " nanosegundos" + "\n");

            sc = new Scanner(arquivo);
            Tree tree = new Tree();
            long tempoInicial4 = System.nanoTime();
            while (sc.hasNextInt()) {
                tree.recursiveAdd(sc.nextInt());
            }
            long tempoFinal4 = System.nanoTime();
            long tempoExecucao4 = tempoFinal4 - tempoInicial4;
            System.out.println("Tree.add: " + tree.toString());
            System.out.println("Tempo de execução Tree: " + tempoExecucao4 + " nanosegundos" + "\n");

            System.out.println("--------------------------------------------------------------");

            long tempoInicial5 = System.nanoTime();
            System.out.println("Valor Array: " + array.getIndex(500));
            long tempoFinal5 = System.nanoTime();
            long tempoExecucao5 = tempoFinal5 - tempoInicial5;
            System.out.println("Tempo de execução ArrayList: " + tempoExecucao5 + " nanosegundos" + "\n");
            long tempoInicial6 = System.nanoTime();
            System.out.println("Valor Linked: " + linked.getIndex(500));
            long tempoFinal6 = System.nanoTime();
            long tempoExecucao6 = tempoFinal6 - tempoInicial6;
            System.out.println("Tempo de execução LinkedList: " + tempoExecucao6 + " nanosegundos" + "\n");
            long tempoInicial7 = System.nanoTime();
            System.out.println("Valor Hash: " + hash.getKey(500));
            long tempoFinal7 = System.nanoTime();
            long tempoExecucao7 = tempoFinal7 - tempoInicial7;
            System.out.println("Tempo de execução HashMap: " + tempoExecucao7 + " nanosegundos" + "\n");
            long tempoInicial8 = System.nanoTime();
            System.out.println("Valor Tree: " + tree.recursiveSearch(500));
            long tempoFinal8 = System.nanoTime();
            long tempoExecucao8 = tempoFinal8 - tempoInicial8;
            System.out.println("Tempo de execução Tree: " + tempoExecucao8 + " nanosegundos" + "\n");

            System.out.println("--------------------------------------------------------------");

            long tempoInicial9 = System.nanoTime();
            array.remove(500);
            long tempoFinal9 = System.nanoTime();
            long tempoExecucao9 = tempoFinal9 - tempoInicial9;
            System.out.println("Array.remove: " + array.toString());
            System.out.println("Tempo de execução ArrayList: " + tempoExecucao9 + " nanosegundos" + "\n");
            long tempoInicial10 = System.nanoTime();
            linked.remove(500);
            long tempoFinal10 = System.nanoTime();
            long tempoExecucao10 = tempoFinal10 - tempoInicial10;
            System.out.println("Linked.remove: " + linked.toString());
            System.out.println("Tempo de execução LinkedList: " + tempoExecucao10 + " nanosegundos" + "\n");
            long tempoInicial11 = System.nanoTime();
            hash.remove(500);
            long tempoFinal11 = System.nanoTime();
            long tempoExecucao11 = tempoFinal11 - tempoInicial11;
            System.out.println("Hash.remove: " + hash.toString());
            System.out.println("Tempo de execução HashMap: " + tempoExecucao11 + " nanosegundos" + "\n");
            long tempoInicial12 = System.nanoTime();
            array.remove(500);
            long tempoFinal12 = System.nanoTime();
            long tempoExecucao12 = tempoFinal12 - tempoInicial12;
            System.out.println("Tree.remove: " + tree.toString());
            System.out.println("Tempo de execução Tree: " + tempoExecucao12 + " nanosegundos" + "\n");
        }
    }
}