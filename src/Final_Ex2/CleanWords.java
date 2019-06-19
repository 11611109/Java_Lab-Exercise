package Final_Ex2;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class CleanWords {
   public static void main (String[] args) throws FileNotFoundException {
      int nWords = 0, longest = 1;
      Set<String> cleanWords = new TreeSet<>();
      Scanner inFile = new Scanner( new File( args[0] ) );

      while (inFile.hasNext()) {
         String word = inFile.next();
         nWords++;
         String cleanWord = clean( word );
         if (cleanWord != null) {
            cleanWords.add( cleanWord );
            if (cleanWord.length() > longest)
               longest = cleanWord.length();
         }       
      }
      inFile.close();
      
      int[] count = new int[longest];
      PrintWriter outFile = new PrintWriter( args[1] ); 
      for (String w : cleanWords) {
         count[w.length()-1]++;
         outFile.println( w );
      }
      outFile.close();
      
      System.out.println( nWords + " words has been read from input file." );
      System.out.println( cleanWords.size() + 
         " clean words has been saved in output file." );
      System.out.printf( "The longest word length is %d.\n", longest );

      System.out.println( "\nword-length  num-of-words" );
      for (int i = 1; i <= longest; i++)
         System.out.printf( "%10d%12d\n", i, count[i-1] );
   }

   public static String clean (String word) {
      String w = word.toUpperCase();
      for (int i = 0; i < w.length(); i++) {
         char c = w.charAt(i);
         if (c < 'A' || 'Z' < c) return null;
      }
      return w;
   }
}
