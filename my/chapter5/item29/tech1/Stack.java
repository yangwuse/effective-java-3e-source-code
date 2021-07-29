package my.chapter5.item29.tech1;

import java.util.Arrays;

import effectivejava.chapter5.item31.EmptyStackException;

// 使用 E[] 实现泛型栈
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 经证明未检测警告是安全的: 消除警告
    // 1. elements 是 private 的 不会暴露给客户端
    // 2. push 方法参数类型是 E 
    // 3. 运行时泛型删除类型参数 故 elements 在运行时类型是 Object[]
    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // 消除过期引用
        return result;
    }

    public boolean isEmpty() { return size == 0; }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}

