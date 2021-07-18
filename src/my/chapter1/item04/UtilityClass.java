package my.chapter1.item04;

/**
 * 工具类不应该实例化
 * @author yangWu
 * @date 2021/7/8 7:25 下午
 * @version 1.0
 */
public class UtilityClass {
    // private 构造器防止在不提供构造器时 编译器自动加入的 public 默认构造器
    // 同时表明该类无法被外部实例化
    private UtilityClass() {
        // 使类永远无法被实例化 即使是类内部 阻止反射攻击和失误
        throw new AssertionError();
    }

    public static void main(String[] args) {
        // 报错
        UtilityClass utility = new UtilityClass();
    }
}
