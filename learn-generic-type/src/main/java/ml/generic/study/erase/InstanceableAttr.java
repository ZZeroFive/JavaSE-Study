package ml.generic.study.erase;


import java.lang.reflect.InvocationTargetException;

/**
 * 通过Class对象间接实例化泛型变量
 * @param <T>
 */
public class InstanceableAttr<T> {

    private T attr;

    public InstanceableAttr(Class<T> typeParameterClass) {
        try {
            this.attr = typeParameterClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * equals(T)' in 'ml.generic.study.erase.InstanceableAttr' clashes with
     * 'equals(Object)' in 'java.lang.Object';
     * both methods have same erasure, yet neither overrides the other
     * @param t
     * @return
     */
    /*public boolean equals(T t) {
        return false;
    }*/

    public static void main(String[] args) {
        InstanceableAttr<String> i = new InstanceableAttr<>(String.class);
        System.out.println(i);
    }
}
