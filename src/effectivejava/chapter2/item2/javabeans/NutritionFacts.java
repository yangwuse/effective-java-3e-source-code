package effectivejava.chapter2.item2.javabeans;

// JavaBeans Pattern - allows inconsistency, mandates mutability  (pages 11-12)
public class NutritionFacts {
    // Parameters initialized to default values (if any)
    private int servingSize  = -1; // Required; no default value
    private int servings     = -1; // Required; no default value
    private int calories     = 0;
    private int fat          = 0;
    private int sodium       = 0;
    private int carbohydrate = 0;

    public NutritionFacts() { }
    // Setters
    public void setServingSize(int val)  { servingSize = val; }
    public void setServings(int val)     { servings = val; }
    public void setCalories(int val)     { calories = val; }
    public void setFat(int val)          { fat = val; }
    public void setSodium(int val)       { sodium = val; }
    public void setCarbohydrate(int val) { carbohydrate = val; }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}

// my test code
class Test {
    private int a = 1;
    private int b = 2;
    private int c;
    private int d;
    private int e;

    public Test() {}
    // Setters
    public void setA(int a) { this.a = a; }
    public void setB(int b) { this.b = b; }
    public void setC(int c) { this.c = c; }
    public void setD(int d) { this.d = d; }
    public void setE(int e) { this.e = e; }

    public static void main(String[] args) {
        Test test = new Test();
        test.setA(2);
        test.setB(3);
    }
}