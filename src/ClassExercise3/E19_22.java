package ClassExercise3;


import java.util.stream.Stream;


public class E19_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a=Integer.parseInt(args[0]);
		Integer[] result = Stream.iterate(0, n -> n+1)
				 .map(i -> (i * i))
				 .filter(w -> String.valueOf(w).equals(new StringBuffer(Integer.toString(w)).reverse().toString()))
				 .limit(a)
				 .toArray(Integer[]::new);
		for(Integer i:result){
			System.out.println(i);
		}

	}

}
