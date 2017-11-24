import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
public class sjftwo extends task {
	 public void doubleSJF(){
	    	File file = new File("time.txt"); 
	    	if(file.exists()){//判断文件是否存在   	
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
		           int FirstTime=0;//��һ�̵߳�ʱ��
		           int SecondTime=0;//�ڶ��̵߳�ʱ��
		           	           
		           boolean ID[];//�����ж������Ƿ��Ѿ����
		           ID = new boolean [100];
		           
		           int NoServerID=0;//��Ƕ�����ǰ��δ������������
		           int min=0;//�����ҵ�������
		           System.out.println("TaskId ArrivalTime ServiceTime StartingTime FinishingTime TurnAroundTime WeightTurnAround");
	               for(i=0;i<100;i++){
	            	   for(int j=NoServerID;j<100;j++){
	            		   if(ID[j]==false){
	            			   min=j;
	            			   break;
	            		   }
	            	   }
	            	   NoServerID=min;
		       		   for(int k=min+1;k<100 && k<=FirstTime && k<=SecondTime ; k++) {//�ҵ��ѵ����������������
		    			   if(ID[k]==true) {
		    				   continue;
		    			   }
		    			   if(ServerTime[min]>ServerTime[k]) {
		    				   min=k;
		    			   }
		    		   }
	            	   if(FirstTime<=ArrivedTime[min]){//�����һ�߳̿���
	            		   startingTime[min]=FirstTime;
	            		   FirstTime=ArrivedTime[min]+ServerTime[min];
	            		   finishingTime[min]=FirstTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   

	            	   }else if(SecondTime<=ArrivedTime[min]){//�����һ�߳������������񣬵ڶ��߳̿���
	            		   if(SecondTime==0){
	            			   SecondTime=ArrivedTime[min];
	            		   }
	            		   startingTime[min]=SecondTime;
	            		   SecondTime=ArrivedTime[min]+ServerTime[min];
	            		   finishingTime[min]=SecondTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   

	            	   }else if(FirstTime<=SecondTime){//��һ�̱߳ȵڶ��߳���ǰ����
	            		   startingTime[min]=FirstTime;
	            		   FirstTime=FirstTime+ServerTime[min];
	            		   finishingTime[min]=FirstTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   

	            	   }else{
	            		   startingTime[min]=SecondTime;
	            		   SecondTime=SecondTime+ServerTime[min];
	            		   finishingTime[min]=SecondTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   

	            	   }
	            	   ID[min]=true;//���������Ѿ����
	               }

	               for(i=0;i<100;i++){
	        		   System.out.print(Task_id[i]+"         ");
        			   System.out.print(ArrivedTime[i]+"            ");
        			   System.out.print(ServerTime[i]+"            ");
        			   System.out.print(startingTime[i]+"            ");
        			   System.out.print(finishingTime[i]+"            ");
        			   System.out.print(turnAroundTime[i]+"            ");
        			   System.out.println( weightTurnAround[i]);
	               }
	    		}catch(Exception e){
	    			e.printStackTrace();//����쳣��Ϣ
	    		}
	    	}
	    }
}
