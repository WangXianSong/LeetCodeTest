package LinkedTest;


/*
 * 1、为什么链表很重要？
 * - 链表是真正的动态数据结构
 * - 最简单的动态数据结构
 * - 更深入的理解引用或者指针
 * - 辅助组成其他数据结构
 *
 * 数据存储在"节点Node"中
 * Node包含数据E和nextNode指向下一个
 * 最后的节点指向null，
 *
 * class Node {
 *      E e;
 *      Node next;
 * }
 *
 * 优点：真正的动态，不需要处理固定容量的问题
 * 缺点：丧失随机访问的能力
 *
 * 2、数组和链表的对比
 * - 数组最好用于索引有寓意的情况，scores[2]
 *   最大的优点：支持快速查找
 *
 * - 链表不适合索引有语义的情况
 *   最大的优点：动态
 *
 * 时间复杂度：
 *  addLast O(n)
 *  addFirst:O(1)
 *  add(e,index):O(n)
 *
 * 链表时间复杂度分析：
 * 增:O(n),如果只对链表头进行操作O(1)
 * 删:O(n),如果只对链表头进行操作O(1)
 * 查:O(n)
 * 改:O(n),只查链表头元素O(1)
 * */
public class LinkedListMain {

    public static void main(String[] args) {

        LinkedList<Integer> testList = new LinkedList<>();
        // 添加元素
        for (int i = 0; i < 5; i++) {
            testList.addFirst(i);
            System.out.println(testList);
        }

        testList.addLast(666);
        System.out.println(testList);

        testList.add(666, 2);
        System.out.println(testList);

        testList.removeFitst();
        System.out.println(testList);
    }
}
