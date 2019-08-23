import java.util.HashMap;

public class LRUCache {

    /**
     * 封装一个节点类
     */
    private class Node {
        private Integer key, val;
        private Node next, prev;

        public Node() {
            this(null, null);
        }

        public Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }

    /**
     * 实现双向链表
     */
    private class DoubleLinkedList {
        private int size;
        private Node head, tail;

        public DoubleLinkedList() {
            head = new Node();
            tail = new Node();

            head.next = tail;
            tail.prev = head;
        }

        public int size() {
            return size;
        }

        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            x.next.prev = x;
            head.next = x;
            size++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            x.next = null;
            x.prev = null;
            size--;
        }

        public Node removeLast() {
            if (tail.prev == head)
                return null;

            Node delNode = tail.prev;
            remove(delNode);
            return delNode;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private DoubleLinkedList list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new DoubleLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        int val = map.get(key).val;
        put(key, val);

        return val;
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);

        if (map.containsKey(key)) {
            list.remove(map.get(key));
            list.addFirst(x);
            map.put(key, x);
        } else {
            if (capacity == list.size()) {
                Node last = list.removeLast();
                map.remove(last.key);
            }

            list.addFirst(x);
            map.put(key, x);
        }
    }
}

