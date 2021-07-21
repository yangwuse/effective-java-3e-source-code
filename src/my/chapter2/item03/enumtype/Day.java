package my.chapter2.item03.enumtype;

/**
 * 枚举练习
 * @author yangWu
 * @date 2021/7/8 7:04 下午
 * @version 1.0
 */
public enum Day {
    // 字段大写 且取值范围有限
    MONDAY, TUESDAY, THURSDAY, WEDNESDAY,
    FRIDAY, SATURDAY, SUNDAY
}

class Test {
    // 枚举的好处: 使用方便且安全 常用于定义常量 替代 static final 定义常量
    public static void main(String[] args) {
        Day monday = Day.MONDAY;
        System.out.println(monday);
    }

}
