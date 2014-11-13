import java.util.Random;

public class EightQueens {

  public static final int GRID_SIZE = 8;

  public static void main(String[] args) {

    System.out.println("\n*** EIGHT QUEENS ***\n");
    Stack stack = new Stack();

    Random rand = new Random();

    int[] row = new int[GRID_SIZE]; 
    int[] col = new int[GRID_SIZE]; 
    for (int i = 0; i < GRID_SIZE; i++) {
      row[i] = i;
      col[i] = i;
    } 

    for (int i = 0; i < row.length; i++) {
      System.out.print(row[i]);
      System.out.println(col[i]);
    } 

    boolean solved = false;
    while (!solved) {
      int new_row = rand.nextInt(row.length);
      int new_col = rand.nextInt(col.length);

      System.out.println("\n[push: (" + 
                            row[new_row] + "," + 
                            col[new_col] + ")]"); 
      stack.push(row[new_row],col[new_col]); 

      // check if valid
      if ( stack.walkAndCompare() ) {
        System.out.println("\nSTACK STATE");
        stack.walk();
        row = new int[(row.length - 1)]; 
        col = new int[(row.length - 1)]; 
        // remove future row/col possibilities
        for (int i = 0; i < (row.length - 1); i++) {
          if (i != new_row) {
            row[i] = i;
          }
          if (i != new_col) {
            col[i] = i;
          }          
        } 
      }
      else {
        stack.pop();
        System.out.println("\nSTACK STATE");
        stack.walk();      
      }

      for (int i = 0; i < row.length; i++) {
        System.out.print(row[i]);
        System.out.println(col[i]);
      } 
    }

    System.out.println("\n*** THE END ***\n");



    //displayBoard();




  }

  public static void displayBoard() {
    System.out.println();
    for (int i = 0; i < 8; i++) {
      System.out.println();
      for (int j = 0; j < 8; j++) {
        System.out.print("(" + i + "," + j + ") ");
      }
    }
    System.out.println("\n");
  }
}

    // FOR TESTING
    /*
    System.out.println("\n[push: (5,4)]");
    stack.push(5,4);
    // check if valid
    if ( stack.walkAndCompare() ) {
      System.out.println("\nSTACK STATE");
      stack.walk();
    }
    */
    
    /*
    // (5,4) --> same row AND same col
    System.out.println("\n[push: (5,4)]");
    stack.push(5,4);
    // check if valid
    if ( stack.walkAndCompare() ) {
      System.out.println("\nSTACK STATE");
      stack.walk();
    }
    else {
      stack.pop();
      System.out.println("\nSTACK STATE");
      stack.walk();      
    }
    */

    /*
    // (5,5) --> same row
    System.out.println("\n[push: (5,5)]");
    stack.push(5,5);
    // check if valid
    if ( stack.walkAndCompare() ) {
      System.out.println("\nSTACK STATE");
      stack.walk();
    }
    else {
      stack.pop();
      System.out.println("\nSTACK STATE");
      stack.walk();      
    }
    */

    /*
    // (4,4) --> same col
    System.out.println("\n[push: (4,4)]");
    stack.push(4,4);
    // check if valid
    if ( stack.walkAndCompare() ) {
      System.out.println("\nSTACK STATE");
      stack.walk();
    }
    else {
      stack.pop();
      System.out.println("\nSTACK STATE");
      stack.walk();      
    }
    */
  
    /*
    // (4,5) --> check "equality" diagonal
    System.out.println("\n[push: (4,5)]");
    stack.push(4,5);
    // check if valid
    if ( stack.walkAndCompare() ) {
      System.out.println("\nSTACK STATE");
      stack.walk();
    }
    else {
      stack.pop();
      System.out.println("\nSTACK STATE");
      stack.walk();      
    }
    */

    /*
    // (2,1) --> check "parity-sequence" diagonal
    System.out.println("\n[push: (2,1)]");
    stack.push(2,1);
    // check if valid
    if ( stack.walkAndCompare() ) {
      System.out.println("\nSTACK STATE");
      stack.walk();
    }
    else {
      stack.pop();
      System.out.println("\nSTACK STATE");
      stack.walk();      
    }
    */

    /*
    // (3,5) --> should be fine
    System.out.println("\n[push: (3,5)]");
    stack.push(3,5);
    // check if valid
    if ( stack.walkAndCompare() ) {
      System.out.println("\nSTACK STATE");
      stack.walk();
    }
    else {
      stack.pop();
      System.out.println("\nSTACK STATE");
      stack.walk();      
    }
    */
