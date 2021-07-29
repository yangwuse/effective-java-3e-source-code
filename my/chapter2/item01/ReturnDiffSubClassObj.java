package my.chapter2.item01;

/**
 * advantage 4: 根据参数返回不同的子类对象
 * @author yangWu
 * @date 2021/6/28 10:22 上午
 * @version 1.0
 */
public class ReturnDiffSubClassObj {
    // 小尺寸自行车
    private static class SmallBicycle implements Bicycle {
        public String toString() { return "small bicycle"; }
    }

    // 大尺寸自行车
    private static class LargeBicycle implements Bicycle {
        public String toString() { return "large bicycle"; }
    }

    // 根据客户身高返回合适的自行车
    public static Bicycle getBicycle(double height) {
        if (height <= 175)
            return new SmallBicycle();
        else
            return new LargeBicycle();
    }

}

// 客户端接口
interface Bicycle {}

// 客户端测试类
class ClientTest2 {
    public static void main(String[] args) {
        Bicycle small = ReturnDiffSubClassObj.getBicycle(175);
        Bicycle large = ReturnDiffSubClassObj.getBicycle(183);

        System.out.println(small);
        System.out.println(large);
    }
}
