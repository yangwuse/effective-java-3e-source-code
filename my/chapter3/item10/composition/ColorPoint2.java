package my.chapter3.item10.composition;

import java.util.Objects;

import my.chapter3.item10.inheritance.Color;
import my.chapter3.item10.inheritance.Point;

// 使用组合扩展类 满足 equals() 约束
public class ColorPoint2 {
    private Point point;
    private Color color;
    public ColorPoint2(int x, int y, Color c) {
        point = new Point(x, y);
        color = Objects.requireNonNull(c);
    }

    @Override
    public boolean equals(Object o) {
        // 此时使用 instanceof ColorPoint2 因为该类不是 Point 子类
        if (! (o instanceof ColorPoint2)) 
            return false;
        ColorPoint2 cp = (ColorPoint2)o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
