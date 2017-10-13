package javaTest1;

public class leapGraph {
	{
	//打印上半个棱形
	   
         for (int i = 1; i <= 4; i++) {//外层循环控制趟数
         for (int j = i; j < 4; j++) {//这一层控制空白的地方
           System.out.print(" ");
                                        }
            for (int k = 1; k <= 2 * i - 1; k++) {//这层控制星星的数量
            		System.out.print("*");
                                                  }
            		System.out.println();
    	                                 }
  }
	{
		for(int a =3;a>0;a--)
		{
			for(int b=a;b<4;b++)
			{
				System.out.print(" ");
			}
			for(int c=1;c<=2*a-1;c++)
			{
				System.out.print("*");
			}
			System.out.println("");
			
		}
	}	
	}
