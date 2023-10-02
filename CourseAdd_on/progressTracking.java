package CourseAdd_on;
import CoursePackage.*;

public class progressTracking {

    public void progressTracking(Course course) {

        if (course.exam.getExam()) {
            System.out.println("You finished the course exam");
        }
        else if (!course.exam.getExam()) {
            System.out.println("You didn't finish the course exam");
        }
        if (course.exam.getQuiz()) {
            System.out.println("You finished the course quiz");
        }
        else if (!course.exam.getQuiz()) {
            System.out.println("You didn't finish the course quiz");
        }
    }
}
