package my.chapter6.item38;

// 实现接口来模拟拓展枚举
public enum BasicOperation implements Operation{
    PLUS("+") {
        @Override public double apply(double x, double y) { 
            return x + y; 
        }
    },
    MIUS("-") {
        @Override public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String name;

    BasicOperation(String name) { this.name = name; }
    
    @Override public String toString() { return name; }
}
