package Java;

import java.util.ArrayList;
import java.util.Random;

public class GeradorNumeros {
    public static void main(String[] args) {
        int tamanhoCarga = 1000; 
        int valorMeio = 10/2;
        ArrayList<Integer> numeros = gerarNumerosAleatorios(tamanhoCarga);
        
        Array array = new Array();
        long tempoInicial1 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            array.add(numeros.get(i));
        }
        long tempoFinal1 = System.nanoTime();
        long tempoExecucao1 = tempoFinal1 - tempoInicial1;
        
        Linked linked = new Linked();
        long tempoInicial2 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            linked.add(numeros.get(i));
        }
        long tempoFinal2 = System.nanoTime();
        long tempoExecucao2 = tempoFinal2 - tempoInicial2;
        
        Hash hash = new Hash();
        long tempoInicial3 = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            hash.put(numeros.get(i));
        }
        long tempoFinal3 = System.nanoTime();
        long tempoExecucao3 = tempoFinal3 - tempoInicial3;
            
        System.out.println("Array.add: " + array.toString());
        System.out.println("Tempo de execução ArrayList: " + tempoExecucao1 + " nanosegundos" + "\n");
        System.out.println("Linked.add: " + linked.toString());
        System.out.println("Tempo de execução LinkedList: " + tempoExecucao2 + " nanosegundos" + "\n");
        System.out.println("Hash.put: " + hash.toString());
        System.out.println("Tempo de execução HashMap: " + tempoExecucao3 + " nanosegundos" + "\n");
        System.out.println("--------------------------------------------------------------");
        
        long tempoInicial4 = System.nanoTime();
        System.out.println("Valor Meio Array: " + array.getIndex(valorMeio));
        long tempoFinal4 = System.nanoTime();
        long tempoExecucao4 = tempoFinal4 - tempoInicial4;
        System.out.println("Tempo de execução ArrayList: " + tempoExecucao4 + " nanosegundos" + "\n");
        long tempoInicial5 = System.nanoTime();
        System.out.println("Valor Meio Linked: " + linked.getIndex(valorMeio));
        long tempoFinal5 = System.nanoTime();
        long tempoExecucao5 = tempoFinal5 - tempoInicial5;
        System.out.println("Tempo de execução LinkedList: " + tempoExecucao5 + " nanosegundos" + "\n");
        long tempoInicial6 = System.nanoTime();
        System.out.println("Valor Meio Hash: " + hash.getIndex(valorMeio));
        long tempoFinal6 = System.nanoTime();
        long tempoExecucao6 = tempoFinal6 - tempoInicial6;
        System.out.println("Tempo de execução HashMap: " + tempoExecucao6 + " nanosegundos" + "\n");
        System.out.println("--------------------------------------------------------------");
        
        long tempoInicial7 = System.nanoTime();
        array.remove(valorMeio);
        long tempoFinal7 = System.nanoTime();
        long tempoExecucao7 = tempoFinal7 - tempoInicial7;
        System.out.println("Array.remove: " + array.toString());
        System.out.println("Tempo de execução ArrayList: " + tempoExecucao7 + " nanosegundos" + "\n");
        long tempoInicial8 = System.nanoTime();
        linked.remove(valorMeio);
        long tempoFinal8 = System.nanoTime();
        long tempoExecucao8 = tempoFinal8 - tempoInicial8;
        System.out.println("Linked.remove: " + linked.toString());
        System.out.println("Tempo de execução LinkedList: " + tempoExecucao8 + " nanosegundos" + "\n");
        long tempoInicial9 = System.nanoTime();
        hash.remove(valorMeio);
        long tempoFinal9 = System.nanoTime();
        long tempoExecucao9 = tempoFinal9 - tempoInicial9;
        System.out.println("Hash.remove: " + hash.toString());
        System.out.println("Tempo de execução HashMap: " + tempoExecucao9 + " nanosegundos" + "\n");
    }

    public static ArrayList<Integer> gerarNumerosAleatorios(int quantidade) {
        ArrayList<Integer> lista = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            lista.add(random.nextInt(10000));
        }

        return lista;
    }
}


