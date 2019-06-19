package ClassExercise3;
import java.util.Currency;

import javafx.util.converter.CurrencyStringConverter;

public class E19_6 {
	public static void main(String args[]) {
		ModigetAvailableCurrencies();
	}
	public static void ModigetAvailableCurrencies(){
		String[] result=Currency.getAvailableCurrencies()
				.stream()
				.map(i -> i.getDisplayName())
				.sorted()
				.toArray(String[]::new);
		for (String a:result){System.out.println(a);}
	}

}
