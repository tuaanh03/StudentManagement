package StudentProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DSKQHT {
    public static ArrayList<KQHT> resultList = new ArrayList<>();
    public void add() 
    {
        KQHT result = new KQHT();
        result.input();
        resultList.add(result);
    }

    public void show() {
        for (Student stu : studentList) {
            stu.output();
            System.out.println("-----------***----------");
        }
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        int check = 0;
        System.out.println("Enter name or ID Student you want to delete");
        String find = sc.nextLine();
        List<Student> studentsToDelete = new ArrayList<Student>();

        for (Student st : studentList) {
            if (find.equals(st.getID_STUDENT()) || find.equals(st.getName())) {
                studentsToDelete.add(st);
                check = 1;
            }
        }

        if (check == 1) {
            studentList.removeAll(studentsToDelete);
            System.out.println("Student(s) deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void search() {
        int check = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name or ID of student: ");
        String find = sc.nextLine();

        for (Student st : studentList) {
            if (find.equals(st.getName()) || find.equals(st.getID_STUDENT())) {
                check = 1;
                System.out.println("Student found successfully!");
                st.output();
            }
        }

        if (check == 0) {
            System.out.println("Student not found.");
        }
    }

    public void modify() {
        int check = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name or ID of student: ");
        String find = sc.nextLine();

        for (Student st : studentList) {
            if (find.equals(st.getName()) || find.equals(st.getID_STUDENT())) {
                check = 1;
                System.out.println("Looking for student successfully!");
                st.input();
            }
        }

        if (check == 0) {
            System.out.println("Student not found.");
        }
    }

    public static ArrayList<Student> ReadData(String filePath) {

        FileInputStream fis = null;
        InputStreamReader reade = null;
        BufferedReader reader = null;

        try  {
            fis = new FileInputStream("StudentFile.txt");
            reade = new InputStreamReader(fis, StandardCharsets.UTF_8);
            reader = new BufferedReader(reade);
            String line = null;
            while ((line = reader.readLine())  != null) {
                if (line.isEmpty())
                {
                    continue;
                }
                Student stu = new Student();
                String[] arr = line.split(",");// 1 line chuoi nen la dung String
                stu.setName(arr[0].trim());
                stu.setBirth(arr[1].trim());
                stu.setAddress(arr[2].trim());
                stu.setGender(Integer.parseInt(arr[3].trim()));
                stu.setMail(arr[4].trim());
                stu.setPhoneNumber(Integer.parseInt(arr[5].trim()));
                stu.setID_STUDENT(arr[6]);
                stu.setGrade(Integer.parseInt(arr[7].trim()));
                stu.setStudentClass(arr[8]);
                studentList.add(stu);
            }
            System.out.println("Read File Successful");
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return studentList;
    }

    public void SaveData(String filepath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            for (Student st : studentList) {
                writer.write(st.getName() + "," + st.getBirth() + "," + st.getAddress() + "," + st.isGender() + ","
                        + st.getMail() + "," + st.getPhoneNumber() + "," + st.getID_STUDENT() + "," + st.getGrade()
                        + "," + st.getStudentClass());
                writer.newLine();
            }
            System.out.println("Read File Successful");
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

}