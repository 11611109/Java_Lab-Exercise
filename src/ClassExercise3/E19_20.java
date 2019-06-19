package ClassExercise3;

import java.util.ArrayList;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class E19_20 {

	public static void main(String[] args) {
		String wordList=args[0];
		String[] words=wordList.split(",");

		String[] previous=new String[words.length];
		for (int i=0;i<words.length-1;i++){
			previous[i+1]=words[i];
		}
		String[] result=new String[words.length];
		
		IntPredicate duplicateTest= (i) ->{
			if(i==0){
				result[i]="False";
				return false;
			}else {
				if(words[i].equals(previous[i])) { 
					result[i]="True";
					return true; }
				else  { 
					result[i]="False";
					return false; }}
		};
		
		
		IntStream.range(0, words.length)
		.filter(duplicateTest)
		.forEach(System.out::println);
		
		for (int j=0;j<result.length;j++){
			System.out.print(result[j]+" ");
		}
		

	}

}
