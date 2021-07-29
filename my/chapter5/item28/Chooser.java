package my.chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// 使用列表代替数组
public class Chooser<T> {
    private final List<T> choiceList;

    public Chooser(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    } 

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> ls = List.of(1, 2, 3, 4, 5, 6, 7);
        Chooser<Integer> chooser = new Chooser<>(ls);
        for (int i = 0; i < 5; i++)
            System.out.println(chooser.choose());
    }
}
