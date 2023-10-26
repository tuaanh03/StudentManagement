//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Scanner;
public class Student
{
    private int choose;
    private int mssv;
    private String name;
    private String sex;
    private int birth;
    public Student(){
        mssv=0;
        name="";
        sex="";
        birth=0;
        choose=0;
    }
    public Student(int mssv, String name, String sex, int birth)
    {
        this.mssv=mssv;
        this.name=name;
        this.sex=sex;
        this.birth=birth;
        this.choose=choose;
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
    public int choose()
    {
        return choose;
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
    public void setChoose(int choose)
    {
        this.choose=choose;
    }
    //--DOC DU LIEU TU FILE--------------
    public static ArrayList<Student> iStudents(String filePath)
    {
        // ArryList<Tên Kiểu dữ liệu> tên ArryList= new ArryList < Tên kiểu dữ liệu>();
        ArrayList<Student> students= new ArrayList<Student>();// tao mang de luu cac doi tuong
        // try dẻ kiem tra doc du lieu 
        // doc du tu file filePath
        try(BufferedReader f=new BufferedReader(new FileReader(filePath)))
        {
            // doc du lieu tu tap tin theo dong cho den khi het du lieu
            String line;
            while ((line = f.readLine()) != null) 
            {
                String[] data = line.split("\\s*,\\s*");// tach dong van bang theo tung phan
                Student student = new Student();// tao doi tuong moi cho moi dong
                student.setMSSV(Integer.parseInt(data[0].trim()));// trim khoa bo khoang trang truoc sau so// chuyen tu chuoi sang so nguyen
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
    public void DELETE(ArrayList<Student> a)
    {
        Scanner r=new Scanner(System.in);
        System.out.println("Enter student's mssv need delete:");
        int mssv=r.nextInt();
        Iterator<Student> i = a.iterator();// duyet qua cac phan tu
        while (i.hasNext())
        {
        Student student = i.next();
        if (student.getMSSV() == mssv) {
            i.remove();
        }
    }
       
    }
    //------- search 1 student-----
    public  void SEARCH (ArrayList<Student>a)
    {
      
       Scanner r=new Scanner(System.in);
       System.out.println("");
       System.out.println("--------------Choose how to search ----------------");
       System.out.println("1. Student ID");
       System.out.println("2. Student name");
       System.out.print ("Enter choose : ");
       choose=r.nextInt();

       if (choose==1)
       {
         System.out.println ("Enter student's mssv need search : ");
         int mssv=r.nextInt();
          Iterator<Student> i =a.iterator();
         while (i.hasNext())// i.hasNext con phan tu khong
          {
             Student student=i.next();
            if (student.getMSSV()==mssv)
            {
         
               System.out.println("MSSV\t\tName\t\tSex\t\tBirth");
               System.out.println("-----------------------------------------------------------");
               System.out.printf("%-8d\t%-15s\t%-8s\t%-4d%n"/*xac dinh kich thuoc cot va can le */, student.getMSSV(), student.getName(), student.getSex(), student.getBirth());
        
            }
    
          }
       }
       else if (choose==2)
       {
              r.nextLine();
              System.out.print ("Enter student's name need search :");
              String name = r.nextLine();
               Iterator<Student> i =a.iterator();
         while (i.hasNext())// i.hasNext con phan tu khong
          {
             Student student=i.next();
            if (student.getName().equals(name))
            {
         
               System.out.println("MSSV\t\tName\t\tSex\t\tBirth");
               System.out.println("-----------------------------------------------------------");
               System.out.printf("%-8d\t%-15s\t%-8s\t%-4d%n"/*xac dinh kich thuoc cot va can le */, student.getMSSV(), student.getName(), student.getSex(), student.getBirth());
        
            }
    
          }
       }

      r.close();

    }
public static void main(String agrs[])
{
    String filePath=("C:\\Users\\THAM\\Downloads\\dataStudent.txt");
    ArrayList<Student> students = iStudents(filePath);
    Student student = new Student();
    student.output(students);
    student.DELETE(students);
    student.output(students);
    student.SEARCH(students);
}
}