import java.util.LinkedList;

public class Linked {
	private LinkedList<Integer> list;

	public Linked() {
		this.list = new LinkedList<>();
	}

	public void add(int numero) {
		this.list.add(numero);
	}

	public void addAll(LinkedList<Integer> dados) {
		this.list.addAll(dados);
	}

	public void addFirst(int numero) {
		this.list.addFirst(numero);
	}

	public void addMiddle(int numero) {
		this.list.add(this.list.size() / 2, numero);
	}

	public void addLast(int numero) {
		this.list.addLast(numero);
	}

	public int getFirst() {
		return this.list.getFirst();
	}

	public int getMiddle() {
		return this.list.get(this.list.size() / 2);
	}

	public int getLast() {
		return this.list.getLast();
	}

	public void removeFirst() {
		if (!this.list.isEmpty()) {
			this.list.removeFirst();
		}
	}

	public void removeMiddle() {
		if (!this.list.isEmpty()) {
			this.list.remove(this.list.size() / 2);
		}
	}

	public void removeLast() {
		if (!this.list.isEmpty()) {
			this.list.removeLast();
		}
	}

	public int size() {
		return this.list.size();
	}

	public void clear() {
		this.list.clear();
	}
} 
