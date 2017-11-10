
import java.io.IOException;
import java.util.Scanner;
public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//main函数
    	fcfsOne f =new fcfsOne();
    	f.InputData();
    	fcfsTwo a=new fcfsTwo();	
    	System.out.println("1、先到先服务(一个队列)");
    	System.out.println("2、先到先服务(两个队列)");
    	System.out.print("请输入你的选择:");
    	Scanner sc = new Scanner(System.in);
    	int input = sc.nextInt();
    	switch(input){
    		case 1:
    			f.SingleFCFS();;
    			break;
    		case 2:
    			a.doubleFCFS();
    			break;
    		default:
    			System.out.println("请输入1或者2！");
    			break;
    	}       
    }
	}


