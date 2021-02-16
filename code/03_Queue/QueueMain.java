package QueueTest;

/**
 * 队列Queue也是一种线性结构
 * 特性：只能从队尾添加，只能从队头取出元素（FIFO）；
 * 进阶：循环队列降低出队的时间复杂度，出队不用移动全部元素
 * front == tail表示队列为空；
 * （tail+1)%capacity==front 表示队列已满;
 * 会浪费1个位置
 */
public class QueueMain {
    public static void main(String[] args) {

//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i + 100);
            System.out.println(queue);
        }
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.getFront());
    }
}
