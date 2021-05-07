package effectivejava.chapter2.item3.field;

// Singleton with public final field  (Page 17)
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() { }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}

// My test code
class Test {
    public static Test INSTATNCE = new Test();
    private Test() {}
    public void bar() {
        System.out.println("Singleton");
    }

    public static void main(String[] args) {
        Test test = Test.INSTATNCE;
        test.bar();
    }
}