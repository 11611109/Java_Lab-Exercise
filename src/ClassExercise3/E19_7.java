package ClassExercise3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class E19_7 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName=args[0];
		String strEncoding="UTF-8";
		BufferedReader br = new BufferedReader(new InputStreamReader(new
				FileInputStream(fileName), strEncoding));
		String temp;
		String all="";
		while((temp=br.readLine())!=null){
			all+=temp;
		}
		String[] wordList=all.split("'s");
		ArrayList<String> words=new ArrayList<>();
		for(String i:wordList) { words.add(i); }
		
		words.stream()
		.filter(w -> w.length()>=2)
		.map(i -> i.charAt(0)+"..."+i.charAt(i.length()-1))
		.forEach(System.out::println);
		
	}

}
