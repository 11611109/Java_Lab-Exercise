package Lab7;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Assignment.ChineseChar;

public class StreamPractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName=args[0];
		String command=args[1];
		
		String strEncoding="UTF-8";
		BufferedReader br = new BufferedReader(new InputStreamReader(new
				FileInputStream(fileName), strEncoding));
		String temp;
		ArrayList<String[]> all=new ArrayList<>();
		while((temp = br.readLine())!=null){
			String[] line=temp.split(", ");

//			System.out.println(line[0]+","+line[1]+","+line[2]);
			all.add(line);
		}
		
		Comparator<String []> comparator = (e1, e2) -> (int)(Integer.parseInt(e2[2]) - Integer.parseInt(e1[2]));
		switch (command) {
		case "1":
			String[][] result = all.stream().sorted(comparator).limit(20).toArray(String[][]::new);
			for(int j=0;j<result.length;j++){
				System.out.println(result[j][0]+","+result[j][1]+","+result[j][2]);
			}
			break;
			
		case "2":
			System.out.println(all.stream().map(i -> Integer.parseInt(i[2])).reduce((x,y) -> x+y).get());
			break;
		case "3":
			System.out.println(all.size());
			break;	
		case "4":
			String[][] result2 = all.stream().sorted(comparator).limit(1).toArray(String[][]::new);
			for(int j=0;j<result2.length;j++){
				System.out.println(result2[j][0]);
			}
			break;
		default:
			break;
		}

	}

}
