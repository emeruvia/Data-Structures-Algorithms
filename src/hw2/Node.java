package hw2;

public class Node {
	
	private Node leftChild;
	private Node rightChild;
	private Node root;
	private String word;
	private int height;
	
	public Node(Node root, String word) {
		this.root = root;
		this.word = word;
	}
	
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	
	public Node getLeftChild() {
		return leftChild;
	}
	
	public Node getRightChild() {
		return rightChild;
	}
	
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return word + " height " + height + " parent " + (root == null ?
				"NULL" : root.word) + " | ";
	}
}
