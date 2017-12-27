JAVA多线程


=======

----------------------------------------------------------------------------------------
对实验三中的单例模式进行改造，使其支持多线程，并且是线程安全的。

--------------------------------------------------------------------------------------------
主要代码
```
package Chocolate;

public class ChocolateBoiler implements Runnable {	
	
	ChocolateBoiler(){}
	private boolean empty = true;
	private boolean boiled = false;
	private static ChocolateBoiler I;
	
	public static synchronized ChocolateBoiler getI(){
		if(I==null){
			I=new ChocolateBoiler();
		}
		return I;
	}
	
	public synchronized void fill(){
		if(empty==true){
			System.out.println("现在填充巧克力和牛奶的混合物");
			empty=false;
			return;
		}
		System.out.println("对不起容器正在使用中");
	}
	
	public synchronized void boil(){
		if(empty==false && boiled==false){
			System.out.println("现在开始煮混合物");
			boiled=true;
			return;
		}
		System.out.println("对不起，容器为空或者容器中的东西未熟");
	}
	
	public synchronized void drain(){
		if(empty==false && boiled==true){
			System.out.println("现在倒出混合物");
			empty=true;
			boiled=false;
			return;
		}
		System.out.println("对不起,混合物还没煮熟或者容器内无物品");
	}
	
	public int isEmpty(){
		if(empty==true)
		{
			return 1;
		}
		return 0;
	}
	
	public int isBoiled(){
		if(boiled==false){		
			return 1;
		}
		return 0;
	}

	
	public void run() {
		fill();
		boil();
		drain();
	}
	
}

```

  

### 实验结果截图：
 
1.：<br>
![](https://github.com/123012013021/javaSpace/blob/master/Fcfs/img/1.png)<br>




