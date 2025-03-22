package ml.generic.study.actual03;

/**
 * 子类继承泛型父类，子类限定泛型变量类型
 */
public class LimitParameterTypeRange<K extends String, V> extends MyMap<K , V>{

    @Override
    public void someMethod() {
        super.someMethod();
        System.out.println("this is sub class\n");
    }

    public static void main(String[] args) {
        MyMap<String, Integer> map = new LimitParameterTypeRange<String, Integer>();
        map.setV(12);
        map.setK("123");
        map.someMethod();
    }
}
