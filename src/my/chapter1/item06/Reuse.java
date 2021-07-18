package my.chapter1.item06;

/**
 * 避免重复创建对象
 * @author yangWu
 * @date 2021/7/18 11:38 上午
 * @version 1.0
 */
// 使用静态工厂方法重用对象
public class Reuse {
    public static void main(String[] args) {
        // 重用 String 常量
        String s = "hello";
        // 避免
        String s2 = new String("hello");

        // 静态工厂重用对象
        Boolean b = Boolean.valueOf("true");
        // 避免
        Boolean b2 = new Boolean("true");
    }
}
