package my.chapter3.item10.inheritance;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 给 Point 添加 color 属性导致违反 equals() 的对称性和传递性
public class ColorPoint extends Point {
	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	// 方法一: 违法了对称性
	// @Override
	// public boolean equals(Object o) {
	// 	// 父类不能转换为子类 违反了对称性
	// 	if (!(o instanceof ColorPoint))
	// 		return false;
	// 	return super.equals(o) && ((ColorPoint)o).color == color;
	// }

	// 方法二: 满足了对称性 不满足传递性
	@Override
	public boolean equals(Object o) {
		// 不是父类类型 
		if (!(o instanceof Point))
			return false;
		// 不是子类类型 根据 o 类型比较
		if (!(o instanceof ColorPoint))
			return o.equals(this);
		// 相同类型
		return super.equals(o) && ((ColorPoint)o).color == color;
	}

	public static void main(String[] args) {
		Point p1 = new Point(1, 2);
		ColorPoint p2 = new ColorPoint(1, 2, Color.RED);
		// 方法一
		// 父类对象 equals 子类对象会忽略子类扩展信息
		// 子类对象 equals 父类对象总是返回 false 因为父类对象无法转化成子类对象
		// System.out.println(p1.equals(p2)); // true
		// System.out.println(p2.equals(p1)); // false

		// 方法二 满足对称性 
		System.out.println(p1.equals(p2)); // true
		System.out.println(p2.equals(p1)); // true
		System.out.println("------------");

		// 方法二 不满足传递性 p2.equals(p1) and p1.equals(p3) but !p2.equals(p3)
		ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
		System.out.println(p2.equals(p1)); // true 忽略了 p2.color 
		System.out.println(p1.equals(p3)); // true 忽略了 p3.color
		System.out.println(p2.equals(p3)); // false !!!
		
	}
}
