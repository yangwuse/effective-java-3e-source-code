package my.chapter4.item17;

// 不可变类范式 复数(实部 + 虚部)
public final class Complex {
    // 私有不变域  
    private final double re;
    private final double im;

    // 公有静态不变域 (使用前提是他们的名字以后都不会改变)
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE  = new Complex(1, 0);
    public static final Complex I    = new Complex(0, 1);

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    // 提供外部访问内部私有域
    public double getRe() { return re; }
    public double getIm() { return im; }

    // private Complex(double re, double im) {
    //     this.re = re;
    //     this.im = im;
    // }
    
    // 公有静态工厂结合私有构造器实现对象缓存和对象共享
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    // 四种运算 +、-、*、/ 都是函数式方法 不修改原对象状态 而是返回新对象
    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im,
                re * c.im + im * c.re);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Complex))
            return false;
        Complex c = (Complex) o;

        return Double.compare(c.re, re) == 0
                && Double.compare(c.im, im) == 0;
    }
    @Override public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override public String toString() {
        return "(" + re + " + " + im + "i)";
    }


}
