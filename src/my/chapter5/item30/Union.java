package my.chapter5.item30;

import java.util.HashSet;
import java.util.Set;

// 泛型方法示例  泛型化静态方法
public class Union {
    // 泛型方法 泛型列表 <E>
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> res = new HashSet<>(s1);
        res.addAll(s2);
        return res;
    }

    public static void main(String[] args) {
        Set<String> s1 = Set.of("abc", "def", "ghi");
        Set<String> s2 = Set.of("123", "456", "789");
        System.out.println(union(s1, s2));
    }
}
