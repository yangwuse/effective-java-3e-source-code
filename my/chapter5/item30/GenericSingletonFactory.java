package my.chapter5.item30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.UnaryOperator;


// 泛型 单例工厂模式 运行类型擦除
public class GenericSingletonFactory {
    private static UnaryOperator<Object> IDENTITY_FN = (t)->t;

    public static <E> UnaryOperator<E> identityFunction() {
        return (UnaryOperator<E>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        String[] s = {"123", "456"};
        UnaryOperator<String>  sameString = identityFunction();
        for (String str : s)
            System.out.println(sameString.apply(str));
        Integer[] i = {1, 2, 3};
        UnaryOperator<Integer> sameInteger = identityFunction();
        for (Integer it : i)
            System.out.println(sameInteger.apply(it));

        Set<String> s1 = Collections.emptySet();
        Set<String> s2 = Collections.emptySet();
        // true  emptySet() 返回一个单例
        System.out.println(s1 == s2);

        // 泛型擦除转换  
        // List<Object> 转 List<String> 
        List<Object> l1 = new ArrayList<>(Arrays.asList(1, 2, 3, "a", "b", "c"));
        List<String> l2 = null;
        // 编译时不能转 因为泛型在编译时类型检查发现类型不匹配
        // l2 = (List<String>) l1;

        // 运行时可以转 因为元素类型在运行时被删除 
        // 实际上是 ArrayList 转 ArrayList
        l2 = caseTo(l1);
        System.out.println(l2);
    }

    @SuppressWarnings("unchecked")
    public static <E> List<E> caseTo(List<Object> l1) {
        return (List<E>) l1;
    }
}
