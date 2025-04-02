package ml.study.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * 这是实现动态代理的核心，可以理解为代理类，通过他可以编写代理的具体逻辑
 * 
 */
public class MyInvocationHandler implements InvocationHandler{

    private Object target; // 被代理对象
    
    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    /**
     * 方法释义如下：
     * proxy是代理对象
     * method是被代理的方法
     * args是方法调用的参数    
     * 返回的Object代表的是被调用方法的返回值         
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method call");
        Object result = method.invoke(target, args);
        System.out.println("After method call");
        return result;
    }


   

}
