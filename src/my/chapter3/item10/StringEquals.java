package my.chapter3.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 违法 equals 对称性: 只修改一个类的 equals 导致 eqauls 不对称
public class StringEquals {
	private final String s;

	public StringEquals(String str) { s = Objects.requireNonNull(str); }

	// 错误示范
	@Override 
	public boolean equals(Object o) {
		if (o instanceof StringEquals) {
			return s.equalsIgnoreCase( ((StringEquals)o).s );
		} 
		// 违反对称性: StringEquals 对 String 忽略大小写, 
		// 而 String 的 equals 不知道对 StringEquals 忽略大小写, 导致 equals 不对称
		if (o instanceof String) {
			return s.equalsIgnoreCase((String)o);
		}
		return false;
	}

	// 违法对称性测试
	public static void main(String[] args) {
		StringEquals se = new StringEquals("FooBar");
		String s = "foobar";
		// 单方面覆盖 equals 导致的不对称
		System.out.println(se.equals(s)); // true
		System.out.println(s.equals(se)); // false

		// 当做集合元素时发生未知行为
		List<StringEquals> ls = new ArrayList<>();
		ls.add(se);
		// 未知: true / false / 异常, 依赖 JDK 实现方式
		System.out.println(ls.contains(s));
	}

	// 正确方式是避免单方面修改 equals()
	// @Override
	// public boolean equals(Object o) {
	// 	return o instanceof StringEquals &&
	// 		s.equalsIgnoreCase(((StringEquals)o).s);
	// }
}
