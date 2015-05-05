// Fig. 20.7: Stack.java (Deitels Java HTP p 850)
// Stack generic class declaration
import java.util.ArrayList;

public class Stack<T> {
  private final ArrayList<T> elements; // ArrayList stores stack elements

  // no-argument constructor creates a stack of the default size
  public Stack() {
    this(10); // default stack size
  }

  // constructor that creates a stack of the specified number of elements
  public Stack(int capacity) {
    int initCapacity = capacity > 0 ? capacity : 10; // validate
    elements = new ArrayList<T>(initCapacity); // create ArrayList
  }

  // push element onto stack
  public void push(T pushValue) {
    elements.add(pushValue); // place pushValue on Stack
  }

  // return the top element if not empty; else throw EmptyStackException
  public T pop() {
    if (elements.isEmpty()) // if stack is empty
      throw new EmptyStackException("Stack is empty, cannot pop");

    // remove and return top element of stack
      return elements.remove(elements.size() - 1);
  }

  // return a string of top element if not empty; else throw EmptyStackException
  public T peek() {
    if (elements.isEmpty()) // if stack is empty
      throw new EmptyStackException("Stack is empty");

    // remove and return top element of stack
      return elements.get(elements.size() - 1);
  }

  // return a string of all values in stack; else return empty stack message
  public String display() {
    String list = "";
    if (elements.isEmpty()) // if stack is empty
      list = "Stack is empty";
    else { // loop through stack
      for (int i = (elements.size()-1); i >= 0; i--) {
        list += (elements.get(i) + " ");
      }
    }

    return list;
  }

} // end class Stack<T>
