# 基础指令

```bash
less
more

echo $SHELL
cat/etc/shells
```

# 查找特定的文件

* find

```bash
find [path] -name "name"
-iname：忽略大小写
[path]：默认为当前路径
"name"：支持模糊查找
```

```bash
➜  ssd_keras git:(master) find -name "ssd300_training.ipynb"
./ssd300_training.ipynb

➜  ssd_keras git:(master) find ~/projects/SSD -name "ssd300_training.ipynb"
/home/biyu/projects/SSD/ssd_keras/ssd300_training.ipynb

➜  ssd_keras git:(master) find -name "ssd*"                                
./ssd512_inference.ipynb
./ssd_encoder_decoder
./ssd_encoder_decoder/ssd_input_encoder.py
./ssd_encoder_decoder/ssd_output_decoder.py
```

# 检索文件内容

* grep（Global Regular Expression Print）

```tex
File: target1.txt
I love you
File: target2.txt
you you I love you asdfadyouasdfasdf
```

* 从指定文件查找包含特定字符串的行

```bash
➜  Desktop grep "you" target*
target1.txt:I love you
target2.txt:you you I love you asdfadyouasdfasdf
```

* 如果不指定目标文件，则会从键盘获取输入

# 管道操作符

* |：可以将指令连接起来，前一个指令的输出作为后一个指令的输入

```bash
find ~ | grep "you"
find ~：列出当前路径下的所有路径，传递给grep，这样grep就不用从键盘获取输入了
```

* 前面的指令如果错误，则无法传递给下一个指令
* 右边的命令必须能够接收标准输入流，否则在传递过程中数据会被抛弃，常用的指令有：

```bash
sed, awk, grep, cut, head, top, less, more, wc, join, sort, split
```

* 总结

```bash
grep 'pattern' target.txt	查询指定文件中包含字段的行
grep -o '正则表达式'
grep -v '想要过滤掉的内容'
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



