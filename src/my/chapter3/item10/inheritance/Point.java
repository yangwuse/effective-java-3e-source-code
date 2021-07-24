package my.chapter3.item10.inheritance;

public class Point {
    private final int x;
    private final int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // @Override
    // public boolean equals(Object o) {
    //     if (!(o instanceof Point))
    //         return false;
    //     Point p = (Point)o;
    //     return p.x == x && p.y == y;
    // }

    // getClass 方式的 equals 会导致无法和子类比较
    // getClass 要求类型一样 父子都不行
    @Override
    public boolean equals(Object o) {
        if (o.getClass() != getClass())
            return false;
        Point p = (Point)o;
        return p.x == x && p.y == y;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new SubPoint(1, 2);
        // getClass 要求必须是同一类 false 即使父子对象逻辑相等
        System.out.println(p1.equals(p2));
    }

}

class SubPoint extends Point {

    public SubPoint(int x, int y) {
        super(x, y);
    }
    
}
