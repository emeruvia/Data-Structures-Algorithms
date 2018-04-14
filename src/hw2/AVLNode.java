package hw2;

public class AVLNode {

  public AVLNode leftChild;
  public AVLNode rightChild;
  public AVLNode root;
  public int value;
  public int height;
  
  public AVLNode(int value, AVLNode root) {
    this.root = root;
    this.value = value;
  }
  
  public void setLeftChild(AVLNode leftChild) {
    if (leftChild != null) {
      leftChild.root = this.root;
    }
    this.leftChild = leftChild;
  }
  
  public void setRightChild(AVLNode rightChild) {
    if (rightChild != null) {
      rightChild.root = this.root;
    }
    this.rightChild = rightChild;
  }
  
  @Override
  public String toString() {
    return value + " height " + height + " parent " + (root == null ?
        "NULL" : root.value) + " | ";
  }
}
