package ml.generic.study.actual01;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用泛型表示分页结果
 * @param <T>
 */
@Data
public class PageResult<T> {
    private Long total;
    private List<T> data;

    /**
     * 生成一个空的返回结果
     * @return
     */
    public static <T> PageResult<T> geneEmptyResult(Class<T> tClass) {
        // 注意这里： T表示泛型变量，而tClass表示Class对象
        // 所以创建PageResult的时候需要传递T 而不能是tClass
        PageResult<T> result = new PageResult<>();
        result.setTotal(0L);
        // 泛型变量不可以直接实例化，而这里实例化的是泛型类，绝非泛型变量
        result.setData(new ArrayList<>());
        return result;
    }
}
