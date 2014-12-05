public class TreeTreeNode {

  // INSTANCE VARIABLES
  private String content;
  private TreeNode left;
  private TreeNode right;

  // CONSTRUCTORS
  public TreeNode() {
    this.content = null;
    this.left = null;
    this.right = null;
  }
  public TreeNode(String content) {
    this.content = content;
    this.left = null;
    this.right = null;
  }
  public TreeNode(String content, TreeNode left, TreeNode right) {
    this.content = content;
    this.left = left;
    this.right = right;
  }

  // GETTERS
  public String getContent() {
   return this.content;
  }
  public TreeNode getLeft() {
   return this.left;
  }
  public TreeNode getRight() {
   return this.right;
  }
  // SETTERS
  public String setContent(String content) {
   this.content = content;
  }
  public TreeNode setLeft(TreeNode left) {
   this.left = left;
  }
  public TreeNode setRight(TreeNode right) {
   this.right = right;
  }
  // PUBLIC METHODS
  public String toString() {
    return this.content;
  }
}
