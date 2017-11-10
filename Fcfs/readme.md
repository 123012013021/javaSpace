模拟实现FCFS（先来先服务）
=======

----------------------------------------------------------------------------------------
FCFS算法按照任务到达的顺序进行服务，先来先服务
每个Task对象可以描述为至少包含下列属性：
taskID //任务ID
arrivalTime //到达时间
serviceTime //服务时间
startingTime //开始时间
finishingTime //完成时间=开始时间+服务时间
turnAroundTime //周转时间=完成时间-达到时间
weightTurnAround //带权周转时间=周转时间/服务时间
其他的属性根据程序需要设置
任务(Task)的ID、开始时间和服务时间由文件读入，形如右图所示。这个任务列表文件首先由程序生成，每秒一个任务达到，服务时间由{6,2,1,3,9}这个集合中的数据随机获取。文件列表要包含至少100个任务。
先要求实现如下要求的FCFS
当只有一个处理队列时的情况
当有两个处理队列时的情况

--------------------------------------------------------------------------------------------
### 主要描述：
##### task.java 描述了任务的基本属性，作为整个工程的父类。在工程目录中调用了FileOutputStream，生成了time.txt文件。


##### fcfsone描述了当一个处理队列时的情况，继承了task。首先调用 FileInputStream，read文件中的数据,给Task_id， ArrivedTime，ServerTime这三个数组赋值。之后再进行其他属性的计算

##### fcfstwo描述了当两个处理队列的情况，继承了task. 设两个整形数据 FirstTime和SecondTime表示第一线程和第二线程的时间。 MarkTask数组用来标记，在第一队列进行的标记为1，第二个队列进行的标记为2.最后在分成两个数组，进行其他属性的计算。

##### test 作为测试类输出结果 :switch..case，选择进行单队列的还是双队列。
  

### 实验结果截图：
 
1. 一个队列：<br>输入：<br>
![](https://github.com/123012013021/javaSpace/blob/master/Fcfs/img/1.png)<br>
![](https://github.com/123012013021/javaSpace/blob/master/Fcfs/img/2.png)<br>
2. 两个队列：<br>
![](https://github.com/123012013021/javaSpace/blob/master/Fcfs/img/3.png)<br>


