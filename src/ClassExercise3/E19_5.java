package ClassExercise3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E19_5 {
	public static void main (String args[]) throws IOException{
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
		
		System.out.println(toString(words.stream(),20));
	}
	
	public static<T> String toString(Stream<T> stream, int n){
		String result= stream.limit(n)
				.map(i -> i.toString())
				.collect(Collectors.joining(","));
		return result;
	}

}
