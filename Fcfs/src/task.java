import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class task {
	 int TaskId[];//����ID
		int arrived_time[];//����ʱ��
		int server_time[];//����ʱ��
		int Task_id[] ;//�������
		int []ServerTime;
		int []ArrivedTime;
		int startingTime[];//��ʼʱ��
		int finishingTime[];//���ʱ��=��ʼʱ��+����ʱ��
		int turnAroundTime[];//��תʱ��=���ʱ��-�ﵽʱ��
		float weightTurnAround[] ;//��Ȩ��תʱ��=��תʱ��/����ʱ��
		
		public task(){//��������
			TaskId= new int[100];
			arrived_time=new int[100];
			server_time=new int[100];
			Task_id=new int[100];//��ʼ����������ID
			ServerTime=new int[100];
			ArrivedTime=new int[100];
			startingTime =new int[100];
			finishingTime=new int[100];
			turnAroundTime=new int[100];
			weightTurnAround=new float[100];

		}
		
	    public void InputData(){  //���������뵽�ļ����� 	 
	    	File file = new File("time.txt");//�����ļ�����
	    	int[] numbers = {6,2,1,3,9};//�������Χ������������
	    	if(file.exists()){//�ж��ļ��Ƿ����
	    		try{
	    			FileOutputStream out = new FileOutputStream(file);//����FileOutputStream���󣬽�������Ϣд�뵽�ļ���
	    			for(int i=0;i<100;i++){
	    				TaskId[i]=i+1;//����������
	    				out.write(TaskId[i]);
	    				
	    				arrived_time[i]=i;//��������ﵽʱ��
	    				out.write(arrived_time[i]);
	    				
	    	    		Random random = new Random();//�������������ѡ������ķ���ʱ��
	    	    		int index = random.nextInt(numbers.length);
	    	    		server_time[i]=numbers[index];
	    	    		out.write(server_time[i]);   	    		
	    			}
	    			out.close();
	    		}catch(Exception e){
	    			e.printStackTrace();//����쳣��Ϣ
	    		}
	    	}else{//�����ڵĻ����½��ļ�
	    		try{//try���鲶׽���ܳ��ֵ��쳣
	    			file.createNewFile();//�������ļ� 
	    			InputData();
	    		}
	    		catch(Exception e){
	    			e.printStackTrace();//����쳣��Ϣ
	    		}
	    	}
	    }
}
