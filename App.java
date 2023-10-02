import java.util.*;

import Admin.*;
import ChatFeature.Helpdesk;
import CoursePackage.*;
import Database.*;
import User.*;
import CourseAdd_on.*;

public class App {

    public static void main(String args[]) 
    {
        Repository database = Repository.getInstance();
        Course course;
        database.coursesVector.add(course = new Course("math 0", "Math", "MA12", "", 100.0, "material"));
        database.coursesVector.add(course = new Course("math 1", "Math", "MA22", "math 0", 100.0, "material"));
        String id;
        UserController user = new UserController();
        Scanner scanner = new Scanner(System.in);
        AdminController admin = new AdminController();
        boolean loopBreak = false;
        int choice;
        for (;;) 
        {
            System.out.println("         Welcome to Training Advisor");
            System.out.println("Press 1 to Signup as a user, 2 to Login as an administrator and 3 to exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    database.accounts.add(user.Signup());
                    System.out.println("Signed up Successfully");
                    System.out.println();
                    user.Login();
                    loopBreak = false;

                    if (database.accountIndex == -1) {
                        System.out.println("Wrong Email or password");
                    } else {
                        System.out.println("Logged in successfully \n\n");
                        while (loopBreak == false) {
                            System.out.println("      Main menu");
                            System.out.println(
                                    "View my courses (Press 1) \nSearch course (Press 2) \nEnroll Course (Press 3) \nEdit Profile (Press 4) \nWithdraw from a Course (Press 5) \nView Profile (Press 6) \nSignup from another account (Press 7) \nLogin from another account (Press 8) \nGet certificate (Press 9)\nSolve quizzes and exams (Press 10) \nHelpdesk (Press 11) \nExit to login page (Press 0) ");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 0:
                                    loopBreak = true;
                                    break;
                                case 1:
                                    if (database.accounts.get(database.accountIndex).myCourses.size() < 1) 
                                    {
                                        System.out.println("\nNo Registered courses\n\n");
                                    }
                                    else {
                                        for (int i = 0; i < database.accounts.get(database.accountIndex).myCourses
                                                .size(); i++) {
                                            System.out.println("Course Name: "
                                                    + database.accounts.get(database.accountIndex).myCourses.get(i)
                                                            .getCourseName());
                                            System.out.println(
                                                    "Course ID: " + database.accounts.get(database.accountIndex).myCourses
                                                            .get(i).getCourseID());
                                        }
                                        System.out.println(
                                                "If you want to track progress of a course press 1, else press any other key");
                                        choice = scanner.nextInt();
                                        if (choice == 1) {
                                            progressTracking pTracking = new progressTracking();
                                            System.out.println("Enter course ID");
                                            scanner.nextLine();
                                            String iDString = scanner.nextLine();
                                            for (int i = 0; i < database.accounts.get(database.accountIndex).myCourses
                                                    .size(); i++) 
                                            {
                                                if (database.accounts.get(database.accountIndex).myCourses
                                                        .get(database.accountIndex).getCourseID()
                                                        .equals(iDString)) 
                                                {
                                                    pTracking.progressTracking(
                                                            database.accounts.get(database.accountIndex).myCourses
                                                                    .get(i));
                                                }
                                            }

                                        }
                                    }
                                    break;
                                case 2:
                                    CourseSearch courseSearch = new CourseSearch();
                                    courseSearch.SearchCourse();

                                    break;
                                case 3:
                                    CourseController enrollCourse = new CourseController();
                                    System.out.println("Enter course ID");
                                    scanner.nextLine();
                                    id = scanner.nextLine();
                                    id.toUpperCase();
                                    enrollCourse.Enroll(id);
                                    break;
                                case 4:
                                    user.EditProfile();
                                    break;
                                case 5:
                                    CourseController withdrawCourse = new CourseController();
                                    System.out.println("Enter course ID");
                                    scanner.nextLine();
                                    id = scanner.nextLine();
                                    id.toUpperCase();
                                    withdrawCourse.Withdraw(id);
                                    break;
                                case 6:
                                    user.viewdata();
                                    break;
                                case 7:
                                    database.accounts.add(user.Signup());
                                    System.out.println("Signed up Successfully");
                                    System.out.println();
                                    break;
                                case 8:
                                    user.Login();
                                    if (database.accountIndex == -1) {
                                        System.out.println("Wrong Email or password");
                                    } else {
                                        System.out.println("Logged in successfully \n\n");
                                    }
                                    break;
                                case 9:
                                    System.out.println("Enter course ID");
                                    scanner.nextLine();
                                    id = scanner.nextLine();
                                    id.toUpperCase();
                                    CertificateIssuance Certificate = new CertificateIssuance();
                                    Certificate.issueCertificate(id);
                                    break;
                                case 10:
                                    System.out.println("Press 1 to solve the exam and 2 to solve the quiz");
                                    choice = scanner.nextInt();
                                    switch (choice) {
                                        case 1:
                                            System.out.println("Enter course ID");
                                            scanner.nextLine();
                                            id = scanner.nextLine();
                                            id.toUpperCase();

                                            for (int i = 0; i < database.accounts.get(database.accountIndex).myCourses
                                                    .size(); i++) {
                                                if (database.accounts.get(database.accountIndex).myCourses
                                                        .get(i).getCourseID().equals(id)) {
                                                            database.accounts.get(database.accountIndex).myCourses
                                                            .get(i).exam
                                                            .solveExam(
                                                                    database.accounts.get(database.accountIndex).myCourses
                                                                            .get(i)
                                                                            .getCourseScore());
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Enter course ID");
                                            scanner.nextLine();
                                            id = scanner.nextLine();
                                            id.toUpperCase();

                                            for (int i = 0; i < database.accounts.get(database.accountIndex).myCourses
                                                    .size(); i++) {
                                                if (database.accounts.get(database.accountIndex).myCourses
                                                        .get(i).getCourseID().equals(id)) 
                                                        {
                                                            database.accounts.get(database.accountIndex).myCourses.get(i).exam
                                                            .solveQuiz(
                                                                    database.accounts.get(database.accountIndex).myCourses.get(i)
                                                                            .getCourseScore());
                                                }
                                            }
                                            break;
                                    }
                                    break;
                                case 11:
                                    Helpdesk help = new Helpdesk();
                                    break;
                                default:
                                    System.out.println("Invalid input");
                            }
                        }
                    }
                    break;
                case 2:
                    loopBreak = false;
                    String inputUser, inputPass;
                    System.out.print("Enter the username: ");
                    scanner.nextLine();
                    inputUser = scanner.nextLine();
                    System.out.print("Enter the password: ");
                    inputPass = scanner.nextLine();
                    if (inputPass.equals(database.admins.password) && inputUser.equals(database.admins.userName))
                    {
                        System.out.println("Logged up successfully");
                        while (loopBreak == false) {
                            System.out.println(
                                    "Set course (Press 1) \nEdit course (Press 2) \nDelete Course(Press 3) \nExit to main menu (Press 0)");
                            choice = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice) {
                                case 1:
                                    admin.setCourse();
                                    break;
                                case 2:
                                    System.out.println("Enter course ID");
                                    id = scanner.nextLine();
                                    id.toUpperCase();
                                    admin.DefiningCourse(id);
                                    break;
                                case 3:
                                    System.out.println("Enter course ID");
                                    id = scanner.nextLine();
                                    id.toUpperCase();
                                    admin.deleteCourse(id);
                                case 0:
                                    loopBreak = true;
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                            }
                        }
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}