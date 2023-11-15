package StudentProject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
	{
		// DSStudent ql = new DSStudent();
		// ql.input();

		ArrayList<StudentClass> Classes = StudentClass.is_Classes ("D:\\StudentManager\\StudentManagement\\StudentClass.txt");
        StudentClass CLASS = new DSCLASS();
         CLASS.output(Classes);
	     CLASS. Add_Childminder (Classes);
		 DSCLASS dsClass = new DSCLASS();
		 dsClass.add(Classes);
		 System.out.println("\n");
		 dsClass.delete(Classes);
		 dsClass.search(Classes);
		dsClass.modify(Classes);

	}

}
