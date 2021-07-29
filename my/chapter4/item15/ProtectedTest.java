package my.chapter4.item15;

// protected 包内部可访问 或父子类可访问
public class ProtectedTest {
    public static void main(String[] args) {
        // 子类访问父类 protected 成员
        Child2 c = new Child2();
        System.out.println(c.name);
    }
}

class Parent2 {
    protected String name = "parent";
}

class Child2 extends Parent2 {
}
