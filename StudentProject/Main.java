package StudentProject;

import java.io.IOException;

//import java.util.ArrayList;

public class Main {

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
    public static void main(String[] args)
	{
		DSGeneral a= new DSGeneral();
		clrscr();
		 a.login_account();
		
	}

}
