package ClassExercise3;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class E19_16 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		try (FileInputStream fis = new FileInputStream(args[0]);
				InputStreamReader isr = new InputStreamReader(fis, "utf-8");
				BufferedReader br = new BufferedReader(isr);) {
			
			Map<String, List<String>> map=br.lines()
					.map(i -> i.split("[\\s\\.;',]"))
					.flatMap(Arrays::stream)
					.map(i -> i.toLowerCase())
					.collect(Collectors.groupingBy(w -> w.substring(0, 1)));
			
			for (int i=1;i<=26;i++){
				String key=String.valueOf((char)(96+i));
				List<String> cur=map.get(key);
				int totalLen=0;
				int avrgLen=0;
				for(String a:cur){
					totalLen+=a.length();
				}avrgLen=totalLen/cur.size();
				System.out.println("Initial letter: "+(char)(96+i)+ " Average length: "+avrgLen);
			}
		}
	}

}
