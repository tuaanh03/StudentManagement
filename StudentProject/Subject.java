package StudentProject;
import java.util.Scanner;
public class Subject {
    
    private String name_SJ;
    private double pointGK_SJ;
    private double pointCK_SJ;
    private String ID_STUDENT;
    private double highestAverage;
    private String studentWithHighestAverage;

    // Constructor
    public Subject(String ID_STUDENT, String name_SJ, double pointGK_SJ, double pointCK_SJ) {
        this.ID_STUDENT = ID_STUDENT;
        this.name_SJ = name_SJ;
        this.pointGK_SJ = pointGK_SJ;
        this.pointCK_SJ = pointCK_SJ;
    }

    // Default constructor
    public Subject() {
        name_SJ = "";
        pointCK_SJ  = 0;
        pointGK_SJ  = 0;
        ID_STUDENT  = "";
    }
    

    public String getID_STUDENT(){
        return ID_STUDENT;
    }
    public String getname_SJ(){
        return name_SJ;
    }
    public double getpointGK_SJ(){
        return pointGK_SJ;
    }
    public double getpointCK_SJ(){
        return pointCK_SJ;
    }
    public double gethighestAverage() {
        return highestAverage;
    }
    public String getStudentWithHighestAverage() {
        return studentWithHighestAverage;
    }


    public void setID_STUDENT(String ID_STUDENT){
        this.ID_STUDENT = ID_STUDENT;
    }
    public void setname_SJ(String name_SJ){
        this.name_SJ = name_SJ;
    }
    public void setpointGK_SJ(double pointGK_SJ){
        this.pointGK_SJ = pointGK_SJ;
    }
    public void setpointCK_SJ(double pointCK_SJ){
        this.pointCK_SJ = pointCK_SJ;
    }
    public void sethighestAverage(double highestAverage) {
        this.highestAverage = highestAverage;
    }
    public void setStudentWithHighestAverage(String studentWithHighestAverage) {
        this.studentWithHighestAverage = studentWithHighestAverage;
    }



   
    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Id student : ");
        ID_STUDENT = sc.nextLine();

        System.out.print("Enter Name subject : ");
        name_SJ = sc.nextLine();

        System.out.print("Enter Point GK : ");
        pointGK_SJ = sc.nextDouble();

        System.out.print("Enter Point CK : ");
        pointCK_SJ = sc.nextDouble();
    }
    

    public void output(){
        System.out.println("ID STUDENT: " + getID_STUDENT());
        System.out.println("Name Subject: " + getname_SJ());
        System.out.println("Point GK: " + getpointGK_SJ());
        System.out.println("Point CK: " + getpointCK_SJ());
    }

    public double getHighestAverage() {
        return 0;
    }

}