import java.io.IOException;
import java.util.Scanner;
public class test {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
    	sjfone a=new sjfone();
    	sjftwo b=new sjftwo();
    	System.out.println("1������ҵ����(һ������)");
    	System.out.println("4������ҵ����(��������)");
    	System.out.print("���������ѡ��:");
    	
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
    			System.out.println("������1����2��");
    			break;
    	}       
    }
	}


