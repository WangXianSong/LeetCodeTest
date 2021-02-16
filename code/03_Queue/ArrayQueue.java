package QueueTest;

import ArrayTest.Array;

public class ArrayQueue<E> implements Queue {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public void enqueue(Object o) {
        array.addLast((E) o);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue size : %d, capacity : %d",
                array.getSize(), array.getCapacity()));
        sb.append('\n');
        sb.append("front[");
        for (int i = 0; ; i++) {
            sb.append(array.get(i));
            if (i == array.getSize() - 1) {
                sb.append("]tail");
                return sb.toString();
            }
            sb.append(',');
        }
    }
}
