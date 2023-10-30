import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
// import java.util.Collections;
// import java.util.Scanner;

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
                                    // ten 
    public static ArrayList<Student> iStudents(String filePath)
    {
        ArrayList<Student> students= new ArrayList<Student>();
        try(BufferedReader f=new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = f.readLine()) != null) 
            {
                String[] data = line.split("\\s*,\\s*");// 1 line chuoi nen la dung String
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
    public static void output(ArrayList<Student> students) {
        System.out.println("MSSV\t\tName\t\tSex\t\tBirth");
        System.out.println("-----------------------------------------------------------");
        for (Student student : students) {
            System.out.printf("%-8d\t%-15s\t%-8s\t%-4d%n"/*xac dinh kich thuoc cot va can le */, student.getMSSV(), student.getName(), student.getSex(), student.getBirth());
        }
    }
    //------------------------------------
    //----DELETE 1 STUDENT----------------
    abstract public void DELETE(ArrayList<Student> a);
    abstract public void SEARCH(ArrayList<Student> a);
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
        r.nextLine();
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
//------- search 1 student-----
    @Override public  void SEARCH (ArrayList<Student>a)
    {
      
       Scanner r=new Scanner(System.in);
       System.out.println("");
       System.out.println("--------------Choose how to search ----------------");
       System.out.println("1. Student ID");
       System.out.println("2. Student name");
       
       System.out.print ("Enter choose : ");
       int choose=r.nextInt();
       
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
}
abstract class Level 
{
    
    public int Number;
    public int point;
    abstract public void arrangeGrade (ArrayList<Level> Level10,ArrayList<Level> Level11,ArrayList<Level> Level12);
    abstract public void arrangeMax(ArrayList<Level> Level10,ArrayList<Level> Level11,ArrayList<Level> Level12);
    abstract public void Input (ArrayList<Level> Level10,ArrayList<Level> Level11,ArrayList<Level> Level12);
    abstract public void Search (ArrayList<Level> Level10,ArrayList<Level> Level11,ArrayList<Level> Level12);
    abstract public void Repair (ArrayList<Level> Level10,ArrayList<Level> Level11,ArrayList<Level> Level12 );
    
  
   public Level()
   {
    Number =0;
    point =0;

   }


   public Level(int Number, int point)
   {
    this.Number=Number;
    this.point=point;
   }

    public int getNumber ()
    {
         return Number;
    }
     public int getpoint()
    {
         return point;
     }
    
    public void setNumber (int Number)
{
      this.Number=Number;

    }
    public void setpoint(int point)
    {
        this.point=point;
        
    }

   // doc du lieu khoi 10
   public static ArrayList<Level> isLevel(String filePath)
   {
        ArrayList<Level>Level10= new ArrayList<Level>();
        try(BufferedReader f =new BufferedReader(new FileReader(filePath))) {
             String line;
            while ((line=f.readLine())!=null)
            {
                String[] data=line.split("\\s*,\\s*"); 
                Level level10 =new QLLevel();
                level10.setNumber(Integer.parseInt(data[0].trim()));
                level10.setpoint(Integer.parseInt(data[1].trim()));
                Level10.add(level10);
            } 

        } 
        catch (Exception e)
        {
             System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        
        return Level10;
    }
       public void output(ArrayList<Level> Level10)
    {  
        
        System.out.println("Number\t\tPoint");
        System.out.println("----------------------");
        for (Level level10 : Level10) 
        {
            System.out.printf("%-8d\t%-4d%n"/*xac dinh kich thuoc cot va can le */, level10.getNumber() ,level10.getpoint());
        }
    }

       

}

 // quan ly khoi 
    class QLLevel extends Level 
{
    
    public int max10;
    public  int max11;
    public  int max12;
    public  int choose;
    public int id;

    QLLevel ()
    {
        max10=0;
        max11=0;
        max12=0;
    }
    
    QLLevel( int Number, int point , int max10, int max11, int max12, int choose,int id)
    {
        super(Number,point);
        this.max10=0;
        this.max11=0;
        this.max12=0;
        this.choose=0;
        id=0;


    }
     // tim diem cao nhat trong khoi
     @Override public void arrangeGrade (ArrayList<Level> Level10,ArrayList<Level> Level11,ArrayList<Level> Level12)
     {
        // max=level10[0]; arrylist khong duoc ho tro truy cap tung phan tu 
         max10 =Level10.get(0).getpoint();
        for ( Level level10 : Level10)
        {
             if ( max10 < level10.getpoint())
             {
                max10 =level10.getpoint();
                
             }
        } 
        System.out.println (" the point is the hightest in grade 10 :  " + max10);
         

        max11=Level11.get(0).getpoint();
        for ( Level level11 : Level11 )
        {
            if (max11 <level11.getpoint())
            {
                max11=level11.getpoint();
               
            }
            
        }
        System.out.println (" the point is the hightest in grade 11 :  " + max11);


        max12=Level12.get(0).getpoint();
        for ( Level level12 : Level12 )
        {
            if (max12 <level12.getpoint())
            {
                max12=level12.getpoint();
                
            }
        }
         System.out.println (" the point is the highest in grade 12 :  " + max12);

         
         
    }
    
    
    // sap xep diem cac khoi trong truong 
    @Override public void arrangeMax (ArrayList<Level> Level10,ArrayList<Level> Level11,ArrayList<Level> Level12)
         { 
          
           
        for ( Level level10 : Level10)
        {
             if ( max10 < level10.getpoint())
             {
                max10 =level10.getpoint();
                
             }
        } 
    
        max11=Level11.get(0).getpoint();
        for ( Level level11 : Level11 )
        {
            if (max11 <level11.getpoint())
            {
                max11=level11.getpoint();
               
            }
            
        }
    
        max12=Level12.get(0).getpoint();
        for ( Level level12 : Level12 )
        {
            if (max12 <level12.getpoint())
            {
                max12=level12.getpoint();
                
            }
        }
      
        if (max10 > max11 && max10 > max12)
        {
                 System.out.println ("The grade ranked first in school: " +max10);
                
                 if ( max11 >  max12)
                {
                System.out.println (" the grade ranked second in school : " +max11);
                }

                else if (  max12 > max11)
                {
                    System.out.println (" the grade ranked third in school : " +max12);
                }
                else if ( max11== max12)
                {
                    System.out.println ( " the grade 11 and the grade 12 have the same rank : " +max11);
                }

            }
            else if ( max11 > max10 && max11 >max12 )
            {
                System.out.println (" the point is the highest in school : " +max11);

                if ( max10 >  max12)
                {
                System.out.println (" the grade ranked second in school : " +max10);
                }

                else if (  max12 > max10)
                {
                    System.out.println (" the grade ranked third in school : " +max12);
                }
                else if ( max12== max10)
                {
                    System.out.println ( " the grade 10 and the grade 12 have the same rank : " +max10);
                }
        }
            else if  ( max12 > max10 && max12 > max11)
        {
                System.out.println (" the point is the highest in school : " +max12);

                 if ( max10 >  max11)
                {
                System.out.println (" the grade ranked second in school : " +max10);
                }

                else if (  max11 > max10)
                {
                    System.out.println (" the grade ranked third in school : " +max11);
                }
                else 
                {
                    System.out.println ( " the grade 11 and the grade 12 have the same rank : " +max11);
                }
        }
            
            else if ( max10 == max11 && max10 >max12 )
        {
                System.out.println ( " the grade 10 and the grade 11  have the first : " +max10);  
                System.out.println (" the grade 12 have second in school : " +max12);

        }
            else if ( max11 == max12 && max11 > max10)
        {
                System.out.println ( " the grade 11 and the grade 12  have the first : " +max11);  
                System.out.println (" the grade 10 ranked second in school : " +max10);

        }
            else if ( max10 == max12 && max10 > max11)
        {
                System.out.println ( " the grade 10 and the grade 12  have the first : " +max10);  
                System.out.println (" the grade 11 ranked second in school : " +max11);

        }
            else if ( max10 == max11 && max11==max12)
        {
                 System.out.println ( " the grade 10 and the grade 11 and the grade 12 have the same rank : " +max12);  
           
        }
            
     } 
     // ham menu lua chon 
     // 1 diem cao nhat trong khoi
     // 2 sap diem cac khoi trong truong
     @Override public void Input (ArrayList<Level> Level10,ArrayList<Level> Level11,ArrayList<Level> Level12)
    {
      QLLevel qllevel = new QLLevel();  
     Scanner w = new Scanner (System.in);
     System.out.println ("--------------- Choose the method you want to search for  --------------");
     System.out.println (" 1.The highest score in the grade");
     System.out.println (" 2.The arrange grades for grade in the school");
     System.out.print (" Enter choose : ");
     choose =w.nextInt();
  
     
     if (choose==1)
     {
          qllevel.arrangeGrade(Level10, Level11,Level12);
     }
     else if (choose==2)
     {
        qllevel.arrangeMax(Level10, Level11,Level12);
     }
     
     
    }


    @Override public void Search (ArrayList<Level> Level10,ArrayList<Level> Level11,ArrayList<Level> Level12)
    {
      
       Scanner w= new Scanner(System.in);
       System.out.println(" ---------- Search information by ID ------------");
       System.out.println (" Enter ID : ");
       id=w.nextInt();
       for (Level level10 : Level10)
       {
            if (id== level10.getNumber())
            {
                //   System.out.println (" Student of grade 10 ");
                // System.out.println("Number\t\tPoint");
                // System.out.println("----------------------");
               
                // System.out.printf("%-8d\t%-4d%n"/*xac dinh kich thuoc cot va can le */, level10.getNumber() ,level10.getpoint());
                super.output(Level10);
            }
       }
       for (Level level11 : Level11)
       {
           if (id==  level11.getNumber())
           {     
                //  System.out.println (" Student of grade 11 ");
                //  System.out.println("Number\t\tPoint");
                // System.out.println("----------------------");
                
                // System.out.printf("%-8d\t%-4d%n"/*xac dinh kich thuoc cot va can le */, level11.getNumber() ,level11.getpoint());
                super.output(Level11);
           }
       }

       for (Level level12:Level12)
       {
         if (id==level12.getNumber())
           {
                //  System.out.println (" Student of grade 12 ");
                //  System.out.println("Number\t\tPoint");
                // System.out.println("----------------------");
                
                // System.out.printf("%-8d\t%-4d%n"/*xac dinh kich thuoc cot va can le */, level12.getNumber() ,level12.getpoint());
                super.output(Level12);
           }
       }
      
    }
    @Override public void Repair (ArrayList<Level> Level10,ArrayList<Level> Level11,ArrayList<Level> Level12)
    {
         Scanner w= new Scanner(System.in);
         System.out.println (" ---------------Choose which grade information to edit: ---------------");
         System.out.println ("1.Grade 10 . ");
         System.out.println ("2.Grade 11 . ");
         System.out.println ("3.Grade 12 . ");
         System.out.println (" Enter choose :  ");
         choose=w.nextInt();
       
         if ( choose == 1 )
         {  
             
              System.out.println("-------------------------- Information of grade 10 ----------------");
              System.out.println("Number\t\tPoint");
              System.out.println("----------------------");
                for (Level level10 : Level10) 
                    {
                         System.out.printf("%-8d\t%-4d%n"/*xac dinh kich thuoc cot va can le */, level10.getNumber() ,level10.getpoint());
                    }
              
               System.out.println(" enter ID want edit : ");
               id=w.nextInt();     
             for (Level level10 : Level10)
             {            
                if (id ==level10.getNumber() )
                {
                    System.out.println (" Information grade 10 ");
                    System.out.println("Number\t\tPoint");
                    System.out.println("----------------------");
                    System.out.printf("%-8d\t%-4d%n"/*xac dinh kich thuoc cot va can le */, level10.getNumber() ,level10.getpoint());
                    System.out.println (" Start edit grade 10 ");
                    System.out.print(" Edit ID");
                    id= w.nextInt();
                    System.out.print (" edit point ");
                    int point = w.nextInt();
                    
                    level10.setNumber(id);
                    level10.setpoint(point);
                   

                     System.out.println("Updated Information:");
                     System.out.println("Number\t\tPoint");
                     System.out.println("----------------------");
                     
                     
                     System.out.printf("%-8d\t%-4d%n", level10.getNumber(), level10.getpoint());
                     System.out.println("Information updated successfully!");
                }
             }
        }

         else if ( choose ==2 )
        {
            System.out.println("-------------------------- Information of grade 11 ----------------");
              System.out.println("Number\t\tPoint");
              System.out.println("----------------------");
                for (Level level11 : Level11) 
                    {
                         System.out.printf("%-8d\t%-4d%n"/*xac dinh kich thuoc cot va can le */, level11.getNumber() ,level11.getpoint());
                    }
              
               System.out.println(" enter ID want edit : ");
               id=w.nextInt();     
             for (Level level11 : Level11)
             {            
                if (id ==level11.getNumber() )
                {
                    System.out.println (" Information grade 11 ");
                    System.out.println("Number\t\tPoint");
                    System.out.println("----------------------");
                    System.out.printf("%-8d\t%-4d%n"/*xac dinh kich thuoc cot va can le */, level11.getNumber() ,level11.getpoint());
                    System.out.println (" Start edit grade 11 ");
                    System.out.print(" Edit ID");
                    id= w.nextInt();
                    System.out.print (" edit point ");
                    int point = w.nextInt();
                    
                    level11.setNumber(id);
                    level11.setpoint(point);
                   

                     System.out.println("Updated Information:");
                     System.out.println("Number\t\tPoint");
                     System.out.println("----------------------");
                     
                     
                     System.out.printf("%-8d\t%-4d%n", level11.getNumber(), level11.getpoint());
                     System.out.println("Information updated successfully!");
                }
            }    

        }    
         else if ( choose ==3 )
        {
            System.out.println("-------------------------- Information of grade 12 ----------------");
              System.out.println("Number\t\tPoint");
              System.out.println("----------------------");
                for (Level level12 : Level12) 
                    {
                         System.out.printf("%-8d\t%-4d%n"/*xac dinh kich thuoc cot va can le */, level12.getNumber() ,level12.getpoint());
                    }
              
               System.out.println(" enter ID want edit : ");
               id=w.nextInt();     
             for (Level level12 : Level12)
             {            
                if (id ==level12.getNumber() )
                {
                    System.out.println (" Information grade 12 ");
                    System.out.println("Number\t\tPoint");
                    System.out.println("----------------------");
                    System.out.printf("%-8d\t%-4d%n"/*xac dinh kich thuoc cot va can le */, level12.getNumber() ,level12.getpoint());
                    System.out.println (" Start edit grade 12 ");
                    System.out.print(" Edit ID");
                    id= w.nextInt();
                    System.out.print (" edit point ");
                    int point = w.nextInt();
                    
                    level12.setNumber(id);
                    level12.setpoint(point);
                   

                     System.out.println("Updated Information:");
                     System.out.println("Number\t\tPoint");
                     System.out.println("----------------------");
                     
                     
                     System.out.printf("%-8d\t%-4d%n", level12.getNumber(), level12.getpoint());
                     System.out.println("Information updated successfully!");
                 }
            }    

        }  


    }
         

}

public class Main
{
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