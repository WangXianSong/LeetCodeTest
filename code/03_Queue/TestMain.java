package QueueTest;

import java.util.Random;

public class TestMain {
    public static void main(String[] args) {

        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double t = testQueue(arrayQueue, opCount);
        System.out.println("arrayQueue time:" + t + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double t1 = testQueue(loopQueue, opCount);
        System.out.println("loopQueue time:" + t1 + "s");
    }

    // 测试使用两种queue的实现方式所执行任务所需要的时间
    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
