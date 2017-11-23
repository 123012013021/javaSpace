import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
public class sjftwo extends task {
	 public void doubleSJF(){
	    	File file = new File("time.txt"); 
	    	if(file.exists()){//鍒ゆ柇鏂囦欢鏄惁瀛樺湪   	
	    		try{   			
	    		   FileInputStream in = new FileInputStream(file);   
	    		   Scanner scan =new Scanner(in);
	    		   int i=0;
	    		   while(scan.hasNext()){
	    			   Task_id[i]=scan.nextInt();
	    			   ArrivedTime[i]=scan.nextInt();
	    			   ServerTime[i]=scan.nextInt();
	    			   i=i+1;
	    		   }
	    		   scan.close();	              
		           int FirstTime=0;//第一线程的时间
		           int SecondTime=0;//第二线程的时间
		           
		           boolean ID[];//用来判断任务是否已经完成
		           ID = new boolean [100];
		           
		           int NoServerID=0;//标记队列最前方未服务任务的序号
		           int min=0;//最短作业所在序号	           
	               for( i=0;i<100;i++){
	            	   for(int j=NoServerID;j<100;j++){
	            		   if(ID[j]==false){
	            			   min=j;
	            			   break;
	            		   }
	            	   }
	            	   NoServerID=min;
		       		   for(int k=min+1;k<100 && k<=FirstTime && k<=SecondTime ; k++) {//找到已到达任务中最短任务
		    			   if(ID[k]==true) {
		    				   continue;
		    			   }
		    			   if(ServerTime[min]>ServerTime[k]) {
		    				   min=k;
		    			   }
		    		   }
	            	   if(FirstTime<=ArrivedTime[min]){
	            		   startingTime[min]=FirstTime;
	            		   FirstTime=ArrivedTime[min]+ServerTime[min];
	            		   finishingTime[min]=FirstTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
	            		   System.out.print("这是第"+(min+1)+"个任务在第一线程中进行，开始时间是");
	            		   System.out.print(startingTime[min]+",   结束时间是"+finishingTime[min]+",  ");
	            		   System.out.print("周转时间"+turnAroundTime[min]+",  ");
	            		   System.out.println("带权周转时间是"+weightTurnAround[min]);
	            	   }else if(SecondTime<=ArrivedTime[min]){//如果第一线程正在运行任务，第二线程空闲     		
	            		      if(SecondTime==0) {
	            			   SecondTime=ArrivedTime[min];
	            		   }
	            		   startingTime[min]=SecondTime;
	            		   SecondTime=ArrivedTime[min]+ServerTime[min];
	            		   finishingTime[min]=SecondTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
	            		   System.out.print("这是第"+(min+1)+"个任务在第二线程中进行，开始时间是");
	            		   System.out.print(startingTime[min]+",  结束时间是"+finishingTime[min]+",  ");
	            		   System.out.print("周转时间"+turnAroundTime[min]+",  ");
	            		   System.out.println("带权周转时间是"+weightTurnAround[min]);
	            		   
	            	   }else if(FirstTime<=SecondTime){
	            		   startingTime[min]=FirstTime;
	            		   FirstTime=FirstTime+ServerTime[min];
	            		   finishingTime[min]=FirstTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
	            		   System.out.print("这是第"+(min+1)+"个任务在第一线程中进行，开始时间是");
	            		   System.out.print(startingTime[min]+",  结束时间是"+finishingTime[min]+",  ");
	            		   System.out.print("周转时间"+turnAroundTime[min]+",  ");
	            		   System.out.println("带权周转时间是"+weightTurnAround[min]);

	            	   }else{
	            		   startingTime[min]=SecondTime;
	            		   SecondTime=SecondTime+ServerTime[min];
	            		   finishingTime[min]=SecondTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
	            		   System.out.print("这是第"+(min+1)+"个任务在第二线程中进行，开始时间是");
	            		   System.out.print(startingTime[min]+",  结束时间是"+finishingTime[min]+",  ");
	            		   System.out.print("周转时间"+turnAroundTime[min]+",  ");
	            		   System.out.println("带权周转时间是"+weightTurnAround[min]);
	            	   }
	            	   ID[min]=true;//将该任务已经完成
	               }
	    		}catch(Exception e){
	    			e.printStackTrace();//输出异常信息
	    		}
	    	}
	    }
}
