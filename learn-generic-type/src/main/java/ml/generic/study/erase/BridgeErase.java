package ml.generic.study.erase;

/**
 * 桥接代码演示
 */
public class BridgeErase implements BridgeInterface<String> {

    @Override
    public void compare(String s) {
        // 桥接代码分析： 子类实现父类，重写父类方法。方法签名和父类并未保持一致
        // 编译器没有出现错误，而且运行正常
        // 通过反编译字节码文件可以看出JDK编译器自动生成类桥接代码以配合泛型擦除，保证程序运行
        System.out.println("s is " + s);
    }

    public static void main(String[] args) {
        BridgeInterface<String> bridgeInterface = new BridgeErase();
        bridgeInterface.compare("123");
    }

}
