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

public class QLTeacher implements Function{
    static List<Teacher> teacherList = new ArrayList<Teacher>();
public QLTeacher(String filePath)
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
                Teacher tea = new Teacher();
                String[] arr = line.split(",");// 1 line chuoi nen la dung String
                tea.setName(arr[0].trim());
                tea.setBirth(arr[1].trim());
                tea.setAddress(arr[2].trim());
                tea.setGender(Integer.parseInt(arr[3].trim()));
                tea.setMail(arr[4].trim());
                tea.setPhoneNumber(Integer.parseInt(arr[5].trim()));
                tea.setID_GV(arr[6]);
                tea.setID_CLASS(arr[7]);
                teacherList.add(tea);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
}
    public void add() {
        Teacher tea = new Teacher();
        tea.input();
        teacherList.add(tea);
    }

    public void show() {
        for (Teacher stu : teacherList) {
            stu.output();
            System.out.println("-----------***----------");
        }
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        int check = 0;
        System.out.println("Enter name or ID Teacher you want to delete");
        String find = sc.nextLine();
        List<Teacher> teachersToDelete = new ArrayList<Teacher>();

        for ( Teacher tea : teacherList) {
            if (find.equals(tea.getID_GV()) || find.equals(tea.getName())) {
                teachersToDelete.add(tea);
                check = 1;
            }
        }

        if (check == 1) {
            teacherList.removeAll(teachersToDelete);
            System.out.println("Teacher(s) deleted successfully.");
        } else {
            System.out.println("Teacher not found.");
        }
    }

    public void search() {
        int check = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name or ID of teacher: ");
        String find = sc.nextLine();

        for (Teacher st : teacherList) {
            if (find.equals(st.getName()) || find.equals(st.getID_GV())) {
                check = 1;
                System.out.println("Teacher found successfully!");
                st.output();
            }
        }

        if (check == 0) {
            System.out.println("Teacher not found.");
        }
    }

    public void modify() {
        int check = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name or ID of teacher: ");
        String find = sc.nextLine();

        for (Teacher st : teacherList) {
            if (find.equals(st.getName()) || find.equals(st.getID_GV())) {
                check = 1;
                System.out.println("Looking for teacher successfully!");
                st.input();
            }
        }

        if (check == 0) {
            System.out.println("Teacher not found.");
        }
    }


    public void SaveData(String filepath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            for (Teacher st : teacherList) {
                writer.write(st.getName() + "," + st.getBirth() + "," + st.getAddress() + "," + st.isGender() + ","
                        + st.getMail() + "," + st.getPhoneNumber() + "," + st.getID_GV() + "," + st.getID_CLASS());
                writer.newLine();
            }
            System.out.println("Save File Successful");
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

    public int loginTeacher(String username, String password)
    {
        for (Teacher tea : teacherList)
        {
            if (username.equals(tea.getMail()) && password.equals(tea.getID_GV()))
            {
                return 1;
            }
        }
        return 0;
    }

    public void input() {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Add Teacher");
            System.out.println("2. Delete Teacher");
            System.out.println("3. Search Teacher");
            System.out.println("4. Modify Teacher");
            System.out.println("5. Display Teachers");
            System.out.println("6. Load From File");
            System.out.println("7. Save From File");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    add();
                    break;
                }
                case 2: {
                    delete();
                    break;
                }
                case 3: {
                    search();
                    break;
                }
                case 4: {
                    modify();
                    break;
                }
                case 5: {
                    show();
                    break;
                }
                case 7: {
                    SaveData("TeacherFile.txt");
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
