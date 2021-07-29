package my.chapter4.item23.hierarchy;

public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
        name = "Square";
    }

    public static void main(String[] args) {
        Square s = new Square(2.0);
        System.out.println(s.name);
        System.out.println(s.area());
    }
}
