package my.chapter5.item30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

// 递归参数类型  <E extends Comparable<E>> 表示与自身可以相互比较的元素类型 E
// 求 List<String> 中最大值
public class RecursiveTypeBound {
    public static <E extends Comparable<E>> E max(List<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Empty Collection");
        
        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = List.of("123", "234", "345");
        // "345"
        System.out.println(max(ls));
    }
}
