package ClassExercise;
import java.util.*;

import javax.swing.text.TabableView;

import Lab3.Encoding2;
//Please input the codes in the conmmand line arguments, each separated with space.
//For example : andes coder codes apple 
public class CodeToNumber {
	private static Map<String, String> map;
	
	public static void main(String[] args) {
		map=new HashMap<>();
		map.put("abc", "2");
		map.put("def", "3");
		map.put("ghi", "4");
		map.put("jkl", "5");
		map.put("mno", "6");
		map.put("pqrs", "7");
		map.put("tuv", "8");
		map.put("wxyz", "9");
		
		String codes[]=new String[args.length];
		for (int arg=0;arg<args.length;arg++){
			codes[arg]=args[arg];
		}

		StringBuffer number=new StringBuffer();
		Map<StringBuffer, Set<String>> Rmap = new HashMap<>();
		int flag=0;
		for (String code:codes){
			number=codetonumber(code);
			//Check if there is already number in the keyset(or do it by overriding equal method)
			for (StringBuffer s:Rmap.keySet()){
				if(s.toString().equals(number.toString())){
					flag=1;
					number=s;
				}
			}

			if ((Rmap.keySet()==null) || flag==0){
				Set<String> a= new TreeSet<>(); 
				a.add(code);
				Rmap.put(number, a);
			}else{
				Set<String> b= Rmap.get(number);
				b.add(code);
				Rmap.put(number, b);
			}flag=0;
		}
		
		for (StringBuffer key:Rmap.keySet()){
			System.out.print(key + " ");
			System.out.println(Rmap.get(key));
		}
		

	}
	public static StringBuffer codetonumber(String code){
		int length=code.length();
		StringBuffer number = new StringBuffer();
		char temp;
		for(int i=0; i<length ;i++){
			temp=code.charAt(i);
			if (temp>= 'A' && temp<= 'Z') {
				temp+= 32;
			}
			
			for (String key:CodeToNumber.map.keySet()){
				if (key.indexOf(temp)!=-1){
						number.append(CodeToNumber.map.get(key));
				}
			}
		}

		return number;
	}

}
