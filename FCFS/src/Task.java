public class Task {
	private int ServiceTime;       //����ʱ��
	private int TaskId;               //����ID  ����ʱ��  ����ʱ��
	private int startingTime;		  //��ʼʱ��
	private int finishingTime;        //���ʱ�� = ��ʼʱ��+����ʱ��
	private int turnAroundTime;       //��תʱ�� = ���ʱ��-����ʱ��
	private int arriveTime;            //����ʱ��
	private double weightTurnAround;     //��Ȩ��תʱ�� = ��תʱ��/����ʱ��
	
	public void Show() {//ÿһ����������ʱ����ʾ����
		System.out.println("����ID  ��ʼʱ��   ����ʱ��    ���ʱ��      �� ת ʱ ��       ��Ȩ ��ת ʱ��");
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
		finishingTime=startingTime+ServiceTime;  //���ʱ��
		turnAroundTime=finishingTime-arriveTime;  //��תʱ��
		weightTurnAround=(turnAroundTime*1.0)/ServiceTime;  //��Ȩ��ת
	}

}
