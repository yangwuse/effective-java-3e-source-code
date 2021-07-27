package my.chapter5.item28;

import java.util.ArrayList;
import java.util.List;

// 泛型是可变的 List<A> 和 List<B> 无父子关系
public class ListTest {
    public static void main(String[] args) {
        List<A> la = new ArrayList<>();
        List<B> lb = new ArrayList<>();
        // 不能通过编译
        // System.out.println(la instanceof List<B>);
        // System.out.println(lb instanceof List<A>);

        // 不能通过编译 类型不兼容 提前报错
        // List<Object> a = new ArrayList<Long>();
        // a.add("hello");
    }

    private static class A {}
    private static class B {}
}
