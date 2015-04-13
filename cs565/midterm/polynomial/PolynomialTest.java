// File: PolynomialTest.java
// Student: Austin J. Alexander
// Assignment: Midterm Problem 1
// Course: MET CS565 (SPRING 2015)

public class PolynomialTest {

  public static void main(String[] args) {

    System.out.println("\n\t<--- POLYNOMIAL CALCULATOR --->\n");
    
    // Degree: 3 //
    // (3.0 * x**0) + (5.0 * x**1) + (0.0 * x**2) + (2.0 * x**3) //
    // x = 7.0 //
    // result should be 724.0 //
    // create new polynomial with a set degree
    Polynomial plynml = new Polynomial(3);

    // set constant coefficient values based on indices
    setConstants(plynml, 
                           new int[] {0, 1, 3}, 
                           new double[] {3.0, 5.0, 2.0});

    // evaluate polynomial at particular x and display result
    evaluateAndDisplay(plynml, 7.0);


    // Degree: 5 //
    // (2.4 * x**0) + (3.5 * x**1) + (25.0 * x**2) + (100.0 * x**3) + 
    // (32.0 * x**4) + (0.0 * x**5) //
    // x = 2.0 //
    // result should be 1421.4 //
    // create new polynomial with a set degree
    plynml = new Polynomial(5);

    // set constant coefficient values based on indices
    setConstants(plynml, 
                           new int[] {0, 1, 2, 3, 4}, 
                           new double[] {2.4, 3.5, 25.0, 100.0, 32.0});

    // evaluate polynomial at particular x and display result
    evaluateAndDisplay(plynml, 2.0);


    // Degree: 1 //
    // (0.0 * x**0) + (26.0 * x**1) //
    // x = 3.7 //
    // result should be 96.2 //
    // create new polynomial with a set degree
    plynml = new Polynomial(1);

    // set constant coefficient values based on indices
    setConstants(plynml, 
                           new int[] {1}, 
                           new double[] {26.0});

    // evaluate polynomial at particular x and display result
    evaluateAndDisplay(plynml, 3.7);


    // Degree: 0 //
    // (3.0 * x**0) + (0.0 * x**1) //
    // x = 1.0 //
    // result should be 3.0 //
    // create new polynomial with a set degree
    plynml = new Polynomial(1);

    // set constant coefficient values based on indices
    setConstants(plynml, 
                           new int[] {0}, 
                           new double[] {3.0});

    // evaluate polynomial at particular x and display result
    evaluateAndDisplay(plynml, 1.0);


    // SHOW EXCEPTION HANDLING WITH NEGATIVE DEGREE //
    // Degree: -1 //
    // attempt to create new polynomial with a set degree
    plynml = new Polynomial(-1);

    System.out.println("\n\t<--- END --->\n");

  }

  // STATIC HELPER METHODS
  // set constants using indices
  private static void setConstants(Polynomial plynml, 
                                             int[] indices, 
                                             double[] constants) {
    for (int i = 0; i < indices.length; i++) {
      plynml.setConstant(indices[i], constants[i]);
    }
  }
  // evaluate and display polynomial and its combination
  private static void evaluateAndDisplay(Polynomial plynml, double x) {
    System.out.println("\nWhen x = " + x + ",");
    System.out.println(plynml.evaluate(x) + "\n");
  }

}