package my.chapter5.item29.tech2;

import java.util.Arrays;

import effectivejava.chapter5.item31.EmptyStackException;

// Object[] 支持的泛型
public class Stack<E> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();

        // 消除未检测警告: push 的元素始终是 E 类型 故可以安全消除警告
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];

        // 消除过期引用
        elements[size] = null;
        return result;
    }
    
    public void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, size * 2 + 1);
    }

}
