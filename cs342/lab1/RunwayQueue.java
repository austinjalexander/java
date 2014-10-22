// FIFO Array-Based Queue

public class RunwayQueue {

  // INSTANCE VARIABLES
  private static final int QUEUE_SIZE = 10000000;
  private Integer front;
  private String[] flight_numbers;
  private int count;
  

  // CONSTRUCTORS
  public RunwayQueue() {
    front = null;
    flight_numbers = new String[QUEUE_SIZE];
    count = 0;
  }
  public RunwayQueue(int queue_size) {
    front = null;
    flight_numbers = new String[queue_size];
    count = 0;
  }

  // GETTERS 
  public String[] getQueue() {
    return this.flight_numbers;
  }

  // PUBLIC METHODS
  public void addFlight(String flight_number) {
    // if queue is empty
    if (count == 0) {
      flight_numbers[0] = flight_number;
      front = 0;
      count++;
    }
    // otherwise, if the apparent proper location is empty
    else {
      flight_numbers[front + count] = flight_number;
      count++;
    }
  }

  public void removeFlight() {
    // if queue is empty
    if (count == 0) {
      System.out.println("\n\tQueue is empty.");
    }
    // otherwise, remove flight
    else {
      flight_numbers[front] = null;
      front = (front + 1);
      count--;
    }
  }

  public int size() {
    return this.count;
  }

  public Boolean isEmpty() {
     Boolean is_empty = true;

     if (this.count > 0) {
        is_empty = false;
     }

    return is_empty;
  }

  public void displayQueue() {
    if (count == 0) {
      System.out.println("\n\tQueue is empty.");
    }
    else {
      System.out.println("\nQueue:");
      if (front == 0) {
        for (int i = front; i < count; i++) {
          System.out.println(flight_numbers[i]);
        }
      }
      else {
        for (int i = front; i <= count; i++) {
          System.out.println(flight_numbers[i]);
        }          
      }
    }
  }

}