package projeto;

import java.util.Stack;

public class PilhaQueue {
    private Stack<Integer> pilha;

    public PilhaQueue() {
        pilha = new Stack<>();
    }

    public void push(int elemento) {
        pilha.push(elemento);
    }

    public int pop() {
        if (pilha.isEmpty()) {
            throw new IllegalStateException("A pilha está vazia!");
        }
        return pilha.pop();
    }

    public int peek() {
        if (pilha.isEmpty()) {
            throw new IllegalStateException("A pilha está vazia!");
        }
        return pilha.peek();
    }

    public boolean isEmpty() {
        return pilha.isEmpty();
    }

    @Override
    public String toString() {
        return pilha.toString();
    }
}
