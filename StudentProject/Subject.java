package StudentProject;
import java.util.Scanner;
public class Subject {
    
    private String name_SJ;
    private double pointGK_SJ;
    private double pointCK_SJ;
    private String ID_STUDENT;
    private double AVG;

    // Constructor
    public Subject(String ID_STUDENT, String name_SJ, double pointGK_SJ, double pointCK_SJ, double avg) {
        this.ID_STUDENT = ID_STUDENT;
        this.name_SJ = name_SJ;
        this.pointGK_SJ = pointGK_SJ;
        this.pointCK_SJ = pointCK_SJ;
        this.AVG=avg;
    }

    // Default constructor
    public Subject() {
        name_SJ = "";
        pointCK_SJ  = 0;
        pointGK_SJ  = 0;
        ID_STUDENT  = "";
        AVG=0;
    }
    

    public String getID_STUDENT(){
        return ID_STUDENT;
    }
    public String getName_SJ(){
        return name_SJ;
    }
    public double getPointGK_SJ(){
        return pointGK_SJ;
    }
    public double getPointCK_SJ(){
        return pointCK_SJ;
    }
    public double getAVG()
    {
        return AVG;
    }
    public void setAVG(double avg)
    {
        AVG=avg;
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
        sc.close();
    }
    

    public void output(){
        System.out.println("ID STUDENT: " + getID_STUDENT());
        System.out.println("Name Subject: " + getName_SJ());
        System.out.println("Point GK: " + getPointGK_SJ());
        System.out.println("Point CK: " + getPointCK_SJ());
    }
    public double pointAVG()
    {
        return (getPointGK_SJ()+2*getPointCK_SJ())/3;
    }
}