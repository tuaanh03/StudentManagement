package StudentProject;

public class DSGeneral {
    final private String studentusername = "student123";
    final private String studentpassword = "123456789";
    final private String teacherusername = "teacher123";
    final private String teacherpassword = "123456789";

    public void login_account()
    {
        UserAccount UA = new UserAccount();
        DSStudent stu = new DSStudent();
        UA.input();
        if (((UA.getID_USER().equals(studentusername)) && (UA.getPASSWORD().equals(studentpassword))) ) 
        {
            
        }
        if (UA.getID_USER().equals(teacherusername) && UA.getPASSWORD().equals(teacherpassword))
        {
            stu.input();
        }

    }

}
