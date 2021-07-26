package my.chapter4.item20;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// 基于接口骨架类二次开发的具体实现类
public class StringArrays {
    // 静态工厂方法 + 匿名内部类
    static List<String> stringArrayAsList(String[] a) {
        Objects.requireNonNull(a);
        return new AbstractList<>() {
            @Override public String get(int index) {
                return a[index];
            }

            @Override public String set(int i, String val) {
                String oldVal = a[i];
                a[i] = val;
                return oldVal;
            }

            @Override public int size() {
                return a.length;
            }
            
        };
    }

    public static void main(String[] args) {
        String[] a = {"1", "2", "3", "4", "5", "6"};
        List<String> list = stringArrayAsList(a);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
