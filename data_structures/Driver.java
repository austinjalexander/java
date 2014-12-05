public class Driver {

  public static void main(String[] args) {

    // BINARY TREE //
    ///*
    System.out.println("\n*** BINARY TREE ***");
    BinaryTree binary_tree = new BinaryTree();

    System.out.println("empty? " + binary_tree.isEmpty());

    System.out.println("\n[enbinary_tree: 'jim','bob','bill']");
    binary_tree.enbinary_tree("jim");
    binary_tree.enbinary_tree("bob");
    binary_tree.enbinary_tree("bill");

    System.out.println("empty? " + binary_tree.isEmpty());
    System.out.println("size? " + binary_tree.size());

    System.out.println("\n[peek then debinary_tree 4 times]");
    System.out.println(binary_tree.peek());
    binary_tree.debinary_tree();
    System.out.println(binary_tree.peek());
    binary_tree.debinary_tree();
    System.out.println(binary_tree.peek());
    binary_tree.debinary_tree();
    System.out.println(binary_tree.peek());
    binary_tree.debinary_tree();

    System.out.println("empty? " + binary_tree.isEmpty());
    System.out.println("size? " + binary_tree.size());
    //*/

    // STACK //
    /*
    System.out.println("\n*** STACK ***");
    Stack stack = new Stack();


    System.out.println("empty? " + stack.isEmpty());

    System.out.println("\n[push: 'jim','bob','bill']");
    stack.push("jim");
    stack.push("bob");
    stack.push("bill");

    System.out.println("empty? " + stack.isEmpty());
    System.out.println("size? " + stack.size());

    System.out.println("\n[peek then pop 4 times]");
    System.out.println(stack.peek());
    stack.pop();
    System.out.println(stack.peek());
    stack.pop();
    System.out.println(stack.peek());
    stack.pop();
    System.out.println(stack.peek());
    stack.pop();

    System.out.println("empty? " + stack.isEmpty());
    System.out.println("size? " + stack.size());
    //*/

    
    // QUEUE //
    /*
    System.out.println("\n*** QUEUE ***");
    Queue queue = new Queue();

    System.out.println("empty? " + queue.isEmpty());

    System.out.println("\n[enqueue: 'jim','bob','bill']");
    queue.enqueue("jim");
    queue.enqueue("bob");
    queue.enqueue("bill");

    System.out.println("empty? " + queue.isEmpty());
    System.out.println("size? " + queue.size());

    System.out.println("\n[peek then dequeue 4 times]");
    System.out.println(queue.peek());
    queue.dequeue();
    System.out.println(queue.peek());
    queue.dequeue();
    System.out.println(queue.peek());
    queue.dequeue();
    System.out.println(queue.peek());
    queue.dequeue();

    System.out.println("empty? " + queue.isEmpty());
    System.out.println("size? " + queue.size());
    //*/
  }
}