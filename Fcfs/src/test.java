
import java.io.IOException;
import java.util.Scanner;
public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//main����
    	fcfsOne f =new fcfsOne();
    	f.InputData();
    	fcfsTwo a=new fcfsTwo();	
    	System.out.println("1���ȵ��ȷ���(һ������)");
    	System.out.println("2���ȵ��ȷ���(��������)");
    	System.out.print("���������ѡ��:");
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
    			System.out.println("������1����2��");
    			break;
    	}       
    }
	}


