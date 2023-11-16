package StudentProject;
import java.util.*;
public class Teacher extends People{
    private String ID_GV;
    private String ID_CLASS;

    public Teacher(String name, String birth, String address, int gender, String mail, long phoneNumber, String iD_GV,
            String iD_CLASS) {
        super(name, birth, address, gender, mail, phoneNumber);
        ID_GV = iD_GV;
        ID_CLASS = iD_CLASS;
    }

    public Teacher() {
        super();
        ID_GV = "";

    }

    public void setID_GV(String iD_GV) {
        ID_GV = iD_GV;
    }

    public String getID_GV()
    {
        return ID_GV;
    }

    public String getID_CLASS() {
        return ID_CLASS;
    }
    public void setID_CLASS(String iD_CLASS) {
        ID_CLASS = iD_CLASS;
    }

    public void input()
    {
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.println("Enter ID_GV: ");
        ID_GV = sc.nextLine();
        System.out.println("Enter ID_CLASS: ");
        ID_CLASS= sc.nextLine();
    }

    public void output()
    {
        super.output();
        System.out.println("ID GV: " + getID_GV());
        System.out.println("ID CLASS: " + getID_CLASS());
    }
}
