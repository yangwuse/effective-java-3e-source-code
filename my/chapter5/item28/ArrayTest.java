package my.chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.DelayQueue;

// 数组是协变的 Child[] 是 Parent[] 的子类型
public class ArrayTest {
    public static void main(String[] args) {
        Child[] c = new Child[1];
        // true Child[] 是 Parent[] 子类
        boolean f = c instanceof Parent[];

        List<String>[] ls = new ArrayList[1];
        // true  List<String> 运行时类型是 List 是 Object 子类
        // 所以 List<String>[] 是 Object[] 子类
        boolean f2 = ls instanceof Object[];

        // true 同理
        List<String>[] l1 = new ArrayList[1];
        boolean f3 = l1 instanceof Collection[];


        // 无法编译 父类无法转换为子类
        // Integer[] i = (Integer[]) new Object[1];
        // 可以编译 子类可以转换为父类
        Object[] o = (Object[]) new Integer[1];

        // 子类向上转 ok
        Object o2 = (Object) "12";

        // 父类向下转 error
        // String s = (String) new Object();

        // 编译合法 直到运行才报错 ArrayStoreException
        // Object[] a = new Long[1];
        // a[0] = "hello";

        // 无法创建泛型数组
        // List<E>[] a1 = new ArrayList<>();
        // E[] a3 = new E[1];  
        
        // 可以编译
        List<String>[] a2 = new List[2];
        a2[0] = new ArrayList<>();
        a2[0].add("1");
    }

    private static class Parent {}
    private static class Child extends Parent{}
    
    private static class Test<E> {
        private E[] e;
        @SuppressWarnings("unchecked")
        public Test() {
            // e 运行时泛型被删除 实际类型是 Object[]
            e = (E[])new Object[1];
        }
        public static void main(String[] args) {
            // 可以编译
            Test<Integer> t = new Test<>();
        }
    }
}
