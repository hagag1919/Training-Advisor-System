package CoursePackage;

import Database.*;


public class CourseController {
    Repository database = Repository.getInstance();

    
    public void Enroll(String id) {
        for (int i = 0; i < database.coursesVector.size(); i++) {
            if (database.coursesVector.get(i).getCourseID().equals(id)) {
                database.accounts.get(database.accountIndex).myCourses.add(database.coursesVector.get(i));
                System.out.println("Course successfully enrolled");
            }
        }

    }
    public void Withdraw(String id) {
        for(int i = 0; i < database.accounts.get(database.accountIndex).myCourses.size(); i++)
        {
            if(database.accounts.get(database.accountIndex).myCourses.get(database.accountIndex).getCourseID().equals(id))
            {
                database.accounts.get(database.accountIndex).myCourses.remove(i);
                System.out.println("Course successfully withdrawn");
            }
        }
    }

}

