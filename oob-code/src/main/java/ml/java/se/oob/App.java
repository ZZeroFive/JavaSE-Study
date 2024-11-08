package ml.java.se.oob;

import ml.java.se.oob.method.Student;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s);

        s.setName(null);
        System.out.println(s);

        // compile error
        // s.setFamilyMemberNums(null);
        System.out.println(s);


        // s.printInterests(null);

        // 无法访问protected修饰的方法
        // s.printInterests(new String[]{});
    }
}
