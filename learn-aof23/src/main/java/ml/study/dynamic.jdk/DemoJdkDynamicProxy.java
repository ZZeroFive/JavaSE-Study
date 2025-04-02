package ml.study.dynamic.jdk;

import java.lang.reflect.Proxy;

public class DemoJdkDynamicProxy {

    public static void main(String[] args) {
        // 创建实例
        RealService realService = new RealService();
        // 通过JDK API 创建代理对象
        Service proxy = (Service) Proxy.newProxyInstance(
            Service.class.getClassLoader(),
            new Class[]{Service.class},
            new MyInvocationHandler(realService)
        );
        // 调用代理对象的doSomething()会触发代理对象的invoke()方法
        proxy.doSomething();
    }

}
