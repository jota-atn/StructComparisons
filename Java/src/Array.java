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

	@Override
	public String toString() {
		StringBuilder saida = new StringBuilder();
		for (Integer numero : this.array) {
			saida.append(numero).append(" ");
		}
		return saida.toString().trim();
	}


}