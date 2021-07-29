package my.chapter2.item03.enumtype;

/**
 * 单例最佳实现方式: 枚举
 * @author yangWu
 * @date 2021/7/8 7:18 下午
 * @version 1.0
 */
public enum Lover {
    LOVER;

    public static void main(String[] args) {
        Lover myLover = Lover.LOVER;
        System.out.println(myLover);
    }
}
