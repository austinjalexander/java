public class Node {

  // INSTANCE VARIABLES
  private int row;
  private int col;
  private Node next;

  // CONSTRUCTORS
  public Node() {
    // set instance variables to 0 or null
    this.row = 0;
    this.col = 0;
    this.next = null;
  }
  public Node(int row, int col) {
    // set row,col to argument values;
    // set next to null
    this.row = row;
    this.col = col;
    this.next = null;
  }
  public Node(int row, int col, Node next) {
    // set row,col,next to argument values;
    this.row = row;
    this.col = col;
    this.next = next;
  }

  // GETTERS 
  // (for all, simply return instance variables)
  public int getRow() {
    return this.row;
  }
  public int getCol() {
    return this.col;
  }
  public int getSum() {
    return (this.row + this.col);
  }
  public Node getNext() {
   return this.next;
  }
  // SETTERS
  public void setNext(Node next) {
   this.next = next;
  }
  // PUBLIC METHODS
  public String toString() {
    return "<" + this.row + "," + this.col + ">";
  }
}
