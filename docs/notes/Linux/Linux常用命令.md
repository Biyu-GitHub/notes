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