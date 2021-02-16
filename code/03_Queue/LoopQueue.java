package QueueTest;

import java.util.Arrays;

/**
 * 进阶：循环队列降低出队的时间复杂度，出队不用移动全部元素
 * front == tail表示队列为空；
 * （tail+1)%capacity==front 表示队列已满，因此会浪费1个位置
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = tail = size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        // 如果队列已满需要进行扩容
        if ((tail + 1) % data.length == front) {
            resize(getCapaticy() * 2);
        }
        data[tail] = e;//存入
        tail = (tail + 1) % data.length;//队尾往后1位
        size++;
    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from empty queue.");
        }
        E e = data[front];
        front = (front + 1) % data.length;//队头往后1位
        size--;
        // 当出队到一定的数量时要进行缩容，并且缩容后不等于0
        if (size == getCapaticy() / 4 && getCapaticy() / 2 != 0) {
            resize(getCapaticy() / 2);
        }
        return e;
    }

    /**
     * 扩容方法
     *
     * @param newCapaticy 扩容后的容量
     */
    private void resize(int newCapaticy) {
        E[] newData = (E[]) new Object[newCapaticy + 1];
        // 将原来数组的元素从0开始重新放入数组
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public int getCapaticy() {
        return data.length - 1;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue size : %d, capacity : %d", size, getCapaticy()));
        sb.append('\n');
        sb.append("front[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]tail");
        return sb.toString();
    }
}
