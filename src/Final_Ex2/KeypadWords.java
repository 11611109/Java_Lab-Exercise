package Final_Ex2;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class KeypadWords {
   public static void main (String[] args) throws FileNotFoundException {
      Map<String, Set<String>> dic = new HashMap<>();
      
      Scanner inFile = new Scanner( new File( args[0] ) );
      while (inFile.hasNext()) {
         String word = inFile.next();
         String key = toDigits( word );
         Set<String> words = 
            (dic.containsKey( key )) ? dic.get( key ) : new TreeSet<>();
         words.add( word );
         dic.put( key, words );
      }
      inFile.close();
     
      Scanner input = new Scanner( System.in ); 
      while (true) {
         System.out.print( "\nEnter a phone number (0 for exit): " );
         String phone = input.next();
         
         if (phone.charAt(0) == '0') break;
         
         Set<String> words = dic.get( phone );
         if (words != null)
            System.out.printf( "\nwords for %s :\n%s\n", 
               phone, words.toString()
            );
         else
            System.out.printf( "\nno words for %s.\n", phone );
      }
      input.close();
   }
   
   private static final String DIGIT = "22233344455566677778889999"; 
   private static String toDigits (String word) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < word.length(); i++)
         sb.append( DIGIT.charAt( (int)(word.charAt(i)-'A') ));
      return sb.toString();
   }      
}
