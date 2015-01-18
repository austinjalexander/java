/* FROM WIKIPEDIA
Starting from the beginning of the list, compare every adjacent pair, swap their position if they are not in the right order (the latter one is smaller than the former one). After each iteration, one less element (the last one) is needed to be compared until there are no more elements left to be compared.
*/

// basically, greater values bubble right -->

// worst case: O(n^2)
// best case:  O(n^2)
// avg case:     O(n)

public class BubbleSort {

  public static char[] text_to_sort = "INSERTIONSORT".toCharArray();
  
  public static void main(String[] args) {

    System.out.println(text_to_sort);
    boolean sorted = false;
    while (sorted == false) {
      sorted = true;
      for (int i = 0; i < text_to_sort.length; i++) {
        if ( (i + 1 != text_to_sort.length) && (text_to_sort[i] > text_to_sort[i + 1]) ) {
          char temp = text_to_sort[i];
          text_to_sort[i] = text_to_sort[i + 1];
          text_to_sort[i + 1] = temp;
          sorted = false;
        }
      }
      System.out.println(text_to_sort);
    }
  }
}