package StudentProject;

import java.util.Scanner;

public class loginAccount extends Account {
    private String ID_USER;
    private String PASSWORD;


    public loginAccount(String iD_USER, String pASSWORD) {
        ID_USER = iD_USER;
        PASSWORD = pASSWORD;
    }

    public loginAccount() {
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
        System.out.println("Enter ID of account: ");
        ID_USER = sc.nextLine();

        System.out.println("Enter Password: ");
        PASSWORD = sc.nextLine();
    }
    
   
}
