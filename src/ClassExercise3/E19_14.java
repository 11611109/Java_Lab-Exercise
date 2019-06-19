package ClassExercise3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

public class E19_14 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		try (FileInputStream fis = new FileInputStream(args[0]);
				InputStreamReader isr = new InputStreamReader(fis, "utf-8");
				BufferedReader br = new BufferedReader(isr);) {
			
			String temp;
			String all="";
			while((temp=br.readLine())!=null){
				all+=temp;
			}
			String[] wordList=all.split("[\\s\\.;',]");
			ArrayList<String> words=new ArrayList<>();
			for(String i:wordList) { words.add(i); }
			String palindrome=words.stream()
					.parallel()
					.filter(i -> i.length()>=5 && i.equals(new StringBuffer(i).reverse().toString()))
					.findAny()
					.orElse("None");
			System.out.println(palindrome);
		}
	}

}
