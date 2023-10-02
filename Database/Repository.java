package Database;
import java.util.Vector;

import CoursePackage.Course;
import User.*;
import Admin.*;

public class Repository {

    public Vector<VisitorAccount> accounts = new Vector<VisitorAccount>();
    public Administrator admins = new Administrator();
    
    public Vector<Course> coursesVector = new Vector<Course>();
    public int accountIndex = -1;
    private static Repository repo;

    private Repository() {
        admins.userName = "admin";
        admins.password = "admin";
    }

    public static Repository getInstance() {
        if (repo == null) {
            repo = new Repository();
        }
        return repo;
    }
}
