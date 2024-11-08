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

    protected void printInterests(String[] interests) {
        for (String interest : interests) {
            System.out.println(interest);
        }
    }



}
