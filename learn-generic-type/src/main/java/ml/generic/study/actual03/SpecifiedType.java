package ml.generic.study.actual03;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 子类继承自泛型父类，限定部分泛型变量类型
 */
public class SpecifiedType<K>  extends MyMap<Integer, K> {

    @Override
    public void someMethod() {
        super.someMethod();
        System.out.println("this is Specified some Type sub class");
    }

    /**
     * 子类继承泛型父类，指定其中一个泛型参数类型
     * 在子类对象中获取该泛型参数类型
     */
    public void printParameterType() {
        Class<?> clazz = this.getClass();
        // 获取super class 的泛型Type
        Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            // 是泛型父类 就获取具体的泛型参数类型
            Type[] parameterTypeArrays = ((ParameterizedType) type).getActualTypeArguments();
            for (Type t : parameterTypeArrays) {
                // 将泛型参数Type转换成实际Class对象并输出
                // 在输出泛型参数类型前 先判断该泛型参数是不是具体的class对象
                // 如果是就输出class信息 如果不是 输出type信息
                if (t instanceof Class) {
                    Class<?> c = (Class<?>) t;
                    System.out.println("子类继承的泛型父类的泛型变量类型是： " + c.getName());
                } else {
                    System.out.println("另外一个不是具体的泛型变量类型： " + t.getTypeName() + " " + t);
                }
            }
        }
    }

    public static void main(String[] args) {
        SpecifiedType<Integer> sub = new SpecifiedType<Integer>();
        sub.setK(120);
        sub.setV(999);
        sub.someMethod();
        sub.printParameterType();
    }
}
