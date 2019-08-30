# 玩转数据结构之循环队列

![LoopQueue](..\images\玩转数据结构\MyDraw-LoopQueue.jpg)

# 1 基本原理

* 基于动态数组实现，包含头指针front，尾指针tail；
* 当 front == tail 代表队列为空
* 当 (tail + 1) % data.length == front 代表队列为满

# 2 构造方法

```java
public class LoopQueue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1]; // 因为需要浪费一个空间
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }
}
```

# 3 基本方法

```java
    /**
     * 获取队列的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 获取队列中元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }
```

# 4 扩容方法

* 新建数组，容量为原来的2倍；
* 将数据依次复制到新数组，并将原数组的引用指向新的数组
* 初始化front与tail指针

```java
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
```

# 5 入队方法

* 先判断是否需要扩容，如果需要，则扩容为原来的2倍
* 添加元素，移动尾指针
* size++

```java
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }
```

# 6 出队方法

* 记录出队元素并返回
* 移动头指针
* 维护size
* 判断是否需要缩容，当size变为容量的1/4时，缩容为原来的1/2，是为了防止抖动

```java
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

        return ret;
    }
```

# 7 完整代码

```java
public class LoopQueue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 获取队列的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 获取队列中元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

        return ret;
    }

    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
}

```

# 8 特点分析

* 普通队列：如果不移动元素，则会出现假队列满的情况；如果移动元素，则需要消耗大量时间；
* 循环队列：不用移动元素，而是移动头尾指针，高效并且不会出现假队列满的情况；但是需要浪费一个额外的空间。