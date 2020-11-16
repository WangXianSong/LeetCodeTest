package StackTest;

import ArrayTest.Array;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    // 已知数量个数的构造函数
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    // 默认情况数量为10
    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        if (array.getSize() == 0) {
            return array.get(0);
        } else {
            return array.get(array.getSize() - 1);
        }
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Stack size : %d, capacity : %d",
                array.getSize(), array.getCapacity()));
        sb.append('\n');
        sb.append('[');
        for (int i = 0; ; i++) {
            sb.append(array.get(i));
            if (i == array.getSize() - 1) {
                sb.append("],Top");
                return sb.toString();
            }
            sb.append(',');
        }
    }
}
