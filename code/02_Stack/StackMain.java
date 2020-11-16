package StackTest;

/**
 * 栈Stack
 * 栈也是一种线性结构，相比数组，栈对应的操作是数组的子集；
 * 特性：只能从一端添加元素，也只能从同一端取出元素，这一端叫端顶；
 * 后进先出（LIFO）
 * 应用：Undo撤销操作、页面跳转栈、方法调用系统栈；
 */
public class StackMain {

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
