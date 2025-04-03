package ml.study.proxy.dynamic.cglib;

import java.lang.reflect.Method;

import lombok.Data;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

@Data
public class CglibInvocationHandler implements MethodInterceptor {

    private Object target;

    

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        System.out.println("代理对象执行前置方法增强： " + System.currentTimeMillis());
        //  触发被代理对象的方法
        Object result = arg1.invoke(target, arg2);
        System.out.println("代理对象执行后置增强方法: " + System.currentTimeMillis());
        return result;
    }

}
