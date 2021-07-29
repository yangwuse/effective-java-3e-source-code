package my.chapter3.item10.abstra;

// 继承抽象类的子类没有 equals() bug 
// 因为无法实例化超类 
public class EqualsTest {
    public static void main(String[] args) {
        Circle c = new Circle(1);
        Rect r = new Rect(1);
        System.out.println(c.equals(r));
    }
}
