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
	               for( i=0;i<100;i++){
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
	            	   if(FirstTime<=ArrivedTime[min]){
	            		   startingTime[min]=FirstTime;
	            		   FirstTime=ArrivedTime[min]+ServerTime[min];
	            		   finishingTime[min]=FirstTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
	            		   System.out.print("���ǵ�"+(min+1)+"�������ڵ�һ�߳��н��У���ʼʱ����");
	            		   System.out.print(startingTime[min]+",   ����ʱ����"+finishingTime[min]+",  ");
	            		   System.out.print("��תʱ��"+turnAroundTime[min]+",  ");
	            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[min]);
	            	   }else if(SecondTime<=ArrivedTime[min]){//�����һ�߳������������񣬵ڶ��߳̿���     		
	            		      if(SecondTime==0) {
	            			   SecondTime=ArrivedTime[min];
	            		   }
	            		   startingTime[min]=SecondTime;
	            		   SecondTime=ArrivedTime[min]+ServerTime[min];
	            		   finishingTime[min]=SecondTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
	            		   System.out.print("���ǵ�"+(min+1)+"�������ڵڶ��߳��н��У���ʼʱ����");
	            		   System.out.print(startingTime[min]+",  ����ʱ����"+finishingTime[min]+",  ");
	            		   System.out.print("��תʱ��"+turnAroundTime[min]+",  ");
	            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[min]);
	            		   
	            	   }else if(FirstTime<=SecondTime){
	            		   startingTime[min]=FirstTime;
	            		   FirstTime=FirstTime+ServerTime[min];
	            		   finishingTime[min]=FirstTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
	            		   System.out.print("���ǵ�"+(min+1)+"�������ڵ�һ�߳��н��У���ʼʱ����");
	            		   System.out.print(startingTime[min]+",  ����ʱ����"+finishingTime[min]+",  ");
	            		   System.out.print("��תʱ��"+turnAroundTime[min]+",  ");
	            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[min]);

	            	   }else{
	            		   startingTime[min]=SecondTime;
	            		   SecondTime=SecondTime+ServerTime[min];
	            		   finishingTime[min]=SecondTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
	            		   System.out.print("���ǵ�"+(min+1)+"�������ڵڶ��߳��н��У���ʼʱ����");
	            		   System.out.print(startingTime[min]+",  ����ʱ����"+finishingTime[min]+",  ");
	            		   System.out.print("��תʱ��"+turnAroundTime[min]+",  ");
	            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[min]);
	            	   }
	            	   ID[min]=true;//���������Ѿ����
	               }
	    		}catch(Exception e){
	    			e.printStackTrace();//����쳣��Ϣ
	    		}
	    	}
	    }
}
