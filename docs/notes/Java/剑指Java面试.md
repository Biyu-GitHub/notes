# 谈谈你对Java的理解

* 平台无关性（一次编译到处运行）

* GC（垃圾回收机制）

* 语言特性（泛型，反射，lambda）

* 面向对象（封装，继承，多态）

* 类库

* 异常处理

## 平台无关性如何实现？

Java源码首先被编译成字节码，再由不同平台的JVM解析，Java语言在不同平台上运行的时候不需要重新编译，JVM在执行字节码的时候会转换成具体平台上的机器指令。

## 为什么JVM不直接将源码解析成机器码去执行？

1. 每次执行之前都需要进行各种检查；
2. 提高兼容性

## JVM如何加载.class文件？

![JVM](..\images\剑指Java面试_JVM.jpg)

* Class Loader：依据特定格式，加载class文件到内存；
* Execution Engine：对命令行进行解析；
* Native Interface：融合不同开发语言的原生库为Java所用；
* Runtime Data Area：JVM内存空间结构模型。

## 谈谈反射？

Java反射机制是在运行状态中，对于任意一个类，都能够直到这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意方法和属性；这种动态获取信息以及动态调用对象方法的功能称为Java语言的反射机制。

## 常用反射函数以及写一个反射的例子？

* 获取Class对象的方式：
```
1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
	* 多用于配置文件，将类名定义在配置文件中。读取文件，加载类
2. 类名.class：通过类名的属性class获取
	* 多用于参数的传递
3. 对象.getClass()：getClass()方法在Object类中定义着。
	* 多用于对象的获取字节码的方式

* 结论：
同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，不论通过哪一种方式获取的Class对象都是同一个。
```

* Class对象功能：

```
1. 获取成员变量们
			
	* Field[] getFields() ：获取所有public修饰的成员变量

	* Field getField(String name)   获取指定名称的 public修饰的成员变量
	
	* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
	* Field getDeclaredField(String name)  
2. 获取构造方法们
  * Constructor<?>[] getConstructors()  
  * Constructor<T> getConstructor(类<?>... parameterTypes)  

  * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)  
  * Constructor<?>[] getDeclaredConstructors()  

3. 获取成员方法们：
  * Method[] getMethods()  
  * Method getMethod(String name, 类<?>... parameterTypes)  

  * Method[] getDeclaredMethods()  
  * Method getDeclaredMethod(String name, 类<?>... parameterTypes)  

4. 获取全类名	
  * String getName()  
```
```
* Field：成员变量
    1. 设置值
    	* void set(Object obj, Object value)  
    2. 获取值
    	* get(Object obj) 
    3. 忽略访问权限修饰符的安全检查
    	* setAccessible(true):暴力反射
```

```java
Class.forname("")
newInstance();

// 可以获取私有方法，但是不能获取继承的方法，和实现的接口的方法
getDeclaredMethod("name");
// 获取到的私有的方法设置权限
setAccessible(true);
// 传参数
invoke();

// 获取public的方法，包括继承来的方法
getMethod();
```

谈谈ClassLoader？

```java
loadClass();
```

双亲委派机制？

loadClass和forName的区别？



你了解Java的内存模型吗？（Runtime Data Area）

递归为什么会引发java.lang.StackOverflowError异常？



