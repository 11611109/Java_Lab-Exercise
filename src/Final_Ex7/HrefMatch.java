/**
 * <a href=...> HTML tag. Start the program as
 * java HrefMatch 
 * java HrefMatch URL
 * java HrefMatch URL CHARSET_NAME
 */
package Final_Ex7;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
import java.nio.charset.*;

public class HrefMatch {
   private static final String CHARSET_NAME = "UTF-8";
   private static final Locale LOCALE = Locale.SIMPLIFIED_CHINESE;
   
   public static void main (String[] args) {
      // get URL string from command line or use default
      String sURL = (args.length > 0) ? args[0] :
                    "http://www.sustech.edu.cn";
      String charSetName = (args.length > 1) ? args[0] : CHARSET_NAME;                 
      try {
         URL url = new URL( sURL );
         URLConnection site = url.openConnection();
         InputStream is = site.getInputStream();
         Scanner scanner = new Scanner( new BufferedInputStream(is), charSetName );
         scanner.useLocale(LOCALE);

         // read contents of URL
         StringBuffer sb = new StringBuffer();
         while (scanner.hasNext()) 
            sb.append( scanner.nextLine() );  
         String input = sb.toString();

         // search for all occurrences of pattern
         final String sPattern = "<a\\s+href\\s*=\\s*((\"[^\"]*\")|('[^']*'))";
         final Pattern pattern = Pattern.compile( sPattern );
         Matcher matcher = pattern.matcher( input );
         while (matcher.find()) {
            String href = purifyHref( matcher.group(1) );
            if (href != null) 
               System.out.println( href );
         }
      } catch (IOException e) {  // IOException or PatternSyntaxException 
         e.printStackTrace();
      }       
   }
   
   public static String purifyHref (String href) {
      String s = href.substring( 1, href.length()-1).trim();
      if (s.length() == 0) return null;
      if (s.startsWith( "#" ) || 
          s.regionMatches( true, 0, "javascript", 0, 10) ||
          s.regionMatches( true, 0, "script", 0, 6) )
         return null;
   // if (s.matches( "^(#.*)|((?i)javascript.*)|((?i)script.*)$" )) return null; 
      return s;
   }
}
