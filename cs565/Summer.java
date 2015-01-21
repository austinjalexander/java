// File: Summer.java
// Student: Austin J. Alexander
// Assignment: HW 1
// Course: MET CS565 (SPRING 2015)

import java.util.Scanner;

public class Summer {

  public static void main(String[] args) {

    String FULLNAME = "Austin J. Alexander";

    System.out.println("\n\t  " + FULLNAME + "\n");
    System.out.println("\t<------- SUMMER ------->\n");

    int n = 0;
    while (n <= 0) {
      n = getUserInput();
    }

    int sum, even_sum, odd_sum;
    sum = even_sum = odd_sum = 0;

    System.out.print("\nn = " + n);
    singleWhile(n, sum, even_sum, odd_sum);
    separateWhiles(n, sum, even_sum, odd_sum);

    System.out.println("\t<------- END ------->\n");
  }

  private static int getUserInput() {
    Scanner user_input = new Scanner(System.in);
    System.out.print("Please enter an integer, n > 0, to sum: ");
    int n = 0;
    try {
      n = Integer.parseInt(user_input.nextLine());
    }
    catch (NumberFormatException e) { // not an int
      n = 0;
    }

    return n;
  }

  private static void singleWhile(int n, int sum, int even_sum,
                                  int odd_sum) {
    System.out.println("\n\t(single while, with %)");
    int i = 1;
    while (i <= n) {
      sum += i;
      if (i % 2 == 0) {
        even_sum += i;
      }
      else {
        odd_sum += i;
      }
      i++;
    }

    display(sum, even_sum, odd_sum);
  }

  private static void separateWhiles(int n, int sum, int even_sum,
                                     int odd_sum) {
    System.out.println("\t(three whiles, no %)");
    int i = 1;
    while (i <= n) {
      sum += i;
      i++;
    }

    i = 1;
    while (i <= n) {
      if ( (i/2) == (i/2.0) ) {
        even_sum += i;
      }
      i++;
    }

    i = 1;
    while (i <= n) {
      if ( (i/2) != (i/2.0) ) {
        odd_sum += i;
      }
      i++;
    }

    display(sum, even_sum, odd_sum);
  }

  private static void display(int sum, int even_sum, int odd_sum) {
    System.out.println("Sum of integers, 1 to n (inclusive) = " 
                       + sum);
    System.out.println("Sum of even integers, 1 to n (inclusive) = " 
                       + even_sum);
    System.out.println("Sum of odd integers, 1 to n (inclusive) = " 
                       + odd_sum + "\n");
  }

}