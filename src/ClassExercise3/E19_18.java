package ClassExercise3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class E19_18 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName=args[0];
		
		String strEncoding="UTF-8";
		BufferedReader br = new BufferedReader(new InputStreamReader(new
				FileInputStream(fileName), strEncoding));
		String temp;
		ArrayList<String[]> all=new ArrayList<>();
		while((temp = br.readLine())!=null){
			String[] line=temp.split(",");
			all.add(line);
		}
		
		Comparator<String []> comparator = Comparator.comparing(i -> (Integer.parseInt(i[1])/Integer.parseInt(i[2])));
		
		Optional<String[]> result = all.stream().max(comparator);
		System.out.println("Most densely contry: "+result.get()[0]);
	}

}
