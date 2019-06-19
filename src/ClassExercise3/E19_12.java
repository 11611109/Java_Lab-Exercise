package ClassExercise3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E19_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stubString string=args[0];
		
		List<String> words=characters("Hello world! å–?")
				.filter(i -> i.codePointAt(0)<=65535)
				.collect(Collectors.toList());
		System.out.println(words);
	}
	public static Stream<String> characters(String str){
		Stream<String> words=Stream.of(str.split(""));
		return words;
	}

}
