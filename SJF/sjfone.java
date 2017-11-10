import java.io.File;
import java.io.FileInputStream;
public class sjfone extends task{
	 public void singleSJF(){
	    	File file = new File("time.txt");//创建文件对象      	
	    	if(file.exists()){//判断文件是否存在   	
	    		try{   			
	    		   FileInputStream in = new FileInputStream(file);   //创建FileInputStream对象，将数据信息从文件中读取出来
	               for(int i=0;i<100;i++){//将文件夹里面的数据读取出来
	            	   int a=in.read();
	            	   Task_id[i]=a;
	            	   int b=in.read();
	            	   ArrivedTime[i] =b;
	            	   int c=in.read();            	   
	            	   ServerTime[i]=c;           	   
	               }
	               in.close();

	               startingTime[0]=ArrivedTime[0];//第一个服务开始时间
	               finishingTime[0]=ArrivedTime[0]+ServerTime[0];//第一个结束时间
	               turnAroundTime[0]=finishingTime[0]-startingTime[0];//第一个周转时间
	               weightTurnAround[0]=turnAroundTime[0]/ServerTime[0];//第一个带权周转时间            	   
	               System.out.print("Task_id: 1"+"   startingtime:"+startingTime[0]+"  finishingTime:");
	        	   System.out.print(+finishingTime[0]+"  turnAroundTime:");
	        	   System.out.print(+turnAroundTime[0]+"     ");
	        	   System.out.println("weightTurnAround:"+weightTurnAround[0]);
	        	   int temp_id;//用来短暂存储任务ID       	   
	        	   int temp;//存储上一个任务完成的时间
	        	   int temp_AT;//临时到达时间
	        	   int temp_ST;//临时服务时间

	               for(int i=1;i<100;i++){//这边开始判断短作业
	            	   temp=finishingTime[i-1];//存储上一个任务完成的时间
	            	   temp_id=i;
	            	   if(temp>=99){
	            		   temp=99;
	            	   }
	            	   
	            	   for(int j=i+1;j<=temp ;j++){
	            		   if(ServerTime[temp_id]>ServerTime[j]){
	            			   temp_id=j;
	            		   }
	            	   }            	   
	            	   
	            	   temp_AT=ArrivedTime[i];           	   
	            	   ArrivedTime[i]=ArrivedTime[temp_id];
	            	   ArrivedTime[temp_id]=temp_AT;
	            	   
	            	   temp_ST=ServerTime[i];            	   
	            	   ServerTime[i]=ServerTime[temp_id];
	            	   ServerTime[temp_id]=temp_ST;
	            	   startingTime[i]=startingTime[i-1]+ServerTime[i-1];
	            	   finishingTime[i]=finishingTime[i-1]+ServerTime[i];
	            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
	            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
	            	   
	            	   System.out.print("Task_id:"+(Task_id[i])+"   startingtime:"+startingTime[i]+"     ");
	            	   System.out.print("  finishingTime:"+finishingTime[i]+"     ");
	            	   System.out.print("  turnAroundTime:"+turnAroundTime[i]+"     ");
	            	   System.out.println("  weightTurnAround:"+weightTurnAround[i]);
	            	   
	               }

	    		}catch(Exception e){
	    			e.printStackTrace();
	    		}
	    	}
	    }

}
