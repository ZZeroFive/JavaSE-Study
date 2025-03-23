package ml.generic.study.actual04;



/**
 * 演示泛型extends通配符限制参数父类类型作用
 */
public class DemoExtends {


    public static <T extends Number> void addPair(Pair<T> pair) {
        Number first = pair.getFirst();
        Number second = pair.getSecond();
        System.out.println(first.intValue() + second.intValue());
        // 会出现编译异常
        // Integer i1 = pair.getFirst();
        // Integer i2 = pair.getFirst();
    }


    public static void demo01() {
        Pair<Integer> pair = new Pair<>();
        pair.setFirst(1_23);
        pair.setSecond(2_34);
        addPair(pair);

        Pair<Double> dPair = new Pair<>();
        dPair.setFirst((double)123.4);
        dPair.setSecond((double)23.1);
        addPair(dPair);
    }

    public static <T extends Number> void addPair2(Pair<T> pair) {
        T t1 = pair.getFirst();
        T t2 = pair.getSecond();

        System.out.println(t1.doubleValue() + t2.doubleValue());
    }

    public static void demo02() {
        Pair<Double> pair = new Pair<>();
        pair.setFirst(0.12);
        pair.setSecond(0.28);
        addPair2(pair);

        Pair<Integer> iPair = new Pair<>();
        iPair.setFirst(1);
        iPair.setSecond(2);
        addPair2(iPair);
    }

    public static void main(String[] args) {
        demo01();
        demo02();

    }
}
