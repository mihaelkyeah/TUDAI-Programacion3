package utils;

import java.util.List;
import java.util.ArrayList;

public class TreeWithNode {

	private TreeNode root;
	
	public TreeWithNode() {
		this.root = null;
	}
	
	public TreeWithNode(int[] valueList) {
		for(int i = 0; i < valueList.length; i++) {
			this.add(valueList[i]);
		}
	}
	
	public TreeWithNode(int value) {
		this.add(value);
	}
	
	// === Agregado ===
	
	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
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
	
	public Integer getRoot() {
		return this.root.getValue();
	}
	
	public boolean hasElem(Integer elem) {
		return this.hasElem(this.root, elem);
	}
	
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
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public int getHeight() {
		return this.getHeight(this.root);
	}
	
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
	
	public Integer getMaxElem() {
		return this.getMaxElem(this.root);
	}
	
	private Integer getMaxElem(TreeNode current) {
		
		if(current.getRight() != null)
			return this.getMaxElem(current.getRight());
		
		return current.getValue();
		
		// Ahora sí anda 8-)
	}
	
	// === Retorno de listas de nodos/valores ===
	
	public List<TreeNode> getLongestBranch() {
		return this.getLongestBranch(this.root);
	}
	
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
	
	public List<TreeNode> getElemAtLevel(int level) {
		return this.getElemAtLevel(level, 0, this.root);
	}
	
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
	
	/* TODO:::
	 * Dado un árbol retornar una lista
	 * donde cada elemento es el valor de
	 * la suma del camino desde la raíz hacia una hoja determinada.
	 * Por ejemplo,
	 * para el árbol del caso anterior la lista resultante sería:
	 * [15, 17, 19, 40, 45]
	 */
	
	// Borrado
	
	public boolean delete(Integer value) {
		if(value == this.getRoot())
			return this.deleteRoot(this.root);
		else
			return this.delete(value, this.root);
	}
	
	private boolean delete(Integer value, TreeNode current) {
		
		if(value != current.getValue() && value != current.getValue()) {
			if(value > current.getValue())
				return this.delete(value, current.getRight());
			else
				return this.delete(value, current.getLeft());
		}
		else {
			switch (this.nodeType(current)) {
			case "leaf": {
				System.out.println(current.getValue());
				this.deleteLeaf(value, current);
			}
				break;
			case "subtree":
				this.deleteSubTree(value, current);
				break;
			case "parent":
				this.deleteParent(value, current);
				break;
			default:
				break;
			}
			
			return true;
		}
	}
	
	// Métodos de impresión
	
	public void printPreOrder() {
		this.printPreOrder(this.root);
	}
	
	private void printPreOrder(TreeNode current) {
		if (current == null) {
			System.out.print(" - ");
			return;
		}
		
		System.out.print(current.getValue() + " ");
		printPreOrder(current.getLeft()); 
		printPreOrder(current.getRight());
	}
	
	public void printPosOrder() {
		this.printPosOrder(this.root);
	}
	
	private void printPosOrder(TreeNode current) {
		if (current == null) 
			return;
		
		printInOrder(current.getLeft()); 
		printInOrder(current.getRight());
		System.out.print(current.getValue() + " ");
	}
	
	public void printInOrder() {
		this.printInOrder(this.root);
	}
	
	private void printInOrder(TreeNode current) {		
		if (current == null) 
			return;
		
		printInOrder(current.getLeft());
		System.out.print(current.getValue() + " "); 
		printInOrder(current.getRight());
	}
	
	// Métodos auxiliares
	
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
	
	private void deleteLeaf(Integer value, TreeNode current) {
		if(current.getParent().getLeft().getValue() == value)
			current.getParent().setLeft(null);
		else if(current.getParent().getRight().getValue() == value)
			current.getParent().setRight(null);
		
		// ANDA! :DDDDDDDDDDD
	}
	
	private void deleteSubTree(Integer value, TreeNode current) {
		if(current.getParent().getLeft().getValue() == value)
			this.exchangeNodeLeft(current);
		else if(current.getParent().getRight().getValue() == value)
			this.exchangeNodeRight(current);
		
		// FELIIZ DOMIIINGOO PARA TOOODOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOs :)
	}
	
	private boolean deleteParent(Integer value, TreeNode current) {
		
		if(value < current.getValue()) {
			if(current.getLeft().getLeft() != null)
				return deleteParent(value, current.getLeft());
			this.exchangeNodeLeft(current);
			return true;
		}
		else if (value > current.getValue()){
			if(current.getRight().getRight() != null)
				deleteParent(value, current.getRight());
			this.exchangeNodeRight(current);
			return true;
		}
		else
			return false;
	}
	
	private boolean deleteRoot(TreeNode current) {
		
		if(current.getLeft().getRight() != null) {
			Integer aux = current.getLeft().getRight().getValue();
			current.getLeft().setRight(null);
			current.setValue(aux);
			return true;
		}
		else {
			if(current.getLeft() != null)
				return this.deleteRoot(current.getLeft());
		}
		return false;
	}
	
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