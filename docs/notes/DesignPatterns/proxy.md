# 代理模式

* [代理模式原理及实例讲解](https://www.ibm.com/developerworks/cn/java/j-lo-proxy-pattern/index.html)

## 1 背景

客户端不想或者不能直接操作目标对象，则可以通过一个“中介”来间接使用。代理对象可以屏蔽或者添加某些功能。我们可以引用新的对象来操作或者代替目标对象

## 2 定义

给某一个对象提供一个代理，并由代理对象控制对原来对象的引用，这种模式叫做代理模式。

## 3 结构

抽象主题角色

代理主题角色

真实主题角色

## 4 延迟加载

在系统启动时，将消耗资源最多的方法都使用代理模式分离，可以加快系统的启动速度，减少用户的等待时间。而**在用户真正做查询操作时再由代理类单独去加载真实的数据库查询类**，完成用户的请求。这个过程就是使用代理模式实现了延迟加载。

**延迟加载的核心思想是：**如果当前并没有使用这个组件，则不需要真正地初始化它，使用一个代理对象替代它的原有的位置，只要在真正需要的时候才对它进行加载。

```java
public interface IDBQuery {
    
    String request();
    
}
```

```java
public class DBQuery implements IDBQuery {

    public DBQuery() {
        try {
            Thread.sleep(1000); //假设数据库连接等耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "Request string";
    }
}
```

```java
public class DBQueryProxy implements IDBQuery {
    
    private DBQuery real = null;

    @Override
    public String request() {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        IDBQuery q = new DBQueryProxy();
        q.request();
    }
}
```

## 5 动态代理

* 在运行时动态生成代理类：代理类的字节码将在运行时生成并载入当前代理的ClassLoader。
* 好处：
  * 首先，不需要为真实主题写一个形式上完全一样的封装类，假如主题接口中的方法很多，为每一个接口写一个代理方法也很麻烦。如果接口有变动，则真实主题和代理类都要修改，不利于系统维护；
  * 其次，使用一些动态代理的生成方法甚至可以在运行时制定代理类的执行逻辑，从而大大提升系统的灵活性。

* 生成方法：JDK 自带的动态处理、CGLIB、Javassist 或者 ASM 库

# 6 应用场合

1. 远程代理：为一个对象在不同的地址空间提供局部代表，这样可以隐藏一个对象存在于不同地址空间的事实。
2. 虚拟代理：根据需要来创建开销很大的对象。例如未加载的图片，通过虚拟代理来替换真实的图片。
3. 安全代理：控制真实对象的访问权限
4. 指针引用：
5. 延迟加载