import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
public class fcfsTwo  extends  task {
	public void doubleFCFS(){//先到先服务（双线程）
File file = new File("time.txt");
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
               int FirstTime=0;
               int SecondTime=0;
               int MarkTask[];
               MarkTask=new int[100];
               for(i=0;i<100;i++){
            	   if(FirstTime<=ArrivedTime[i]){
            		   startingTime[i]=FirstTime;
            		   FirstTime=ServerTime[i]+ArrivedTime[i];
            		   finishingTime[i]=FirstTime;
            		   MarkTask[i]=1;
            		  
            	   }else if(SecondTime<=ArrivedTime[i]){
            		   if(SecondTime==0) {
            			   SecondTime=ArrivedTime[i];
            		   }            		     
            		   startingTime[i]=SecondTime;
            		   SecondTime=ServerTime[i]+ArrivedTime[i];
            		   finishingTime[i]=SecondTime;
            		   MarkTask[i]=2;
            		  
            	   }else if(FirstTime<=SecondTime){
            		   startingTime[i]=FirstTime;
            		   FirstTime=FirstTime+ServerTime[i];
            		   finishingTime[i]=FirstTime;
            		   MarkTask[i]=1;
   	
            	   }else{
            		   startingTime[i]=SecondTime;
            		   SecondTime=ServerTime[i]+SecondTime;
            		   finishingTime[i]=SecondTime;
            		   MarkTask[i]=2;
            		 
            	   }
               }
               
               for( i=0;i<100;i++){
            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
               }
               
               System.out.println("TaskId ArrivalTime ServiceTime StartingTime FinishingTime TurnAroundTime WeightTurnAround");
               for(i=0;i<100;i++){
            	   if(MarkTask[i]==1){
	            	   System.out.print(+Task_id[i]+"        ");
	            	   System.out.print(ArrivedTime[i]+"           ");
	            	   System.out.print(ServerTime[i]+"             ");
	            	   System.out.print(startingTime[i]+"             ");
	            	   System.out.print(finishingTime[i]+"             ");
	            	   System.out.print(turnAroundTime[i]+"             ");
	            	   System.out.println(weightTurnAround[i]);         		   
            	   }else{
	            	   System.out.print(+Task_id[i]+"        ");
	            	   System.out.print(ArrivedTime[i]+"           ");
	            	   System.out.print(ServerTime[i]+"            ");
	            	   System.out.print(startingTime[i]+"             ");
	            	   System.out.print(finishingTime[i]+"             ");
	            	   System.out.print(turnAroundTime[i]+"            ");
	            	   System.out.println(weightTurnAround[i]);
            	   }
            
               }
    		}catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    	}

    }
}
