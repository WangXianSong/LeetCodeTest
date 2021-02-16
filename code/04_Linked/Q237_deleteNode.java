package LinkedTest;

/**
 * 237.删除链表中的节点
 * <p>
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 提示：
 * - 链表至少包含两个节点。
 * - 链表中所有节点的值都是唯一的。
 * - 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * - 不要从你的函数中返回任何结果。
 */
public class Q237_deleteNode {



    public static void deleteNode( ListNode node) {

//        // 创建一个虚拟头节点
//        ListNode dummyHead = new ListNode(-999);
//        dummyHead.next = head;

//        ListNode prev = dummyHead;
//        while (prev.next != null) {
//            if (prev.next.val == node.val){
//                prev.next = prev.next.next;
//            }else {
//                prev = prev.next;
//            }
//        }

        // 哇，我看了leetcode上门的评论，正精彩：
        // 「是谁杀了我？而我又杀了谁？ 是我，杀了我！！！」
        // 好吧，这题就是这么简单：只给定被删除节点的情况下，删除该节点。
        // 看来中文翻译过来的题目真的垃圾
        node.val=node.next.val;
        node.next=node.next.next;
    }
    public static void main(String[] args) {
        deleteNode( new ListNode(5));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
