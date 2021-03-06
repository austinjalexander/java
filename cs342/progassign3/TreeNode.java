// File: TreeNode.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 3
// Course: MET CS342 (FALL 2014)

public class TreeNode {

  // INSTANCE VARIABLES
  private String content;
  private int frequency;
  private TreeNode left;
  private TreeNode right;

  // CONSTRUCTORS
  // default constructor (not used in TextMine)
  public TreeNode() {
    this.content = null;
    this.frequency = 0;
    this.left = null;
    this.right = null;
  }
  // constructor that sets frequency to 1 upon instantiation
  public TreeNode(String content) {
    this.content = content;
    this.frequency++;
    this.left = null;
    this.right = null;
  }

  // GETTERS
  public String getContent() {
   return this.content;
  }
  public int getFrequency() {
   return this.frequency;
  }
  public TreeNode getLeft() {
   return this.left;
  }
  public TreeNode getRight() {
   return this.right;
  }

  // SETTERS
  public void setContent(String content) {
   this.content = content;
  }
  public void setLeft(TreeNode left) {
   this.left = left;
  }
  public void setRight(TreeNode right) {
   this.right = right;
  }

  // PUBLIC METHODS
  // return an incremented frequency
  public int updateContentFrequency() {
    return ++this.frequency;
  }
}
