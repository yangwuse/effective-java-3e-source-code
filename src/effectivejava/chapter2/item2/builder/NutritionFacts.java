package effectivejava.chapter2.item2.builder;

// Builder Pattern  (Page 13)
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories      = 0;
        private int fat           = 0;
        private int sodium        = 0;
        private int carbohydrate  = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public Builder calories(int val)
        { calories = val;      return this; }
        public Builder fat(int val)
        { fat = val;           return this; }
        public Builder sodium(int val)
        { sodium = val;        return this; }
        public Builder carbohydrate(int val)
        { carbohydrate = val;  return this; }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
    }
}

// my test code
class Test {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;

    public static class Builder {
        // required fields
        private final int a;
        private final int b;

        // optimal fields
        private int c;
        private int d;
        private int e;

        public Builder(int a, int b) { this.a = a; this.b = b; }
        public Builder setC(int c) { this.c = c; return this; }
        public Builder setD(int d) { this.d = d; return this; }
        public Builder setE(int e) { this.e = e; return this; }

        public Test build() { return new Test(this); }
    }

    private Test(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Test: {a = ").append(a)
            .append(", b = ").append(b)
            .append(", c = ").append(c)
            .append(", d = ").append(d)
            .append(", e = ")
            .append(e).append("}");
        return s.toString();
    }

    public static void main(String[] args) {
        Test test = new Test.Builder(1, 2).setC(3).setD(4).setE(5).build();
        System.out.println(test);
    }
}

class Test2 {
    int a = 1;
    int b = 2;
    public Test2() {}
    public void print() {
        System.out.println(this.a + " " + this.b);
    }

    public static void main(String[] args) {
        new Test2().print();
    }
}