package my.chapter3.item10.floatdouble;

// float 类型使用 Float.compare() 比较是否相等 
// 特殊处理 Float.NaN
public class FloatTest {
    public static void main(String[] args) {
        float f1 = 1.0f;
        float f2 = 1.1f;
        float f3 = 1.0f;
        // -1 小于
        System.out.println(Float.compare(f1, f2));
        // 1 大于
        System.out.println(Float.compare(f2, f1));
        // 0 等于
        System.out.println(Float.compare(f1, f3));

        // NaN
        float f4 = 0.0f/ 0.0f;
        // 正无穷
        float f5 = 1.0f / 0.0f;
        // 负无穷
        float f6 = -1.0f / 0.0f;
        System.out.printf("%f, %f, %f%n", f4, f5, f6);
        // -1
        System.out.println(Float.compare(f1, f4));
        
    }
}
