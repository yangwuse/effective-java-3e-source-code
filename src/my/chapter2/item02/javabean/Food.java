package my.chapter2.item02.javabean;

/**
 * java bean 模式设置可选参数虽然易读 但是有数据不一致的危险 不用于并发环境
 * @author yangWu
 * @date 2021/6/28 2:45 下午
 * @version 1.0
 */
public class Food {
    // 2个必选参数
    private int item1;
    private int item2;

    // 3个可选参数
    private int opt1;
    private int opt2;
    private int opt3;

    // 无参构造函数
    public Food() {}

    // setter 函数设置参数
    public void setItem1(int item1) { this.item1 = item1; }

    public void setItem2(int item2) { this.item2 = item2; }

    public void setOpt1(int opt1) { this.opt1 = opt1; }

    public void setOpt2(int opt2) { this.opt2 = opt2; }

    public void setOpt3(int opt3) { this.opt3 = opt3; }

    public static void main(String[] args) {
        // 对象的构造分成几个函数 有状态不一致危险
        Food food = new Food();
        food.setItem1(1);
        food.setItem1(2);
        food.setOpt3(3);
    }
}
