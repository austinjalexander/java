public class Queue {

  private int[] nodes;
  private int front;
  private int rear;
  private int size;

  public Queue() {
    this.nodes = new int[3];
    this.front = 0;
    this.rear = 0;
    this.size = 0;
  }

  public boolean add(int content) {
    boolean added = false;

    if ((size == 0) && (front == rear)) {
      nodes[front] = content;
      rear++;
      size++;
      added = true;
    }
    else if ((size > 0) && (front != rear)) {
      nodes[rear] = content;
      rear++;
      size++;
      added = true;
    }
    else if ((size > 0) && (front == rear)) {
      System.out.println("\nQueue is full");
    }

    return added;
  }

  public void display() {
    System.out.println("front: " + this.front);
    System.out.println("rear: " + this.rear);
    for (int i = 0; i < this.size; i++) {
      System.out.println(nodes[i]);
    }
  }
}