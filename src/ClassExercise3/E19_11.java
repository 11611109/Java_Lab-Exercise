package ClassExercise3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class E19_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number=args[0];
		int n=Integer.parseInt(number);
		int[] result=IntStream.range(1, n)
		.map(i -> i*i)
		.filter(w -> String.valueOf(w).equals(new StringBuffer(Integer.toString(w)).reverse().toString()))
		.toArray();
		for (int i:result){
			System.out.println(i+" ");
		}
	}

}
