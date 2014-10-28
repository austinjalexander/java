/*
$ javadoc -author -source 1.4 -public -tag param -tag precondition:a:"Precondition:" -tag postcondition:a:"Postcondition:" -tag return -tag throws -tag example:a:"Example:" *.java
*/

// File: TemperatureConversion.java
// A Java application to print a temperature conversion table
// Additional Javadoc information is available in Figure 1.1 on page 11 or at
// http://www.cs.colorado.edu/~main/docs/TemperatureConversion.html

/****************************************************************************
* The <CODE>TemperatureConversion</CODE> Java application prints a table
* converitng Celsius to Fahrenheit degrees.
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
****************************************************************************/
public class TemperatureConversion {
  /** 
  * The main method prints a Celsius to Fahrenheit conversion table.
  * The String arguments (args) are not used in this implementation.
  * The bounds of the table range from -50C to +50C in 10 degree increments.
  **/
  public static void main(String[] args) {
    // Declare values that control the table's bounds
    final double TABLE_BEGIN = -50.0; // The table's first Celsius temperature
    final double TABLE_END = 50.0;    // The table's final Celsius temperature
    final double TABLE_STEP = 10.0;   // Increment between temperatures in table

    double celsius;    // A Celsius temperature
    double fahrenheit; // The equivalent Fahrenheit temperature

    System.out.println("TEMPERATURE CONVERSION");
    System.out.println("----------------------");
    System.out.println("Celsius     Fahrenheit");
    for (celsius = TABLE_BEGIN; celsius <= TABLE_END; celsius += TABLE_STEP) {
      // The for-loop has set celsius equal to the next Celsius temperature of the table.
      // Each iteration prints one line of the conversion table.
      fahrenheit = celsiusToFahrenheit(celsius);
      System.out.printf("%6.2fC", celsius);
      System.out.printf("%14.2fF\n", fahrenheit);
    }
    System.out.println("----------------------");
  }

  /**
  * Convert a temperature from Celsius to Fahrenheit degrees.
  * @param c
  *   a temperature in Celsius degrees
  * @precondition
  *   c >= -273.15
  * @return 
  *   the temperature c converted to Fahrenheit
  * @throws IllegalArgumentException
  *   Indicates that c is less than the smallest Celsius temperature (-273.15).
  **/
  public static double celsiusToFahrenheit(double c) {
    final double MINIMUM_CELSIUS = -273.15;
    if (c < MINIMUM_CELSIUS) {
      throw new IllegalArgumentException("Argument " + c + " is too small.");
    }
    return (9.0/5.0) * c + 32;
  }
}