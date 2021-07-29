package my.chapter4.item23.hierarchy;

public class Circle extends Figure {
    // final 域
    private final double radius;
    public Circle(double radius) { 
        name = "Circle";
        this.radius = radius; 
    }
    // 加上 @Override 检错
    @Override public double area() {
        return Math.PI * radius * radius;
    }
}
