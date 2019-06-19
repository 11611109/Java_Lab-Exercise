package Assignment;

import java.io.*;
import java.util.*;

public class WordCount {

	public static void main(String[] args) throws IOException {
		String fileName=args[0];
		String charset0=args[1];
		String charset1=args[2];
		String sortKey=args[3];
		TreeMap<ChineseChar, Integer> tm=new TreeMap<>();
		
		readfile(charset0, charset1, fileName, tm);
		
		//写入文件
		File target=new File(sortKey+"_"+charset1+"_Dict_From_"+fileName);
		target.createNewFile();
        FileWriter fw=new FileWriter(target.getAbsoluteFile(),true);  //getAbsoluteFile获得绝对路径
        BufferedWriter bw=new BufferedWriter(fw);
        
        ArrayList<Map.Entry<ChineseChar,Integer>> list=new ArrayList<>();
		list.addAll(tm.entrySet());
		ArrayList<Comparator<Map.Entry<ChineseChar, Integer>>> methodList = new ArrayList<>();
		methodList.add((o1, o2) -> (Long.parseLong(o1.getKey().getCode(),16)-Long.parseLong(o2.getKey().getCode(),16))>0?1:-1);
		methodList.add((o1, o2) -> o2.getValue()-o1.getValue());
        
        if (sortKey.equals("char")){
		}else if (sortKey.equals("code")) {
			Collections.sort(list,methodList.get(0));
		}else if (sortKey.equals("count")) {
			Collections.sort(list,methodList.get(1));
		}else{
			System.out.println("Please input the right key of sorting");
		}
		
		
		for (int i=0; i<list.size();i++){
	    	try {
				bw.write(list.get(i).getKey().toString()+list.get(i).getValue().toString());
				bw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}	
	    }bw.close();

	}

	public static void readfile(String charset0,String charset1,String fileName,
			TreeMap<ChineseChar, Integer> tm) throws IOException{
		String strEncoding = charset0;
		FileInputStream fis = new FileInputStream(fileName);
		InputStreamReader isr = new InputStreamReader(fis, strEncoding);
		int tempchar;
		try {
		    while((tempchar = isr.read())!=-1) {
				if(((char)tempchar)!='\r' && ((char)tempchar)!='\n'&&tempchar>=0x4e00&&tempchar<=0x9fa5) {
				     char a=(char)tempchar;
				     ChineseChar cur=new ChineseChar(a, Bytes2HexString(String.valueOf(a).getBytes(charset1)));
				     Integer count;
				     if ((count = tm.get(cur)) == null) {
			             tm.put(cur, 1);
			         } else {
			             tm.put(cur, 1 + count);
			         } 
				}
		    }
		} catch (IOException e) {
		    e.printStackTrace(); }
		isr.close();
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
