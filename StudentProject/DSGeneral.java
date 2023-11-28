package StudentProject;

import java.io.IOException;
import java.util.Scanner;

public class DSGeneral {

    final private String adminUsername = "admin123";
    final private long adminPassword = 123456789;

    DSStudent stu = new DSStudent("StudentFile.txt");
    QLTeacher tea = new QLTeacher("TeacherFile.txt");
    DSSubject sub = new DSSubject("SubjectFile.txt");
    DSCLASS a = new DSCLASS("StudentClass.txt");
    KQHT kq = new KQHT();

    public static void clrscr()
	{
		try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
	}

    public void user(String id) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. View study results");
            System.out.println("2. View tuition");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    clrscr();
                    kq.studyResultByID(id);
                    break;
                }
                case 2: {
                    clrscr();
                    a.show_tuition(id, stu.is_stuList());
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
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    clrscr();
                    stu.show();
                    break;
                }
                case 2: {
                    clrscr();
                    kq.menu();
                    break;
                }
                case 3: {
                    clrscr();
                    stu.input();
                    break;
                }
                case 4: {
                    clrscr();
                    sub.output();
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
                        kq.menu();
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
        int check = 0;
        int loginAttempts = 0; 
        final int maximumlogin = 3; 
    
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\tWelcome to Student Manage System");
        do {
            loginAccount UA = new loginAccount();
            UA.input();
    
            String username = UA.getID_USER();
            long password = UA.getPASSWORD();
    
            if (stu.loginStudent(username, password) == 1) {
                clrscr();
                user(UA.getID_USER());
                check = 1;
            } 
            else if (tea.loginTeacher(username, password) == 1) {
                clrscr();
                teacher();
                check = 1;
            } 
            else if (UA.getID_USER().equals(adminUsername) && UA.getPASSWORD() == adminPassword) {
                clrscr();
                admin();
                check = 1;
            } 
            else {
                System.out.println("Invalid login credentials. Please try again.");
    
                loginAttempts++;
    
                if (loginAttempts == maximumlogin) {
                    System.out.println("Maximum login attempts reached. Exiting program.");
                    System.exit(0);
                }
            }
        } while (check == 0);
    
    
    }
}
