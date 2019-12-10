## 查找特定文件

使用`find`命令

```bash
# 在当前路径下查找a.java文件
find -name "a.java"

# 在指定路径查找，从根目录查找
find / -name "a.java"

# 查找的时候使用iname来忽略大小写
find / -iname "a.java"

# 模糊查询
find / -iname "a*"
```

## 检索文件内容

使用`grep`命令

```bash
# 从a.java种查找指定内容，返回包含该内容的行
grep "查找内容" a.java

# 不加文件名就会变成交互式，从用户的输入查找是否包含指定内容
grep "查找内容"
```

## 管道操作符

* 使用`|`可以将指令连接起来，前一个指令的输出作为后一个指令的输入

```bash
# 例如，以下两条命令的结果是相同的
find ~ -name "target*"
find ~ | grep "target"
```

* 使用管道需要注意的地方：
  1. 只处理前一个命令的正确输出，不处理错误输出；
  2. 右边的命令必须能够接收标准输入流，否则传递过程中，数据会被抛弃；
  3. 常用的搭配有`sed, awk, grep, cut, head, top, less, more, wc, join, sort, split`等。
* 使用特殊符号时需要加`\`转义

```bash
# 查找包含"partial[true]"的数据行
grep "partial\[true\]" a.java

# 对查找结果做进一步筛选，可用 | grep -o 正则表达式
grep "partial\[true\]" a.java | grep -o "engin\[[0-9A-Z]\]"

# 使用-v选项来过滤掉包含某些信息的内容
# 在查找结果中，过滤掉(不显示)包含"xxx"的数据
grep "partial\[true\]" a.java | grep -v "xxx"
```

# 统计文件内容

* awk
  * 一次读取一行文本，按照输入的分隔符进行切片，切成多个组成部分
  * 将切片直接保存在内建的变量中，$1，$2...（$0表示行的全部）
  * 支持对单个切片的判断，支持循环判断，默认分隔符为空格

```bash
# 按照空格分隔，并打印2，3，4列
➜  Desktop awk '{print $2, $3, $4}' target2.txt
you I love

# 打印第二列为you的行的第2，3，4列
➜  Desktop awk '$2=="you"{print $2, $3, $4}' target2.txt
you I love

# 打印第二列为I或者打印第一行，NR代表第几行
➜  Desktop awk '$2=="I" || NR==1 {print $2, $3, $4}' target2.txt
you I love

# 使用-F指定分隔符
➜  Desktop awk -F "," '{print $1}' target2.txt                  
you you I love you asdfadyouasdfasdf
```

# 批量替换文本内容

* sed：流编辑器（Stream Editor）

```bash
# 将每行开头的Str替换成String
# -i：将修改保存到原文件，否则只打印到终端显示而不修改文件
# 's///g'：s代表操作字符串，g代表进行全文替换，如果不加g，则只替换每行中的第一个
sed -i 's/^Str/String/g' target.txt
```

```bash
# 删除符合条件的行
sed -i '/String/d' target.txt
# 删除空行
sed -i '/^ *$/d' target.txt
```