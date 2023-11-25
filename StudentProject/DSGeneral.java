package StudentProject;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class DSGeneral {
    // final private String studentUsername = "student123";
    // final private String studentPassword = "123456789";
    // final private String teacherUsername = "teacher123";
    // final private String teacherPassword = "123456789";
    final private String adminUsername = "admin123";
    final private long adminPassword = 123456789;

    // gọi các class đã khởi tạo ra để sử dụng chung. Tác dụng để tránh việc đọc
    // file lại lần thứ 2
    DSStudent stu = new DSStudent("StudentFile.txt");
    QLTeacher tea = new QLTeacher("TeacherFile.txt");
    DSCLASS a = new DSCLASS("StudentClass.txt");

    ArrayList<Student> newArr = new ArrayList<>();

    public void clrscr() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    // public DSGeneral()
    // {
    // DSCLASS a=new DSCLASS("StudentClass.txt");
    // DSStudent b=new DSStudent("StudentFile.txt");
    // DSSubject c=new DSSubject("SubjectFile.txt");
    // QLTeacher d=new QLTeacher("TeacherFile.txt");
    // }

    

    public void user(String id) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. View study results");
            System.out.println("2. See the school year's payroll");
            System.out.println("3. View tuition");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    a.show_tuition(id);
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
        sc.close();
    }

    public void teacher() {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. View student list");
            System.out.println("2. View study results list");
            System.out.println("3. Edit student list");
            System.out.println("4. Edit study results list");
            System.out.println("5. Save all edits");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {               
                    stu.show();
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    stu.input();
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
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
        sc.close();
    }

    public void admin() {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Student management");
            System.out.println("2. Teacher management");
            System.out.println("3. Class management");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    stu.input();
                    break;
                }
                case 2: {
                    tea.input();
                    break;
                }
                case 3: {
                    a.menu();
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
        sc.close();
    }

    public void login_account() {

        loginAccount UA = new loginAccount();

        UA.input();

        String username = UA.getID_USER();
        long password = UA.getPASSWORD();

        if (stu.loginStudent(username, password) == 1) {
            clrscr();
            user(UA.getID_USER());
        }

        if (tea.loginTeacher(username, password) == 1) {
            clrscr();
            teacher();
        }
        if (UA.getID_USER().equals(adminUsername) && UA.getPASSWORD() == adminPassword) {
            clrscr();
            admin();
        }

    }

}
