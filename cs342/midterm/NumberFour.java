public class NumberFour {
  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 12; j++) {
        if (j == 5) {
          break;
        }
        if ((j == 0) || (i == 0)) {
          continue;
        }
        if (!((j*i % 3) != 0)) {
          System.out.print(j*i);
        }
      }
    }
    System.out.println();
  }
}