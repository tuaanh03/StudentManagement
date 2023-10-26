//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
//import java.util.List;
import java.util.Scanner;

 abstract class Student
{
    private int mssv;
    private String name;
    private String sex;
    private int birth;
    public Student(){
        mssv=0;
        name="";
        sex="";
        birth=0;
    }
    public Student(int mssv, String name, String sex, int birth)
    {
        this.mssv=mssv;
        this.name=name;
        this.sex=sex;
        this.birth=birth;
    }
    public int getMSSV()
    {
        return mssv;
    }
    public String getName()
    {
        return name;
    }
    public String getSex()
    {
        return sex;
    }
    public int getBirth()
    {
        return birth;
    }
    public void setMSSV(int mssv)
    {
        this.mssv=mssv;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setSex(String sex)
    {
        this.sex=sex;
    }
    public void setBirth(int birth)
    {
        this.birth=birth;
    }
    //--DOC DU LIEU TU FILE--------------

    public static ArrayList<Student> iStudents(String filePath)
    {
        ArrayList<Student> students= new ArrayList<Student>();
        try(BufferedReader f=new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = f.readLine()) != null) 
            {
                String[] data = line.split("\\s*,\\s*");
                Student student = new QLStudent();
                student.setMSSV(Integer.parseInt(data[0].trim()));
                student.setName(data[1].trim());
                student.setSex(data[2].trim());
                student.setBirth(Integer.parseInt(data[3].trim()));
                students.add(student);
            }
        }
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return students;
    }
    //-------------------------------------
    //----OUPUT VOI FILE-------------------
    public void output(ArrayList<Student> students) {
        System.out.println("MSSV\t\tName\t\tSex\t\tBirth");
        System.out.println("-----------------------------------------------------------");
        for (Student student : students) {
            System.out.printf("%-8d\t%-15s\t%-8s\t%-4d%n"/*xac dinh kich thuoc cot va can le */, student.getMSSV(), student.getName(), student.getSex(), student.getBirth());
        }
    }
    //------------------------------------
    //----DELETE 1 STUDENT----------------
    abstract public void DELETE(ArrayList<Student> a);
}
class QLStudent extends Student{
    public int point_avg;
    public QLStudent()
    {
        super();
        point_avg=0;
    }
    @Override public void DELETE(ArrayList<Student> a)
    {
          Scanner r=new Scanner(System.in);
        System.out.println("Enter student's mssv need delete:");
        int mssv=r.nextInt();
        Iterator<Student> i = a.iterator();//
        while (i.hasNext())
        {
        Student student = i.next();
        if (student.getMSSV() == mssv) {
            i.remove();
        }
    }
        r.close();
    }

}
public class Main{
public static void main(String agrs[])
{
    String filePath="dataStudent.txt";
    ArrayList<Student> students = Student.iStudents(filePath);
    Student student = new QLStudent();
    student.output(students);
    student.DELETE(students);
    student.output(students);
}
}