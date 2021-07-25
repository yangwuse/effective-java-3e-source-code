package my.chapter3.item10.collections;
import java.util.Set;

// Set 集合的不同实现类之间可以相互比较 
// 实际上比较的是集合中的元素是否相等
public class CollectionsTest {
    public static void main(String[] args) {
        Set<Integer> s1 = Set.of(1, 2);
        Set<Integer> s2 = Set.of(1, 2);
        // true
        System.out.println(s1.equals(s2));
        Set<Character> s3 = Set.of('1', '2');
        // false
        System.out.println(s1.equals(s3)); 
    }
}
