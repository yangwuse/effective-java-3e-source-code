package my.chapter1.item02.builder;

/**
 * 建造器既有javabean模式的易读性 又将对象的构造放在一个函数中 避免了不一致情况
 * @author yangWu
 * @date 2021/6/28 2:49 下午
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

    // 首先用必要参数初始化一个 builder 然后通过 setter 方法在 builder 上设置可选参数
    // Builder 通常作为静态类成员 充当临时对象的作用
    public static class Builder {
        // 2个必选参数
        private int item1;
        private int item2;

        // 3个可选参数
        private int opt1 = 0;
        private int opt2 = 0;
        private int opt3 = 0;

        // 设置必要参数
        public Builder(int item1, int item2) {
            this.item1 = item1;
            this.item2 = item2;
        }

        // 通过在 setter 返回 this 实现链式调用
        public Builder setOpt1(int opt1) {
            this.opt1 = opt1;
            return this;
        }

        public Builder setOpt2(int opt2) {
            this.opt2 = opt2;
            return this;
        }

        public Builder setOpt3(int opt3) {
            this.opt3 = opt3;
            return this;
        }

        // 最后通过 builder() 完成属性传递
        public Food build() {
            return new Food(this);
        }
    }

    // 最后被 builder 对象调用的目标构造器
    private Food(Builder builder) {
        // 属性赋值
        this.item1 = builder.item1;
        this.item2 = builder.item2;
        this.opt1 = builder.opt1;
        this.opt2 = builder.opt2;
        this.opt3 = builder.opt3;
    }
}

// 客户端测试代码
class ClientTest {
    public static void main(String[] args) {
    }
}
