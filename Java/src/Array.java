import java.util.ArrayList;

public class Array {
	private ArrayList<Integer> array;

	public Array() {
		this.array = new ArrayList<>();
	}

	public void add(int numero) {
		this.array.add(numero);
	}

	public void addAll(ArrayList<Integer> dados) {
		this.array.addAll(dados);
	}

	public void addFirst(int numero) {
		this.array.add(0, numero);
	}

	public void addMiddle(int numero) {
		this.array.add(this.array.size() / 2, numero);
	}

	public void addLast(int numero) {
		this.array.add(numero);
	}

	public int getFirst() {
		return this.array.get(0);
	}

	public int getMiddle() {
		return this.array.get(this.array.size() / 2);
	}

	public int getLast() {
		return this.array.get(this.array.size() - 1);
	}

	public void removeFirst() {
		if (!this.array.isEmpty()) {
			this.array.remove(0);
		}
	}

	public void removeMiddle() {
		if (!this.array.isEmpty()) {
			this.array.remove(this.array.size() / 2);
		}
	}

	public void removeLast() {
		if (!this.array.isEmpty()) {
			this.array.remove(this.array.size() - 1);
		}
	}

	public int size() {
		return this.array.size();
	}

	public void clear() {
		this.array.clear();
	}
} 
