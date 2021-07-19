package my.chapter1.item06;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map.keySet() 返回同一个对象 避免重复创建
 * @author yangWu
 * @date 2021/7/18 2:42 下午
 * @version 1.0
 */
public class MapKeySetTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);

        Set<Integer> s1 = map.keySet();
        Set<Integer> s2 = map.keySet();
        System.out.println(s1 == s2); // true
    }
}
