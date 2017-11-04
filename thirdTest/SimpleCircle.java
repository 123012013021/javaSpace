package javaTest3;

public class SimpleCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simple circle = new Simple();
		System.out.println("radius"+circle.radius+"is"+circle.getArea());
		System.out.println("radius"+circle.radius3+"is"+circle.getArea3());
		System.out.println("radius"+circle.radius4+"is"+circle.getArea4());
	}
}

class Simple{
	  double   radius;
	  private double  radius2 ;
	  protected double radius3 ;
	  public  double   radius4;
	  
	  Simple(){
		  radius = 1;
		  radius2 = 1;
		  radius3 =1;
		  radius4 = 1;
		  
	  }	  
	  double getArea() {
		  return radius*radius*Math.PI;
	  }  
	  private double getArea2() {
		  return   radius2*radius2*Math.PI;
	  }
	  protected double getArea3() {
		  return radius3*radius3*Math.PI;
	  } 
	  public double getArea4() {
		  return radius4*radius4*Math.PI;
	  }  
}
