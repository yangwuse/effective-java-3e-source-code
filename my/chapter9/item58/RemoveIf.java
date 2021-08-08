package my.chapter9.item58;

import java.util.ArrayList;
import java.util.List;

// removeIf 替代显示的迭代

public class RemoveIf {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        ls.removeIf(e -> e % 2 == 0);
        System.out.println(ls.toString());
    }
}
