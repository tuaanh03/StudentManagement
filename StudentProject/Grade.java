package StudentProject;
import java.util.ArrayList;
// import java.util.List;

public class Grade {
    private String ID_GRADE;
    private ArrayList<ID_CLASSES> ID_CLASS ;
    public Grade(String g)
    {
        ID_GRADE=g;
        this.ID_CLASS=new ArrayList<>();
    }
    public String getID_Grade()
    {
        return ID_GRADE;
    }
    public void setID_Grade(String g)
    {
        ID_GRADE=g;
    }
    public ArrayList<ID_CLASSES> getID_ClassList()
    {
        return ID_CLASS;
    }
    public void setID_ClassList(ArrayList<ID_CLASSES> a)
    {
        this.ID_CLASS=a;
    }
    public void addClass(ID_CLASSES a)
    {
        ID_CLASS.add(a);
    }
    public void input()
    {}
    public void output()
    {
        System.out.println("Grade: " + getID_Grade());
        for(ID_CLASSES a: ID_CLASS)
        {
            System.out.println(a.toString());
        }
    }
    class ID_CLASSES {
        private String ID_CLASS;
        public ID_CLASSES(String s)
        {
            ID_CLASS=s;
        }
        public String getID_Class()
        {
            return ID_CLASS;
        }
        public void setID_Class(String a)
        {
            ID_CLASS=a;
        }
        @Override
        public String toString() {
            return ID_CLASS;
        }
    }
    // public static void main(String[] args) {
    //     Grade khoi10=new Grade("khoi10");
    //     ID_CLASSES a=khoi10.new ID_CLASSES("10A1");
    //     ID_CLASSES b=khoi10.new ID_CLASSES("10A2");
    //     khoi10.addClass(a);
    //     khoi10.addClass(b);
    //     khoi10.output();
    //     Grade khoi11=new Grade("khoi11");
    //     ID_CLASSES c=khoi11.new ID_CLASSES("11A1");
    //     ID_CLASSES d=khoi11.new ID_CLASSES("11A2");
    //     khoi11.addClass(c);
    //     khoi11.addClass(d);
    //     khoi11.output();}
}
