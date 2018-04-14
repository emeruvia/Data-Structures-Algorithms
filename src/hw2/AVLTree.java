package hw2;

public class AVLTree {

  private AVLNode root;
  
  public void insert(int data) {
    insert(root, data);
  }
  
  public void insert(AVLNode p, int value) {
    if (p == null) {
      p = new AVLNode(value, null);
      return;
    }
    
    if (value < p.value) {
    
    } else if (value > p.value) {
    
    }
  }

}
