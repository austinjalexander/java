public class Node {

  // INSTANCE VARIABLES
  private String content;
  private Node next;

  // CONSTRUCTORS
  public Node() {
    this.content = null;
    this.next = null;
  }
  public Node(String content) {
    this.content = content;
    this.next = null;
  }
  public Node(String content, Node next) {
    this.content = content;
    this.next = next;
  }

  // GETTERS
  public Node getNext() {
   return this.next;
  }
  // SETTERS
  public void setNext(Node next) {
   this.next = next;
  }
  // PUBLIC METHODS
  public String toString() {
    return this.content;
  }
}
