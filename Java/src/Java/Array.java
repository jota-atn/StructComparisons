package Java;

import java.util.ArrayList;

public class Array {
	private ArrayList<Integer> array;
	
	public Array() {
		this.array = new ArrayList<>();
	}
	
	public void add(int numero) {
		this.array.add(numero);
	}
	
	public int getIndex(int index) {
		return this.array.get(index);
	}
	
	public void remove(int meio) {
		this.array.remove(meio);
	}
	
	public String toString() {
		String saida = "";
		
		for(Integer numero: this.array) {
			saida += numero.toString() + " ";
		}
		
		return saida;
	}
	
}
