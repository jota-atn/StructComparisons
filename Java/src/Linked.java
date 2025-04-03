import java.util.LinkedList;

public class Linked {
	private LinkedList<Integer> linked;
	
	public Linked() {
		this.linked = new LinkedList<>();
	}
	
	public void add(int numero) {
		this.linked.add(numero);
	}

	public void addFirst(int numero){ this.linked.addFirst(numero);}

	public void addMeio(int index, int numero){ this.linked.add(index, numero);}

	public void addLast(int numero){ this.linked.addLast(numero);}

	public int getIndex(int index) {
		return this.linked.get(index);
	}
	
	public void remove(int meio) {
		this.linked.remove(meio);
	}

}