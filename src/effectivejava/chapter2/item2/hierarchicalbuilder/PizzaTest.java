package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.*;

import static effectivejava.chapter2.item2.hierarchicalbuilder.Pizza.Topping.*;
import static effectivejava.chapter2.item2.hierarchicalbuilder.NyPizza.Size.*;

// Using the hierarchical builder (Page 16)
public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
        
        System.out.println(pizza);
        System.out.println(calzone);
    }
}

// my test code
class Test {
    public static void main(String[] args) {
        Child1 child1 = new Child1.Builder(23)
            .methodChian(Parent.Enum.A).methodChian(Parent.Enum.B).build();
        System.out.println(child1);
    }
}

abstract class Parent {
    public enum Enum { A, B, C, D };
    final List<Enum> list;

    abstract static class Builder<T extends Builder<T>> {
        private final ArrayList<Enum> list = new ArrayList<>();
        public T methodChian(Enum e) {
            this.list.add(Objects.requireNonNull(e));
            return self();
        }

        abstract Parent build();
        protected abstract T self();
    }
    Parent(Builder<?> builder) {
        this.list = new ArrayList<>(builder.list);
    }
}

class Child1 extends Parent {
    private final int age;
    static class Builder extends Parent.Builder<Builder> {
        private final int age;
        public Builder(int age) {
            this.age = age;
        }

        public Child1 build() {
            return new Child1(this);
        }

        @Override
        protected Builder self() { return this; }
    }
    private Child1(Builder builder) {
        super(builder);
        this.age = builder.age;
    }
    public String toString() {
        return "Child1 " + list.toString() + " " + age;
    }
}