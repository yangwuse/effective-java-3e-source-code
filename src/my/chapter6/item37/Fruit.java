package my.chapter6.item37;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

// 使用 EnumMap 实现基于枚举键的 Map
// 根据颜色将水果分类 map
public class Fruit {
    private enum Color { RED, YELLOW, GREEN }

    private final String name;
    private final Color color;

    Fruit(String name, Color color) {
        this.name   = name;
        this.color  = color;     
    }

    @Override public String toString() { return name; }

    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[] {
            new Fruit("Apple1",  Color.RED),
            new Fruit("Orange1", Color.YELLOW),
            new Fruit("Banana1", Color.GREEN),
            new Fruit("Apple2",  Color.GREEN),
            new Fruit("Orange2", Color.RED),
            new Fruit("Banana2", Color.YELLOW)
        };
        
        // 不要用枚举常量的位置作为索引键
        Set<Fruit>[] set = new Set[Color.values().length];
        for (int i = 0; i < set.length; i++)
            set[i] = new HashSet<>();
        for (Fruit f : fruits) 
            set[f.color.ordinal()].add(f);
        for (int i = 0; i < set.length; i++)
            System.out.printf("%s: %s%n",
                    Color.values()[i], set[i]);

        // 使用 EnumSet 建立基于枚举键的映射
        Map<Color, Set<Fruit>> map = new EnumMap<>(Color.class);
        for (Color c : Color.values())
            map.put(c, new HashSet<>());
        for (Fruit f : fruits) 
            map.get(f.color).add(f);
        System.out.println(map);

        // 使用 stream 的 goupingBy 和 EnumMap 建立映射
        System.out.println(Arrays.stream(fruits)
                .collect(groupingBy(f -> f.color, 
                        () -> new EnumMap<>(Color.class), toSet())));
    }
}
