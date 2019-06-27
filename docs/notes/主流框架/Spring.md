# 1. 使用xml配置Spring

1. 读取配置文件
2. 获取Object对象，并强制类型转换

```java
ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
IAccountService as = (IAccountService) ac.getBean("accountService");
```

3. xml约束

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
</beans>
```

# 2. Spring对Bean的管理细节

## 2.1 创建Bean的3种方式

### 2.1.1 使用默认构造函数创建

在Spring的配置文件中使用bean标签，配置好id和class属性，且没有其他属性和标签时，采用默认构造函数创建Bean对象。如果没有默认构造函数（无参构造），则对象无法创建。

```xml
<!--以下配置会调用无参构造函数-->
<bean id="accountService" class="com.spring.service.impl.AccountServiceImpl"></bean>
```

```java
public class AccountServiceImpl implements IAccountService {
    public AccountServiceImpl(String name) {
        System.out.println("AccountServiceImpl Create");
    }

    public void saveAccount() {
        System.out.println("saveAccount");
    }
}
```

### 2.1.2 使用普通工厂方法创建对象(使用某个类中的方法创建对象)

```xml
<!--指定工厂对象-->
<bean id="instanceFactory" class="com.spring.factory.InstanceFactory"></bean>

<!--指定工厂对象，以及获取对象的方法-->
<bean id="accountService" factory-bean="instanceFactory" factory-method="getIAccountService"></bean>
```

```java
// 使用工厂创建AccountServiceImpl对象
public class InstanceFactory {
    public IAccountService getIAccountService() {
        return new AccountServiceImpl();
    }
}
```

### 2.1.3 使用工厂中的静态方法创建对象

```xml
<bean id="accountService" class="com.spring.factory.InstanceFactory" factory-method="getIAccountService"></bean>
```

```java
public class InstanceFactory {
    public static IAccountService getIAccountService() {
        return new AccountServiceImpl();
    }
}
```

## 2.2 bean的作用范围

Spring中默认的bean是单例的，可以使用bean标签中的scope属性指定bean的作用范围，取值：

| 取值           | 说明                                                         |
| -------------- | ------------------------------------------------------------ |
| **singleton**  | 单例（默认值）                                               |
| **prototype**  | 多例                                                         |
| request        | 作用于web应用的请求范围                                      |
| session        | 作用于web应用的会话范围                                      |
| global-session | 作用于集群环境的会话范围（全局会话范围）<br>当不是集群环境时，就是session |

 ## 2.3 bean的生命周期

### 2.3.1 单例

* 出生：当容器创建时出生
* 活着：只要容器存在，对象一直活着
* 死亡：容器销毁，对象死亡

### 2.3.2 多例

- 出生：使用对象时出生
- 活着：对象在使用中就一直活着
- 死亡：当对象长时间不用，且没有被引用时，由java的垃圾回收器回收

# 3. 依赖注入【Dependency Injection】

* IOC的作用：降低程序间的耦合（依赖关系），将依赖关系的管理都交给Spring来维护。

* 在当前类中需要用到其他类的对象，由Spring来为我们提供，我们只需要在配置文件中说明，依赖关系的维护就称之为依赖注入。
* 能够依赖注入的数据有3类：
  1. 基本数据类型和String类型；
  2. 其他bean类型（在配置文件或注解中配置过的bean）
  3. 集合类型
* 注入的方式3种：
  1. 使用构造函数
  2. 使用set方法
  3. 使用注解

> 使用依赖注入的数据应该时不经常发生变化的数据，如果经常变化，则不适合使用依赖注入

## 3.1 使用构造函数

在bean标签中使用construor-arg标签

| 属性      | 说明                                                 |
| --------- | ---------------------------------------------------- |
| type      | 指定要注入的数据类型，即构造函数中某个参数的数据类型 |
| index     | 指定构造函数中参数的索引，索引从0开始                |
| **name**  | 指定构造函数的参数名                                 |
| **value** | 提供基本类型和String类型的数据                       |
| **ref**   | 指定其他bean类型的数据（在bean中配置过的）           |

```xml
<bean id="accountService" class="com.spring.service.impl.AccountServiceImpl">
    <constructor-arg name="a" value="AAA"></constructor-arg>
    <constructor-arg name="b" value="18"></constructor-arg>
    <constructor-arg name="c" ref="data"></constructor-arg>
</bean>

<!--配置其他类型，赋值时使用ref-->
<bean id="data" class="java.util.Date"></bean>
```

```java
public class AccountServiceImpl implements IAccountService {
    private String a; // String类型
    private Integer b; // 基本数据类型
    private Date c; // 其他bean类型

    public AccountServiceImpl(String a, Integer b, Date c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
```

## 3.2 使用set方法

在bean标签中使用property标签

```xml
<bean id="accountService" class="com.spring.service.impl.AccountServiceImpl">
    <property name="a" value="A"></property>
    <property name="b" value="20"></property>
    <property name="c" ref="data"></property>
</bean>
```

> name是set方法名称去掉set并且转为小写字母，例如setA --> a

## 3.3 复杂类型（集合类）的注入

* 数组类型

```xml
<property name="myList">
    <array>
        <value>AA</value>
        <value>BB</value>
    </array>
</property>
```

* 其他类型就修改`<array>`就行，结构相同可以使用相同的标签
  1. 使用list标签给List，Array，Set注入
  2. 使用map标签给Map，Properties注入

