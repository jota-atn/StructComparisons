package projeto;

public class Main {
    public static void main(String[] args) {
       
        PilhaQueue pilha = new PilhaQueue();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        System.out.println("Pilha: " + pilha);
        System.out.println("Elemento removido da pilha: " + pilha.pop());
        System.out.println("Pilha após remoção: " + pilha);
        System.out.println("Elemento no topo da pilha: " + pilha.peek());
        System.out.println("A pilha está vazia? " + pilha.isEmpty());
        System.out.println();

        FilaStack fila = new FilaStack();
        fila.offer("Alice");
        fila.offer("Bob");
        fila.offer("Charlie");
        System.out.println("Fila: " + fila);
        System.out.println("Elemento removido da fila: " + fila.poll());
        System.out.println("Fila após remoção: " + fila);
        System.out.println("Elemento na frente da fila: " + fila.peek());
        System.out.println("A fila está vazia? " + fila.isEmpty());
    }
}