package my.chapter6.item34;

// 在普通类中使用 switch 对外部枚举类型增强
public class Inverse {
    // 返回相反操作的枚举常量
    public static  Operation inverse(Operation op) {
        switch(op) {
            case PLUS:      return Operation.MINUS;
            case MINUS:     return Operation.PLUS;
            case TIMES:     return Operation.DIVIDE;
            case DIVIDE:    return Operation.TIMES;
            default: throw new AssertionError("Unknown op: " + op);
        }
    }

    public static void main(String[] args) {
        double x = 4;
        double y = 2;
        for (Operation op : Operation.values()) {
            Operation invOp = inverse(op);
            System.out.printf("%.2f %s %.2f %s %.2f = %.2f%n",
                x, op, y, invOp, y, invOp.apply(op.apply(x, y), y));
        }
    }  
}
