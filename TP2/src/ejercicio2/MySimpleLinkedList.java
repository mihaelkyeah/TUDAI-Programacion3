package ejercicio2;

// Archivo copiado del proyecto TP1
// (esa mala práctica sí se puede ver :D)

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
	
	// TP2 EJ2
	public boolean encuentraElemento(T infoElemento) {
		return this.estaElElementoEnLaLista(this.first, infoElemento);
	}
	
	private boolean estaElElementoEnLaLista(Node<T> primero, T infoElemento) {
		boolean seEncuentra = false;
		
		if(primero != null)
			if(!primero.getInfo().equals(infoElemento))
				seEncuentra = estaElElementoEnLaLista(primero.getNext(), infoElemento);
			else
				seEncuentra = true;
		
		return seEncuentra;
	}
	
}
