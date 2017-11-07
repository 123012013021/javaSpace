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
	private int TimeMessage[][];       //接收获取的任务时间
	FCFS() {
		task = new Task();
		list = new ArrayList<Task>();
		WaitList = new LinkedList<Task>();  //等待对列
		DealList = new ArrayList<Task>();   //处理队列
		CurrentTime = 0;
		file = new File("F:\\array.txt");
		TimeMessage = new int [100][3];
		file.ReadFile();  				   //读取文件
		file.GetTimeMessage(TimeMessage);  //把数据放在TimeMessage里面
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
			//取两个 进行比较 然后删除一个 
				Task taskTemp = new Task();
				task = new Task();
				task = WaitList.get(0);
				taskTemp = WaitList.get(1);
				
				if(task.GetArriveTime()<=CurrentTime) //到达时间小于当前时间
				{//等候多时
					task.sumTime(CurrentTime);
				}                  
				task.sumTime(SumSerTime);
				task.GetFinishTime();
			
			CurrentTime = task.GetFinishTime();  //最后的完成时间
		}
		
	}
	

}
