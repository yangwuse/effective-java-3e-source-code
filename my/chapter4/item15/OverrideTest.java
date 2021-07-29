package my.chapter4.item15;

// 子类覆盖父类方法时 其方法访问权限不低于父类
public class OverrideTest {
    public static void main(String[] args) {
        Parent p = new Child();
        p.foo();
    }
}

class Parent {
    public void foo() {
        System.out.println("Parent foo()");
    }
}

class Child extends Parent {
    // 错误 访问权限小于了父类方法
    // protected void foo() {
    //     System.out.println("Child foo()");
    // }

    // 正确示例
    public void foo() {
        System.out.println("Child foo()");
    }
}
