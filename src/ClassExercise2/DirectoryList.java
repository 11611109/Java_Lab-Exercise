package ClassExercise2;
import java.io.File;

public class DirectoryList {
	public static void main(String []args){
		String str = new String(); 
		if (args[0].equals(".")){
			str = System.getProperty("user.dir");
		} else {
			str=args[0];
		}
		File root=new File(str);
		if (!root.exists()){
			System.out.println("No such file or directory!");
		}else{
			dirList(root,0);
		}	
	}
	
	private static void dirList(File file, int depth){
		File flist[] = file.listFiles();
	    if (flist == null || flist.length == 0) {
	    	System.out.println("This is a file." + file.getName());
	    }
	    for (File f : flist) {
	        if (f.isDirectory()) {
	              //输出文件夹名字
	            System.out.println(tabs(depth) + "+"+ f.getName()); 
	              //递归的遍历文件夹
	            int a=depth+1;
	            dirList(f, a);
	        } else {
	             //输出文件名字
	            System.out.println(tabs(depth)+f.getName());
	        }
	    }
	}
	private static String tabs(int n){
		String s = new String("    ");
		String tab = new String();
		while(n >= 0){
			tab += s;
			n--;
		}
		return tab;
	}
}
