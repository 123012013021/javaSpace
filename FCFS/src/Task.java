public class Task {
	private int ServiceTime;       //服务时间
	private int TaskId;               //任务ID  到达时间  服务时间
	private int startingTime;		  //开始时间
	private int finishingTime;        //完成时间 = 开始时间+服务时间
	private int turnAroundTime;       //周转时间 = 完成时间-到达时间
	private int arriveTime;            //到达时间
	private double weightTurnAround;     //带权周转时间 = 周转时间/服务时间
	
	public void Show() {//每一个任务的相关时间显示出来
		System.out.println("任务ID  开始时间   服务时间    完成时间      周 转 时 间       带权 周转 时间");
		System.out.println(TaskId+"      "+startingTime+"      "+ServiceTime+"    "+"   "+finishingTime+"       "
				+turnAroundTime+"         "+weightTurnAround);
	}
	
	Task() {
		TaskId = 0;
		startingTime = 0;
		finishingTime = 0;
		turnAroundTime = 0;
		weightTurnAround = 0;
		arriveTime=0;
		ServiceTime=0;
	}
	
	public int GetService() {
		return ServiceTime==0?0:ServiceTime;
	}
	public int GetArriveTime() {
		return arriveTime;
	}
	public int GetFinishTime() {
		return finishingTime;
	}
	public void SetTimedate(int [] time) {
		this.TaskId = time[0];
		this.arriveTime = time[1];
		this.ServiceTime = time[2];
	}
	
	public void sumTime( int StartTime) {
		startingTime=StartTime;         
		finishingTime=startingTime+ServiceTime;  //完成时间
		turnAroundTime=finishingTime-arriveTime;  //周转时间
		weightTurnAround=(turnAroundTime*1.0)/ServiceTime;  //带权周转
	}

}
