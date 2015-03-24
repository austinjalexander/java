public class Polynomial {
  
  // ATTRIBUTES
  // value of the largest exponent
  int degree;         
  // array of coefficients  
  double[] coefficients; 

  // CONSTRUCTOR
  public Polynomial(int max) {
    // only continue if max is non-negative
    try {
      if (max < 0) {
        throw new Exception(max + " was the degree entered. " +
                            "Degree must be non-negative.\n");
      }
      this.degree = max; 
      this.coefficients = new double[max + 1];
      // set all coefficients to 0 by default
      for (int i = 0; i < this.coefficients.length; i++) {
        this.coefficients[i] = 0;
      }
    }
    catch(Exception e) {
      System.out.println(e);
    }
  }

  // METHODS
  // set individual constant coefficient values by index
  public void setConstant(int i, double value) {
    this.coefficients[i] = value;
  }
  // evaluate entire polynomial as a linear combination of monomials
  public double evaluate(double x) {
    double sum = 0;
    for (int i = 0; i < this.coefficients.length; i++) {
      sum += ( this.coefficients[i] * Math.pow(x,i) );

      // display each monomial term
      System.out.print("(" + this.coefficients[i] + " * x**" + i + ")");
      if ( (i + 1) < this.coefficients.length ) {
        System.out.print(" + ");
      }
      else {
        System.out.print(" = ");
      }
    }
    return sum;
  }
}