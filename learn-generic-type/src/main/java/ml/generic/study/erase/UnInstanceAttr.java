package ml.generic.study.erase;


/**
 * 范型变量无法执行new操作
 */
public class UnInstanceAttr<T> {
    private T attr;

    public UnInstanceAttr() {
        // 无法通过编译 Type parameter 'T' cannot be instantiated directly
        // this.attr = new T();
    }

    public UnInstanceAttr(T attr) {
        this.attr = attr;
    }

    public static void main(String[] args) {
        System.out.println("hello world!");
    }

}
