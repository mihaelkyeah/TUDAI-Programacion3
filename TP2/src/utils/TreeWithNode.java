package utils;

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
	
	// TODO public void delete(int value) {}
	
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
	
}