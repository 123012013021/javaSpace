import java.io.*;
import java.io.FileInputStream;
public class fcfsOne extends  task{
	  public void SingleFCFS(){//�����ȷ���(���߳�)
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
	               for(int i=0;i<100;i++){
	            	   System.out.println(Task_id[i]+"  "+ArrivedTime[i]+"  "+ServerTime[i]);
	               }
	               startingTime[0]=ArrivedTime[0];//�����ǵ�һ������ʼʱ��
	               finishingTime[0]=ArrivedTime[0]+ServerTime[0];//����ǵ�һ������ʱ��
	               turnAroundTime[0]=finishingTime[0]-startingTime[0];//��һ����תʱ��
	               weightTurnAround[0]=turnAroundTime[0]/ServerTime[0];//��һ����Ȩ��תʱ��
	               for(int i=1;i<100;i++){
	            	   startingTime[i]=startingTime[i-1]+ServerTime[i-1];
	            	   finishingTime[i]=finishingTime[i-1]+ServerTime[i];
	            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
	            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
	               }
	               for(int i=0;i<100;i++){
	            	   System.out.print("task_id:"+(i+1)+"     "+"start_time:"+startingTime[i]+"     ");
	            	   System.out.print("finishi_time:"+finishingTime[i]+"     ");
	            	   System.out.print("turn_around_time:"+turnAroundTime[i]+"     ");
	            	   System.out.println("weightTurnAround_time:"+weightTurnAround[i]);
	               }
	    		}catch(Exception e){
	    			e.printStackTrace();//����쳣��Ϣ
	    		}
	    	}
	    	
	    }
}
