package projeto;

import java.util.LinkedList;
import java.util.Queue;

public class FilaQueue {
    private Queue<String> fila;

    public FilaQueue() {
        fila = new LinkedList<>();
    }

    public void offer(String elemento) {
        fila.offer(elemento);
    }

    public String poll() {
        if (fila.isEmpty()) {
            throw new IllegalStateException("A fila está vazia!");
        }
        return fila.poll();
    }

    public String peek() {
        if (fila.isEmpty()) {
            throw new IllegalStateException("A fila está vazia!");
        }
        return fila.peek();
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    @Override
    public String toString() {
        return fila.toString();
    }
}
