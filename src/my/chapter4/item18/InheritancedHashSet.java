package my.chapter4.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

// 继承现有类有很多缺点 
// 1. 不能保证现有类在将来不会修改、扩展其中的方法
// 2. 子类无法访问父类私有域
// 3. 父类方法可能是自包含的 导致子类覆盖方法的逻辑错误
// 4. 子类的扩展方法可能和未来父类中的方法发生冲突
// ...
public class InheritancedHashSet<E> extends HashSet<E>{
    private int addCount;

    public InheritancedHashSet() {}

    public InheritancedHashSet(int inintCap, int loadFactor) {
        super(inintCap, loadFactor);
    }

    // 父类方法的自包含性导致 逻辑错误
    @Override public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    // 父类 addAll() 会调用子类覆盖的 add() 导致子类逻辑错误
    @Override public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() { return addCount; }

    public static void main(String[] args) {
        InheritancedHashSet<Integer> set = new InheritancedHashSet<>();
        set.addAll(List.of(1, 2, 3));
        System.out.println(set.getAddCount());
    }
}