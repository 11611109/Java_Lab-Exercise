package Final_Ex8;
import textio.TextIO;

    /** 
     * This program will convert Roman numerals to ordinary arabic numerals
     * and vice versa.  The user can enter a numerals of either type.  Arabic
     * numerals must be in the range from 1 to 3999 inclusive.  The user ends
     * the program by entering an empty line.
     */
    public class RomanConverter {
    
       public static void main(String[] args) {
          
          System.out.println("Enter a Roman numeral and I will convert it to an ordinary");
          System.out.println("arabic integer.  Enter an integer in the range 1 to 3999");
          System.out.println("and I will convert it to a Roman numeral.  Press return when");
          System.out.println("you want to quit.");
          
          while (true) {
    
             System.out.println();
             System.out.print("? ");
             
             /* Skip past any blanks at the beginning of the input line.
                Break out of the loop if there is nothing else on the line. */
             
             while (TextIO.peek() == ' ' || TextIO.peek() == '\t')
                TextIO.getAnyChar();
             if ( TextIO.peek() == '\n' )
                break;
                
             /* If the first non-blank character is a digit, read an arabic
                numeral and convert it to a Roman numeral.  Otherwise, read
                a Roman numeral and convert it to an arabic numeral. */
                
             if ( Character.isDigit(TextIO.peek()) ) {
                int arabic = TextIO.getlnInt();
                try {
                    RomanNumeral N = new RomanNumeral(arabic);
                    System.out.println(N.toInt() + " = " + N.toString());
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    System.out.println(e.getMessage());
                }
             }
             else {
                String roman = TextIO.getln();
                try {
                    RomanNumeral N = new RomanNumeral(roman);
                    System.out.println(N.toString() + " = " + N.toInt());
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    System.out.println(e.getMessage());
                }
             }
    
          }  // end while
          
          System.out.println("OK.  Bye for now.");
    
       }  // end main()
       
    } // end class RomanConverter
    /**
     * An object of type RomanNumeral is an integer between 1 and 3999.  It can
     * be constructed either from an integer or from a string that represents
     * a Roman numeral in this range.  The function toString() will return a
     * standardized Roman numeral representation of the number.  The function
     * toInt() will return the number as a value of type int.
     */
    class RomanNumeral {
    
       private final int num;   // The number represented by this Roman numeral.
       
       /* The following arrays are used by the toString() function to construct
        * the standard Roman numeral representation of the number.  For each i,
        * the number numbers[i] is represented by the corresponding string, letters[i].
        */
       
       private static int[]    numbers = { 1000,  900,  500,  400,  100,   90,  
                                             50,   40,   10,    9,    5,    4,    1 };
                                          
       private static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC",
                                           "L",  "XL",  "X",  "IX", "V",  "IV", "I" };
          
       /**
        * Constructor.  Creates the Roman number with the int value specified
        * by the parameter.  
        * @throws NumberFormatException if the parameter is not in the range 1 to 3999 inclusive.
        */
       public RomanNumeral(int arabic) {
          if (arabic < 1)
             throw new NumberFormatException("Value of RomanNumeral must be positive.");
          if (arabic > 3999)
             throw new NumberFormatException("Value of RomanNumeral must be 3999 or less.");
          num = arabic;
       }
       
    
       /*
        * Constructor.  Creates the Roman number with the given representation.
        * For example, RomanNumeral("xvii") is 17.  If the parameter is not a
        * legal Roman numeral, a NumberFormatException is thrown.  Both upper and
        * lower case letters are allowed.
        * @throws NumberFormatException if the parameter is not a legal Roman numeral
        */
       public RomanNumeral(String roman) {
             
          if (roman.length() == 0)
             throw new NumberFormatException("An empty string does not define a Roman numeral.");
             
          roman = roman.toUpperCase();  // Convert to upper case letters.
          
          int i = 0;       // A position in the string, roman;
          int arabic = 0;  // Arabic numeral equivalent of the part of the string that has
                           //    been converted so far.
          
          while (i < roman.length()) {
          
             char letter = roman.charAt(i);        // Letter at current position in string.
             int number = letterToNumber(letter);  // Numerical equivalent of letter.
                             
             i++;  // Move on to next position in the string
             
             if (i == roman.length()) {
                   // There is no letter in the string following the one we have just processed.
                   // So just add the number corresponding to the single letter to arabic.
                arabic += number;
             }
             else {
                   // Look at the next letter in the string.  If it has a larger Roman numeral
                   // equivalent than number, then the two letters are counted together as
                   // a Roman numeral with value (nextNumber - number).
                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > number) {
                     // Combine the two letters to get one value, and move on to next position in string.
                   arabic += (nextNumber - number);
                   i++;
                }
                else {
                     // Don't combine the letters.  Just add the value of the one letter onto the number.
                   arabic += number;
                }
             }
             
          }  // end while
          
          if (arabic > 3999)
             throw new NumberFormatException("Roman numeral must have value 3999 or less.");
             
          num = arabic;
          
       } // end constructor
       
    
       /**
        * Find the integer value of letter considered as a Roman numeral.  Throws
        * NumberFormatException if letter is not a legal Roman numeral.  The letter 
        * must be upper case.
        */
       private int letterToNumber(char letter) {
          switch (letter) {
             case 'I':  return 1;
             case 'V':  return 5;
             case 'X':  return 10;
             case 'L':  return 50;
             case 'C':  return 100;
             case 'D':  return 500;
             case 'M':  return 1000;
             default:   throw new NumberFormatException(
                          "Illegal character \"" + letter + "\" in Roman numeral");
          }
       }
       
    
       /**
        * Return the standard representation of this Roman numeral.
        */
       public String toString() {
          String roman = "";  // The roman numeral.
          int N = num;        // N represents the part of num that still has
                              //   to be converted to Roman numeral representation.
          for (int i = 0; i < numbers.length; i++) {
             while (N >= numbers[i]) {
                roman += letters[i];
                N -= numbers[i];
             }
          }
          return roman;
       }
       
     
       /**
        * Return the value of this Roman numeral as an int.
        */
       public int toInt() {
          return num;
       }
     
       
    } // end class RomanNumeral
