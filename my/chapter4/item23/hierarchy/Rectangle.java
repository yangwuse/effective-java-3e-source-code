package my.chapter4.item23.hierarchy;

public class Rectangle extends Figure {
    private final double length;
    private final double width;
    public Rectangle(double length, double width) {
        name = "Rectangle";
        this.length = length;
        this.width = width;
    }
    @Override public double area() {
        return length * width;
    }
}
