// NOT FINISHED

public class List {

  // INSTANCE VARIABLES
  private Node head;
  private Node tail;
  private int size;

  // CONSTRUCTORS
  public List() {
    this.head = null;
  }

  // PUBLIC METHODS
  public boolean addHead(String content) {
    boolean added = false;
    if (this.size == 0) {
      this.head = new Node(content);
      this.size++;
      added = true;
    }
    else {
      Node temp_node = this.head;
      while (temp_node.getNext() != null) {
        temp_node = temp_node.getNext();
      }
      temp_node.setNext(new Node(content));
      this.size++;
      added = true;
    }
    return added;
  }
  public boolean removeHead(){
    boolean removed = false;
    if (this.size > 0) {
      this.head = this.head.getNext();
      this.size--;
      removed = true;
    }
    return removed;
  }
  public boolean addHead(String content) {
    boolean added = false;
    if (this.size == 0) {
      this.head = new Node(content);
      this.size++;
      added = true;
    }
    else {
      Node temp_node = this.head;
      while (temp_node.getNext() != null) {
        temp_node = temp_node.getNext();
      }
      temp_node.setNext(new Node(content));
      this.size++;
      added = true;
    }
    return added;
  }
  public boolean removeHead(){
    boolean removed = false;
    if (this.size > 0) {
      this.head = this.head.getNext();
      this.size--;
      removed = true;
    }
    return removed;
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
}