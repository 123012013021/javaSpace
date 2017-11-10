java的I/O操作
=======

实验一 基本IO操作
------------------
 ### 实验过程：
 
1. 从键盘接收字节流，写入到当前目录下的文件src.txt中：
![](https://github.com/123012013021/javaSpace/blob/master/IOstream/img/1.png) <br>

src.txt截图：
![](https://github.com/123012013021/javaSpace/blob/master/IOstream/img/2.png) <br>

2. 将src.txt文件内容复制到当src.txt前目录下dest.txt文件中
![](https://github.com/123012013021/javaSpace/blob/master/IOstream/img/3.png)  <br>

dest.txt截图：
![](https://github.com/123012013021/javaSpace/blob/master/IOstream/img/4.png) <br>
3. 将dest.txt文件内容显示到屏幕上：
![](https://github.com/123012013021/javaSpace/blob/master/IOstream/img/5.png) <br>
通过main函数进行测试：
![](https://github.com/123012013021/javaSpace/blob/master/IOstream/img/6.png) <br>
控制台输出截图
![](https://github.com/123012013021/javaSpace/blob/master/IOstream/img/7.png)
<br>
实验二 获取系统的文件树
------------------
* 主要使用java.nio.file实现*

 ### 实验过程：
1.  获取某个目录下的目录信息，目录从控制台输入。
![](https://github.com/123012013021/javaSpace/blob/master/IOstream/img/11.png) <br>

2.  目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
![](https://github.com/123012013021/javaSpace/blob/master/IOstream/img/12.png) <br>

3. 目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序。
![](https://github.com/123012013021/javaSpace/blob/master/IOstream/img/13.png) <br>





