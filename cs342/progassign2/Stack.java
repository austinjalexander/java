// File: Stack.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 2
// Course: MET CS342 (FALL 2014)

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
    // set pushed flag to false
    boolean pushed = false;
    // if stack is empty
    if (this.size == 0) {
      // make a new top
      this.top = new Node(row, col);
      // increment size
      this.size++;
      // set flag to true
      pushed = true;
    }
    // otherwise, set new node to top,
    // and the old top to next
    else {
      this.top = new Node(row, col, this.top);
      // increment size
      this.size++;
      // set flag to true
      pushed = true;
    }
    // return flag
    return pushed;
  }
  public boolean pop() {
    //set flag to false
    boolean popped = false;
    // if there are nodes
    if (this.size > 0) {
      // set top to next 
      // (which will be null if size == 1)
      this.top = this.top.getNext();
      // decrement size
      this.size--;
      // set flag to true
      popped = true;
    }
    // return flag
    return popped;
  }
  public boolean isEmpty() {
    // set flag to true
    boolean is_empty = true;
    // if stack has any nodes
    if (this.size > 0) {
      // set flag to false
      is_empty = false;
    }
    // return flag
    return is_empty;
  }
  public int size() {
    // return size instance variable
    return this.size;
  }
  public String peek() {
    // if null, tell the user
    // otherwise, display node contents
    return (this.top != null) ? this.top.toString() : EMPTY_STACK_MESSAGE;
  }
  public void walk() {
    // if null, tell the user
    if (this.top == null) {
      System.out.println(EMPTY_STACK_MESSAGE);
    }
    // otherwise
    else {
      Node current_node = this.top;
      // while stack nodes exist
      while (current_node != null) {
        // display the contents of the current node
        System.out.println(current_node);
        // then get the next one (when null, loop will exit)
        current_node = current_node.getNext();
      }      
    }
  }
  public boolean walkAndCompare() {
    // set flag to false
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
        // check if "parity-difference-equality" diagonals match:
        // first check parity; if different parity, 
        // definitely not the same 
        // "parity-difference-equality" diagonal
        else if ( ((new_node.getSum()  % 2 == 0) && (current_node.getSum() % 2 == 0)) || 
                  ((new_node.getSum()  % 2 != 0) && (current_node.getSum() % 2 != 0)) ) {
            // then check if there is a match 
            // in the same exact sequence
            if ( (new_node.getRow() - current_node.getRow()) == 
                 (new_node.getCol() - current_node.getCol()) ) {
              // exit loop
              System.out.println("[failed " +
                                 "'parity-difference-equality' " + 
                                 "test]\n");
              // set flag to false
              valid = false;
              current_node = null;
            }
            // otherwise, no match, and new_node is currently valid
            else {
              System.out.println("[node is valid]\n");
              // set flag to true
              valid = true;
              current_node = current_node.getNext();
            }            
        }  
        // if no matches, then new_node is currently valid
        else {
          System.out.println("[node is valid]\n");
          // set flag to true
          valid = true;
          current_node = current_node.getNext();
        }
      }      
    }

    // return flag
    return valid;
  }
  public Integer[][] walkAndReturn() {
    // create a 2-dimensional array 
    // for a row vector and a col vector
    Integer[][] rows_and_cols = new Integer[this.size()][2];
    // if the stack is empty, forget it
    if (this.top == null) {
      System.out.println(EMPTY_STACK_MESSAGE);
    }
    // otherwise
    else {
      Node current_node = this.top;

      // set an index to 0
      int index = 0;
      // while stack nodes exist
      while (current_node != null) {
        // set current stack values into array at index point
        // in both vectors
        rows_and_cols[index][0] = current_node.getRow();
        rows_and_cols[index][1] = current_node.getCol();
        // increment index
        index++;
        current_node = current_node.getNext();
      } 

      // sort
      // set flag to false
      boolean sorted = false;
      // while not sorted
      while (!sorted) {
        // keep track of swaps
        int swaps = 0;
        // for the size of the array
        for (int i = 0; i < this.size(); i++) {
          // if not out of bounds and 
          // a first value is greater than a second
          if ( (i + 1 != this.size()) && (rows_and_cols[i][0] > rows_and_cols[i + 1][0]) ) {
            // places values in temp variables and swap
            int temp_row = rows_and_cols[i][0];
            int temp_col = rows_and_cols[i][1];
            rows_and_cols[i][0] = rows_and_cols[i + 1][0];
            rows_and_cols[i][1] = rows_and_cols[i + 1][1];
            rows_and_cols[i + 1][0] = temp_row;
            rows_and_cols[i + 1][1] = temp_col;
            // increment swaps
            swaps++;
          }
        } 
        // if swaps ever == 0
        if (swaps == 0) {
          // set sorted to true
          sorted = true;
        }        
      }
   
    }

    // return the 2-dimensional array
    return rows_and_cols;
  }
}