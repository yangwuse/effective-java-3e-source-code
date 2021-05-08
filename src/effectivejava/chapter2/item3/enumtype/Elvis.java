package effectivejava.chapter2.item3.enumtype;

// Enum singleton - the preferred approach (Page 18)
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}

// Test
enum Singleton {
    INSTANCE;

    public static void main(String[] args) {
        Singleton s = Singleton.INSTANCE;
    }
}
