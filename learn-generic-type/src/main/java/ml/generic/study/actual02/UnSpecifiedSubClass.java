package ml.generic.study.actual02;

/**
 * 继承自泛型类，但并没有指定泛型变量类型
 * 此时子类仍然是泛型类
 * @param <T>
 */
public class UnSpecifiedSubClass<T> extends GenericParent<T> {

    @Override
    public void someMethod() {
        System.out.println("child attr is " + getAttr());
    }

    public static void main(String[] args) {
        GenericParent<String> sub = new UnSpecifiedSubClass<>();
        sub.setAttr("JML");
        sub.someMethod();
    }
}
