package Final_Ex6;
import java.util.stream.Stream;

public class E19_12 {

    public static void main(String[] args) {

        characters("Hello world! �?").forEach(System.out::println);

    }


    public static Stream<String> characters(String str) {
        return str.codePoints().mapToObj(it -> new String(new int[]{it}, 0, 1));
    }

}
