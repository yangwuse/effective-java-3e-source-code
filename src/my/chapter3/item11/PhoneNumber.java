package my.chapter3.item11;

import java.util.HashMap;
import java.util.Map;

// hashCode 的三种写法
public final class PhoneNumber {
    // 使用 short 类型 节省内存
    private final short areaCode = 0, prefix = 0, lineNum = 0;
    // 注意传入的是 int 类型参数
    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        areaCode = rangeCheck(areaCode, 999, "area code");
        prefix   = rangeCheck(prefix, 999, "prefix");
        lineNum  = rangeCheck(lineNum, 9999, "line num");
    }
    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short)val;
    }
    // 覆盖 equals() 同时覆盖 hahsCode()
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.prefix == prefix && pn.areaCode == areaCode 
                && pn.lineNum == lineNum;
    }
    // 方法一: 计算每个 equals 关键成员
    // @Override
    // public int hashCode() {
    //     int result = Short.hashCode(areaCode);
    //     result = 31 * result + Short.hashCode(prefix);
    //     result = 31 * result + Short.hashCode(lineNum);
    //     return result; 
    // }

    // 方法二: 使用 Objects.hash() 方法 但性能不高
    // @Override
    // public int hashCode() {
    //     return Objects.hash(areaCode, prefix, lineNum);
    // }

    // 缓存 hashCode
    private int hashCode;
    // 方法三: 缓存 hashCode 延迟初始化
    // @Override
    // public int hashCode() {
    //     int result = hashCode;
    //     if (result == 0) {
    //         result = Short.hashCode(areaCode);
    //         result = 31 * result + Short.hashCode(prefix);
    //         result = 31 * result + Short.hashCode(lineNum);
    //     }
    //     return result;
    // }

    public static void main(String[] args) {
       Map<PhoneNumber, String> m = new HashMap<>();
       m.put(new PhoneNumber(110, 119, 1024), "jerry");
       // 没有 hashCode() 将返回 null
       System.out.println(m.get(new PhoneNumber(110, 119, 1024))); 
    }
}
