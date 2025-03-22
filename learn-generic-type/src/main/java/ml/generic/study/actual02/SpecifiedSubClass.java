package ml.generic.study.actual02;



import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 子类继承明确泛型参数的父类
 */
public class SpecifiedSubClass extends GenericParent<Integer> {

    public static void main(String[] args) {
        // 获取子类实例的泛型变量类型
        SpecifiedSubClass specifiedSubClass = new SpecifiedSubClass();
        Class<? extends SpecifiedSubClass> clazz = specifiedSubClass.getClass();
        // 获取当前class的super class type
        // Type是JDK反射中的类型 是Class的父类
        // 如果父类是泛型类，返回的Type对象一定会准确地表示出泛型变量的类型
        // 如果clazz表示数组Class 那么会返回Object对象
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            // 如果返回的t是一个泛型类对象 ParameterizedType表示参数化的类型，也就是泛型类
            // 强制转换成ParameterizedType 并获取泛型变量的具体类型
            // 可能会有多个范型参数
            Type[] parameterTypes = ((ParameterizedType) t).getActualTypeArguments();
            // 获取第一个泛型参数的Type类型
            Type pType = parameterTypes[0];
            // 通过Type强制转换成Class对象 查看子类所继承的父类泛型变量类型
            Class<?> c = (Class<?>) pType;
            System.out.println(c.getName());
        }
    }
}
