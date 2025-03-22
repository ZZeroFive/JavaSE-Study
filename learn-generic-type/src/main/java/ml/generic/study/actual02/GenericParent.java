package ml.generic.study.actual02;


import lombok.Data;

/**
 * 演示继承自泛型父类时，通过反射代码获取子类的泛型变量类型
 * @param <T>
 */
@Data
public class GenericParent <T> {
    private T attr;


    public void someMethod() {
        System.out.println("attr is " + attr);
    }
}
