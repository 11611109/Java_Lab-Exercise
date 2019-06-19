package Final_Ex8;


public class sortMethod {
	public static void main(String args[]) {
		Integer[] integers={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Double[] doubles={1.11, 2.11, 3.23, 4.67, 5.32, 6.86, 7.54, 8.46, 9.0, 10.0};
		String[] strings={"q", "r", "s","t", "u", "v", "w", "x", "y", "z"};
		
		long startTime1 =System.nanoTime();
		bulbSort(integers);
		long endTime1 = System.nanoTime(); 
		System.out.println("bubbleSort+integer "+(endTime1-startTime1)+"nm");
//		System.out.println(Arrays.toString(integers));
		
		long startTime2 = System.nanoTime();
		bulbSort(doubles);
		long endTime2 = System.nanoTime(); 
		System.out.println("bubbleSort+double "+(endTime2-startTime2)+"nm");
//		System.out.println(Arrays.toString(doubles));
		
		long startTime3 = System.nanoTime();
		bulbSort(strings);
		long endTime3 = System.nanoTime(); 
		System.out.println("bubbleSort+string "+(endTime3-startTime3)+"nm");
//		System.out.println(Arrays.toString(strings));
		
		Integer[] integers2={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Double[] doubles2={1.11, 2.11, 3.23, 4.67, 5.32, 6.86, 7.54, 8.46, 9.0, 10.0};
		String[] strings2={"q", "r", "s","t", "u", "v", "w", "x", "y", "z"};
		
		long startTime4 =System.nanoTime();
		quickSort(0, 9, integers2);
		long endTime4 = System.nanoTime(); 
		System.out.println("bubbleSort+integer "+(endTime4-startTime4)+"nm");
		
		long startTime5 =System.nanoTime();
		quickSort(0, 9, doubles2);
		long endTime5 = System.nanoTime(); 
		System.out.println("bubbleSort+double "+(endTime5-startTime5)+"nm");
		
		long startTime6 =System.nanoTime();
		quickSort(0, 9, strings2);
		long endTime6= System.nanoTime(); 
		System.out.println("bubbleSort+string "+(endTime6-startTime6)+"nm");
		
	}
	
	public static <T extends Comparable<? super T>> void bulbSort (T[] x){
		T temp;
		int size=x.length;
		for(int i=0;i<size-1;i++){
			for(int j=0;j<size-1-i;j++){
				if((x[j].compareTo(x[j+1]) )>0){
					temp=x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
				}
			}
		}
		
	}
	public static <T extends Comparable<? super T>> void quickSort(int p,
            int r, T[] A) {
        if (p < r) {
            int q = partition(p, r, A);
            quickSort(p, q - 1, A);
            quickSort(q + 1, r, A);
        }
    }

    public static <T extends Comparable<? super T>> int partition(int p, int r,
            T[] A) {
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j].compareTo(A[r]) > 0) {
                i++;
                T t = A[j];
                A[j] = A[i];
                A[i] = t;
            }
        }
        T t = A[i + 1];
        A[i + 1] = A[r];
        A[r] = t;
        return i + 1;
    }

}
