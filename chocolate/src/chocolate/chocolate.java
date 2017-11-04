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
	  private boolean empty ; //判断锅炉是否为空
	  private boolean boiled ;//判断锅炉是否煮沸
	  private static ChocolateBoiler uniqueInstance; 
	  
	  private ChocolateBoiler() {
		  empty = true;
		  boiled = false;		  
	  }
	  
	  //单例
	  public static ChocolateBoiler getInstance() {  
	        if (uniqueInstance == null) {  
	            System.out.println("开启锅炉");  
	            uniqueInstance = new ChocolateBoiler();  
	        }  
	        System.out.println("锅炉已经存在");  
	        return uniqueInstance;  
	    }  
	  public boolean isEmpty(){
		   return empty;   
	   }
	  
	  
	   public boolean isBoiled(){
		    return boiled;
		    }
	   
		//填满  
	  public void fill() {
		  if(isEmpty()) {
			  System.out.println("填充巧克力和牛奶");
			  empty = false;
		  }
		  if(isEmpty() == true) {
			  System.out.println("锅炉已满");
		  }
	  } 
	  //煮沸
	  public void boil() {
		  if(!isBoiled()&&isEmpty()==false){
			   System.out.println("进行煮巧克力操作");
			   boiled=true;
		   }
		   else {
			   System.out.println("已经煮熟（或者锅炉为空），无需进行该操作！");
		   }
	  }
	  //排出
	  public void drain() {
		  
		  if(!isEmpty()&&isBoiled()){
			   empty=true;
			   boiled=false;
			   System.out.println("排出煮沸的巧克力和牛奶");
		   }
		   else System.out.println("无需进行排出操作");
	  } 
	  

	
	
}
