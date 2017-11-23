import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
public class sjfone extends task{
	 public void singleSJF(){
		 File file = new File("time.txt");
	        boolean [] Server;
	        Server =new boolean[100];
	        for(int i=0;i<100;i++){
	        	Server[i]=false;
	        }
	    	if(file.exists()){  	
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
		        	   int temp_id=0;//用来短暂存储任务ID 
		        	   int first_unserver=temp_id;

		        	   int time=0;
		        	   for(i=0;i<100;i++){
		        		   for(int j=first_unserver;j<100;j++){
		        			   if(Server[j]==false){//判断最靠前的任务是否被服务过
		        				   temp_id=j;
		        				   break;
		        			   }
		        		   }
		        		   first_unserver=temp_id;
		        		   for(int k=temp_id+1;k<100 && k<=time;k++){
		        			   if(Server[k]==true){
		        				   continue;
		        			   }
		        			   if(ServerTime[k]<ServerTime[temp_id] ){
		        				   temp_id=k;	        				   
		        			   }
		        		   }
		        		   if(ArrivedTime[temp_id]<=time){//如果任务达到时间小于前一个任务完成时间
		        			   startingTime[temp_id]=time;
		        			   finishingTime[temp_id]=time+ServerTime[temp_id];
		        			   turnAroundTime[temp_id]=finishingTime[temp_id]-ArrivedTime[temp_id];
		        			   weightTurnAround[temp_id]=turnAroundTime[temp_id]/ServerTime[temp_id];
		        			   System.out.print("这是第"+(temp_id+1)+"个任务  ");
		        			   System.out.print("开始时间："+startingTime[temp_id]+"结束时间："+finishingTime[temp_id]);
		        			   System.out.println("周转时间："+turnAroundTime[temp_id]+"带权周转时间："+ weightTurnAround[temp_id]);
		        		   }else{
		        			   startingTime[temp_id]=ArrivedTime[temp_id];
		        			   finishingTime[temp_id]=ArrivedTime[temp_id]+ServerTime[temp_id];
		        			   turnAroundTime[temp_id]=finishingTime[temp_id]-startingTime[temp_id];
		        			   weightTurnAround[temp_id]=turnAroundTime[temp_id]/ServerTime[temp_id];
		        			   System.out.print("这是第"+(temp_id+1)+"个任务  ");
		        			   System.out.print("开始时间："+startingTime[temp_id]+"结束时间："+finishingTime[temp_id]);
		        			   System.out.println("周转时间："+turnAroundTime[temp_id]+"带权周转时间："+ weightTurnAround[temp_id]);
		        		   }
		        		   time=finishingTime[temp_id];
		        		   Server[temp_id]=true;
		        	   }
		    		}catch(Exception e){
		    			e.printStackTrace();//输出异常信息
		    		}
		    	}
		    }
	    }

