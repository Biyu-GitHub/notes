# 1. 概念

* **JDBC**(Java DataBase Connectivity)即Java数据库连接，Java语言操作数据库。
* 其实是官方（sun公司）定义的一套操作所有关系型数据库的规则，即接口。各个数据库厂商去实现这套接口，提供数据库驱动jar包。我们可以使用这套接口（JDBC）编程，真正执行的代码是驱动jar包中的实现类。

# 2. 快速入门

## 2.1 步骤

1. 导入驱动jar包
2. 注册驱动
3. 获取数据库连接对象 Connection
4. 定义sql
5. 获取执行sql语句的对象 Statement
6. 执行sql，接受返回结果
7. 处理结果
8. 释放资源

## 2.2 代码示例

```java
Connection conn = null;
Statement stmt = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4", "root", "mysql");

    String sql = "update emp set salary = 999.99 where id = 1001";

    stmt = conn.createStatement();

    int i = stmt.executeUpdate(sql); // 返回受影响的行数
    
} catch (ClassNotFoundException e) {
    e.printStackTrace();
} catch (SQLException e) {
    e.printStackTrace();
} finally {
    if (stmt != null) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (conn != null) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

# 3. 详解各个对象

## 3.1 DriverManager

1. 注册驱动：告诉程序该使用哪一个数据库驱动jar
   * 新版本使用`Class.forName("com.mysql.cj.jdbc.Driver");`
   * 旧版本使用`Class.forName("com.mysql.jdbc.Driver");`
2. 获取数据库连接：`DriverManager.getConnection(String url, String user, String password)`
   * url：指定连接的路径
     * `“jdbc:mysql://ip地址(域名):端口号/数据库名称”`
     * 如果连接的是本机mysql服务器，并且mysql服务默认端口是3306，则url可以简写为：`jdbc:mysql:///数据库名称`
   * user：用户名
   * password：密码

## 3.2 Connection

1. 获取执行sql 的对象

   * `Statement createStatement()`
   
     ```java
     String sql = "select * from emp";
     stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery(sql);
     ```
   
   * `PreparedStatement prepareStatement(String sql)`
   
     ```java
     // 使用?占位
     String sql = "select * from emp where id = ?";
     stmt = conn.prepareStatement(sql);
     // 设置?的值setXxx，参数1代表?的位置，编号从1开始；参数2代表?的取值
     stmt.setInt(1, 1001);
     ResultSet rs = stmt.executeQuery();
     ```

2. 管理事务

	* 开启事务：`setAutoCommit(boolean autoCommit)` ：调用该方法设置参数为false，即开启事务
	* 提交事务：`commit()`
	* 回滚事务：`rollback()`

## 3.3 Statement

1. 执行sql
   * `boolean execute(String sql)`：可以执行任意的sql
   * `int executeUpdate(String sql)`：执行DML（insert、update、delete）语句、DDL(create，alter、drop)语句
   * `ResultSet executeQuery(String sql)`：执行DQL（select)语句

## 3.4 ResultSet

1. `boolean next()`：游标向下移动一行，若移动到末尾则返回false
2. `getXxx(列名/列的序号)`

# 附录

## 1. 乱码问题

```sql
-- 修改mysql全局时区为北京时间，即我们所在的东8区
set global time_zone = '+8:00'; 
-- 修改当前会话时区
set time_zone = '+8:00';
-- 立即生效
flush privileges; 
```

