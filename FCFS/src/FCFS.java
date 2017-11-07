import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FCFS {
	Task task;
	List<Task> list;
	List<Task> WaitList;
	List<Task> DealList;
	File file;
	int CurrentTime;
	private int TimeMessage[][];       //���ջ�ȡ������ʱ��
	FCFS() {
		task = new Task();
		list = new ArrayList<Task>();
		WaitList = new LinkedList<Task>();  //�ȴ�����
		DealList = new ArrayList<Task>();   //�������
		CurrentTime = 0;
		file = new File("F:\\array.txt");
		TimeMessage = new int [100][3];
		file.ReadFile();  				   //��ȡ�ļ�
		file.GetTimeMessage(TimeMessage);  //�����ݷ���TimeMessage����
		for(int i=0;i<100;i++) {
			task = new Task();
			task.SetTimedate(TimeMessage[i]);
			list.add(task);    
		}
	}
	
	public void FcfsFrist() {	
		int StartTime=0;
		for(int i=0;i<100;i++) {
			task = new Task();
			task = list.get(i);
			task.sumTime(StartTime);
			task.Show();
			StartTime=StartTime+task.GetService();
		}
	}
	
	public void FcfsSecond() {	
		int SumSerTime=0;
		WaitList.add(list.get(0));
		for(int i=0;i<list.size();i++) {
			WaitList.add(list.get(i));  
			//ȡ���� ���бȽ� Ȼ��ɾ��һ�� 
				Task taskTemp = new Task();
				task = new Task();
				task = WaitList.get(0);
				taskTemp = WaitList.get(1);
				
				if(task.GetArriveTime()<=CurrentTime) //����ʱ��С�ڵ�ǰʱ��
				{//�Ⱥ��ʱ
					task.sumTime(CurrentTime);
				}                  
				task.sumTime(SumSerTime);
				task.GetFinishTime();
			
			CurrentTime = task.GetFinishTime();  //�������ʱ��
		}
		
	}
	

}
