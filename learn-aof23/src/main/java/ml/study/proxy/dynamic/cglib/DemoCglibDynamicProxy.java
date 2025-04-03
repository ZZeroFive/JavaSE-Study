package ml.study.proxy.dynamic.cglib;

import ml.study.proxy.dynamic.jdk.RealService;
import net.sf.cglib.proxy.Enhancer;

public class DemoCglibDynamicProxy {

    /**
     * 基于cglib的动态代理实现
     */
    public static Object getProxyObject(Object target) {
        CglibInvocationHandler cglibInvocationHandler = new CglibInvocationHandler();
        cglibInvocationHandler.setTarget(target);
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(cglibInvocationHandler);
        enhancer.setSuperclass(target.getClass());
        return enhancer.create();
    }

    public static void main(String[] args) {
        RealService s = new RealService();
        RealService proxyObject = (RealService) DemoCglibDynamicProxy.getProxyObject(s);
        proxyObject.doSomething();
    }
}
