package StudentProject;

import java.io.Serializable;
import java.util.*;

public class Student extends People implements Serializable{
    private String ID_STUDENT;
    private String Grade;
    private String StudentClass;

    
    public Student(String name, String birth, String address, int gender, String mail, int phoneNumber,
            String iD_STUDENT, String grade, String studentClass) {
        super(name, birth, address, gender, mail, phoneNumber);
        ID_STUDENT = iD_STUDENT;
        Grade = grade;
        StudentClass = studentClass;
    }
    
    public Student()
    {
        super();
        ID_STUDENT = "";
        Grade = "";
        StudentClass = "";
    }
    

    public void setStudentClass(String studentClass) {
        StudentClass = studentClass;
    }

    public String getID_STUDENT() {
        return ID_STUDENT;
    }

    public void setID_STUDENT(String iD_STUDENT) {
        ID_STUDENT = iD_STUDENT;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getStudentClass() {
        return StudentClass;
    }

    public void setClass(String class1) {
        StudentClass = class1;
    }

    public void input()
    {
        Scanner sc = new Scanner(System.in);
        super.input();

        System.out.println("Enter ID_Student: ");
        ID_STUDENT = sc.nextLine();
        

        System.out.println("Enter Student'Grade: ");
        Grade = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter Student'Class: ");
        StudentClass = sc.nextLine();
        
    }

    public void output()
    {
        super.output();
        System.out.println("ID Student: " + getID_STUDENT());
        System.out.println("Grade: " + getGrade());
        System.out.println("Class: " + getStudentClass());
        
    }

}

