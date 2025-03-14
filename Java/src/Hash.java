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
	
	public int getKey(int key) {
		return this.hash.get(key);
	}
	
	public void remove(int meio) {
		this.hash.remove(meio);
	}

	@Override
	public String toString() {
		StringBuilder saida = new StringBuilder();
		for (Map.Entry<Integer, Integer> entry : this.hash.entrySet()) {
			saida.append(entry.getValue()).append(" ");
		}
		return saida.toString().trim();
	}


}