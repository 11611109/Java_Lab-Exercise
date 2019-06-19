package ClassExercise3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;  

public class E19_4 {
	public static void main(String[] args) throws IOException{
		String fileName=args[0];
		String strEncoding="UTF-8";
		BufferedReader br = new BufferedReader(new InputStreamReader(new
				FileInputStream(fileName), strEncoding));
		String temp;
		String all="";
		while((temp=br.readLine())!=null){
			all+=temp;
		}
		String[] wordList=all.split(" ");
		ArrayList<String> words=new ArrayList<>();
		for(String i:wordList) { words.add(i); }
		List<String> result=words.stream()
				.map(i -> (i.length()>3)? i.substring(0,4) : i)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
	}
	
}
