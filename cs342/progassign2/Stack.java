// Last In First Out
public class Stack {

  // CONSTANTS
  private final String EMPTY_STACK_MESSAGE = "[stack is empty]";
 
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
    return (this.top != null) ? this.top.toString() : EMPTY_STACK_MESSAGE;
  }
  public void walk() {
    if (this.top == null) {
      System.out.println(EMPTY_STACK_MESSAGE);
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
      System.out.println(EMPTY_STACK_MESSAGE);
    }
    // if stack now has only node,
    // simply allow that it remain
    if (this.size() == 1) {
      System.out.println("[only one node]");
      valid = true;
    }
    // else, stack already has at least one node,
    // so push new one, then compare
    else {
      Node new_node = this.top;
      Node current_node = this.top.getNext();

      // while stack nodes exist
      while (current_node != null) {
        System.out.println("compare: " + new_node + " and " + current_node);

        // check if row OR cols match
        if ( (new_node.getRow() == current_node.getRow()) || 
             (new_node.getCol() == current_node.getCol()) ) {
          // exit loop
          System.out.println("[failed row OR col test]");
          valid = false;
          current_node = null;       
        }
        // check if "equality" diagonals match
        else if (new_node.getSum() == current_node.getSum()) {
          // exit loop
          System.out.println("[failed 'equality' test]\n");
          valid = false;
          current_node = null;
        }
        // check if "difference-equality" diagonals match:
        // first check parity; if different parity, 
        // definitely not the same "difference-equality" diagonal
        else if ( ((new_node.getSum()  % 2 == 0) && (current_node.getSum() % 2 == 0)) || 
                  ((new_node.getSum()  % 2 != 0) && (current_node.getSum() % 2 != 0)) ) {
            // then check if there is a match 
            // in the same exact sequence
            if ( (new_node.getRow() - current_node.getRow()) == 
                 (new_node.getCol() - current_node.getCol()) ) {
              // exit loop
              System.out.println("[failed 'difference-equality' " + 
                                 "test]\n");
              valid = false;
              current_node = null;
            }
            // otherwise, no match, and new_node is currently valid
            else {
              System.out.println("[node is valid]\n");
              valid = true;
              current_node = current_node.getNext();
            }            
        }  
        // if no matches, then new_node is currently valid
        else {
          System.out.println("[node is valid]\n");
          valid = true;
          current_node = current_node.getNext();
        }
      }      
    }

    return valid;
  }
  public Integer[][] walkAndReturn() {
    Integer[][] rows_and_cols = new Integer[this.size()][2];
    if (this.top == null) {
      System.out.println(EMPTY_STACK_MESSAGE);
    }
    else {
      Node current_node = this.top;

      int index = 0;
      // while stack nodes exist
      while (current_node != null) {
        rows_and_cols[index][0] = current_node.getRow();
        rows_and_cols[index][1] = current_node.getCol();
        index++;
        current_node = current_node.getNext();
      } 

      // sort
      boolean sorted = false;
      while (!sorted) {
        int swaps = 0;
        for (int i = 0; i < this.size(); i++) {
          if ( (i + 1 != this.size()) && (rows_and_cols[i][0] > rows_and_cols[i + 1][0]) ) {
            int temp_row = rows_and_cols[i][0];
            int temp_col = rows_and_cols[i][1];
            rows_and_cols[i][0] = rows_and_cols[i + 1][0];
            rows_and_cols[i][1] = rows_and_cols[i + 1][1];
            rows_and_cols[i + 1][0] = temp_row;
            rows_and_cols[i + 1][1] = temp_col;
            swaps++;
          }
        } 
  
        if (swaps == 0) {
          sorted = true;
        }        
      }
   
    }

    return rows_and_cols;
  }
}