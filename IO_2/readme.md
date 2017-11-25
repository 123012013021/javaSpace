## 实验三 带缓冲区的IO


### 实验内容：
用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。


#### 实验结果截图：

![](https://github.com/123012013021/javaSpace/blob/master/IO_2/img/1.png)<br>
  
  
## 实验四 对象序列化


### 实验内容：
类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，使用序列化技术定义Student。学生信息从文件list.txt读入，并按照学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。
使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。
使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中。

#### 建student类 implements Serializable	
#### 建Read_Write类继承student类 主要有Read_List()、write（）、ReadFromNewFile()方法

#### 实验结果截图：

![](https://github.com/123012013021/javaSpace/blob/master/IO_2/img/2.png)<br>

    


