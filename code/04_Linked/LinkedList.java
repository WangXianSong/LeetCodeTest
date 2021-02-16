package LinkedTest;

public class LinkedList<E> {

    private Node dummyHead;// 头节点
    private int size; // 个数

    // 空参数构造函数，只创建空壳
    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表中的个数
    public int getSize() {
        return size;
    }

    // 判断当前链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // --------------- 添加操作 ---------------

    // 在链表中间添加元素
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, ILLegal index");
        }
        // 找到待插入前的那个节点
        Node prev = dummyHead;// 虚拟头节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        // 简化上面的代码
        // prev.next = new Node(e,prev.next);
        size++;
    }

    // 在链表末尾添加新的元素
    public void addLast(E e) {
        add(e, size);
    }

    // 在链表头添加新的元素
    public void addFirst(E e) {
        add(e, 0);
    }
    // --------------- 获取操作 ---------------

    // 获取索引index位置的值
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, ILLegal index");
        }

        Node cur = dummyHead.next;// 虚拟头节点的下一个才是开始
        // 只遍历index次，就能找到index对应的节点
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    // --------------- 修改操作 ---------------
    // 修改当前元素的值
    public void set(E e, int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed, ILLegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找链表中是否包含当前元素
    public int contains(E e) {
        Node cur = dummyHead.next;
        int i = 0;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return i;
            }
            cur = cur.next;
            i++;
        }
        return -1;
    }

    // --------------- 删除操作 ---------------
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed, ILLegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node ret = prev.next;
        prev.next = ret.next;
        ret.next = null;
        size--;
        return ret.e;
    }

    public E removeFitst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    /**
     * 私有内部类，外部不需要知道
     */
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
}
