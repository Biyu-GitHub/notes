public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }


    // 在链表的index(0-based)位置添加新的元素e
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");


        Node prev = dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;

    }

    // 头插法
    public void addFirst(E e) {
        add(0, e);
    }

    // 尾插法
    public void addLast(E e) {
        add(size, e);
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Node prev = dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node rmNode = prev.next;
        prev.next = rmNode.next;
        rmNode.next = null;
        size--;

        return rmNode.e;
    }

    // 从链表中删除元素e
    public void removeElement(E e){
        Node prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if (prev.next != null) {
            Node rmNode = prev.next;
            prev.next = rmNode.next;
            rmNode.next = null;
            size--;
        }
    }
}
