package my.chapter5.item26;

import java.util.ArrayList;
import java.util.List;

// 运行时报错 
public class Raw {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        unsafeAdd(list, Integer.valueOf(15));
        // 类型装换错误 Integer -> String
        String s = list.get(0);
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
