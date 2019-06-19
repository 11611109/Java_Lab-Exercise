package ClassExercise3;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

public class E19_10 {
	public static void main(String args[]){
		int n=Integer.parseInt(args[0]);
		Optional<Integer> res=smallestProperDivisor(n);
		if (res.isPresent()){
			System.out.println(res.get());
		}else {
			System.out.println("No smallest proper divisor. It's a prime!");
		}
	}
	public static Optional<Integer> smallestProperDivisor(int n) {
		Comparator<Integer> intComparator = (e1, e2) -> e1.compareTo(e2);	
		Optional<Integer> sd = Stream.iterate(2, p -> p+1)
				.limit((int)Math.sqrt(n)-1)
				.filter(e -> n%e==0)
				.min(intComparator);
		return sd;
		
//		Predicate<Integer> isDivisor= (e) -> {
//			if (e == 1)
//				return 0;
//			for (int i = 2; i <= Math.sqrt(e); i++) {
//				if (e % i == 0)
//					return false;
//			}
//			return true;
//		};
//		
//		
//		int sd=0;
//		for (int i = 2; i <= Math.sqrt(n); i++) {
//			if (n % i == 0){
//				sd=i;
//				break;
//			}
//		}
//		if ((n==1)|| sd==0){
//			System.out.println("There is no smallest proper divisor. It's a prime.");
//		}else{System.out.println(sd);}
	}
}
