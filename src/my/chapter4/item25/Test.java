package my.chapter4.item25;

// 将其它类做成  私有静态类
public class Test {
    public static void main(String[] args) {
        System.out.println(A.name + " " + B.name);
    }

    private static class A {
        static final String name = "A";
    }

    private static class B { 
        static final String name = "B";
    }
}
