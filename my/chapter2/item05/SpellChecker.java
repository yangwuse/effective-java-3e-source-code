package my.chapter2.item05;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * 优先考虑依赖注入来引用资源
 * @author yangWu
 * @date 2021/7/18 11:21 上午
 * @version 1.0
 */
// 构造器依赖注入
public class SpellChecker {
    private final Dict dict;
    public SpellChecker(Dict d) {
        dict = requireNonNull(d);
    }

    public static void main(String[] args) {
        // 通过构造器传入依赖的资源
        SpellChecker s1 = new SpellChecker(new Dict("dict1"));
        SpellChecker s2 = new SpellChecker(new Dict("dict2"));
    }
}

class Dict {
    String name;
    public Dict(String name) { this.name = name; }
}
