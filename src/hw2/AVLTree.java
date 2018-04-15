package hw2;

/**
 * Class with no access modifier to limit the accessibility for other packages
 */
class AVLTree {
	
	private Node root;
	private int lineNum;
	
	/**
	 * Method inserts the node into the AVL Tree
	 * @param word, word that is going to be inserted
	 * @param lineNum, number of line where the word appears.
	 */
	void insert(String word, int lineNum) {
		this.lineNum = lineNum;
		root = insert(root, word);
	}
	
	/**
	 * Method compares the word that is being inserted into the AVL Tree, it
	 * will balance the tree when necessary.
	 * @param p, Node of tree
	 * @param word, word that is being inserted
	 * @return balanced node of the Tree.
	 */
	private Node insert(Node p, String word) {
		if (p == null) {
			p = new Node(word);
			p.addLineNumber(lineNum);
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
			p.appendLineNumber(lineNum);
		}
		p.setHeight(max(height(p.getLeftChild()), height(p.getRightChild()) + 1));
		return p;
	}
	
	/**
	 * Method checks if the AVL Tree is populated or not, if null then prints
	 * proper message, else it calls another print method
	 */
	void print() {
		if (isEmpty()) {
			System.out.println("Empty tree");
		} else {
			printTree(root);
		}
	}
	
	/**
	 * Method prints the word and line position of the node and it's
	 * perspective childs.
	 * @param p
	 */
	private void printTree(Node p) {
		if (p != null) {
			printTree(p.getLeftChild());
			System.out.println(p.toString());
			printTree(p.getRightChild());
		}
	}
	
	/**
	 * Checks if the AVL Tree is empty
	 * @return
	 */
	private boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * Method determines the height of the node
	 * @param p, node that is being inserted
	 * @return the height of the node
	 */
	private int height(Node p) {
		if (p != null) {
			return p.getHeight();
		}
		return -1;
	}
	
	/**
	 * Method compares both childs and calculates the maximum between both of them
	 * @param left child
	 * @param right child
	 * @return child with greater value
	 */
	private int max(int left, int right) {
		return left > right ? left : right;
	}
	
	/**
	 * Method rotates the AVL Tree to the left to balance it
	 * @param p, current node
	 * @return new balanced node
	 */
	private Node leftRotation(Node p) {
		Node q = p.getLeftChild();
		p.setLeftChild(q.getRightChild());
		q.setRightChild(p);
		p.setHeight(max(height(p.getLeftChild()), height(p.getRightChild())) + 1);
		q.setHeight(max(height(q.getLeftChild()), p.getHeight()) + 1);
		return q;
	}
	
	/**
	 * Method rotates the AVL Tree to the right to balance it
	 * @param p, current Node
	 * @return new balanced node
	 */
	private Node rightRotation(Node p) {
		Node q = p.getRightChild();
		p.setRightChild(q.getLeftChild());
		q.setLeftChild(p);
		p.setHeight(max(height(p.getLeftChild()), height(p.getRightChild())) + 1);
		q.setHeight(max(height(q.getRightChild()), p.getHeight()) + 1);
		return q;
	}
	
	/**
	 * Method makes a double rotation to balance the AVL Tree
	 * @param p, current Node
	 * @return new balanced node
	 */
	private Node doubleLeftRotation(Node p) {
		p.setLeftChild(rightRotation(p.getLeftChild()));
		return leftRotation(p);
	}
	
	/**
	 * Method makes a double rotation to balance the AVL Tree
	 * @param p, current Node
	 * @return new balanced node
	 */
	private Node doubleRightRotation(Node p) {
		p.setRightChild(leftRotation(p.getRightChild()));
		return rightRotation(p);
	}
}
