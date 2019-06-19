package ClassExercise3;

import java.util.stream.Stream;

public class E19_21 {

	public static void main(String[] args) {
		// generate some random integer
//				int n = 10000000;
				long n = 100000000000L;

				// Stream
				 streamFilter(n);

				// StreamParallel
				 streamFilterParallel(n);
	}
	public static void streamFilter(long n) {
		long timeStart = System.currentTimeMillis();
		 long res = Stream.generate(Math::random).map(i -> (long) (i *
		 n)).limit(n).filter(e -> e % 2 == 0)
		 .count();

		long timeEnd = System.currentTimeMillis();
		long timeCost = timeEnd - timeStart;
		System.out.println("Stream:" + timeCost);

	}

	public static void streamFilterParallel(long n) {
		long timeStart = System.currentTimeMillis();
		 long res = Stream.generate(Math::random).map(i -> (long) (i *
		 n)).limit(n).parallel().filter(e -> e % 2 == 0)
		 .count();

		long timeEnd = System.currentTimeMillis();
		long timeCost = timeEnd - timeStart;
		System.out.println("StreamParallel:" + timeCost);

	}
}
