/* FROM THE ALGORITHM DESIGN MANUAL
- the basis case consists of a single element, and by definition a 
one-element array is completely sorted
- in general, we can assume that the first n - 1 elements of array A
are completely sorted after n - 1 iterations of insertion sort
- to insert one last element x to A, we find where it goes, namely the 
unique spot between the biggest element less than or equal to x 
and the smallest element greater than x. this is done by moving all the 
greater elements back by one position, creating room for x in the 
desired location
*/

// basically, smaller values are inserted left

// worst case: O(n^2) comparisons, swaps
// best case:    O(n) comparisons, O(1) swaps
// avg case:   O(n^2) comparisons, swaps

public class InsertionSort {

  public static char[] text_to_sort = "INSERTIONSORT".toCharArray();
  
  public static void main(String[] args) {

    System.out.println(text_to_sort);

    // loop through array
    for (int i = 0; i < text_to_sort.length; i++) {
      int j = i;
      // while j is a valid index, and [j-1] > [j] 
      // (i.e., left > right),
      // loop backwards through array, comparing values,
      //  and insert at appropriate spot
      while ( (j > 0) && (text_to_sort[j - 1] > text_to_sort[j]) ) {
        // temp for the larger value
        char larger = text_to_sort[j - 1];
        // move smaller value to lower index
        text_to_sort[j - 1] = text_to_sort[j];
        // move larger value to higher index
        text_to_sort[j] = larger;

        // decrement j index
        j--;
      }
      System.out.println(text_to_sort);
    }
    
  }
}