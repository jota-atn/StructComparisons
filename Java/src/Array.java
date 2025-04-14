import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Array {
	private ArrayList<Integer> array;

	public Array() {
		this.array = new ArrayList<>();
	}

	public void add(String caminho) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(caminho));

		while(sc.hasNext()){
			this.array.add(sc.nextInt());
		}
	}

	public void addFirst(int numero) {
		this.array.add(0, numero);
	}

	public void addNFirst(String caminho, int carga) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(caminho));
		int aux = 0;

		while(aux < carga){
			this.array.add(0, sc.nextInt());
			aux++;
		}
	}

	public void addMiddle(int middle, int numero) {
		this.array.add(middle, numero);
	}

	public void addNMiddle(String caminho, int carga, int middle) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(caminho));
		int aux = 0;

		while(aux < carga){
			this.array.add(middle, sc.nextInt());
			aux++;
		}
	}

	public void addLast(int numero) {
		this.array.add(numero);
	}

	public void addNLast(String caminho, int carga) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(caminho));
		int aux = 0;

		while(aux < carga){
			this.array.add(sc.nextInt());
			aux++;
		}
	}

	public int getFirst() {
		return this.array.get(0);
	}

	public int getMiddle(int middle) {
		return this.array.get(middle);
	}

	public int getLast() {
		return this.array.get(this.array.size() - 1);
	}

	public void removeFirst() {
		if (!this.array.isEmpty()) {
			this.array.remove(0);
		}
	}

	public void removeNFirst(int carga){
		int aux = 0;

		if (!this.array.isEmpty()) {
			while(aux < carga) {
				this.array.remove(0);
				aux++;
			}
		}
	}

	public void removeMiddle(int middle) {
		if (!this.array.isEmpty()) {
			this.array.remove(middle);
		}
	}

	public void removeNMiddle(int carga, int middle){
		int aux = 0;

		if (!this.array.isEmpty()) {
			while(aux < carga) {
				this.array.remove(middle);
				aux++;
			}
		}
	}

	public void removeLast() {
		if (!this.array.isEmpty()) {
			this.array.remove(this.array.size() - 1);
		}
	}

	public void removeNLast(int carga){
		int aux = 0;

		if (!this.array.isEmpty()) {
			while(aux < carga) {
				this.array.remove(this.array.size() - 1);
				aux++;
			}
		}
	}

	public void clear(){
		this.array.clear();
	}
}

