package Assignment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class UgradScraping {

	public static void main(String[] args) throws IOException {
		int[] count=new int[10];
		Document doc = Jsoup.connect("http://www.cs.princeton.edu/people/ugrad").get();
		Elements tables = doc.select("div.people-ugrad-col");
		for (Element col : tables) {
			Elements groups=col.select("div.people-ugrad-letter-group");
			for(Element group:groups){
				Elements uls = group.select("ul");
				for(Element ul :uls){
					Elements students=ul.select("li");
					for (Element s:students){
						String result=s.text();
						String[] split=result.split(", ");
						String[] split2=split[1].split(" '");
						
						System.out.println(split[0]+" "+split2[0]+", "+split2[1]);
						count[(int)Integer.parseInt(split2[1])-19]++;
						}
					}
				}
			}
		for(int i=0;i<count.length;i++){
			if(count[i]!=0){
				System.out.printf("Graduating year:%d, Student number:%d%n",(i+19),count[i]);
			}
		}
	}

}
