package Java;

import java.util.LinkedList;

public class Linked {
	private LinkedList<Integer> linked;
	
	public Linked() {
		this.linked = new LinkedList<>();
	}
	
	public void add(int numero) {
		this.linked.add(numero);
	}
	
	public int getIndex(int index) {
		return this.linked.get(index);
	}
	
	public void remove(int meio) {
		this.linked.remove(meio);
	}
	
	public String toString() {
		String saida = "";
		
		for(Integer numero: this.linked) {
			saida += numero.toString() + " ";
		}
		return saida;
	}

}
