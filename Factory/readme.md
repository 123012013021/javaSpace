---
title: 2017-10-13工厂模式练习


总共6个类：pizza类作为接口类，
其有三个子类实现：CheesePizza,PepperoniPizza和ClamPizza
SimplePizzaFactory是一个披萨对象生成“工厂”。
PizzaStore的构造函数需要传入SimplePizzaFactory实例，并且在orderPizza方法中利用SimplePizzaFactory实例首先生成一个具体的Pizza子类实例，然后进行披萨生产，包括pizza.prepare; pizza.bake(); pizza.cut(); pizza.box()，最后返回该Pizza子类实例。
以下是实验截图：
![enter description here][1]


  [1]: ./images/QQ%E5%9B%BE%E7%89%8720171013133648.png "QQ图片20171013133648.png"