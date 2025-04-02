package ml.study.proxy;

import lombok.Data;


@Data
public class StaticProxyDemo {

    private ProxyObject proxyObject;


    private void adviceMethod() {
        System.out.println("这是代理执行增强逻辑.");
    }

    public void proxyMethod() {
        adviceMethod();
        proxyObject.proxyMethod();
    }


    @Data
    private class ProxyObject {
        private String name;

        public void proxyMethod() {
            System.out.println("这是代理对象执行.");
        }

    }

    public static void main(String[] args) {
        StaticProxyDemo demo = new StaticProxyDemo();

        ProxyObject object = demo.new ProxyObject();
        demo.setProxyObject(object);
        demo.proxyMethod();
    }

}
