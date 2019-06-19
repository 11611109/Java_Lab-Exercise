package Lab3;
import java.io.*;
import java.util.TreeMap;

public class test {
	public static void main(String []args) {
//	
//		BufferedReader Infile=new BufferedReader(new FileReader("a"));
//		int x=Integer.parseInt(Infile.readLine());
//		String aString="h";
//		char x=aString.charAt(2);
//		System.out.println(x);
//		try {
//			System.out.println("aa");
//		} 
		String x="Hello";
		String y=null;
//		System.out.println(x==y);
		y="Hello";
		System.out.println(x==y);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
	}
	public static TreeMap<Integer, Integer> add(TreeMap<Integer, Integer> b) {    
		b.put(2, 2);
		return b;
	} 
	
}
