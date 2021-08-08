package my.chapter9.item59;

import java.util.Random;

public class RandomBug {
    public static void main(String[] args) {
        int n = Integer.MAX_VALUE / 2;
        Random rand = new Random(n);
        int low = 0;
        for (int i = 0; i < 1000_0000; i++) {
            if (rand.nextInt() < n / 2)
                low++;
        }
        System.out.println(low);
    }
}
