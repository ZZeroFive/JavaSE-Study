package ml.generic.study.actual03;

/**
 * 子类继承自泛型父类，限定部分泛型变量类型
 */
public class SpecifiedType<K>  extends MyMap<Integer, K> {

    @Override
    public void someMethod() {
        super.someMethod();
        System.out.println("this is Specified some Type sub class");
    }

    public static void main(String[] args) {
        MyMap<Integer, Integer> sub = new SpecifiedType<Integer>();
        sub.setK(120);
        sub.setV(999);
        sub.someMethod();
    }
}
