package javaTest1;

public class leapYear {
	{ int sum = 0;
      for(int year=1990;year<2008;year++) {
	       if ((year%4==0 && year%100!=0)||(year%400==0)) {
		
			     System.out.print(" "+year);
		         sum ++;                    
                   if (sum%2 ==0)
                      {
                	   System.out.println("");
                      }      
	  }	    
      }

	}
}
