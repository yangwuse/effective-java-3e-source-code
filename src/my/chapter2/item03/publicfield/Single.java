package my.chapter2.item03.publicfield;

/**
 * 构造单例类方法一: 公有静态域（最简单）
 * @author yangWu
 * @date 2021/7/8 6:54 下午
 * @version 1.0
 */
public class Single {
    // static 保证了唯一性
    public static final Single INSTANCE = new Single();
    // private 保证外部无法访问
    private Single() {}

    public static void main(String[] args) {
        Single s1 = Single.INSTANCE;
        Single s2 = Single.INSTANCE;
        System.out.println(s1 == s2);
    }
}
