package Buffered;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class test {

	public static void main(String[] args)throws IOException, ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		
		String res = sdf.format(new Date());
		Nobuffered I =new Nobuffered();
		
		I.ReadWriteFile();	
		String res2=sdf.format(new Date());
		
		String res3=sdf.format(new Date());
		buffered M=new buffered();
		M.ReadAndWrite();
		String res4=sdf.format(new Date());
		
	
		long result = sdf.parse(res2).getTime() - sdf.parse(res).getTime();
		long result2 = sdf.parse(res4).getTime() - sdf.parse(res3).getTime();
	    System.out.println("不带缓冲的字符流实现文件复制："+result+" ms");
	    System.out.println("带缓冲实现文件复制："+result2+" ms");
	    long result3=result-result2;
	    System.out.println("时间差："+result3+" ms");

	}

}
