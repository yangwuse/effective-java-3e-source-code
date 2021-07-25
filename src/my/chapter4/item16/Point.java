package my.chapter4.item16;

// 公有类编程范式
// 公有类不应该包含公有域 而是通过访问方法和设置方法控制私有域
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // 公有访问方法将类内部数据表示和客户端代码解耦
    public double getX() { return x; }
    public double getY() { return y; }

    // 公有修改方法提供修改数据的能力
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
}
