import java.io.File;
import java.io.FileInputStream;
public class fcfsTwo  extends  task {
	public void doubleFCFS(){//�ȵ��ȷ���˫�̣߳�
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
               int FirstTime=0;//��һ�̵߳�ʱ��
               int SecondTime=0;//�ڶ��̵߳�ʱ��
               int MarkTask[];//������ǲ����ĸ�
               MarkTask=new int[100];
               for(int i=0;i<100;i++){
            	   if(FirstTime<=ArrivedTime[i]){//�����һ�߳���������
            		   startingTime[i]=FirstTime;//��¼����Ŀ�ʼʱ��
            		   FirstTime=ServerTime[i]+ArrivedTime[i];
            		   finishingTime[i]=FirstTime;
            		   MarkTask[i]=1;
            	   }else if(SecondTime<=ArrivedTime[i]){//�����һ�߳��������񣬶��ڶ��߳̿���
            		   startingTime[i]=SecondTime;
            		   SecondTime=ServerTime[i]+ArrivedTime[i];
            		   finishingTime[i]=SecondTime;
            		   MarkTask[i]=2;
            	   }else if(FirstTime<=SecondTime){//�����һ���ڶ��̶߳��ڹ�������ô���ж��ĸ��Ƚ�������
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
               /*������תʱ�䣬��Ȩ��תʱ��*/
               for(int i=0;i<100;i++){
            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
               }
               
               for(int i=0;i<100;i++){
            	   if(MarkTask[i]==1){
            		   System.out.print("task_id:"+(i+1)+" ");
            		   System.out.print("in one_queque"+"  startingTime:"+startingTime[i]+"  ");
            		   System.out.print("finishingTime:"+finishingTime[i]+"  ");
            		   System.out.print("turnAroundTime"+turnAroundTime[i]+"  ");
            		   System.out.println("turnAroundTime"+weightTurnAround[i]);            		   
            	   }else{
            		   System.out.print("task_id:"+(i+1)+" ");
            		   System.out.print("in two_queque"+"  startingTime:"+startingTime[i]+"  ");
            		   System.out.print("finishingTime:"+finishingTime[i]+"  ");
            		   System.out.print("turnAroundTime:"+turnAroundTime[i]+"  ");
            		   System.out.println("turnAroundTime:"+weightTurnAround[i]);
            	   }
               }
    		}catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}

    }
}
