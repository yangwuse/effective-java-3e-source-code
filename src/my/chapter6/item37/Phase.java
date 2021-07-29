package my.chapter6.item37;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public enum Phase {
    SOLID, LIQUID, GAS;
    
    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
        
        private final Phase from;
        private final Phase to;
    
        Transition(Phase from, Phase to) {
            this.from = from;
            this.to   = to;
        }

        // 建立二级映射
        private static final Map<Phase, Map<Phase, Transition>> 
                map = Stream.of(values()).collect(groupingBy(t -> t.from, 
                () -> new EnumMap<>(Phase.class),
                toMap(t -> t.to, t -> t, 
                        (x, y) -> y, () -> new EnumMap<>(Phase.class))));

        public static Transition getTransition(Phase from, Phase to) {
            return map.get(from).get(to);
        }
    }

    public static void main(String[] args) {
        for (Phase from : values()) {
            for (Phase to : values()) {
                Transition t = Transition.getTransition(from, to);
                if (t != null)
                    System.out.printf("%-6s to %s : %s %n", from, to, t);
            }
        }
    }
}
