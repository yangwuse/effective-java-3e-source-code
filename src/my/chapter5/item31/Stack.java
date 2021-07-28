package my.chapter5.item31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import effectivejava.chapter2.item7.EmptyStackException;

// 有限通配符类型 提升 API 灵活性 PECS
// <? extends E> 表示 E 的某个子类型 用于生产者
// <? super E> 表示 E 的某个父类型 用于消费者
public class Stack<E> {
    // 使用泛型数组支持泛型栈
    private E[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 运行时泛型类型擦除后 elements 类型实际上是 Object[]
    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size==0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++)
            sb.append(elements[i]).append(", ");
        sb.append(elements[size - 1]).append("]");
        return sb.toString();
    }

    // 有限通配符类型 <? extends E> 作为 E 的子类(生产者) PE
    public void pushAll(Collection<? extends E> c) {
        for (E e : c)
            push(e);
    }

    // 有限通配符类型 <? extends E> 作为 E 的父类(消费者) CS
    public void popAll(Collection<? super E> c) {
        while (!isEmpty())
            c.add(pop());
    }

    public static void main(String[] args) {
        Stack<Number> s1 = new Stack<>();
        List<Integer> ls = List.of(1, 2, 3);
        s1.pushAll(ls);
        System.out.println(s1);

        List<Object> res = new ArrayList<>();
        s1.popAll(res);
        System.out.println(res);
    }
}
