package ClassExercise3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class E19_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String charString=args[0];
		String pattern=args[1];
		int[] result = IntStream.range(0, charString.length())
				.filter(i ->String.valueOf(charString.charAt(i)).equals(pattern))
				.toArray();
		for (int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}
		
		//Other use RE to implement this funtion
//		String searchString = "", searchPattern = "";
//		if (args.length == 2) {
//			searchPattern = args[1];
//			searchString = args[0];
//
//		} else {
//			System.exit(0);
//		}
//		Pattern p = Pattern.compile(searchPattern);
//		Matcher m = p.matcher(searchString);
//		boolean b = m.find();
//		System.out.println("\nMatch found : " + b);
//		while (b) {
//			System.out.println("Match start : " + m.start());
//			System.out.println("Match end : " + m.end());
//			System.out.println("Match content : " + m.group(0));
//			if (m.groupCount() != 0) {
//				for (int i = 1; i <= m.groupCount(); i++) {
//					System.out.println("Group " + i + " : " + m.group(i));
//				}
//			}
//			b = m.find();
//			if (b)
//				System.out.println("\nMatch found : " + b);
//		}
	}

}
