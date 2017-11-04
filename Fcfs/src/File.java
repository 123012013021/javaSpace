import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class File {
	FileWriter writer;
	FileReader reader;
	BufferedReader br;
	private int [] ServiceTime;       //服务时间
	private Random random;            //随机化参数
	private int [][] TimeMessage;
	/**
	 * 构造函数
	 * @param Pathname 文件路径名
	 */
	File(String Pathname) {
		//task = new Task();
		try {
            this.reader = new FileReader(Pathname);
            this.br = new BufferedReader(reader);
            this.writer = new FileWriter(Pathname,true);  //没有true 表示覆盖写入的文件
		}catch(FileNotFoundException e) {
            e.printStackTrace();
      }
      catch(IOException e) {
            e.printStackTrace();
      }
	  random = new Random();
	  ServiceTime = new int []{6,1,3,2,9};
	  TimeMessage = new int [100][3];
	}
	public int RandomParam() {
		int k=0;			   		 //实现随机函数生成1，2，3，4 作为下标
		k=random.nextInt(4);
		return ServiceTime[k];
	}
	public void WriteFile() {
		//task : TaskId 到达时间  服务时间
		 //生成100个任务
		for(int i=1;i<=100;i++) {
			String TaskID = ""+i;
			String ArrivalTime  = ""+(i-1);
			String ServiceTime  = ""+this.RandomParam();
			String writerString=TaskID+"  "+ArrivalTime+"  "+ServiceTime+"\r\n";	
			//String writerString=i+"  "+(i-1)+"  "+task.RandomParam()+"\r\n";
			try {
				writer.append(writerString);
				writer.flush(); 
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
		System.out.println("写入成功！");
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void ReadFile() {
		int k=0;
		try {
			String line="";
	        String[] arrs=null;
	        while ((line=br.readLine())!=null) {
	            arrs=line.split("  ");  //每次读取一条并打印出来
	           // System.out.println(arrs[0] + "   " + arrs[1] + "   " + arrs[2]);
	            for(int i=0;i<3;i++) {
	            	TimeMessage[k][i]=Integer.parseInt(arrs[i]);
	            }
	            k++;
	        }
				  br.close();  
				  reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	public void GetTimeMessage(int [][]Time) {
		for(int k=0;k<100;k++) {
			for(int i=0;i<3;i++) {
				Time[k][i] = TimeMessage[k][i];
			}
		}
	}
}


