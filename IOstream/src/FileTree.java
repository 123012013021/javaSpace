import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.*;
public class FileTree  {
	public void filetree ()throws  IOException {
	   //input url from console
		Scanner num = new Scanner(System.in);
		System.out.println("ÇëÊäÈëÄ¿Â¼Â·¾¶£º");
		Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path);
         Path dir = file.toPath();
	  //use API of java.nio.file.* to search information
    try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
    	List<String> files = new ArrayList<>();
        for(Path e : stream){
        	if(!Files.isDirectory(e)) {//is folder or not
        		System.out.println(e.getFileName()+"     "+Files.getLastModifiedTime(e)+"           " +Files.size(e));
           
            }
            else {
            	System.out.println(e.getFileName()+"        "+Files.getLastModifiedTime(e) );
            	}
        	   	
        }
    }
    }	 
}
