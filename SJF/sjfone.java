import java.io.File;
import java.io.FileInputStream;
public class sjfone extends task{
	 public void singleSJF(){
	    	File file = new File("time.txt");//�����ļ�����      	
	    	if(file.exists()){//�ж��ļ��Ƿ����   	
	    		try{   			
	    		   FileInputStream in = new FileInputStream(file);   //����FileInputStream���󣬽�������Ϣ���ļ��ж�ȡ����
	               for(int i=0;i<100;i++){//���ļ�����������ݶ�ȡ����
	            	   int a=in.read();
	            	   Task_id[i]=a;
	            	   int b=in.read();
	            	   ArrivedTime[i] =b;
	            	   int c=in.read();            	   
	            	   ServerTime[i]=c;           	   
	               }
	               in.close();

	               startingTime[0]=ArrivedTime[0];//��һ������ʼʱ��
	               finishingTime[0]=ArrivedTime[0]+ServerTime[0];//��һ������ʱ��
	               turnAroundTime[0]=finishingTime[0]-startingTime[0];//��һ����תʱ��
	               weightTurnAround[0]=turnAroundTime[0]/ServerTime[0];//��һ����Ȩ��תʱ��            	   
	               System.out.print("Task_id: 1"+"   startingtime:"+startingTime[0]+"  finishingTime:");
	        	   System.out.print(+finishingTime[0]+"  turnAroundTime:");
	        	   System.out.print(+turnAroundTime[0]+"     ");
	        	   System.out.println("weightTurnAround:"+weightTurnAround[0]);
	        	   int temp_id;//�������ݴ洢����ID       	   
	        	   int temp;//�洢��һ��������ɵ�ʱ��
	        	   int temp_AT;//��ʱ����ʱ��
	        	   int temp_ST;//��ʱ����ʱ��

	               for(int i=1;i<100;i++){//��߿�ʼ�ж϶���ҵ
	            	   temp=finishingTime[i-1];//�洢��һ��������ɵ�ʱ��
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
