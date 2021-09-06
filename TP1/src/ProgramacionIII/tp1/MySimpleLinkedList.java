package ProgramacionIII.tp1;

public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public T extractFront() {		
		T retorno = this.first.getInfo();
		this.first = this.first.getNext();
		this.size--;
		return retorno;
	}

	public boolean isEmpty() {
		return this.first == null;
	}
	
	public T get(int index) {
		if ((index < this.size) && (index >= 0)) {
			Node<T> aux = this.first;
			
			for (int i = 0; i < index; i++)
				aux = aux.getNext();
			
			return aux.getInfo();
		}
		return null;
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		String retorno = new String();
		Node<T> aux = new Node<T>();
		
		aux = this.first;
		
		while (aux != null) {
			retorno += (aux.getNext() != null) ?
				"[" + aux.getInfo() + "][@" + aux.getNext().hashCode() + "] "
			:
				"[" + aux.getInfo() + "][null]";
			
			aux = aux.getNext();
		}
		return retorno;
	}
	
	public static void main(String[] args) {
		
		MySimpleLinkedList<Integer> sasarasa = new MySimpleLinkedList<Integer>();
		
		sasarasa.insertFront(123);
		sasarasa.insertFront(456);
		sasarasa.insertFront(23);
		sasarasa.insertFront(98);
		sasarasa.insertFront(1);
		
		System.out.println("Lista de nodos inicial:");
		System.out.println(sasarasa+"\n");
		System.out.println("Tamaño:");
		System.out.println(sasarasa.size()+"\n");
//		System.out.println("Primer elemento extraído:");
//		System.out.println(sasarasa.extractFront());
//		System.out.println(sasarasa.extractFront());
//		System.out.println(sasarasa.extractFront()+"\n");
//		System.out.println("¿La lista está vacía?");
//		System.out.println(sasarasa.isEmpty()+"\n");
//		System.out.println("Tamaño:");
//		System.out.println(sasarasa.size()+"\n");
//		System.out.println(sasarasa.extractFront());
//		System.out.println(sasarasa.extractFront()+"\n");
//		System.out.println("Lista de nodos luego de la extracción:");
//		System.out.println(sasarasa+"\n");
//		System.out.println("Tamaño:");
//		System.out.println(sasarasa.size()+"\n");
//		System.out.println("¿La lista está vacía?");
//		System.out.println(sasarasa.isEmpty());
		
		System.out.println(sasarasa.get(4));
		
	}
	
}
