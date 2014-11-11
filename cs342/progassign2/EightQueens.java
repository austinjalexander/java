public class EightQueens {

  public static void main(String[] args) {

    System.out.println("\n*** EIGHT QUEENS ***");
    Stack stack = new Stack();

    stack.walk();

    System.out.println("\n[push: (4,4)]");
    stack.push(4,4);
    // check if valid
    if ( stack.walkAndCompare() ) {
      System.out.println("\nSTACK STATE");
      stack.walk();
    }

    // (4,4) --> same row AND same col
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

    // (4,5) --> same row
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

    // (5,4) --> same col
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

    // (5,3) --> check equality diagonal
    System.out.println("\n[push: (5,3)]");
    stack.push(5,3);
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

    // (5,1) --> check parity diagonal
    System.out.println("\n[push: (5,3)]");
    stack.push(5,3);
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



    //displayBoard();



  }

  public static void displayBoard() {
    for (int i = 0; i < 8; i++) {
      System.out.println();
      for (int j = 0; j < 8; j++) {
        System.out.print(" - ");
      }
    }
  }
}