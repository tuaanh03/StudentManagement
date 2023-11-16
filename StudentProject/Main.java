package StudentProject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
	{
		//  DSStudent ql = new DSStudent();
		//  ql.input();
    
       // StudentClass CLASS = new StudentClass();
		// System.out.println("\n");
		 DSCLASS dsClass = new DSCLASS();
		 dsClass.is_Classes("StudentManagement\\StudentProject\\StudentClass.txt");
		 dsClass.show();
		 System.out.println("\n");
		 dsClass.add();
		 System.out.println("\n");
		 dsClass.delete();
		 dsClass.search();
		 dsClass.modify();
		 System.out.println("\n");
		 dsClass.show_all();

	}

}
