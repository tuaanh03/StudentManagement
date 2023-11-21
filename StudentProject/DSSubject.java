package StudentProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DSSubject implements Function 
{

    public ArrayList<Subject> subjectList=new ArrayList<>();
    public DSSubject (String filePath)
    {
        
        FileInputStream fis = null;
        InputStreamReader reade = null;
        BufferedReader reader = null;

        try  {
            fis = new FileInputStream(filePath);
            reade = new InputStreamReader(fis, StandardCharsets.UTF_8);
            reader = new BufferedReader(reade);
            String line = null;
            while ((line = reader.readLine())  != null) {
                if (line.isEmpty())
                {
                    continue;
                }
                Subject sb = new Subject();
                String[] arr = line.split(",");// 1 line chuoi nen la dung String
                sb.setID_STUDENT(arr[0].trim());
                sb.setname_SJ(arr[1].trim());
                sb.setpointGK_SJ(Double.parseDouble(arr[2].trim()));
                sb.setpointCK_SJ(Double.parseDouble(arr[3].trim()));
                subjectList.add(sb);
            }
            System.out.println("Read File Successful");
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }


    public void SaveData(String f) {
        System.out.println();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
            for (Subject sb : subjectList) {
                writer.write(sb.getID_STUDENT() + "," + sb.getname_SJ() + "," + sb.getpointGK_SJ() + "," + sb.getpointCK_SJ());
                writer.newLine();
            }
            System.out.println("Read File Successful");
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }
    
    //  public static ArrayList<Subject> ReadData(String f) {

    //     FileInputStream fis = null;
    //     InputStreamReader reade = null;
    //     BufferedReader reader = null;

    //     try  {
    //         fis = new FileInputStream("StudentManagement/StudentProject/SubjectFile.txt");
    //         reade = new InputStreamReader(fis, StandardCharsets.UTF_8);
    //         reader = new BufferedReader(reade);
    //         String line = null;
    //         while ((line = reader.readLine())  != null) {
    //             if (line.isEmpty())
    //             {
    //                 continue;
    //             }
    //             Subject sb = new Subject();
    //             String[] arr = line.split(",");// 1 line chuoi nen la dung String
    //             sb.setID_STUDENT(arr[0].trim());
    //             sb.setname_SJ(arr[1].trim());
    //             sb.setpointGK_SJ(Double.parseDouble(arr[2].trim()));
    //             sb.setpointCK_SJ(Double.parseDouble(arr[3].trim()));
    //             subjectList.add(sb);
    //         }
    //         System.out.println("Read File Successful");
    //         reader.close();
    //     } catch (Exception e) {
    //         System.out.println("An error occurred: " + e.getMessage());
    //     }
    //     return subjectList ;
    // }

    public void add() {
        Scanner sc = new Scanner(System.in);
        char addSubject;
        do {
            Subject sb = new Subject();
            sb.input();
            subjectList.add(sb);
            System.out.println("Do you want to add another subject? (y/n): ");
            addSubject = sc.next().charAt(0); //lấy kí tự đầu tiên khi nguoi dung nhập yes/no
        } while (addSubject == 'y' || addSubject == 'Y');
    
        System.out.println("List of added subjects:");
        for (Subject sub : subjectList) {
            System.out.println(sub);
        }
        SaveData("StudentManagement/StudentProject/SubjectFile.txt");
        show();

    }
    public void delete() {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the ID_STUDENT of the subject to delete:");
        String ID = sc.nextLine();
    
        
        List<Subject> subjectDelete = new ArrayList<>();
        for (Subject sb : subjectList) {
            if (sb.getID_STUDENT().equals(ID)) {
                subjectDelete.add(sb);
            }
        }
    
        if (!subjectDelete.isEmpty()) {
            
            System.out.println("Subjects with ID_STUDENT " + ID + ":");
            for (int i = 0; i < subjectDelete.size(); i++) {
                System.out.println((i + 1) + ". " + subjectDelete.get(i).getname_SJ());
            }
    
            System.out.println("Enter the number of the subject to delete:");
            int choice = sc.nextInt();
    
            if (choice >= 1 && choice <= subjectDelete.size()) {
                Subject Remove = subjectDelete.get(choice - 1);
                subjectList.remove(Remove);
                System.out.println("Subject with ID_STUDENT " + ID + " deleted successfully!");
            } else {
                System.out.println("Invalid choice. No subject deleted.");
            }
        } else {
            System.out.println("No subjects found with ID_STUDENT " + ID);
        }
    
    }
    

public void modify() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the ID_STUDENT of the subject to modify:");
    String ID = sc.nextLine();
    ArrayList<Subject> subjectModify = new ArrayList<>();

    // Iterate through the subjectList to find subjects for the given ID
    for (Subject sb : subjectList) {
        if (sb.getID_STUDENT().equals(ID)) {
            subjectModify.add(sb);
        }
    }

    if (!subjectModify.isEmpty()) {
        System.out.println("Subjects found for student with ID_STUDENT " + ID + ":");
        for (int i = 0; i < subjectModify.size(); i++) {
            System.out.println((i + 1) + ". " + subjectModify.get(i).getname_SJ());
        }

        System.out.println("Enter the number corresponding to the subject you want to modify:");
        int subjectNumber = sc.nextInt();

        if (subjectNumber >= 1 && subjectNumber <= subjectModify.size()) {
            Subject subjecttoModify = subjectModify.get(subjectNumber - 1);
            System.out.println("Modifying subject: " + subjecttoModify.getname_SJ());
            // Prompt user for new pointGK and pointCK
            System.out.println("Enter new pointGK for the subject:");
            double newPointGK = sc.nextDouble();

            System.out.println("Enter new pointCK for the subject:");
            double newPointCK = sc.nextDouble();

            // Update the points for the subjecttoModify
            subjecttoModify.setpointGK_SJ(newPointGK);
            subjecttoModify.setpointCK_SJ(newPointCK);

            System.out.println("Subject with ID_STUDENT " + ID + " modified successfully!");
        } else {
            System.out.println("Invalid subject number entered.");
        }
    } else {
        System.out.println("No subjects found for student with ID_STUDENT " + ID);
    }

    show();
   
}



public void show ()
  {
    System.out.printf("%-15s%-15s%-15s%-20s\n" , "ID_STUDENT", "Name_SJ", "PointGK", "PointCK");
    System.out.println("-----------------------------------------------------------");
    for (Subject sb : subjectList) 
    {    
      System.out.printf("%-15s%-15s%-15s%-20s", sb.getID_STUDENT(),sb.getname_SJ() ,sb.getpointGK_SJ(), sb.getpointCK_SJ());
    } 
    System.out.print("\n"); 
    System.out.println("-----------------------------------------------------------");
  }
    
  public void search() {
    Scanner sc= new Scanner(System.in);
    System.out.print("Enter the subject which you want search : ");
    String subject="";
    double average=0;
    for (Subject sb : subjectList) {
        if(sb.getname_SJ().equals(subject))
        {
            average = calculateAverage(sb);
            System.out.println("Average of student have id " + sb.getID_STUDENT() + " in " + sb.getname_SJ() + " is " + String.format("%.2f", average));
        }
    if (average > sb.gethighestAverage()) {
        sb.sethighestAverage(average);
        sb.setStudentWithHighestAverage(sb.getID_STUDENT() + " " + sb.getname_SJ());
    }

    if (sb.getStudentWithHighestAverage() != null) {
        System.out.println("Student have the highest point in  " + sb.getname_SJ() + ": ID " + sb.getStudentWithHighestAverage());
    } else {
        System.out.println("Don't find the subject have name " + sb.getname_SJ() + ".");
    }
        }
}







    public double calculateAverage(Subject subject) {
        return (subject.getpointGK_SJ() + (subject.getpointCK_SJ() * 2)) / 3.0;
    }
  
    
    public void output(){
        int choice;
        Scanner sc = new Scanner(System.in);
        do 
        {
            System.out.println("1. Add Subject");
            System.out.println("2. Delete Subject");
            System.out.println("3. Search Student have Subject Max");
            System.out.println("4. Modify Point");
            System.out.println("5. Show Subject");
            System.out.println("6. Read From File");
            System.out.println("7. Save From File");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    add();
                    System.out.print("\n"); 
                    break;
                }
                case 2: {
                    delete();
                    System.out.print("\n"); 
                    break;
                }
                case 3: {
                    search();
                    System.out.print("\n"); 
                    break;
                }
                case 4: {
                    modify();
                    System.out.print("\n"); 
                    break;
                }
                case 5: {
                    show();
                    break;
                }
                case 6: {
                    System.out.print("\n"); 
                    System.out.println("-----------------------------------------------------------");
                    break;
                }

                case 7: {
                    SaveData("StudentManagement/StudentProject/SubjectFile.txt");
                    break;
                }

                case 0: {
                    System.out.println("Thanks for using!");
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                    break;
                }
            }
        } while (choice != 0);
    }
    public static void main(String[] args) {
        DSSubject a=new DSSubject("SubjectFile.txt");
        a.show();
    }
 }