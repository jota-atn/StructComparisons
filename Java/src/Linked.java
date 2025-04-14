import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Linked {
	private LinkedList<Integer> linked;

	public Linked() {
		this.linked = new LinkedList<>();
	}

	public void add(String caminho) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(caminho));

		while(sc.hasNext()){
			this.linked.add(sc.nextInt());
		}
	}

	public void addFirst(int numero) {
		this.linked.addFirst(numero);
	}

	public void addNFirst(String caminho, int carga) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(caminho));
		int aux = 0;

		while(aux < carga){
			this.linked.addFirst(sc.nextInt());
			aux++;
		}
	}

	public void addMiddle(int middle, int numero) {
		this.linked.add(middle, numero);
	}

	public void addNMiddle(String caminho, int carga, int middle) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(caminho));
		int aux = 0;

		while(aux < carga){
			this.linked.add(middle, sc.nextInt());
			aux++;
		}
	}
	public void addLast(int numero) {
		this.linked.addLast(numero);
	}

	public void addNLast(String caminho, int carga) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(caminho));
		int aux = 0;

		while(aux < carga){
			this.linked.addLast(sc.nextInt());
			aux++;
		}
	}

	public int getFirst() {
		return this.linked.getFirst();
	}

	public int getMiddle(int middle) {
		return this.linked.get(middle);
	}

	public int getLast() {
		return this.linked.getLast();
	}

	public void removeFirst() {
		if (!this.linked.isEmpty()) {
			this.linked.removeFirst();
		}
	}

	public void removeNFirst(int carga){
		int aux = 0;

		if (!this.linked.isEmpty()) {
			while(aux < carga) {
				this.linked.remove(0);
				aux++;
			}
		}
	}

	public void removeMiddle(int middle) {
		if (!this.linked.isEmpty()) {
			this.linked.remove(middle);
		}
	}

	public void removeNMiddle(int carga, int middle){
		int aux = 0;

		if (!this.linked.isEmpty()) {
			while(aux < carga) {
				this.linked.remove(middle);
				aux++;
			}
		}
	}

	public void removeLast() {
		if (!this.linked.isEmpty()) {
			this.linked.removeLast();
		}
	}

	public void removeNLast(int carga){
		int aux = 0;

		if (!this.linked.isEmpty()) {
			while(aux < carga) {
				this.linked.removeLast();
				aux++;
			}
		}
	}

	public void clear() {
		this.linked.clear();
	}
}

