package StudentProject;

import java.util.Scanner;

public class DSGeneral {

    final private String adminUsername = "admin123";
    final private long adminPassword = 123456789;

    DSStudent stu = new DSStudent("StudentFile.txt");
    QLTeacher tea = new QLTeacher("TeacherFile.txt");
    DSSubject sub = new DSSubject("SubjectFile.txt");
    // DSCLASS a = new DSCLASS("StudentClass.txt");
    KQHT kq = new KQHT();

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
                    kq.studyResultByID(id);
                    break;
                }             
                case 2: {
                    DSCLASS a = new DSCLASS("StudentClass.txt");
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
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            
            choice = sc.nextInt();

            switch (choice) {
                case 1: {                   
                    stu.show();
                    break;
                }
                case 2: {                    
                    kq.menu();
                    break;
                }
                case 3: {
                    stu.input();
                    break;
                }
                case 4: {
                    sub.show();
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
        
        loginAccount UA = new loginAccount();
        UA.input();
        
        String username = UA.getID_USER();
        long password = UA.getPASSWORD();

        if (stu.loginStudent(username, password) == 1) {
            
            user(UA.getID_USER());
        }

        if (tea.loginTeacher(username, password) == 1) {
            
            teacher();
        }
        if (UA.getID_USER().equals(adminUsername) && UA.getPASSWORD() == adminPassword) {
            
            admin();
        }
    }
}
