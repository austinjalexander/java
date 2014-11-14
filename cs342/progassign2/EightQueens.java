import java.util.Random;

public class EightQueens {

  public static final int GRID_SIZE = 8;

  public static void main(String[] args) {

    System.out.println("\n\t\t*** EIGHT QUEENS ***\n");
    Stack stack = new Stack();

    tryNewCoordinates(GRID_SIZE, stack); 

    //displayBoard();
  }

  public static void tryNewCoordinates(int num_of_rows_and_cols,
                                       Stack stack) {
    // create a new random object
    Random rand = new Random();

    // create a first, random coordinate selection
    int init_rand_row = rand.nextInt(num_of_rows_and_cols);
    int init_rand_col = rand.nextInt(num_of_rows_and_cols);

    // display the first selection;
    System.out.println("\n[push: (" + 
                        init_rand_row + "," + 
                        init_rand_col + ")]\n"); 

    // push these initial coordinates onto stack
    stack.push(init_rand_row,init_rand_col); 

    // create initial coordinate arrays;
    // elimate initial coordinates as future options;
    // these arrrays will be used for all future selections
    Integer[] init_row_options = new Integer[num_of_rows_and_cols - 1];
    Integer[] init_col_options = new Integer[num_of_rows_and_cols - 1];

    // for the initial size of grid - 1
    for (int i = 0; i < (num_of_rows_and_cols - 1); i++) {
      // if i isn't the initial row coordinate,
      // use the value of i
      if (i != init_rand_row) {
        init_row_options[i] = i;
      }
      // in the place of the initial row coordinate,
      // use that value + 1
      else {
        init_row_options[i] = ++init_rand_row;
      }
      // if i isn't the initial col coordinate,
      // use the value of i
      if (i != init_rand_col) {
        init_col_options[i] = i;
      }
      // in the place of the initial col coordinate,
      // use that value + 1
      else {
        init_col_options[i] = ++init_rand_col;
      }
    }

    // a solved flag for while loop control
    boolean solved = false;
    // while the problem is not solved, loop!
    while (!solved) {
      // initialize loop arrays using the init versions
      Integer[] row = init_row_options; 
      Integer[] col = init_col_options;

      // a for-loop to solve the problem with a pair of
      // randomly generated possible-solution vectors;
      // it attempts the loop (size of num_of_rows_and_cols - 1) times
      for (int n = 0; n < (num_of_rows_and_cols - 1); n++) {
        System.out.println(row.length);
        // create new, random coordinate selections
        int new_rand_row_coord = rand.nextInt(row.length);
        int new_rand_col_coord = rand.nextInt(col.length);
        // display
        System.out.println("\n[push: (" + 
                            row[new_rand_row_coord] + "," + 
                            col[new_rand_col_coord] + ")]\n"); 

        // push new coordinates onto stack before checking validity
        stack.push(row[new_rand_row_coord],col[new_rand_col_coord]); 

        // check if valid coordinates
        if ( stack.walkAndCompare() ) {
          System.out.println("\nSTACK STATE");
          stack.walk();

          // create new coordinate arrays, with one less option;
          Integer[] new_row = new Integer[(row.length - 1)]; 
          Integer[] new_col = new Integer[(col.length - 1)]; 

          // a for-loop to remove row values that are 
          // no longer possible options;
          // loop for the length 1 less than the current
          // vector lengths
          for (int i = 0; i < (new_row.length); i++) {
            // if i is less than the new random row coord,
            // then use i
            if (i < new_rand_row_coord) {
              new_row[i] = row[i];
            }
            // if i is >= new_rand_row_coord, 
            // skip an index
            else if ( (i >= new_rand_row_coord)) {
              new_row[i] = row[i + 1];
            }
          }

          // a for-loop to remove col values that are 
          // no longer possible options;
          // loop for the length 1 less than the current
          // vector lengths
          for (int i = 0; i < (new_col.length); i++) {
            // if i is less than the new random col coord,
            // then use i
            if (i < new_rand_col_coord) {
              new_col[i] = col[i];
            }
            // if i is >= new_rand_col coord, 
            // skip an index
            else if ( (i == new_rand_col_coord) || (i > new_rand_col_coord)) {
              new_col[i] = col[i + 1];
            }
          }

          // set row and col to these new versions
          row = new_row;
          col = new_col;

        } //end: if ( stack.walkAndCompare() )
        // if the new trial coordinates were not valid,
        // get rid of them, and display the stack state
        else {
          stack.pop();
          System.out.println("\nSTACK STATE");
          stack.walk();      
        }

        // if at any time during the for-loop, 
        // the stack reaches the appropriate size,
        // exit the for loop
        if (stack.size() == num_of_rows_and_cols) {
          n = 100;
        }
        // at the end of each for loop, 
        // display the possible options left
        displayCoordinateState(row,col); 
      }

      // if at any time during the while-loop, 
      // the stack reaches the appropriate size,
      // exit the while loop
      if (stack.size() == num_of_rows_and_cols) {
        solved = true;
      }
      // otherwise, if that for-loop solution set
      // didn't solve the problem, 
      // get rid of all nodes exist for initial one
      else {
        while (stack.size() > 1) {
          stack.pop();
        }
      }

    }
  }

  public static void displayCoordinateState(Integer[] row, 
                                            Integer[] col) {
    System.out.println("\n" + row.length + " options left:");
    // display coordinate array states
    for (int i = 0; i < row.length; i++) {
      System.out.print(row[i] + ",");
      System.out.println(col[i]);
      // if finished
      if (i == (row.length - 1)) {
        System.out.println();
      }
    } 
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
