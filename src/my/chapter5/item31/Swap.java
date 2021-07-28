package my.chapter5.item31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Swap {
    static void swap(List<?> l, int i, int j) {
        helper(l, i, j);
    }
    
    // 泛型方法用于捕获运行时的通配符类型
    private static <E> void helper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>(Arrays.asList(1, 3, 4));
        swap(ls, 0, 1);
        System.out.println(ls);
    }

}
