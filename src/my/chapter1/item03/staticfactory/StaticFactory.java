package my.chapter1.item03.staticfactory;

/**
 * 构造单例类方法一: 静态工厂方法
 * @author yangWu
 * @date 2021/7/8 6:36 下午
 * @version 1.0
 */
public class StaticFactory {
    // 私有 static final 实例域 只能通过静态方法访问 且仅仅实例化一次
    private static final StaticFactory INSTANCE = new StaticFactory();
    // 私有构造器 只能内部访问
    private StaticFactory() {}
    // 外部唯一访问点
    public static StaticFactory getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        StaticFactory s1 = StaticFactory.getInstance();
        StaticFactory s2 = StaticFactory.getInstance();
        // true
        System.out.println(s1 == s2);
    }
}
