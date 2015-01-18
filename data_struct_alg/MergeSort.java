/* FROM WIKIPEDIA
An example of merge sort. First divide the list into the smallest unit 
(1 element), then compare each element with the adjacent list to sort 
and merge the two adjacent lists. Finally all the elements are sorted 
and merged.

Conceptually, a merge sort works as follows:
1) Divide the unsorted list into n sublists, each containing 1 element 
(a list of 1 element is considered sorted).
2) Repeatedly merge sublists to produce new sorted sublists until 
there is only 1 sublist remaining. This will be the sorted list.
*/

// worst case: O(n log n)
// best case:  O(n log n) typical, O(n) natrual variant
// avg case:   O(n log n) 

public class MergeSort {

  public static char[] text_to_sort = "SNI".toCharArray();
  
  public static void main(String[] args) {

    
    char[] merged = partition(text_to_sort);
    for (int i = 0; i < merged.length; i++) {
      System.out.println(merged[i]);
    }




  }

  public static char[] partition(char[] text_to_sort) {

    char[] left;
    char[] right;
    char[] merged = new char[text_to_sort.length];

    if (text_to_sort.length > 1) {

      // partition
      right = new char[text_to_sort.length / 2];
      left = new char[text_to_sort.length - right.length];

      for (int i = 0; i < left.length; i ++) {
        left[i] = text_to_sort[i];
      }
      left = partition(left);

      for (int i = 0; i < right.length; i ++) {
        right[i] = text_to_sort[i + left.length];
      }
      right = partition(right);

      // sort
      char[] sorted = new char[left.length + right.length];
      for (int i = 0; i < sorted.length; i++) {
        if (i < right.length) {
          if (left[i] > right[i]) {
            sorted[i] = right[i];
            sorted[i + 1] = left[i];
          }
          else {
            sorted[i] = left[i];
            sorted[i + 1] = right[i];
          }
        }
        else if (i < left.length) {
          if (left[i] > right[i - 1]) {
            sorted[i] = right[i - 1];
            sorted[i + 1] = left[i];
          }
          else {
            sorted[i] = left[i];
            sorted[i + 1] = right[i - 1];
          }
        }
      }

      merged = sorted;

    } //if (text_to_sort.length > 1) 
    else if (text_to_sort.length == 1) {
      merged = text_to_sort;
    }
    
    return merged;

  } //public static char[] partition(char text_to_sort)


}