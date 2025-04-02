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

    // 获取泛型成员属性值
    public static <T extends Number> void setPair(Pair<T> pair, T first, T second) {
        pair.setFirst(first);
        pair.setSecond(second);
        // 无法通过编译
        // pair.setFirst(new Integer(first.intValue()));
        System.out.println(pair.getFirst().intValue() + pair.getSecond().intValue());
    }

    public static void demo03() {
        Pair<Double> dPair = new Pair<>();
        Double first = Double.valueOf(123.45);
        Double second = Double.valueOf(123.45);
        setPair(dPair, first, second);
    }

    /**
     * 指定泛型参数是Integer 或者 Integer的父类
     */
    public static void getPair(Pair<? super Integer> pair) {
        // 无法使用Integer接受 因为如果泛型参数是Integer父类，那么下面代码就有问题
        // Integer n = pair.getFirst();
        // 正确的应该使用Object接受
        Object first = pair.getFirst();
        // 不允许获取泛型属性的引用，即： T obj = pair.getObj();
        System.out.println(first);
    }

    public static void demo04() {
        Pair<Number> p = new Pair<>();
        p.setFirst(Integer.valueOf(1));
        p.setSecond(Integer.valueOf(2));
        getPair(p);
    }

    public static void setPair(Pair<? super Integer> pair) {
        // 传递的是Integer类型  因此没有出现编译错误
        pair.setFirst(1);
        // 传递的是Double类型 所以就出现错误了
        // pair.setFirst(1.1);
        // Number n1 = new Integer(23);
        // pair.setFirst(n1);

        Integer n2 = Integer.valueOf(1);
        pair.setFirst(n2);
        pair.setSecond(2);
        System.out.println(pair.getFirst() + " " + pair.getSecond());
    }

    public static void demo05() {
        Pair<Integer> pair = new Pair<>();
        setPair(pair);
    }

    public static void main(String[] args) {
        // demo01();
        // demo02();
        // demo03();
        // demo04();
        demo05();
    }
}
