package my.chapter3.item10.inheritance;

// 两个 Point 子类对象 equals 发生无限递归 StackOverFlowError
public class SizePoint extends Point {
    private final Size size;
    public SizePoint(int x, int y, Size size) {
        super(x, y);
        this.size = size;
    }
     
    @Override
    public boolean equals(Object o) {
        // 不是父类型
        if (!(o instanceof Point))
            return false;
        // 不是相同类型 根据 o 类型比较 可能导致无限递归
        if (!(o instanceof SizePoint))
            return o.equals(this);
        // 相同类型
        return super.equals(o) && ((SizePoint)o).size == size;
    }
    
    public static void main(String[] args) {
        // 两个不同的 Point 子类对象 equals 导致无限递归 
        // 原因是每个子类对象的第二个 if 使用参数类型的 equals 导致相互调用各自的 equals
        ColorPoint colorPoint = new ColorPoint(1, 2, Color.RED);
        SizePoint sizePoint = new SizePoint(1, 2, Size.BIG);
        // StackOverFlowError!!!
        colorPoint.equals(sizePoint);
    }
}
