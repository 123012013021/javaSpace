import java.io.IOException;
import java.util.Scanner;
public class test {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
    	sjfone a=new sjfone();
    	sjftwo b=new sjftwo();
    	System.out.println("1、短作业优先(一个队列)");
    	System.out.println("4、短作业优先(两个队列)");
    	System.out.print("请输入你的选择:");
    	
    	Scanner sc = new Scanner(System.in);
    	int input = sc.nextInt();
    	switch(input){
    		case 1:
    			a.singleSJF();
    			break;
    		case 2:
    		    b.doubleSJF();
    			break;
    		default:
    			System.out.println("请输入1或者2！");
    			break;
    	}       
    }
	}


