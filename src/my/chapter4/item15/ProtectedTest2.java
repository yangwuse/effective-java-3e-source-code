package my.chapter4.item15;

// protected 包内部可访问 或父子类可访问
public class ProtectedTest2 {
    public static void main(String[] args) {
        // 包内部访问类的 protected 成员
        Parent2 p = new Parent2();
        System.out.println(p.name);
    }
}
