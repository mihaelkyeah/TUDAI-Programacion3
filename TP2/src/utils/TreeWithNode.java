package utils;

import java.util.List;
import java.util.ArrayList;

public class TreeWithNode {

	private TreeNode root;
	
	public TreeWithNode() {
		this.root = null;
	}
	
	// Complejidad: O(n*h) donde n es el tamaño de la lista de valores
	// y h es la altura del árbol
	public TreeWithNode(int[] valueList) {
		for(int i = 0; i < valueList.length; i++) {
			this.add(valueList[i]);
		}
	}
	
	public TreeWithNode(int value) {
		this.add(value);
	}
	
	// === Agregado ===

	// Complejidad: O(h) donde h es la altura del árbol
	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
	// Complejidad: O(h) donde h es la altura del árbol
	private void add(TreeNode current, Integer value) {
		if (current.getValue() > value) {
			if (current.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				current.setLeft(temp);
				temp.setParent(current);
			} else {
				add(current.getLeft(),value);
			}
		} else if (current.getValue() < value) {
			if (current.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				current.setRight(temp);
				temp.setParent(current);
			} else {
				add(current.getRight(),value);
			}
		}
	}
	
	// === Datos del árbol ===
	
	// Complejidad: O(1)
	public Integer getRoot() {
		return this.root.getValue();
	}
	
	// Complejidad: O(h) donde h es la altura del árbol	
	public boolean hasElem(Integer elem) {
		return this.hasElem(this.root, elem);
	}
	
	// Complejidad: O(h) donde h es la altura del árbol
	private boolean hasElem(TreeNode currentNode, Integer elem) {
		if(currentNode == null)
			return false;
		else {
			if(currentNode.getValue() != elem) {
				if(elem < currentNode.getValue()) 
					return this.hasElem(currentNode.getLeft(), elem);
				else
					return this.hasElem(currentNode.getRight(), elem);
			}
			else
				return true;
		}
	}
	
	// Complejidad: O(1)
	public boolean isEmpty() {
		return this.root == null;
	}
	
	// Complejidad: O(n) donde n es la cantidad de nodos del árbol	
	public int getHeight() {
		return this.getHeight(this.root);
	}
	
	// Complejidad: O(n) donde n es la cantidad de nodos del árbol
	private int getHeight(TreeNode current) {
		
		// Se declaran dos contadores
		int leftHeight = 0;
		int rightHeight = 0;
		
		// Cuenta hacia la izquierda
		if(current.getLeft() != null)
			leftHeight = this.getHeight(current.getLeft())+1;
		
		// Cuenta hacia la derecha
		if(current.getRight() != null)
			rightHeight = this.getHeight(current.getRight())+1;
		
		// Compara el contador más grande para devolverlo
		if(leftHeight > rightHeight)
			return leftHeight;
		else
			return rightHeight;
		
		// ANDUVICIONÓ!!! :DDDD
	}
	
	// Complejidad: O(h) donde h es la altura del árbol hacia la derecha	
	public Integer getMaxElem() {
		return this.getMaxElem(this.root);
	}
	
	// Complejidad: O(h) donde h es la altura del árbol hacia la derecha
	private Integer getMaxElem(TreeNode current) {
		if(current.getRight() != null)
			return this.getMaxElem(current.getRight());
		return current.getValue();
		// Ahora sí anda 8-)
	}
	
	// === Retorno de listas de nodos/valores ===
	
	// Complejidad: O(n) donde n es la cantidad de nodos del árbol	
	public List<TreeNode> getLongestBranch() {
		return this.getLongestBranch(this.root);
	}
	
	// Complejidad: O(n) donde n es la cantidad de nodos del árbol
	private List<TreeNode> getLongestBranch(TreeNode current) {
		// Se declaran dos listas auxiliares
		List<TreeNode> auxLeft = new ArrayList<>();
		List<TreeNode> auxRight = new ArrayList<>();
		
		// Recorre y agrega hacia la izquierda
		auxLeft.add(current);
		if(current.getLeft() != null)
			auxLeft.addAll(this.getLongestBranch(current.getLeft()));
		
		// Recorre y agrega hacia la derecha
		auxRight.add(current);
		if(current.getRight() != null)
			auxRight.addAll(this.getLongestBranch(current.getRight()));	
		
		// Compara el arreglo más grande para devolverlo
		if(auxLeft.size() > auxRight.size())
			return auxLeft;
		else
			return auxRight;
	}
	
	public List<TreeNode> getFrontier() {
		return this.getFrontier(this.root);
	}
	
	// Complejidad: O(n) donde n es la cantidad de nodos del árbol
	private List<TreeNode> getFrontier(TreeNode current) {
		List<TreeNode> aux = new ArrayList<>();
		if(this.nodeType(current) != "leaf") {
			if(current.getLeft() != null)
				aux.addAll(this.getFrontier(current.getLeft()));
			if(current.getRight() != null)
				aux.addAll(this.getFrontier(current.getRight()));
		}
		else
			aux.add(current);
		return aux;
	}
	
	// Complejidad: O(h) donde h es la altura del árbol
	public List<TreeNode> getElemAtLevel(int level) {
		return this.getElemAtLevel(level, 0, this.root);
	}
	
	// Complejidad: O(h) donde h es la altura del árbol
	private List<TreeNode> getElemAtLevel(int level, int currentLevel, TreeNode current) {
		List<TreeNode> aux = new ArrayList<>();
		if(currentLevel < level) {
			if(current.getLeft() != null)
				aux.addAll(this.getElemAtLevel(level, currentLevel+1, current.getLeft()));
			if(current.getRight() != null)
				aux.addAll(this.getElemAtLevel(level, currentLevel+1, current.getRight()));
		}
		else
			aux.add(current);
		return aux;
	}
	
	/* 
	 * Dado un árbol retornar una lista
	 * donde cada elemento es el valor de
	 * la suma del camino desde la raíz hacia una hoja determinada.
	 * Por ejemplo,
	 * para el árbol del caso anterior la lista resultante sería:
	 * [15, 17, 19, 40, 45]
	 */
	
	// Complejidad: O(n) donde n es la cantidad de nodos del árbol
	public List<Integer> getPathSumList() {
		return this.getPathSumList(this.root,0);
	}
	
	// Complejidad: O(n) donde n es la cantidad de nodos del árbol
	private List<Integer> getPathSumList(TreeNode current, Integer value) {
		List<Integer> aux = new ArrayList<>();
		if(this.nodeType(current) != "leaf") {
			if(current.getLeft() != null)
				aux.addAll(this.getPathSumList(current.getLeft(),value+current.getValue()));
			if(current.getRight() != null)
				aux.addAll(this.getPathSumList(current.getRight(),value+current.getValue()));
		}
		else
			aux.add(value+current.getValue());
		return aux;
	}
	
	// Borrado
	
	// Complejidad: O(h) donde h es la altura del árbol
	public boolean delete(Integer value) {
		if(value == this.getRoot()) {
			return this.deleteRoot();
		}
		else
			return this.delete(value, this.root);
	}
	
	// Complejidad: O(h) donde h es la altura del árbol
	private boolean delete(Integer value, TreeNode current) {
		if(current != null) {
			if(value != current.getValue()) {
				if(value > current.getValue())
					return this.delete(value, current.getRight());
				else
					return this.delete(value, current.getLeft());
			}
			else {
				switch (this.nodeType(current)) {
				case "leaf": {
					this.deleteLeaf(value, current);
				}
					break;
				case "subtree":
					this.deleteSubTree(value, current);
					break;
				case "parent":
					this.deleteParent(current);
					break;
				default:
					break;
				}
				return true;
			}
		}
		else
			return false;
	}
	
	// Métodos de impresión
	
	// Complejidad: O(n) donde n es la cantidad de nodos del árbol
	public void printPreOrder() {
		this.printPreOrder(this.root);
	}
	
	// Complejidad: O(n) donde n es la cantidad de nodos del árbol
	private void printPreOrder(TreeNode current) {
		if (current == null) {
			System.out.print(" - ");
			return;
		}
		
		System.out.print(current.getValue() + " ");
		printPreOrder(current.getLeft()); 
		printPreOrder(current.getRight());
	}
	
	// Complejidad: O(n) donde n es la cantidad de nodos del árbol
	public void printPosOrder() {
		this.printPosOrder(this.root);
	}

	// Complejidad: O(n) donde n es la cantidad de nodos del árbol	
	private void printPosOrder(TreeNode current) {
		if (current == null) 
			return;
		printInOrder(current.getLeft()); 
		printInOrder(current.getRight());
		System.out.print(current.getValue() + " ");
	}
	
	// Complejidad: O(n) donde n es la cantidad de nodos del árbol
	public void printInOrder() {
		this.printInOrder(this.root);
	}
	
	// Complejidad: O(n) donde n es la cantidad de nodos del árbol	
	private void printInOrder(TreeNode current) {		
		if (current == null) 
			return;
		printInOrder(current.getLeft());
		System.out.print(current.getValue() + " "); 
		printInOrder(current.getRight());
	}
	
	// Métodos auxiliares
	
	// Complejidad: O(1) 
	private String nodeType(TreeNode current) {
		if(current.getLeft() == null && current.getRight() == null)
			return "leaf";
		else
			{
			if(current.getLeft() != null && current.getRight() != null)
				return "parent";
			else
				return "subtree";
			}
	}
	
	// Complejidad: O(1)
	private void deleteLeaf(Integer value, TreeNode current) {
		if(current.getParent().getLeft().getValue() == value)
			current.getParent().setLeft(null);
		else if(current.getParent().getRight().getValue() == value)
			current.getParent().setRight(null);
		// ANDA! :DDDDDDDDDDD
	}
	
	// Complejidad: O(1)
	private void deleteSubTree(Integer value, TreeNode current) {
		if(current.getParent().getLeft().getValue() == value)
			this.exchangeNodeLeft(current);
		else if(current.getParent().getRight().getValue() == value)
			this.exchangeNodeRight(current);
		// FELIIZ DOMIIINGOO PARA TOOODOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOs :)
	}
	
	// Complejidad: O(1)
	private void deleteParent(TreeNode current) {
		Integer max = this.getMaxElem(current.getLeft());
		current.setValue(max);
		this.delete(max, current.getLeft());
		// Kenny Bell :ok_hand:
	}
	
	// Complejidad: O(1)
	private boolean deleteRoot() {
		switch (this.nodeType(this.root)) {
		case "parent":
			this.deleteParent(this.root);
			break;
		case "leaf":
			this.root = null;
			break;
		case "subtree": {
			if(this.root.getLeft() != null) {
				Integer aux = this.root.getLeft().getValue();
				this.delete(aux, this.root.getLeft());
				this.root.setValue(aux);
			}
			else if (this.root.getRight() != null) {
				Integer aux = this.root.getRight().getValue();
				this.delete(aux, this.root.getRight());
				this.root.setValue(aux);
			}
		}
		default:
			return false;
		}
		return true;	
	}
	
	// Complejidad: O(3) => O(1)
	private void exchangeNodeLeft(TreeNode current) {
		if(current.getLeft() != null) {
			current.getParent().setLeft(current.getLeft());
			current.getLeft().setParent(current.getParent());
		}
		else {
			current.getParent().setLeft(current.getRight());
			current.getRight().setParent(current.getParent());
		}
	}

	// Complejidad: O(3) => O(1)
	private void exchangeNodeRight(TreeNode current) {
		if(current.getRight() != null) {
			current.getParent().setRight(current.getRight());
			current.getRight().setParent(current.getParent());
		}
		else {
			current.getParent().setRight(current.getLeft());
			current.getLeft().setParent(current.getParent());
		}
	}
}