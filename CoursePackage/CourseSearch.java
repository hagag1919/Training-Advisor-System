package CoursePackage;
import java.util.Scanner;

import Database.Repository;

public class CourseSearch 
{
    Repository database = Repository.getInstance();
    private Course course;
    public CourseSearch()
    {
        this.course = new Course();
    }
    public boolean Matching(String CourseName) {
        String name;
        for (int i = 0; i < database.coursesVector.size(); i++) {
            name = database.coursesVector.get(i).getCourseName();
            name = name.toLowerCase();
            if (name.equals(CourseName)) {
                return true;
            }
        }
        return false;
    }
    public void SearchCourse()
    {
        String name = new String();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter course name: ");
        name = input.nextLine();
        name.toLowerCase();
        for (int i = 0; i < database.coursesVector.size(); i++)
        {
            if (Matching(name))
            {
                System.out.println("Course ID:  " + database.coursesVector.get(i).getCourseID());
                System.out.println("Course name: " + database.coursesVector.get(i).getCourseName());
                System.out.println("Course type: " + database.coursesVector.get(i).getCourseType());
                System.out.println("Course prerequisites: " + database.coursesVector.get(i).getPrerequisites());
                System.out.println("Course cost: " + database.coursesVector.get(i).getCourseCost());
                System.out.println("Do you want to enroll in this course? Pass 1 for yes and 2 for no");
                int choice = input.nextInt();
                if (choice == 1)
                {
                    CourseController enrollCourse = new CourseController();
                    enrollCourse.Enroll(database.coursesVector.get(i).getCourseID());
                }

            }
        }
    }
}