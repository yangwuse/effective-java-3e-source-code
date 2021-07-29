package my.chapter2.item02.telescopingconstructor;

/**
 * 重叠构造器在可选参数不多时有用
 * @author yangWu
 * @date 2021/6/28 2:36 下午
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

    // 依次创建重叠构造器 代码冗余且不能选择设置某个可选参数
    public Food(int item1, int item2) {
        this(item1, item1, 0);
    }

    public Food(int item1, int item2, int opt1) {
        this(item1, item2, opt1, 0);
    }

    public Food(int item1, int item2, int opt1, int opt2) {
        this(item1, item2, opt1, opt2, 0);
    }

    // 创建有最大参数列表的构造器
    public Food(int item1, int item2, int opt1, int opt2, int opt3) {
        this.item1 = item1;
        this.item2 = item2;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
    }

    public static void main(String[] args) {
        // 设置 item1 item2 opt2 opt3
        Food food = new Food(1, 2, 0,3, 4);
    }
}
