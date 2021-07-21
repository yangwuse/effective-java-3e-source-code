package my.chapter2.item07;

import effectivejava.chapter2.item7.EmptyStackException;

import java.util.Arrays;

/**
 * 栈未消除过期引用 导致内存泄漏
 * @author yangWu
 * @date 2021/7/18 3:12 下午
 * @version 1.0
 */
public class Stack {
    private Object[] elements;
    private int size;
    private final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() { elements = new Object[DEFAULT_INITIAL_CAPACITY]; }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 注意内存泄漏风险
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object e = elements[--size];
        // 消除过期引用
        elements[size] = null;
        return e;
    }

    public void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, size << 1 + 1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 6; i++)
            stack.push(i);

        while (true)
            System.err.println(stack.pop());

    }

}
