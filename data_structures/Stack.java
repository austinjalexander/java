// Last In First Out
public class Stack {

  // INSTANCE VARIABLES
  private Node top;
  private int size;

  // CONSTRUCTORS
  public Stack() {
    this.top = null;
  }

  // PUBLIC METHODS
  public boolean push(String content) {
    boolean pushed = false;
    if (this.size == 0) {
      this.top = new Node(content);
      this.size++;
      pushed = true;
    }
    else {
      this.top = new Node(content, this.top);
      this.size++;
      pushed = true;
    }
    return pushed;
  }
  public boolean pop() {
    boolean popped = false;
    if (this.size > 0) {
      this.top = this.top.getNext();
      this.size--;
      popped = true;
    }
    return popped;
  }
  public boolean isEmpty() {
    boolean is_empty = true;
    if (this.size > 0) {
      is_empty = false;
    }
    return is_empty;
  }
  public int size() {
    return this.size;
  }
  public String peek() {
    return (this.top != null) ? this.top.toString() : "[stack is empty]";
  }
}