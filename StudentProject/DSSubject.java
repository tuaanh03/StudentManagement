package StudentProject;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DSSubject implements Function {

    public DSSubject() {
    }

    static ArrayList<Subject> subjectList = new ArrayList<Subject>();

    public DSSubject(String filePath) {
        FileInputStream fis = null;
        InputStreamReader reade = null;
        BufferedReader reader = null;

        try {
            fis = new FileInputStream(filePath);
            reade = new InputStreamReader(fis, StandardCharsets.UTF_8);
            reader = new BufferedReader(reade);
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
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
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
             
public ArrayList<Subject> is_SubList()
{
    return subjectList;
}
    public void SaveData(String f) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
            for (Subject sb : subjectList) {
                writer.write(sb.getID_STUDENT() + "," + sb.getName_SJ() + "," + sb.getPointGK_SJ() + ","
                        + sb.getPointCK_SJ());
                writer.newLine();
            }
            System.out.println("Read File Successful");
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }
    public void add() {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Adding a new subject:");
        System.out.println("--------------------------------------------------------------");
        Subject newSubject = new Subject();
        newSubject.input();
    
        // Kiểm tra xem môn học đã tồn tại trong danh sách hay chưa
        if (!isSubjectExists(newSubject)) {
            subjectList.add(newSubject);
            System.out.println("Subject added successfully.");
        } else {
            System.out.println("Subject with ID " + newSubject.getID_STUDENT() + " already exists. Skipping addition.");
        }
    }
    
    // Phương thức kiểm tra xem môn học đã tồn tại hay chưa
    private boolean isSubjectExists(Subject newSubject) {
        for (Subject existingSubject : subjectList) {
            if (existingSubject.getID_STUDENT().equals(newSubject.getID_STUDENT())) {
                return true; // Môn học đã tồn tại
            }
        }
        return false; // Môn học chưa tồn tại
    }


    
        
    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID_STUDENT of the subject to delete:");
        String ID = sc.nextLine();
        List<Subject> subjectDelete = new ArrayList<>();
        for (Subject sb : subjectList) {
            if (sb.getID_STUDENT().equals(ID)) 
            {
                                  // add thằng thuộc tính muns xóa vào dsach list
                subjectDelete.add(sb);
            }
        }
        if (!subjectDelete.isEmpty()) {
            System.out.println("Subjects with ID_STUDENT " + ID + ":");
            for (int i = 0; i < subjectDelete.size(); i++) 
            {
                System.out.println((i + 1) + ". " + subjectDelete.get(i).getName_SJ());
            }
            System.out.println("Enter the number of the subject to delete:");
            int choice = sc.nextInt();
            if (choice >= 1 && choice <= subjectDelete.size())
            {
                Subject Remove = subjectDelete.get(choice - 1);
                subjectList.remove(Remove);
                System.out.println("Subject with ID_STUDENT " + ID + " deleted successfully!");
            } else {
                System.out.println("Invalid choice. No subject deleted.");
            }
            sc.close();
        } else {
            System.out.println("No subjects found with ID_STUDENT " + ID);
        }
    }
      
    
    public void modify() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID_STUDENT of the subject to modify:");
        String ID = sc.nextLine();
        ArrayList<Subject> subjectModify = new ArrayList<>();
        for (Subject sb : subjectList) {
            if (sb.getID_STUDENT().equals(ID)) {
                subjectModify.add(sb);
            }
        }
        if (!subjectModify.isEmpty()) {
            System.out.println("Subjects found for student with ID_STUDENT " + ID + ":");
            for (int i = 0; i < subjectModify.size(); i++) {
                System.out.println((i + 1) + ". " + subjectModify.get(i).getName_SJ());
            }
            System.out.println("Enter the number corresponding to the subject you want to modify:");
            int subjectNumber = sc.nextInt();
            if (subjectNumber >= 1 && subjectNumber <= subjectModify.size()) {
                Subject subjectToModify = subjectModify.get(subjectNumber - 1);
                System.out.println("Modifying subject: " + subjectToModify.getName_SJ());
                // Prompt user for new pointGK and pointCK
                System.out.println("Enter new pointGK for the subject:");
                double newPointGK = sc.nextDouble();

                System.out.println("Enter new pointCK for the subject:");
                double newPointCK = sc.nextDouble();

                // Update the points for the subjecttoModify
                subjectToModify.setpointGK_SJ(newPointGK);
                subjectToModify.setpointCK_SJ(newPointCK);

                System.out.println("Subject with ID_STUDENT " + ID + " modified successfully!");

            } else {
                System.out.println("Invalid subject number entered.");
            }
        } else {
            System.out.println("No subjects found for student with ID_STUDENT " + ID);
        }
        show();
    }

    public void show() {
        System.out.println("+-----------------+-----------------+-----------------+-----------------+");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s |\n", "ID_STUDENT", "Name_SJ", "PointGK", "PointCK");
        System.out.println("+-----------------+-----------------+-----------------+-----------------+");
        for (Subject sb : subjectList) {
            System.out.printf("| %-15s | %-15s | %-15s | %-15s |\n", sb.getID_STUDENT(), sb.getName_SJ(), sb.getPointGK_SJ(),
                    sb.getPointCK_SJ());
        }
        System.out.println("+-----------------+-----------------+-----------------+-----------------+");
    }

    public void search() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Search students' point by subject: ");
        String subject = sc.nextLine();

        System.out.println("Subject: " + subject);

        System.out.printf("| %-15s | %-15s | %-15s | %-15s |\n", "ID_STUDENT", "Name_SJ", "PointGK", "PointCK");
        System.out.println("+-----------------+-----------------+-----------------+-----------------+");
        for (Subject sb : subjectList) {
            if (subject.equals(sb.getName_SJ())) {
                System.out.printf("| %-15s | %-15s | %-15s | %-15s |\n", sb.getID_STUDENT(), sb.getName_SJ(), sb.getPointGK_SJ(),sb.getPointCK_SJ());
            }
        }
        System.out.println("+-----------------+-----------------+-----------------+-----------------+");

    }

    public void output() {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Add Subject");
            System.out.println("2. Delete Subject");
            System.out.println("3. Modify Point");
            System.out.println("4. Show Subject");
            System.out.println("5. Save From File");
            System.out.println("6. Search"); 
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
                    modify();
                    System.out.print("\n");
                    break;
                }
                case 4: {
                    show();
                    break;
                }
                case 5: {
                    SaveData("SubjectFile.txt");
                    break;
                }

                case 6: {
                    search();
                    System.out.print("\n");
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
   
}