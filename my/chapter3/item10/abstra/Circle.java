package my.chapter3.item10.abstra;

// 继承抽象类的子类添加实例域不会违法 equals 约定
public class Circle extends Shape {
    private int radius;
    public Circle(int r) { radius = r; }

    @Override
    public boolean equals(Object o) {
        if (! (o instanceof Shape))
            return false;
        if (! (o instanceof Circle))
            return false;
        Circle c = (Circle)o;
        return c.radius == radius;
    }
}
