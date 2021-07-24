import java.util.Objects;

// 比较可能为 null 的引用时 使用 Objects.equals()
public class NullTest {
    public static void main(String[] args) {
        // false;
        System.out.println(Objects.equals(1, null));
        // false;
        System.out.println(Objects.equals(null, 1));
        // true
        System.out.println(Objects.equals(null, null));
    }
}
