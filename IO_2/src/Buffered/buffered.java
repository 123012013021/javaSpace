package Buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class buffered {
	public void ReadAndWrite() throws IOException{
		File rfile=new File("read.txt");
		File wfile=new File("write.txt");
		if(rfile.exists()){
			FileWriter fw=new FileWriter(wfile);
			FileReader fr=new FileReader(rfile);
			BufferedReader read =new BufferedReader(fr);
			BufferedWriter write=new BufferedWriter(fw);
			if(wfile.exists()){
				String s=null;
				while((s=read.readLine())!=null){
					write.write(s);
				}
			}else{
				wfile.createNewFile();
				ReadAndWrite();
			}
		}else{
			return ;
		}
	}
}
