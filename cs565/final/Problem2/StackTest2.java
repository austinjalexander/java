// Fig. 20.10: StackTest2.java (Deitels Java HTP p 855)
// Passing generic Stack objects to generic methods
public class StackTest2 {

  public static void main(String[] args) {
    Double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5};
    Integer[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // Create a Stack<Double> and a Stack<Integer>
    Stack<Double> doubleStack = new Stack<>(5);
    Stack<Integer> integerStack = new Stack<>();

    // push elements of doubleElements onto doubleStack
    //testPush("doubleStack", doubleStack, doubleElements);
    //testPop("doubleStack", doubleStack); // pop from doubleStack

    // push elements of integerElements onto integerStack
    //testPush("integerStack", integerStack, integerElements);
    //testPop("integerStack", integerStack); // pop from integerStack

    /*** AJA : PEEK TEST ***/
    System.out.println("\n\n*** PEEK TEST ***");

    System.out.println("\n<doubleStack>");
    testPeek("doubleStack", doubleStack);
    // push elements of doubleElements onto doubleStack
    testPush("doubleStack", doubleStack, doubleElements);
    testPeek("doubleStack", doubleStack);
    testPop("doubleStack", doubleStack);

    System.out.println("\n<integerStack>");
    testPeek("integerStack", integerStack);
    // push elements of integerElements onto integerStack
    testPush("integerStack", integerStack, integerElements);
    testPeek("integerStack", integerStack);
    testPop("integerStack", integerStack);

    /*** AJA : DISPLAY TEST ***/
    System.out.println("\n\n*** DISPLAY TEST ***");

    System.out.print("\n<doubleStack>");
    testDisplay("doubleStack", doubleStack);
    // push elements of doubleElements onto doubleStack
    testPush("doubleStack", doubleStack, doubleElements);
    testDisplay("doubleStack", doubleStack);
    testPop("doubleStack", doubleStack);

    System.out.print("\n<integerStack>");
    testDisplay("integerStack", integerStack);
    // push elements of integerElements onto integerStack
    testPush("integerStack", integerStack, integerElements);
    testDisplay("integerStack", integerStack);
    testPop("integerStack", integerStack);

  }

  // generic method testPush pushes elements onto a Stack
  public static <T> void testPush(String name, Stack<T> stack, T[] elements) {
    System.out.printf("%nPushing elements onto %s%n", name);

    // push elements onto Stack
    for (T element : elements) {
      System.out.printf("%s ", element);
      stack.push(element); // push element onto stack
    }
  }

  /*** AJA ***/
  // generic method testDisplay displays all elements in a Stack
  public static <T> void testDisplay(String name, Stack<T> stack) {
    System.out.printf("%n%nDisplaying elements from %s: %s%n", 
                      name, stack.display());
  }

  /*** AJA ***/
  // generic method testPeek peeks at the next element from a Stack
  public static <T> void testPeek(String name, Stack<T> stack) {
    // pop elements from stack
    try {
      System.out.printf("%n%nPeek at the next element from from %s: %s%n", 
                        name, stack.peek().toString());
    }
    catch(EmptyStackException emptyStackException) {
      System.out.println();
      emptyStackException.printStackTrace();
    }
  } 

  // generic method testPop pops elements from a Stack
  public static <T> void testPop(String name, Stack<T> stack) {
    // pop elements from stack
    try {
      System.out.printf("%nPopping elements from %s%n", name);
      T popValue; // store element removed from stack

      // remove all elements from Stack
      while (true) {
        popValue = stack.pop();
        System.out.printf("%s ", popValue);
      }
    }
    catch(EmptyStackException emptyStackException) {
      System.out.println();
      emptyStackException.printStackTrace();
    }
  } 
  
} // end class StackTest2
