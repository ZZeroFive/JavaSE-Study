package ml.generic.study.actual03;

import lombok.Data;

/**
 * 子类继承泛型类
 * 子类可以指定部分泛型变量
 * 子类可以利用通配符限制泛型变量范围
 * @param <K>
 * @param <V>
 */
@Data
public class MyMap<K, V>{

    private K k;
    private V v;

    public void someMethod() {
        System.out.printf("key is %s, value is %s\n", k, v);
    }
}
