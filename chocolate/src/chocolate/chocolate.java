package chocolate;

public class chocolate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ChocolateBoiler test = ChocolateBoiler.getInstance();
		  test.boil();
		  test.fill();
		  test.boil();
		  test.drain();
		  
		  
	}

}


  class ChocolateBoiler{
	  private boolean empty ; //�жϹ�¯�Ƿ�Ϊ��
	  private boolean boiled ;//�жϹ�¯�Ƿ����
	  private static ChocolateBoiler uniqueInstance; 
	  
	  private ChocolateBoiler() {
		  empty = true;
		  boiled = false;		  
	  }
	  
	  //����
	  public static ChocolateBoiler getInstance() {  
	        if (uniqueInstance == null) {  
	            System.out.println("������¯");  
	            uniqueInstance = new ChocolateBoiler();  
	        }  
	        System.out.println("��¯�Ѿ�����");  
	        return uniqueInstance;  
	    }  
	  public boolean isEmpty(){
		   return empty;   
	   }
	  
	  
	   public boolean isBoiled(){
		    return boiled;
		    }
	   
		//����  
	  public void fill() {
		  if(isEmpty()) {
			  System.out.println("����ɿ�����ţ��");
			  empty = false;
		  }
		  if(isEmpty() == true) {
			  System.out.println("��¯����");
		  }
	  } 
	  //���
	  public void boil() {
		  if(!isBoiled()&&isEmpty()==false){
			   System.out.println("�������ɿ�������");
			   boiled=true;
		   }
		   else {
			   System.out.println("�Ѿ����죨���߹�¯Ϊ�գ���������иò�����");
		   }
	  }
	  //�ų�
	  public void drain() {
		  
		  if(!isEmpty()&&isBoiled()){
			   empty=true;
			   boiled=false;
			   System.out.println("�ų���е��ɿ�����ţ��");
		   }
		   else System.out.println("��������ų�����");
	  } 
	  

	
	
}
