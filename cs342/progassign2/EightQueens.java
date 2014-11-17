import java.util.Random;

public class EightQueens {

  // set number of rows/columns
  public static final int GRID_SIZE = 8;

  public static void main(String[] args) {

    // announce program start
    System.out.println("\n\t\t/// *** EIGHT QUEENS *** \\\\\\\n");
    // instantiate new Stack object
    Stack stack = new Stack();

    // call primary solving function;
    // return number of attempts
    int number_of_attempts = attemptToSolve(GRID_SIZE, stack); 

    // display number of attempts
    System.out.println("\n\nNUMBER OF ATTEMPTS: " + 
                       number_of_attempts);

    // display solution board
    displaySolutionBoard(GRID_SIZE, stack);
  }

  public static int attemptToSolve(int num_of_rows_and_cols,
                                       Stack stack) {
    // number of attempts after initial values
    int number_of_attempts = 0;

    // create a new random object
    Random rand = new Random();

    // create an initial, random coordinate selection
    int init_rand_row = rand.nextInt(num_of_rows_and_cols);
    int init_rand_col = rand.nextInt(num_of_rows_and_cols);

    // display the initial selection;
    System.out.println("INITIAL SELECTION\n[push: (" + 
                        init_rand_row + "," + 
                        init_rand_col + ")]"); 

    // push these initial coordinates onto stack
    stack.push(init_rand_row,init_rand_col); 

    // create initial coordinate arrays, containing
    // values 0 through (num_of_rows_and_cols - 1);
    // elimate initial coordinates as future options, since
    // future options cannot have the same row or column;
    // these arrrays will be used for future selections
    Integer[] init_row_options = new Integer[num_of_rows_and_cols - 1];
    Integer[] init_col_options = new Integer[num_of_rows_and_cols - 1];

    // for an initial (num_of_rows_and_cols - 1) times
    for (int i = 0; i < (num_of_rows_and_cols - 1); i++) {
      // if i != init_rand_row,
      // use the value of i
      if (i != init_rand_row) {
        init_row_options[i] = i;
      }
      // once i == init_rand_row,
      // pre-increment init_rand_row and use that value
      // for each subsequent loop
      else if (i == init_rand_row) {
        init_row_options[i] = ++init_rand_row;
      }
      // if i != init_rand_col,
      // use the value of i
      if (i != init_rand_col) {
        init_col_options[i] = i;
      }
      // once i == init_rand_col,
      // pre-increment init_rand_col and use that value
      // for each subsequent loop
      else if (i == init_rand_col) {
        init_col_options[i] = ++init_rand_col;
      }
    }

    // display the possible options left
    displayPossibilities(init_row_options,init_col_options); 

    // set a "solved" flag to use as while-loop control
    boolean solved = false;
    // while the problem is not solved, loop!
    while (!solved) {
      // initialize new arrays for the while-loop
      // using the initial possible options
      Integer[] row = init_row_options; 
      Integer[] col = init_col_options;

      // run a for-loop to solve the problem by creating a pair of
      // randomly-generated possible-solution vectors;
      // number_of_iterations should 
      // at least equal (num_of_rows_and_cols - 1);
      int number_of_iterations = 100;
      for (int n = 0; n < number_of_iterations; n++) {
        // create new, random coordinate selections to try
        int new_rand_row_coord = rand.nextInt(row.length);
        int new_rand_col_coord = rand.nextInt(col.length);
        // increment number of attempts;
        // display the new selections
        System.out.println("\nAttempt " + 
                            (++number_of_attempts) + 
                            ": [push: (" + 
                            row[new_rand_row_coord] + "," + 
                            col[new_rand_col_coord] + ")]\n"); 

        // push new coordinates onto stack before checking validity
        stack.push(row[new_rand_row_coord],col[new_rand_col_coord]); 

        // check if valid coordinates;
        if ( stack.walkAndCompare() ) {
          // if valid, display current stack 
          System.out.println("\n<--STACK STATE-->");
          stack.walk();

          // remove new valid row/col coordinates from options
          row = removeOptions(row, new_rand_row_coord);
          col = removeOptions(col, new_rand_col_coord);

          // if at any time during the for-loop, 
          // the stack reaches the appropriate goal size,
          // exit the for-loop and the while-loop
          if (stack.size() == num_of_rows_and_cols) {
            n = number_of_iterations;
            solved = true;
          }

        } 
        // if the new trial coordinates were not valid,
        // get rid of them, and display the stack state
        else {
          stack.pop();
          System.out.println("\n<--STACK STATE-->");
          stack.walk();      
        }

        // at the end of each for loop, 
        // display the possible options left
        displayPossibilities(row,col); 
      }

      // otherwise, if that for-loop solution set
      // didn't solve the problem, 
      // get rid of all coordinates except for initial ones
      if (stack.size() < num_of_rows_and_cols) {
        while (stack.size() > 1) {
          stack.pop();
        }
      }

    }

    // return the total number of attempts
    return number_of_attempts;
  }

  public static void displayPossibilities(Integer[] row, 
                                            Integer[] col) {
    // display numerics
    if (row.length != 1) {
      System.out.println("\n" + row.length + 
                         " sets of row,col options left\n(" +
                         (row.length * col.length) + 
                         " possibilities)");
    }
    else {
       System.out.println("\n" + row.length + 
                         " set of row,col options left\n(" +
                         (row.length * col.length) + 
                         " possibility)");     
    }

    // display possibilites
    for (int i = 0; i < row.length; i++) {
      System.out.print(row[i] + ",");
      System.out.println(col[i]);
    } 
  }

  public static Integer[] removeOptions(Integer[] old_row_or_col, 
                                int new_rand_row_or_col_coord) {
    // create new coordinate arrays for future possible choices,
    // with one less option for rows/columns;
    Integer[] new_row_or_col = new Integer[(old_row_or_col.length - 1)]; 
    // a for-loop to remove row/column values that are 
    // no longer possible options;
    // loop for current (vector lengths - 1)
    for (int i = 0; i < (new_row_or_col.length); i++) {
      // if i is less than the new valid row coord,
      // then use i
      if (i < new_rand_row_or_col_coord) {
        new_row_or_col[i] = old_row_or_col[i];
      }
      // if i is >= new_rand_row_coord, 
      // skip an index in the row array
      else if ( (i >= new_rand_row_or_col_coord)) {
        new_row_or_col[i] = old_row_or_col[i + 1];
      }
    }  

    // return a new array with options removed
    return new_row_or_col;
  }

  public static void displaySolutionBoard(int num_of_rows_and_cols,
                                          Stack stack) {
    System.out.print("\n\nSOLUTION");

    Integer[][] rows_and_cols = stack.walkAndReturn();

    for (int row = 0; row < num_of_rows_and_cols; row++) {
      System.out.println();
      for (int col = 0; col < num_of_rows_and_cols; col++) {
        if ( (rows_and_cols[row][0] == row) && 
          (rows_and_cols[row][1] == col) ) {
          System.out.print("  Q    ");
        } 
        else {
          System.out.print("(" + row + "," + col + ")  ");
        }
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
    // (2,1) --> check "difference-equality" diagonal
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
