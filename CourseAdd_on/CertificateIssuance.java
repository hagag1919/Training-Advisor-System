package CourseAdd_on;
import java.util.*;


import CoursePackage.*;
import Database.*;



public class CertificateIssuance implements ICheck {

    Scanner scanner = new Scanner(System.in);
    Repository database = Repository.getInstance();
    

    public boolean checkCost(String Id) {

        for(int i=0;i<database.coursesVector.size();i++)
        {
            if(database.coursesVector.get(i).getCourseID().equals(Id))
            {
                if (database.coursesVector.get(i).getCourseCost() != 0.0) {
                    Double fee = database.coursesVector.get(i).getCourseCost();
                    Payment payment = new Payment();
                    payment.paymentMethod(fee);
                    return true;
                } else {
                    System.out.println("The course is already paid");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkScore(String Id) {
        for(int i=0;i<database.coursesVector.size();i++)
        {
            if(database.accounts.get(database.accountIndex).myCourses.get(i).getCourseID().equals(Id))
            {
                if (database.accounts.get(database.accountIndex).myCourses.get(i).exam.getExam()) {
                    System.out.println("You passed the course");
                    return true;
                } else {
                    System.out.println("You failed the course");
                    return false;
                }
            }
        }
        return false;
    }
    public void issueCertificate(String Id)
    {
        if(checkCost(Id) && checkScore(Id))
        {
            System.out.println("Certificate issued");
        }
        else
        {
            System.out.println("Certificate not issued");
        }
    }
    
}
