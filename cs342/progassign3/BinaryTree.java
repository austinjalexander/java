// File: BinaryTree.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 3
// Course: MET CS342 (FALL 2014)

public class BinaryTree {

  // INSTANCE VARIABLES
  private TreeNode root;

  // CONSTRUCTORS
  public BinaryTree() {
    this.root = null;
  }

  // PUBLIC METHODS
  public void addContent(String content) {
    traverseTreeAddContent(content, this.root);
  }
  public int searchContent(String content) {
    return traverseTreeSearchContent(content, this.root);
  }

  // PRIVATE METHODS
  private void traverseTreeAddContent(String content, 
                                      TreeNode current_tree_node) {
    // if the tree is empty
    if (this.root == null) {
      this.root = new TreeNode(content);
    }
    // if tree is not empty
    else if (this.root != null) {
      // make string comparison
      int comparison = content.compareTo(current_tree_node.getContent());
      /* if the new content is lexicographically 
         equivalent to the current node string content, (comparison == 0) */
      // update frequency
      if (comparison == 0) {
        current_tree_node.updateContentFrequency();
      }
       /* if the new content lexicographically 
         precedes the current node string content, (comparison < 0) */
      // go left
      else if (comparison < 0) {
        // if left node is empty
        if (current_tree_node.getLeft() == null) {
          current_tree_node.setLeft(new TreeNode(content));
        }
        // otherwise, keep traversing
        else {
          traverseTreeAddContent(content, current_tree_node.getLeft());
        }
      }
       /* if the new content lexicographically 
         follows the current node string content, (comparison > 0) */
      // go right
      else if (comparison > 0) {
        // if right node is empty
        if (current_tree_node.getRight() == null) {
          current_tree_node.setRight(new TreeNode(content));
        }
        // otherwise, keep traversing
        else {
          traverseTreeAddContent(content, current_tree_node.getRight());
        }
      }    
    } //end: else if (this.root != null)
  }
  private int traverseTreeSearchContent(String content,
                                        TreeNode current_tree_node) {
    // frequency
    int frequency = 0;
    // if tree is not empty
    // (if tree is empty, frequency, left, and right will remain 0)
    if (this.root != null) {
      // make string comparison
      int comparison = content.compareTo(current_tree_node.getContent());
      /* if the new content is lexicographically 
         equivalent to the current node string content, (comparison == 0) */
      // get frequency
      if (comparison == 0) {
        frequency = current_tree_node.getFrequency();
      }
       /* if the new content lexicographically 
         precedes the current node string content, (comparison < 0) */
      // go left
      else if (comparison < 0) {
        // if left node is not empty, keep traversing content
        // (if left node is empty, then content was not found; freq == 0);
        // hold on to frequency
        if (current_tree_node.getLeft() != null) {
          frequency = traverseTreeSearchContent(content, current_tree_node.getLeft());
        }
      }
       /* if the new content lexicographically 
         follows the current node string content, (comparison > 0) */
      // go right
      else if (comparison > 0) {
        // if right node is not empty, keep traversing content
        // (if right node is empty, then content was not found; freq == 0)
        if (current_tree_node.getRight() != null) {
          // hold on to frequency
          frequency = traverseTreeSearchContent(content, current_tree_node.getRight());
        }
      }    
    } //end: else if (this.root != null)
    return frequency;
  }

}
