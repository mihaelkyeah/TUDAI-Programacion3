package utils;

public class TreeNode {

	private Integer value;
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;

	public TreeNode(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public TreeNode getParent() {
		return this.parent;
	}
	
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public Integer getValue() {
		return value;
	}
	
	// Método auxiliar creado para uso en casos particulares
	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return ""+this.getValue()+"";
	}

}
