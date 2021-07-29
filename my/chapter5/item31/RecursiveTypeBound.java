package my.chapter5.item31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class RecursiveTypeBound {
    // Comparable 作为消费者 <? super E> 表示 E 的某个超类型 
    // list 作为生产者 <? extends E> 表示 E 的某个子类型 

    // 任何类型自能和自身类型相互比较 父子类型不行
    public static <E extends Comparable<? super E>> E max(List<? extends E> l) {
        if (l.isEmpty())
            throw new IllegalArgumentException("Empty Collection");
        
        E result = null;
        for (E e : l)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        
        return result;
    }

    public static void main(String[] args) {
        // 编译错误: 只能同种类型元素相互比较 
        // List<Number> l = List.of(1, 3, 4);
        // System.out.println(max(l));

        List<Integer> l = List.of(1, 3, 4);
        System.out.println(max(l));
    }
}
