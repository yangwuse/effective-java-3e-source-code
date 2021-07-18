package my.chapter1.item01;

/**
 * advantage 1: has name
 * @author yangWu
 * @date 2021/6/28 9:30 上午
 * @version 1.0
 */
public class HasName {
    // 有名字更加清晰简单
    public static String getFirstName() { return "Yang"; }
    public static String getLastName() { return "Wu"; }

    // 昵称和正式称呼
    public static String getNikeName() { return "wu"; }
    public static String getFormalName() { return "yang sir"; }

    // test
    public static void main(String[] args) {
        String firstName = HasName.getFirstName();
        String lastName = HasName.getLastName();
        String nikeName = HasName.getNikeName();
        String formalName = HasName.getFormalName();
        System.out.println();
    }
}
