package StudentProject;

import java.util.Scanner;

public class UserAccount extends Account {
    private String ID_USER;
    private String PASSWORD;


    public UserAccount(String iD_USER, String pASSWORD) {
        ID_USER = iD_USER;
        PASSWORD = pASSWORD;
    }

    public UserAccount() {
        ID_USER = "";
        PASSWORD = "";
    }

    public String getID_USER() {
        return ID_USER;
    }

    public void setID_USER(String iD_USER) {
        ID_USER = iD_USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
    
    public void setPASSWORD(String pASSWORD) {
        PASSWORD = pASSWORD;
    }

    @Override   
    public void input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID_USER: ");
        ID_USER = sc.nextLine();

        System.out.println("Enter Password: ");
        PASSWORD = sc.nextLine();
    }
    
   
}
