package ml.generic.study;

public class DemoEraseApp {

    public static void main(String[] args) {
        // 验证泛型擦除所做的类型强制转换工作
        MyList<String> list = new MyList<>();
        list.add("123");

        String s = list.get(0);
        System.out.println(s);
    }
}
