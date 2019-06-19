package ClassExercise2;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.Map.Entry;

public class exercise3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<String> wordlist = new ArrayList<>();
		Map<String, String> wordmap = new HashMap<>();
		FileReader f = new FileReader(args[0]);
		char[] c = new char[1];
		int b = 0;
		String str = "";

		while ((b = f.read(c)) != -1) {

			if (String.valueOf(c).equals("\r") || String.valueOf(c).equals("\n") || String.valueOf(c).equals(" ")
					|| String.valueOf(c).equals(",") || String.valueOf(c).equals(".") || String.valueOf(c).equals("\"")
					|| String.valueOf(c).equals("'")) {
				wordlist.add(str);
				char[] Cstr = str.toCharArray();
				String strvalue = "";
				for (char a : Cstr) {
					if (a == 'a' || a == 'b' || a == 'c') {
						strvalue = strvalue + "2";
					} else if (a == 'd' || a == 'e' || a == 'f') {
						strvalue = strvalue + "3";
					} else if (a == 'g' || a == 'h' || a == 'i') {
						strvalue = strvalue + "4";
					} else if (a == 'j' || a == 'k' || a == 'l') {
						strvalue = strvalue + "5";
					} else if (a == 'm' || a == 'n' || a == 'o') {
						strvalue = strvalue + "6";
					} else if (a == 'p' || a == 'q' || a == 'r' || a == 's') {
						strvalue = strvalue + "7";
					} else if (a == 't' || a == 'u' || a == 'v') {
						strvalue = strvalue + "8";
					} else if (a == 'w' || a == 'x' || a == 'y' || a == 'z') {
						strvalue = strvalue + "9";
					}
				}
				wordmap.put(str, strvalue);
				str = "";

			} else {
				str = str + String.valueOf(c);
			}
		}
		getKeyByValue(wordmap, args[1]);

	}

	public static void getKeyByValue(Map map, String value) {
		String keys = "";
		Iterator it = map.entrySet().iterator();
		System.out.print("The word you find may be:");
		while (it.hasNext() == true) {
			Map.Entry entry = (Entry) it.next();
			Object Ovalue = entry.getValue();
			if (Ovalue.equals(value) == true) {
				keys = (String) entry.getKey();
				System.out.print(keys + " ");
			}
		}
	}
}