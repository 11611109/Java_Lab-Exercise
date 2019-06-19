package Lab1;
import java.io.*;

public class CharsetConvertor {
	public static void main(String []args) throws FileNotFoundException, UnsupportedEncodingException, IOException{
		String fileName=args[0];
		String charset0=args[1];
		String charset1=args[2];
		
		String strEncoding = charset0;
		FileInputStream fis;
		fis = new FileInputStream(fileName);
		InputStreamReader isr;
		isr = new InputStreamReader(fis, strEncoding);
		BufferedReader br = new BufferedReader(isr);
		
		String source ="";
		String line ="";
		while((line = br.readLine())!=null) {
			source += line;
		}
		
		String dest = "";
		byte[] bytes = source.getBytes(charset1); 
		System.out.println(Bytes2HexString(bytes));
		
		for (byte b : bytes) {
		    dest += b;
		}
		System.out.println(dest);
		File target=new File(charset1+fileName);
		target.createNewFile();
        FileWriter fw=new FileWriter(target.getAbsoluteFile(),true);  //getAbsoluteFile获得绝对路径
        
        BufferedWriter bw=new BufferedWriter(fw);
		bw.write(dest);
		bw.close();
	
	}
	public static String Bytes2HexString(byte[] b) {    
		String ret = "";    
		for (int i = 0; i < b.length; i++) {      
			String hex = Integer.toHexString(b[i] & 0xFF);      
			if (hex.length() == 1) {        
				hex = '0' + hex;      
			}      
			ret += hex.toUpperCase();    
		}    
		return ret; 
	} 
	
}
