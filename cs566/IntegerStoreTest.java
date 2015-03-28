// File: IntegerStoreTest.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS566 (SPRING 2015)


public class IntegerStoreTest {

  public static void main(String[] args) {

    BinarySearchTree binary_search_tree = new BinarySearchTree();
    treeInsert(binary_search_tree, new Node(6));
    treeInsert(binary_search_tree, new Node(5));
    treeInsert(binary_search_tree, new Node(7));
    treeInsert(binary_search_tree, new Node(2));
    treeInsert(binary_search_tree, new Node(5));
    treeInsert(binary_search_tree, new Node(8));
    inorderTreeWalk(binary_search_tree.root);

      
  }

  public static void treeInsert(BinarySearchTree T, Node z) {
    // as instructed, the following algorithm follows, 
    // as precisely as possible in Java,
    // the TREE-INSERT algorithm/pseudocode in _______;
    // from a software design perspective, the code is efficient to be sure
    // but at the expense of human readability;
    // personally, i would not write code like this.
    Node y = null;
    Node x = T.root;
    while (x != null) {
      y = x;
      if (z.key < x.key)
        x = x.left;
      else x = x.right;
    }
    z.p = y;
    if (y == null)
      T.root = z; // tree T was empty
    else if (z.key < y.key)
      y.left = z;
    else y.right = z;
  }

  public static void inorderTreeWalk(Node x) {
    if (x != null) {
      inorderTreeWalk(x.left);
      System.out.println(x.key + " ");
      inorderTreeWalk(x.right);
    }
  }
}
