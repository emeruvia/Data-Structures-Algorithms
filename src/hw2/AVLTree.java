package hw2;

public class AVLTree {
	
	private Node root;
	
	public void insert(String word) {
		root = insert(root, word);
	}
	
	public Node insert(Node p, String word) {
		if (p == null) {
			p = new Node(null, word);
		} else if (word.toLowerCase().compareTo(p.getWord().toLowerCase()) < 0) {
			p.setLeftChild(insert(p.getLeftChild(), word));
			if (height(p.getLeftChild()) - height(p.getRightChild()) == 2) {
				if (word.toLowerCase()
						.compareTo(p.getLeftChild().getWord().toLowerCase()) < 0) {
					p = leftRotation(p);
				} else {
					p = doubleLeftRotation(p);
				}
			}
		} else if (word.toLowerCase().compareTo(p.getWord().toLowerCase()) > 0) {
			p.setRightChild(insert(p.getRightChild(), word));
			if (height(p.getRightChild()) - height(p.getRightChild()) == 2) {
				if (word.toLowerCase()
						.compareTo(p.getRightChild().getWord().toLowerCase()) > 0) {
					p = rightRotation(p);
				} else {
					p = doubleRightRotation(p);
				}
			}
		} else {
			//Do nothing, same branch
		}
		p.setHeight(max(height(p.getLeftChild()), height(p.getRightChild()) + 1));
		return p;
	}
	
	public void print() {
		if (isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}
	
	private void printTree(Node p) {
		if (p != null) {
			printTree(p.getLeftChild());
			System.out.println(p.getWord());
			printTree(p.getRightChild());
		}
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	private int height(Node p) {
		if (p != null) {
			return p.getHeight();
		}
		return -1;
	}
	
	private int max(int left, int right) {
		return left > right ? left : right;
	}
	
	private Node leftRotation(Node p) {
		Node q = p.getLeftChild();
		p.setLeftChild(q.getRightChild());
		q.setRightChild(p);
		p.setHeight(max(height(p.getLeftChild()), height(p.getRightChild())) + 1);
		q.setHeight(max(height(q.getLeftChild()), p.getHeight()) + 1);
		return q;
	}
	
	private Node rightRotation(Node p) {
		Node q = p.getRightChild();
		p.setRightChild(q.getLeftChild());
		q.setLeftChild(p);
		p.setHeight(max(height(p.getLeftChild()), height(p.getRightChild())) + 1);
		q.setHeight(max(height(q.getRightChild()), p.getHeight()) + 1);
		return q;
	}
	
	private Node doubleLeftRotation(Node p) {
		p.setLeftChild(rightRotation(p.getLeftChild()));
		return leftRotation(p);
	}
	
	private Node doubleRightRotation(Node p) {
		p.setRightChild(leftRotation(p.getRightChild()));
		return rightRotation(p);
	}
	
}
