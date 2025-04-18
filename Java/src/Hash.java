import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Hash {
	private HashMap<Integer, Integer> hash;
	
	public Hash() {
		this.hash = new HashMap<>();
	}
	
	public void put(String caminho) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(caminho));
		int indice = 0;

		while(sc.hasNext()){
			this.hash.put(indice, sc.nextInt());
			indice++;
		}
	}
	
	public int getKey(int key) {
		return this.hash.get(key);
	}

	public boolean contains(int numero){
		return this.hash.containsValue(numero);
	}
	
	public void remove(int key) {
		this.hash.remove(key);
	}

	public void clear(){
		this.hash.clear();
	}

}