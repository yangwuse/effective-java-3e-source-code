package my.chapter2.item06;

import java.util.regex.Pattern;

/**
 * 重用正则表达式 Pattern 对象
 * @author yangWu
 * @date 2021/7/18 2:20 下午
 * @version 1.0
 */
public class ReusePattern {
    // 每次调用 match() 都创建一个新的 Pattern 对象
    static boolean slow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    // 重用 Pattern 对象
    private static final Pattern P = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})"
        + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean fast(String s) {
       return P.matcher(s).matches();
    }

    public static void main(String[] args) {
        // 测试性能
        int cycTimes = 5,
            repTimes = 10;
        boolean b = false;
        for (int i = 0; i < cycTimes; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < repTimes; j++)
                b = slow("MCMLXXVI");
//                b = fast("MCMLXXVI");
            long end = System.nanoTime();
            System.out.println(((end - start) / (1_000. * repTimes)) + "us.");
        }
    }
}
