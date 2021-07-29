package my.chapter6.item34;

// 给每个常量绑定一个方法  将常量看做一个对象
public enum Operation {
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    Operation(String symbol) { this.symbol = symbol; }

    @Override public String toString() { return symbol; }

    // 每个常量是实现自己特定的方法
    public abstract double apply(double x, double y);

    public static void main(String[] args) {
        double x = 4;
        double y = 2;
        for (Operation op : values())
            System.out.printf("%.2f %s %.2f = %.2f%n", 
                x, op, y, op.apply(x, y));
    }
}