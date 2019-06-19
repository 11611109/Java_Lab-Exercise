package ClassExercise3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class E19_13 {

	public static void main(String[] args) throws FileNotFoundException, IOException  {
		// TODO Auto-generated method stub
		Comparator<String> valueComparator = Comparator.comparing(i -> numOfVowel(i));
		try (FileInputStream fis = new FileInputStream(args[0]);
				InputStreamReader isr = new InputStreamReader(fis, "utf-8");
				BufferedReader br = new BufferedReader(isr);) {
			
//			String temp;
//			String all="";
//			while((temp=br.readLine())!=null){
//				all+=temp;
//			}
//			String[] wordList=all.split("[\\s\\.;',]");
//			ArrayList<String> words=new ArrayList<>();
//			for(String i:wordList) { words.add(i); }
//			
//			String wordMaxcVowel=words.stream().max(valueComparator).orElse("None");
//			System.out.println(wordMaxcVowel);
			
			
			String wordMaxcVowel=br.lines()
					.map(i -> i.split("[\\s\\.;',]"))
					.flatMap(Arrays::stream)
					.max(valueComparator)
					.orElse("None");
			System.out.println(wordMaxcVowel);
		}
		
	}
	public static int numOfVowel(String a){
		String[] all=a.split("");
		int count=0;
		for (String cur:all){
			if(cur.equals("a")|| cur.equals("e") || cur.equals("i") || cur.equals("o")|| cur.equals("u")){
				count++;
			}
		}
		return count;
	}

}
