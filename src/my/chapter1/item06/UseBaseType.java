package my.chapter1.item06;

/**
 * 使用基本数据类型 避免包装类型
 * @author yangWu
 * @date 2021/7/18 2:33 下午
 * @version 1.0
 */
public class UseBaseType {
    static long sum() {
        // 改为 long 性能提高 7 倍
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            long start = System.nanoTime();
            sum();
            long end = System.nanoTime();
            System.out.println(((end - start) / 1000_000) + "us");
        }
    }
}
