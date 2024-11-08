package ml.java.se.oob.method;

public class Student {

    private String name;

    private Integer age;

    private int familyMemberNums = 3;


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", familyMemberNums=" + familyMemberNums +
                '}';
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("name is " + name);
    }

    public void setFamilyMemberNums(int familyMemberNums) {
        this.familyMemberNums = familyMemberNums;
        System.out.println("familyMemberNums is " + familyMemberNums);
    }

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s);

        s.setName(null);
        System.out.println(s);

        // compile error
        // s.setFamilyMemberNums(null);
        System.out.println(s);
    }

}
