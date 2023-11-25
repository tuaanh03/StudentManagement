package StudentProject;

import java.util.Scanner;

public class DSGeneral {

    final private String adminUsername = "admin123";
    final private long adminPassword = 123456789;

    DSStudent stu = new DSStudent("StudentFile.txt");
    QLTeacher tea = new QLTeacher("TeacherFile.txt");
    DSCLASS a = new DSCLASS("StudentClass.txt");

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
                    // Add logic for viewing study results
                    break;
                }
                case 2: {
                    // Add logic for viewing school year's payroll
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
                    DSStudent studentList = new DSStudent("StudentFile.txt");
                    studentList.show();
                    break;
                }
                case 2: {
                    DSSubject subjectList = new DSSubject("SubjectFile.txt");
                    subjectList.show();
                    break;
                }
                case 3: {
                    stu.input();
                    break;
                }
                case 4: {
                    // Add logic for editing study results list
                    break;
                }
                case 5: {
                    // Add logic for saving all edits
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
