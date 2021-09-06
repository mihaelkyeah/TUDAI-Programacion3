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
	
	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
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
		int maxElement = 0;
		
		if(current.getRight() != null) {
			maxElement = this.getMaxElem(current.getRight());
		}
		if(current.getLeft() != null) {
			maxElement = this.getMaxElem(current.getLeft());
		}
		
		if(current.getValue() > maxElement)
			maxElement = current.getValue();
		
		return maxElement;
		
		// NO ANDA D:
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
		if(this.hasElem(value))
			return this.delete(value, this.root);
		else
			return false;
	}
	
	private boolean delete(Integer value, TreeNode current) {
		
		switch (this.nodeType(current)) {
		case "root":
				
			break;
		
		case "leaf":
				
			break;
			
		case "subtree":
				
			break;
			
		case "parent":
				
			break;
			
		default:
			break;
		}
		
		return true;
		
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
		if(current.getValue() == this.getRoot())
			return "root";
		else {
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
	}
	
	private void deleteLeaf(Integer value, TreeNode current) {
		if(current.getLeft() != null && current.getLeft().getValue() == value)
			current.setLeft(null);
		else
			current.setRight(null);
	}
	
	private void deleteSubTree(Integer value, TreeNode Current) {
		// TODO: Delete subtree
	}
	
	private void deleteParent(Integer value, TreeNode Current) {
		// TODO: Delete parent
	}
	
	private void deleteRoot(Integer value, TreeNode Current) {
		// TODO: Delete root
	}
}