package my.chapter5.item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


// 有限通配符类型 <? extends T> 作为 T 的生产者类型
// 传入 T 的子类: 父类引用指向子类对象
public class Chooser<T> {
    private final List<T> list;
    private final Random rnd = new Random();

    public Chooser(Collection<? extends T> c) {
        list = new ArrayList<>(c);
    }

    public T choice() {
        return list.get(rnd.nextInt(list.size()));
    }
    
    public static void main(String[] args) {
        // Chooser 可以接受 T 的子类型
        List<Integer> list = List.of(1, 3, 5, 7, 9);
        Chooser<Number> chooser = new Chooser<>(list);
        for (int i = 0; i < 5; i++) {
            Number n = chooser.choice();
            System.out.println(n);
        }
    }
}
