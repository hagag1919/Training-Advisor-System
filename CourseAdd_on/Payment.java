package CourseAdd_on;
import java.util.*;

public class Payment
{
    public double paymentMethod(Double fee)
    {
        System.out.println("<<< Payment Method >>>\n");
        System.out.println("1- Credit Card\n");
        System.out.println("3- Bank Transfer\n");
        System.out.println("4- Back\n");
        System.out.println("5- Exit\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice)
        {
            case 1:
            System.out.println("Enter your credit card number");
            String creditCard = scanner.nextLine();
            System.out.println("Enter your credit card password");
            String password = scanner.nextLine();
            System.out.println("Enter your credit card CVV");
            String cvv = scanner.nextLine();
            System.out.println("Enter your credit card expiry date");
            String expiryDate = scanner.nextLine();
            System.out.println("Payment done successfully");
            break;
            case 2:
            System.out.println("Payment done successfully");
            break;
            case 3:
            System.out.println("Enter your bank account number");
            String bankAccount = scanner.nextLine();
            System.out.println("Enter your bank account password");
            String bankPassword = scanner.nextLine();
            System.out.println("Payment done successfully");
            break;
            case 4:
            break;
            case 5:
            System.exit(0);
            break;
            default:
            System.out.println("Wrong choice\n");
            break;
        }
        return fee = 0.0;
    }
}