# 1. File类

`java.io.File` 类是文件和目录路径名的**抽象表示**，主要用于文件和目录的创建、查找和删除等操作。

## 1.1 静态成员变量

* `File.separator`：获取文件分隔符，Windows为`\`，Linux为`/`
* `pathSeparator`：获取路径分隔符，Windows为`;`，Linux为`:`

```java
System.out.println(File.separator); // print \
System.out.println(File.pathSeparator); // print ;
```

## 1.2 构造方法

- `public File(String pathname) ` ：通过将给定的**路径名字符串**转换为抽象路径名来创建新的 File实例。  
- `public File(String parent, String child) ` ：从**父路径名字符串和子路径名字符串**创建新的 File实例。
- `public File(File parent, String child)` ：从**父抽象路径名和子路径名字符串**创建新的 File实例。  
  * 父路径是File类型，可以使用File的属性和方法。

- 构造举例：

```java
File f1 = new File("D:\\JavaEE\\IO\\FileDemo1.java");

File f2 = new File("D:\\JavaEE\\IO", "FileDemo1.java");

File f3 = new File("D:\\JavaEE\\IO");
File f4 = new File(f3, "FileDemo1.java");
```

> 1. 一个File对象代表硬盘中实际存在的一个文件或者目录。
> 2. 无论该路径下是否存在文件或者目录，都不影响File对象的创建。

## 1.3  常用方法

### 1.3.1 获取功能的方法

- `public String getAbsolutePath() ` ：返回此File的绝对路径名字符串。
- ` public String getPath() ` ：将此File转换为路径名字符串。 
- `public String getName()`  ：返回由此File表示的文件或目录的名称。  
- `public long length()`  ：返回由此File表示的文件的长度

* 常用方法举例：

```java
File f1 = new File("01-File\\src\\FileDemo1.java");
System.out.println("文件绝对路径:" + f1.getAbsolutePath());
System.out.println("文件构造路径:" + f1.getPath());
System.out.println("文件名称:" + f1.getName());
System.out.println("文件长度:" + f1.length() + "字节");

File f2 = new File("01-File\\src\\");
System.out.println("文件绝对路径:" + f2.getAbsolutePath());
System.out.println("文件构造路径:" + f2.getPath());
System.out.println("文件名称:" + f2.getName());
System.out.println("文件长度:" + f2.length() + "字节");
```

* 输出结果

```bash
文件绝对路径:D:\Projects\JavaEE\IO\01-File\src\FileDemo1.java
文件构造路径:01-File\src\FileDemo1.java
文件名称:FileDemo1.java
文件长度:200字节

文件绝对路径:D:\Projects\JavaEE\IO\01-File\src
文件构造路径:.\01-File\src
文件名称:src
文件长度:0字节
```

### 1.3.2 判断功能的方法

- `public boolean exists()` ：此File表示的文件或目录是否实际存在。
- `public boolean isDirectory()` ：此File表示的是否为目录。
- `public boolean isFile()` ：此File表示的是否为文件

### 1.3.3 创建删除功能的方法

- `public boolean createNewFile()` ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。 
- `public boolean delete()` ：删除由此File表示的文件或目录。  
- `public boolean mkdir()` ：创建由此File表示的目录。
- `public boolean mkdirs()` ：创建由此File表示的目录，包括任何必需但不存在的父目录。

### 1.3.4 遍历目录的方法

- `public String[] list()` ：返回一个String数组，表示该File目录中的所有子文件或目录。

- `public File[] listFiles()` ：返回一个File数组，表示该File目录中的所有的子文件或目录。  

