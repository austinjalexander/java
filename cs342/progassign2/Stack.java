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
  public boolean push(int row, int col) {
    boolean pushed = false;
    if (this.size == 0) {
      this.top = new Node(row, col);
      this.size++;
      pushed = true;
    }
    else {
      this.top = new Node(row, col, this.top);
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
  public void walk() {
    if (this.top == null) {
      System.out.println("Stack is empty");
    }
    else {
      Node current_node = this.top;
      // while stack nodes exist
      while (current_node != null) {
        System.out.println(current_node);
        current_node = current_node.getNext();
      }      
    }
  }
  public boolean walkAndCompare() {
    boolean valid = false;

    // if stack is empty,
    // simply let the user know
    if (this.top == null) {
      System.out.println("Stack is empty");
    }
    // if stack now has only node,
    // simply allow that it remain
    if (this.size() == 1) {
      valid = true;
    }
    // else, stack already has at least one node,
    // so push new one, then compare
    else {
      Node new_node = this.top;
      Node current_node = this.top.getNext();

      // while stack nodes exist
      while (current_node != null) {
        System.out.println("Compare:" + new_node + " and " + current_node);

        // check if row OR cols match
        if ( (new_node.getRow() == current_node.getRow()) || 
             (new_node.getCol() == current_node.getCol()) ) {
          // exit loop
          valid = false;
          current_node = null;       
        }
        // check if "equality" diagonals match
        else if (new_node.getSum() == current_node.getSum()) {
          // exit loop
          valid = false;
          current_node = null;
        }
        // check if "parity" diagonals match
        else if ( ((new_node.getSum()  % 2 == 0) && (current_node.getSum() % 2 == 0)) || 
                  ((new_node.getSum()  % 2 != 0) && (current_node.getSum() % 2 != 0)) ) {
          // exit loop
          valid = false;
          current_node = null;
        }  
        // if no matches, then new_node is currently valid
        else {
          valid = true;
          current_node = current_node.getNext();
        }
      }      
    }

    return valid;
  }
}