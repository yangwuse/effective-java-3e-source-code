package my.chapter4.item23.taggedclass;

// 避免使用标签类 冗长、低效、易错、可读性差
public class Figure {
    enum Shape { RECTANGLE, CIRCLE }

    // 标签域
    final Shape shape;

    // 矩阵域 只有矩阵才会用到
    double length;
    double width;

    // 半径 只有圆形才会用到
    double radius;

    // 矩形构造器
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    } 

    // 圆形构造器
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 通用方法 但是需要判断具体类型 容易遗漏情况导致出错
    double area() {
        switch(shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }

    public static void main(String[] args) {
        Figure rect = new Figure(2, 2);
        System.out.println(rect.area());
    }
}
