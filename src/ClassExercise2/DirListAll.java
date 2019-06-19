package ClassExercise2;
// java DirListAll
// java DirListAll <directory>

import java.io.File;

public class DirListAll {
   public static void main (String[] args) {
      String dir = (args.length > 1 && ! ".".equals(args[0])) ? args[0] :
             System.getProperty( "user.dir" );  // default for current dir
      File root = new File( dir );
      
      if (root.isDirectory()) {
		   System.out.printf( "Contents of %s :\n", dir );
		   dirList( root );
      } else if (root.exists()) {
         System.out.printf( "%s is a file.\n", dir );
      } else {
         System.out.printf( "No such a directory or file : %s !\n", dir );
      }
   }
   
   // a small overloading method for simple signature
   private static void dirList (File node) {   
      dirList( 0, node ); 
   }
   
   private static void dirList (int level, File node) {
	   if (node.isFile()) {
		   System.out.println( tabs(level) + FILE_ICON + node.getName() );
	   } else {  // for directory
         System.out.println( tabs(level) + DIR_ICON  + node.getName() );

         File[] subNodes = node.listFiles();
   	   for (File d : subNodes)    // deal with sub-notes recursively
   		   dirList( level+1, d );    
      }
   }
   
   private static String tabs (int n) {
      final String TAB = "|   ";
      String s = "";
      while (n-- > 0) s += TAB;     // repeat n times
      return s;
   }
   
   private static String FILE_ICON = "-";
   private static String DIR_ICON  = "+";    
}
