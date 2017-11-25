package ObjectSerialization;

import java.io.FileNotFoundException;
import java.io.IOException;

import  ObjectSerialization.Read_Write;

public class Main extends Read_Write {
	public static void main(String[]args) throws FileNotFoundException, ClassNotFoundException, IOException{
		Read_Write M = new Read_Write();
		M.Read_List();
		M.ReadFromNewFile();
	}	
}
