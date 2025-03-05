package Java;

import java.util.Map;
import java.util.HashMap;

public class Hash {
	private HashMap<Integer, Integer> hash;
	private int indice;
	
	public Hash() {
		this.hash = new HashMap<>();
		this.indice = 0;
	}
	
	public void put(int numero) {
		this.hash.put(indice, numero);
		this.indice++;
	}
	
	public int getIndex(int index) {
		return this.hash.get(index);
	}
	
	public void remove(int meio) {
		this.hash.remove(meio);
	}
	
	public String toString() {
		String saida = "";
		
		for(Map.Entry<Integer, Integer> numero : this.hash.entrySet()) {
			saida += numero.getValue() + " ";
		}
		return saida;
	}

}
