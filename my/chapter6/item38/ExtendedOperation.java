package my.chapter6.item38;

import java.util.Arrays;
import java.util.Collection;

public enum ExtendedOperation implements Operation {
    EXP("^") {
        @Override public double apply(double x, double y) {
            return Math.pow(x, y);
        }

    },
    REMAINDED("%") {
        @Override public double apply(double x, double y) {
            return x % y;
        }
        
    };

    private final String name;

    private ExtendedOperation(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return name;
    }

    // 使用集合有限通配符类型参数传递拓展的枚举
    public static void test(Collection<? extends Operation> opSet, double x, double y) {
        // 使用接口类型 Operation
        for (Operation op : opSet)
            System.out.printf("%.2f %s %.2f = %.2f %n",
                    x, op, y, op.apply(x, y));
    }

    public static void main(String[] args) {
        double x = 2;
        double y = 10;
        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }
    
}
