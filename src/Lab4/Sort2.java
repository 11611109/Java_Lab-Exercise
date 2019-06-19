package Lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class Sort2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();

		while (total-- > 0) {
			int n = in.nextInt();
			ArrayList<Element> arrayList = new ArrayList<Element>(n);
			for (int i = 0; i < n; i++) {
				arrayList.add(new Element(i,in.nextInt()));
			}
			
//			Collections.sort(arrayList, new Comparator<Element>() {//其他类型就不会按这个排？arraylist是干什么？
//
//				@Override
//				public int compare(Element o1, Element o2) {
//					
//					return o1.value - o2.value;
//				}
//				
//			});//匿名内部类在编译的时候会生成一个类
			

			Collections.sort(arrayList, (e1, e2)->e1.value - e2.value);//箭头后既是执行语句，也是返回值,这是方法对象而不是匿名内部类
			//实现的是什么接口
			//Collections.sort(arrayList, (e1, e2)->{return e1.value - e2.value});

			for (int i = 0; i < n; i++) {
				System.out.printf("%d", arrayList.get(i).index);
				if (i != n - 1)
					System.out.print(" ");
			}
			System.out.println();
		}
		in.close();
	}
}