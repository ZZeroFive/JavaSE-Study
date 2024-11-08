package ml.java.se.oob.method;

public class HighStudent extends Student {

    // 向下转型判断
    public static void demoInstanceOf() {
        Student student = new Student();
        System.out.println(student instanceof Student);
        System.out.println(student instanceof HighStudent);

        Student student1 = new HighStudent();
        System.out.println(student1 instanceof Student);
        System.out.println(student1 instanceof HighStudent);
    }
    public static void main(String[] args) {
        // HighStudent highStudent = new HighStudent();
        // highStudent.printInterests(new String[]{});

        demoInstanceOf();
    }
}
