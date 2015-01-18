public class HashTable {
  
  // INSTANCE VARIABLES
  private int num_of_buckets;
  private Node[] table;

  // CONSTRUCTORS
  public HashTable() {
    this.num_of_buckets = 100;
    this.table = new Node[num_of_buckets];
  }
  public HashTable(int num_of_buckets) {
    this.num_of_buckets = num_of_buckets;
    this.table = new Node[num_of_buckets];
  }

  // PUBLIC METHODS
  public boolean add(String content) {
    int index = hashFunction(content);
    boolean added = false;
    if (this.table[index] == null) {
      this.table[index] = new Node(content);
      added = true;
    }
    else {
        Node temp_node = this.table[index];
        while (temp_node.getNext() != null) {
          temp_node = temp_node.getNext();
        }
        temp_node.setNext(new Node(content));
        added = true; 
    }

    return added;
  }

  public void showHash() {
    System.out.println("\n--- HASH TABLE ---");
    for (int i = 0; i < this.num_of_buckets; i++) {
      System.out.print("  " + i + " : ");
      if (this.table[i] == null) {
        System.out.println();
      }
      else {
        Node temp_node = this.table[i];
        while (temp_node != null) {
          System.out.print(temp_node.toString() + " ");
          temp_node = temp_node.getNext();
        }
        System.out.println();
      }
    }
  }

  public boolean search(String content) {
    boolean found = false;

    int index = hashFunction(content);

    if (this.table[index] != null) {
      if (this.table[index].toString() == content) {
        found = true;
      }
      else {
        Node temp_node = this.table[index];
        while ((temp_node != null) && (found == false)) {
          if (temp_node.toString() == content) {
            // exit while loop
            found = true;
          }
          else {
            temp_node = temp_node.getNext();
          }
        }
      }
    }

    return found;
  }

  public void traceSearch(String content) {
    boolean found = false;

    int index = hashFunction(content);

    System.out.print("(trace) ");

    if (this.table[index] != null) {
      if (this.table[index].toString() == content) {
        System.out.print(this.table[index].toString());
        found = true;
      }
      else {
        Node temp_node = this.table[index];
        while ((temp_node != null) && (found == false)) {
          System.out.print(temp_node.toString() + " ");
          if (temp_node.toString() == content) {
            // exit while loop
            found = true;
          }
          else {
            temp_node = temp_node.getNext();
          }
        }
      }
    }

    if (found == false) {
      System.out.println("not found");
    }
    else {
      System.out.println();
    }    
  }

  public boolean delete(String content) {
    boolean deleted = false;

    int index = hashFunction(content);

    
    if (this.table[index] != null) {
      // if head-node matches, set it to next (which might be null)
      if (this.table[index].toString() == content) {
        this.table[index] = this.table[index].getNext();
        deleted = true;
      }
      else {
        Node temp_node = this.table[index];
        while ((temp_node != null) && (deleted == false)) {
          // if the next node matches, 
          // set it to next-next node (which might be null)
          if ((temp_node.getNext() != null) && (temp_node.getNext().toString() == content)) {
            temp_node.setNext(temp_node.getNext().getNext());

            // exit while loop
            deleted = true;
          }
          else {
            temp_node = temp_node.getNext();
          }
        }
      }
    }

    return deleted;
  }

  // PRIVATE METHODS
  private int hashFunction(String content) {
    return Math.abs(content.hashCode()) % this.num_of_buckets;
  }


}