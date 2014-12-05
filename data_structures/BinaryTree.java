// NOT FINISHED

public class BinaryTree {

  // INSTANCE VARIABLES
  private TreeNode root;
  private int depth;


  // CONSTRUCTORS
  public BinaryTree() {
    this.root = null;
    this.depth = 0;
  }

  // PUBLIC METHODS
  public boolean addTreeNode(String content) {
    boolean added = false;
    // if the tree is empty
    if (this.depth == 0) {
      this.root = new TreeNode(content);
      this.depth++;
      added = true;
    }
    else {
      TreeNode temp_node = this.root;
      while (temp_node.getNext() != null) {
        temp_node = temp_node.getNext();
      }
      temp_node.setNext(new TreeNode(content));
      this.depth++;
      added = true;
    }
    return added;
  }
  public boolean isEmpty() {
    boolean is_empty = true;
    if (this.depth > 0) {
      is_empty = false;
    }
    return is_empty;
  }
  public int depth() {
    return this.depth;
  }
}