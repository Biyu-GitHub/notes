谈谈你对Java的理解

平台无关性（一次编译到处运行）

GC（垃圾回收机制）

语言特性（泛型，反射，lambda）

面向对象（封装，继承，多态）

类库

异常处理



平台无关性如何实现？

为什么JVM不直接将源码解析成机器码去执行？

JVM如何加载.class文件？



谈谈反射？

​	把类中的各个部分映射成对象

常用反射函数以及写一个反射的例子？

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







