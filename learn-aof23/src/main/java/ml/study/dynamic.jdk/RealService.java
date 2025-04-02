package ml.study.dynamic.jdk;


/**
 * 接口实现类，也是需要被代理的对象
 */
public class RealService implements Service {

    @Override
    public void doSomething() {
        System.out.println("实现类逻辑");
    }

}
