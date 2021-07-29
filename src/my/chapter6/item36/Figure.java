package my.chapter6.item36;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// 用 EnumSet 替代 int 类型的枚举常量 表示位域
public class Figure {
    private enum Style { RECT, CIRCLE, SQUARE }
    
    public static void applyStyles(Set<Style> styles) {
        System.out.printf("Applying styles of %s to figure%n", 
                Objects.requireNonNull(styles));
    }

    public static void main(String[] args) {
        applyStyles(EnumSet.of( Style.RECT, Style.CIRCLE ));
    }

}
