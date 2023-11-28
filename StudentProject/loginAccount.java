package StudentProject;

import java.util.Scanner;

public class loginAccount extends Account {
    private String ID_USER;
    private long PASSWORD;


    public loginAccount(String iD_USER, long pASSWORD) {
        ID_USER = iD_USER;
        PASSWORD = pASSWORD;
    }

    public loginAccount() {
        ID_USER = "";
        PASSWORD = 0;
    }

    public String getID_USER() {
        return ID_USER;
    }

    public void setID_USER(String iD_USER) {
        ID_USER = iD_USER;
    }

    public long getPASSWORD() {
        return PASSWORD;
    }
    public void setPASSWORD(long pASSWORD) {
        PASSWORD = pASSWORD;
    }
    @Override
    public void input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID of Student or ID of Teacher: ");
        ID_USER = sc.nextLine();

        System.out.print("Enter Password: ");
        PASSWORD = sc.nextLong();
       
    }
}
