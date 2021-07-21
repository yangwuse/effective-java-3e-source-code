package my.chapter2.item01;

/**
 * advantage 3: return a subclass obj of any class
 * @author yangWu
 * @date 2021/6/28 9:50 上午
 * @version 1.0
 */
public class ReturnSubClassObj {
    // 服务端内部不可见的实现类
    private static class Hamburg implements Lunch {
        private String name;
        private double price;
        Hamburg(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String toString() {
            return name + ", " + price;
        }
    }

    // 返回子类对象 隐藏了内部实现逻辑
    public static Lunch getHamburgLunch(String name, double price) {
        return new Hamburg(name, price);
    }
}

// 客户端引用的接口
interface Lunch {}

// 客户端测试类
class ClientTest {
    public static void main(String[] args) {
        // 使用接口引用子类对象
        Lunch myLunch = ReturnSubClassObj.getHamburgLunch("肯德基", 25.4);
        System.out.println(myLunch);
    }
}
