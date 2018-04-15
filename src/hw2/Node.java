package hw2;

/**
 * Object class for the nodes
 */
class Node {
	
	//Node values
	private Node leftChild;
	private Node rightChild;
	private String word;
	private int height;
	private StringBuilder lineNumber;
	
	//Object constructor
	Node(String word) {
		this.word = word;
		lineNumber = new StringBuilder();
	}
	
	void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	
	Node getLeftChild() {
		return leftChild;
	}
	
	Node getRightChild() {
		return rightChild;
	}
	
	void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	String getWord() {
		return word;
	}
	
	int getHeight() {
		return height;
	}
	
	void setHeight(int height) {
		this.height = height;
	}
	
	void addLineNumber(int lineNum) {
		this.lineNumber.append(lineNum);
	}
	
	void appendLineNumber(int lineNum) {
		this.lineNumber.append(", ").append(lineNum);
	}
	
	//Method returns the string with the proper Node values.
	@Override
	public String toString() {
		return String.format("%-10s%s", word, lineNumber);
	}
}
