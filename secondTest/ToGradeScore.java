package javaTest1;

import java.util.Scanner;
public class ToGradeScore {
       {
    	System.out.println("Enter a number between 0 and 100");   
       Scanner input = new Scanner(System.in);  
       double num =input.nextDouble();
       if(num<=100&&num>=90){
    	   System.out.print("优");
          }
       else if(num<=89&&num>=80) {
    	   System.out.print("良");   
       }
       else if(num<=69&&num>=60) {
    	   System.out.print("及格");   
       }
       else if(num<=59&&num>=0) {
    	   System.out.print("不及格");   
       }
  
}}
