package my.chapter6.Item35;

// 不要使用 oridnal() 得到常量位置 而是使用实例域
public enum Test {
    A, B, C, D;
    public int getPos() { return ordinal() + 1; }

    public static void main(String[] args) {
        for (Test t : values())
            System.out.println(t.getPos());
    }
}
