// File: BinaryTree.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 3
// Course: MET CS342 (FALL 2014)

public class BinaryTree {

  // INSTANCE VARIABLES
  private TreeNode root;
  private TreeNode most_frequent;
  private int distinct;
  private int depth;
  private TreeNode deepest;

  // CONSTRUCTORS
  // set instance variables to 0 or null
  public BinaryTree() {
    this.root = null;
    this.most_frequent = null;
    this.distinct = 0;
    this.depth = 0;
    this.deepest = null;
  }

  // PUBLIC METHODS
  // add content string to tree (via a node)
  public void addContent(String content) {
    // if the tree is empty, add node as root
    if (this.root == null) {
      this.root = new TreeNode(content);
    }
    // if tree is not empty, traverse for the right location
    else if (this.root != null) {
      traverseTreeAddOrSearch("add", 
                              content, 
                              this.root);
    }
  }
  // search nodes in tree for content string
  public int searchContent(String content) {
    // set frequency to 0
    int frequency = 0;

    // if tree is not empty, search for term and its frequency
    // (if tree is empty, frequency will remain 0)
    if (this.root != null) {
      frequency = traverseTreeAddOrSearch("search", 
                                          content, 
                                          this.root);
    }

    // return frequency
    return frequency;
  }
  // show tree state to user
  public void displayStats() {

    // if the tree is empty
    if (this.root == null) {
      // display that message to the user
      System.out.println("\n\t[tree is empty]");      
    }

    // if there is a root, traverse the tree;
    // display state values (adding 1 [the root] to depth display value)
    else if ((this.root != null)) {

      // traverse tree
      this.traverse();

      // display depth
      System.out.println("\n\tTree is: " + (this.depth + 1) + 
                         " node(s) deep");  

      // display distinct
      System.out.println("\n\tTree contains: " + this.distinct + 
                         " distinct word(s)"); 

      // display root content
      System.out.println("\n\tWord at root is: " + 
                         this.root.getContent());

      // display deepest content
      System.out.println("\n\tDeepest word is: " + 
                         this.deepest.getContent());  

      // display deepest word
      System.out.println("\n\tMost frequent is: '" + 
                         this.most_frequent.getContent() +
                         "' occuring " +
                         this.most_frequent.getFrequency() +
                         " time(s)");  
    }
  }

  // PRIVATE METHODS
  // reset state to constructor defaults (0, null)
  private void resetStats() {
    this.most_frequent = null;
    this.distinct = 0;
    this.depth = 0;
    this.deepest = null;    
  }
  // if there is a root, reset stats and traverse list;
  private void traverse() {
    if (this.root != null) {
      this.resetStats();
      traverseTree(0, this.root);
    }
  }
  // add or search for a node and its content
  private int traverseTreeAddOrSearch(String function, 
                                      String content, 
                                      TreeNode current_tree_node) {
    // frequency (set to 0) for searching
    // (gets returned/sent back up the recursion pipe)
    int frequency = 0;

    // make string comparison
    int comparison = content.compareTo(current_tree_node.getContent());

    // if the new content is lexicographically 
    // equivalent to the current node string content, (comparison == 0)
    if (comparison == 0) {
      // if adding, update frequency
      if (function == "add") {
        current_tree_node.updateContentFrequency();
      }
      // if searching, capture frequency
      else if (function == "search") {
        frequency = current_tree_node.getFrequency();
      }
    }

    // if the new content lexicographically 
    // precedes the current node string content, (comparison < 0),
    // go left
    else if (comparison < 0) {
      // for adding, if left node is empty, create node there;
      // for search, content was not found, frequency will remain 0
      if (current_tree_node.getLeft() == null) {
        current_tree_node.setLeft(new TreeNode(content));
      }
      // otherwise, keep traversing left;
      // hold on to frequency for search
      else if (current_tree_node.getLeft() != null) {
        frequency = traverseTreeAddOrSearch(function, 
                                            content, 
                                            current_tree_node.getLeft());
      }
    }

    // if the new content lexicographically 
    // follows the current node string content, (comparison > 0),
    // go right
    else if (comparison > 0) {
      // for adding, if left node is empty, create node there;
      // for search, content was not found, frequency will remain 0
      if (current_tree_node.getRight() == null) {
        current_tree_node.setRight(new TreeNode(content));
      }
      // otherwise, keep traversing right;
      // hold on to frequency for search
      else if (current_tree_node.getRight() != null) {
        frequency = traverseTreeAddOrSearch(function, 
                                            content, 
                                            current_tree_node.getRight());
      }
    } 
    // return frequency 
    // (garbage if adding)
    return frequency;   
  }

  // traverse the tree, and keep track of stats
  private void traverseTree(int depth, 
                            TreeNode current_tree_node) {
    
    // count number of nodes crossed (hit once per method call)
    this.distinct++;

    // if most_frequent has not been set, set to current;
    // otherwise, if the current node frequency
    //  is higher than most_frequent, update most_frequent
    if ((this.most_frequent == null) || ((this.most_frequent != null) && (current_tree_node.getFrequency() > this.most_frequent.getFrequency()))) {
      this.most_frequent = current_tree_node;
    }

    // if reached a node without further leaves,
    // set tree depth to current depth, 
    // and tree deepest to current deepest;
    // depth >= this.depth will give ties for depth to the furthest-right;
    if ((current_tree_node.getLeft() == null) && (current_tree_node.getRight() == null) && (depth >= this.depth)) {
      this.depth = depth;
      this.deepest = current_tree_node;
      //System.out.println(depth + "-" + current_tree_node.getContent());
    }

    // lefts go first;
    // if node has a left leaf, go left;
    // send an increased depth into function
    // (not increased here since, when the function returns here,
    // depth needs to stay the same value for traversing right)
    if (current_tree_node.getLeft() != null) {
      traverseTree(depth + 1, current_tree_node.getLeft());
    }

    // rights go second;
    // if node has a right leaf, go right;
    // send an increased depth into function (same logic as above)
    if (current_tree_node.getRight() != null) {
      traverseTree(depth + 1, current_tree_node.getRight());
    }
  }

}
