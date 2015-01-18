public class Searcher {


  public static void main(String[] args) {
    
    int[] items = new int[100000000];

    for (int i = 0; i < items.length; i++) {
      if (i % 2 == 0) {
        items[i] = (i * i) - i + 3 / 2;
      }
      else {
        items[i] = i;
      }
      //System.out.print(items[i] + " ");
    }


    // LINEAR SEARCH
    // worst-case: O(n)
    // avg-case:   O([n+1]/2) --> O(n)
    // best-case:  1 step --> O(1)
    int count = 0;
    for (int i = 0; i < items.length; i++) {
      count++;
      if (items[i] == -1641438353) {
        System.out.println("found! after " + count + " operations");
      }
    }

  }

}