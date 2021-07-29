package my.chapter6.item34;

// 用策略枚举替代 switch 和特定于常量的方法 好处是减少样板代码 提高安全想
// 本质思想是分类计算 类似于 helper 方法
public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY(DayType.WEEKEND), SUNDAY(DayType.WEEKDAY);

    private final DayType dayType;

    private PayrollDay(DayType dayType) { this.dayType = dayType; }
    private PayrollDay() { this(DayType.WEEKDAY); }

    // 委托给策略枚举计算
    public double pay(int mins, double payRate) {
        return dayType.pay(mins, payRate);
    }

    // 策略枚举类型 效果等同于 helper 成员方法
    private enum DayType {
        // 特定于常量的实现方法
        WEEKDAY {
            public double overtimePay(int minsWorked, double payRate) {
                return minsWorked <= FIXED_WORKED_MINUTES ? 0 :
                    (minsWorked - FIXED_WORKED_MINUTES) * payRate / 2;
            }
        }, 
        WEEKEND {
            public double overtimePay(int minsWorked, double payRate) {
                return minsWorked * payRate / 2;
            }
        };

        // 正常工作时间 8h
        private static final int FIXED_WORKED_MINUTES = 8 * 60;

        // 被用于覆盖的计算加班工资的抽象方法
        public abstract double overtimePay(int minsWorked, double payRate);

        // 被委托的方法
        public double pay(int minsWorked, double payRate) {
            double basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }

    public static void main(String[] args) {
        // 根据类型计算每天的工资
        for (PayrollDay day : values()) 
            System.out.printf("%-10s%.2f%n", day, day.pay(8 * 60, 1));
    }
}
