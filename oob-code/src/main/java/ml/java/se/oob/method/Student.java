package ml.java.se.oob.method;

public class Student {

    private String name;

    private Integer age;

    private int sClass = 1;


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sClass=" + sClass +
                '}';
    }

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s);
    }

}
