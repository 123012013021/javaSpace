javaJAVA多线程

=======

利用4个线程分段求和1~100
线程1计算1~25之和；线程2计算26~50之和；以此类推
要求线程1完成之后执行线程2，之后执行线程3，最后执行线程4
打印每段求和结果，以及最后的总结果。即分别打印第一段求和结果，第二段求和结果，第三段求和结果，第四段求和结果，最终的求和结果

------------------
 ### 实验过程：
 
1. 主要代码
```
package numberadd;

public class NumberAdd extends Thread{
private static Thread []Add = new Thread[4];
static int Sum=0;
	int num;
	public NumberAdd(int number){
		num=number;
	}
	
	public void run(){
		int count=0;
		for(int i=0;i<25;i++){
			count=count+num;
			num++;
			
		}
		Sum=Sum+count;
		System.out.print(count);
	}
	
	public static void main(String []args) throws InterruptedException{
		for(int i=0;i<Add.length;i++){//这里定义的i是线程数量
			int k=i*25+1;
			Add[i]= new Thread (new NumberAdd(k));
			System.out.print("第"+(i+1)+"线程计算结果：");
			Add[i].start();
			Add[i].join();
			System.out.println();
		}
		System.out.println("总和："+Sum);
	}
}

```
2. 
实验截图：
<br>
![](https://github.com/123012013021/javaSpace/blob/master/numberadd/img/2.png)







