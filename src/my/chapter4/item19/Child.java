package my.chapter4.item19;

import java.time.Instant;

// 父类不能在构造器中调用覆盖方法 
// 因为此时子类还没有被创建
public class Child extends Parent {
    private final Instant instant;

    public Child() {
        instant = Instant.now();
    }

    @Override public void overrideMe() {
        // null
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Child c = new Child();
        System.out.println(c.instant);
    }
}
