package my.chapter5.item31;

import java.util.HashSet;
import java.util.Set;

// 有限通配符类型 提升类型灵活性 可以接受子类型
// 合并 Set<Integer> 和 Set<Double> 集合
public class Union {
    // 不返回通配符类型
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> res = new HashSet<>(s1);
        res.addAll(s2);
        return res;
    }

    public static void main(String[] args) {
        // 逻辑是 Integer 和 Double 是 Number 的子类型
        Set<Integer> integers = Set.of(1, 2, 3);
        Set<Double> doubles   = Set.of(1.0, 2.0, 3.0);
        Set<Number> numbers   = union(integers, doubles);
        System.out.println(numbers);
    }
}
