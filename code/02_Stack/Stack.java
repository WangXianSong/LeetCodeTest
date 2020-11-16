package StackTest;

public interface Stack<E> {
    int getSize();// 获取大小
    boolean isEmpty(); // 是否为空
    void push(E e); // 进栈
    E pop(); // 出栈
    E peek();// 查看元素
}
