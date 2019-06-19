package ClassExercise;

//5.1.26
//a. /(?=(0|1)+)^((?!(11|111)).)*$/
//b. /(^(.1)+$)|(^(.1)+.$)/
//
//c. /(?=(0|1)+)^(?=(?:[^0]*0){2})(?!([^1]*1))[+\-]?[01]+$/
//d. /(?=(0|1)+)^((?!(11)).)*$/


//5.1.33
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Harvester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("href=\"([\\w\\s./:]+?)\"");
		String input = getURLContent(args[1]);		
		Matcher matcher = pattern.matcher(input);
		while(matcher.find()) {
			System.out.println(matcher.group(1));
		}
		
	}
		
	public static String getURLContent(String urlStr) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName("utf-8")));
			String temp ="";
			while((temp=reader.readLine())!=null) {
				sb.append(temp);
			}
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}


//5.1.34
// (\((?=(a|b)+)(?!\(.*\))\))+


