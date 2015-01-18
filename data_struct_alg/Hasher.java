public class Hasher {

  private static final int NUM_OF_BUCKETS = 31;

  public static void main(String[] args) {

    System.out.println("\n\t--> THE HASHER : string --> &#*#^#@");

    // content for table
    String[] names = { "Jim",
                       "Bob",
                       "Vic",
                       "Susie",
                       "Billy",
                       "Jimmy",
                       "Nancy",
                       "Jenny",
                       "Curly",
                       "Moe",
                       "Steve",
                       "Sara",
                       "Heather",
                       "Marge",
                       "Jim" };

    // create a hash table
    HashTable hash_table = new HashTable(NUM_OF_BUCKETS);

    // loop through content and add each
    for (int i = 0; i < names.length; i++) {
      hash_table.add(names[i]);
    }

    hash_table.showHash();

    System.out.println("\nSEARCH");
    System.out.println("Sparky found? " + hash_table.search("Sparky"));
    System.out.println("Jim found? " + hash_table.search("Jim"));
    System.out.println("Vic found? " + hash_table.search("Vic"));
    System.out.println("Moe found? " + hash_table.search("Moe"));
    System.out.println("Curly found? " + hash_table.search("Curly"));

    System.out.println("\nTRACE SEARCH");
    System.out.print("Sparky found? ");
    hash_table.traceSearch("Sparky");
    System.out.print("Jim found? ");
    hash_table.traceSearch("Jim");
    System.out.print("Vic found? ");
    hash_table.traceSearch("Vic");
    System.out.print("Moe found? ");
    hash_table.traceSearch("Moe");
    System.out.print("Curly found? ");
    hash_table.traceSearch("Curly");

    System.out.println("\nDELETE");
    System.out.println("Sparky deleted? " + hash_table.delete("Sparky"));
    System.out.println("Jim deleted? " + hash_table.delete("Jim"));
    System.out.println("Vic deleted? " + hash_table.delete("Vic"));
    System.out.println("Moe deleted? " + hash_table.delete("Moe"));
    System.out.println("Curly deleted? " + hash_table.delete("Curly"));

    hash_table.showHash();

    System.out.println("\n\t--> THE END <--\n");

  }
}