## 一、DDL(Data Definition Language)数据定义语言

用来定义数据库对象：数据库，表，列等。关键字：create, drop,alter 等

### 1. 操作数据库 CRUD

#### 1.1 C(Create):创建

```sql
-- 创建数据库
create database 数据库名称;
-- 创建数据库，判断不存在，再创建
create database if not exists 数据库名称;
-- 创建数据库，并指定字符集
create database 数据库名称 character set 字符集名;

-- 练习： 创建db4数据库，判断是否存在，并制定字符集为gbk
create database if not exists db4 character set gbk;
```

#### 1.2 R(Retrieve):查询

```sql
-- 查询所有数据库的名称
show databases;
-- 查询某个数据库的字符集:查询某个数据库的创建语句
show create database 数据库名称;
```

#### 1.3 U(Update):修改

```sql
-- 修改数据库的字符集
alter database 数据库名称 character set 字符集名称;
alter database db4 character set utf8;
```

#### 1.4 D(Delete):删除

```sql
-- 删除数据库
drop database 数据库名称;
-- 判断数据库存在，存在再删除
drop database if exists 数据库名称;
```

#### 1.5 使用数据库

```sql
-- 使用数据库
use 数据库名称;
-- 查询当前正在使用的数据库名称
select database();
```

### 2. 操作表

#### 2.1 C(Create):创建

1. 语法

```sql
create table 表名(
    列名1 数据类型1,
    列名2 数据类型2,
    ....
    列名n 数据类型n
);
```

2. 注意事项：最后一列，不需要加逗号（,）
3. 数据类型

|   名称    |                             描述                             |               例子                |
| :-------: | :----------------------------------------------------------: | :-------------------------------: |
|    int    |                           整数类型                           |              age int              |
|  double   |                           小数类型                           |         score double(5,2)         |
|   date    |                      日期，只包含年月日                      |            yyyy-MM-dd             |
| datetime  |                    日期，包含年月日时分秒                    |        yyyy-MM-dd HH:mm:ss        |
| timestamp | 时间戳类型，包含年月日时分秒。如果将来不给这个字段赋值，或赋值为null，则默认使用当前的系统时间，来自动赋值 |        yyyy-MM-dd HH:mm:ss        |
|  varchar  |                            字符串                            | name varchar(20):姓名最大20个字符 |

```sql
-- 创建学生表
create table student(
	id int,
    name varchar(32),
    age int,
    score double(4,1),
    birthday date,
    insert_time timestamp
);

-- 复制表
create table 表名 like 被复制的表名;
```

#### 2.2 R(Retrieve):查询

```sql
-- 查询某个数据库中所有的表名称
show tables;
-- 查询表结构
desc 表名;
```

#### 2.3 U(Update):修改

1. 修改表名

```sql
alter table 表名 rename to 新的表名;
```

2. 修改表的字符集

```sql
alter table 表名 character set 字符集名称;
```

3. 添加一列

```sql
alter table 表名 add 列名 数据类型;
```

4. 修改列名称 类型

```sql
alter table 表名 change 列名 新列名 新数据类型;
alter table 表名 modify 列名 新数据类型;
```

5. 删除列

```sql
alter table 表明 drop 列名;
```

#### 2.4 D(Delete):删除

```sql
drop table 表名;
drop table  if exists 表名;
```

## 二、DML(Data Manipulation Language)数据操作语言

用来对数据库中表的数据进行增删改。关键字：insert, delete, update 等

### 1. 添加数据

* 语法

```sql
insert into 表名(列名1,列名2,...列名n) values(值1,值2,...值n);
insert into 表名 values(值1,值2,...值n);
```

* 注意：
  1. 列名和值要一一对应；
  2. 使用方法2添加数据，则要包含全部字段；
  3. 除了数字类型，其他类型需要使用引号(单双都可以)引起来；
  4. 自动增长的主键可以用：0，null，default来占位；
  5. 枚举类型如("男","女")可以使用数字1，2来代替，数字下标从1开始；

### 2. 删除数据

* 语法

```sql
delete from 表名 [where 条件];
```

* 注意：
  1. 如果不加条件，则删除表中所有记录，有多少条记录就删除多少次，如果想要删除所有数据，并不推荐，效率很低；
  2. 如果要删除所有记录，推荐使用`TRUNCATE TABLE 表名;`会先删除该表，再创建一个名称相同的空表。

### 3. 修改数据

* 语法

```sql
update 表名 set 列名1 = 值1, 列名2 = 值2,... [where 条件];
```

* 注意：
  1. 如果不加任何条件，则会将表中所有记录全部修改。

## 三、DQL(Data Query Language)数据查询语言

用来查询数据库中表的记录(数据)。关键字：select, where 等

### 1. 语法

```sql
select
	字段列表
from
	表名列表
where
	条件列表
group by
	分组字段
having
	分组之后的条件
order by
	排序
limit
	分页限定
```

### 2. 基础查询

1. 多个字段的查询

```sql
select 字段名1，字段名2... from 表名；

-- 如果查询所有字段，则可以使用*来替代字段列表
select * from 表名；
```

2. 别名

```sql
-- 给字段起别名
select name as 姓名, age as 年龄 from 表名;

-- 给表起别名
select 别名.name 别名.age from 表名 as 别名;
```

3. 去重

```sql
-- 去重复，完全相同的数据只显示一次
select distinct 字段名1, 字段名2 from 表名;
```

### 3. 条件查询

1. 使用`where`后面加表达式
2. 运算符
   * 比较运算符：> 、< 、<= 、>= 、= 、!= 或 <>
   * 逻辑运算符：and 或 && 、or或 || 、not 或 !  

### 4. 模糊查询

1. 使用`like`
   * `_`表示==1个任意字符
   * `%`表示>=0个任意字符

```sql
--  查询名字以王开头
select * from 表名 where name like "王%"

-- 查询名字以王开头,两个字的名字
select * from 表名 where name like "王_"
```

2. 使用`rlike`可加正则表达式

### 5. 范围查询

1. 非连续范围使用`in`或`not in`

```sql
select * from 表名 where id in (1, 3, 6);
select * from 表名 where id not in (2, 4);
```

2. 连续范围使用`between a and b`表示范围为[a,b]

```sql
select * from 表名 where age not between 15 and 30;
```

3. 空判断使用`is null`或`is not null`

### 6. 排序查询

1. 使用`order by`进行排序
   * `asc`从小到大为默认的
   * `desc`从大到小
2. 如果有多个排序条件，则当前边的条件值一样时，才会判断第二条件。

```sql
-- 单字段
order by age desc;

-- 多字段
order by age desc, id asc;
```

### 7. 分页查询

1. 使用`limit`限制返回的行数，第一个参数为起始行，从 0 开始；第二个参数为返回的**总行数**；
2. 如果不写第一个参数，则默认为0；
3. 开始的索引 = （当前的页码 - 1） * 每页显示的条数

```sql
-- 返回前5行
select * from 表名 limit 0, 5;
select * from 表名 limit 5;

-- 返回3~5行
select * from 表名 limit 2, 3;
```

### 8. 聚合函数

将一列数据作为一个整体，进行纵向的计算。

| 函 数   | 说 明            |
| ------- | ---------------- |
| AVG()   | 返回某列的平均值 |
| COUNT() | 返回某列的行数   |
| MAX()   | 返回某列的最大值 |
| MIN()   | 返回某列的最小值 |
| SUM()   | 返回某列值之和   |

```sql
select max(age) from table;
select count(*) as 男性人数 from table where gender=1;
```

### 9. 分组查询

## 四、DCL(Data Control Language)数据控制语言(了解)

用来定义数据库的访问权限和安全级别，及创建用户。关键字：GRANT， REVOKE 等



