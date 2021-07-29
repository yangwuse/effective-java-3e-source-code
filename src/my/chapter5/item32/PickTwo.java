package my.chapter5.item32;

// 带泛型可变参数的方法是不安全的
public class PickTwo {
    // 不安全 数组引用逃逸
    static <T> T[] toArray(T... args) {
        return args;
    }

    // 在方法中调用带泛型可变参数的方法是不安全
    static <T> T[] getTwo(T a, T b, T c) {
        T[] t =  toArray(a, b);
        return t;
    }

    public static void main(String[] args) {
        // Object[] 转 String[] ClassCastException
        // String[] s = getTwo("abc", "def", "ghi");
        // ok
        Object[] o = getTwo(1, 2, 3);
        Integer[] i = toArray(1, 2, 3);
    }  
}
