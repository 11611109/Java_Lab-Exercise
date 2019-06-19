package Assignment;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class FilesManager {

	static int fileNum=0;
	static ArrayList<String> FileList=new ArrayList<>();
	static Map<String, Integer> extension=new HashMap<>();
	public static void main(String[] args) {
		String DirName=args[0];
		String mode=args[1];
		
		extension.put(" ", 0);
		
		tranverse(DirName);
		if (FileList.size()>0){
			switch(mode){
			case "1":
				System.out.println(FileList.size());
				break;
			case "2":
				long size=FileList.stream()
								  .map(s -> new File(s).length())
								  .reduce((x,y) -> (x+y))
								  .orElse(0L);
				long sizeInK=size/1024;
				System.out.println(sizeInK+"k");			  
				break;
			case "3":
				FileList.stream()
				  		.filter(s -> new File(s).length()>1000000)
				  		.forEach(a -> {
				  			System.out.println(a);
				  		});;
				break;
			case "4":
				String noSuffix=" ";
				FileList.stream()
						.map(s -> s.lastIndexOf('.')>=0?s.substring(s.lastIndexOf('.')):noSuffix)
						.forEach(i -> {
							if (extension.get(i)!=null) {
								extension.replace(i, extension.get(i)+1);
							}else {
								extension.put(i, 1);
							}
						});
				for(String s:extension.keySet()){
					if(s.equals(" ")){
						System.out.println(","+extension.get(s));
					}else {
						System.out.println(s+","+extension.get(s));
					}
				}
				break;
			default:
				System.out.println("Please input the right command");
			}
		}
		

	}
	
	public static void tranverse(String path){
		File file = new File(path);

        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files) {
                System.out.println("The file doesn't exit!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                    	tranverse(file2.getPath());
                    } else {
                    	FileList.add(file2.getPath());
        			}	
                }
            }
        } else {
            System.out.println("The file doesn't exit!");
        }

	}
	
}
//package Assignment;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class FilesManager {
//
//	static int fileNum=0;
//	static ArrayList<String> FileList=new ArrayList<>();
//	static Map<String, Integer> extension=new HashMap<>();
//	public static void main(String[] args) {
//		String DirName=args[0];
//		String mode=args[1];
//		
//		extension.put(" ", 0);
//		switch(mode){
//		case "1":
//			tranverse(DirName);
//			System.out.println(fileNum);
//			
//			
//			break;
//		case "2":
//			File file = new File(DirName);
//			if (file.exists()) {
//				System.out.println(file.length());
//			}else {
//				System.out.println("Please input the right command");
//			}
//			break;
//		case "3":
//			tranverse(DirName);
//			for (String a:bigFiles){
//				System.out.println(a);
//			}
//			break;
//		case "4":
//			tranverse(DirName);
//			for(String s:extension.keySet()){
//				if(s.equals(" ")){
//					System.out.println(","+extension.get(s));
//				}else {
//					System.out.println("."+s+","+extension.get(s));
//				}
//			}
//			break;
//		default:
//			System.out.println("Please input the right command");
//		}
//
//	}
//	
//	public static void tranverse(String path){
//		File file = new File(path);
//
//      if (file.exists()) {
//          File[] files = file.listFiles();
//          if (null == files || files.length == 0) {
//              System.out.println("文件夹是空的!");
//              return;
//          } else {
//              for (File file2 : files) {
//                  if (file2.isDirectory()) {
//                  	tranverse(file2.getPath());
//                  } else {
//                  	FileList.add(file2.getPath());
//                  	
//                  	fileNum++;
//                  	if (file2.length()>100000) {
//							bigFiles.add(file2.toString());
//						}
//                  	int index = file2.getName().lastIndexOf('.');
//      				if (index >= 0) {
//      					index >= 0说明文件有后缀,截取文件后缀名
//      					String ext = file2.getName().substring(index + 1);
//      					if (extension.get(ext)!=null) {
//      						int cur=extension.get(ext)+1;
//								extension.replace(ext, cur);
//							}else {
//								extension.put(ext, 1);
//							}
//      				} else {
//      					extension.replace(" ", extension.get(" ")+1);
//      				}
//      			}	
//              }
//          }
//      } else {
//          System.out.println("文件不存在!");
//      }
//
//	}
//	
//}
