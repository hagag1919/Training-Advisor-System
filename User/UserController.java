package User;

import java.util.*;
import Database.Repository;

public class UserController {
    Scanner scanner = new Scanner(System.in);
    Repository database = Repository.getInstance();

    public void EditProfile() {
        System.out.println("Change Profile");
        System.out.println("Press 1 to change your name");
        System.out.println("Press 2 to change your email");
        System.out.println("Press 3 to change your password");
        System.out.println("Press 4 to change your phone number");

        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Enter new name");
            String nameString = scanner.next();
            database.accounts.get(database.accountIndex).Name = nameString;
            System.out.println("Name changed successfully");
        }
        if (choice == 2) {
            System.out.println("Enter new email");
            String emailString = scanner.next();
            database.accounts.get(database.accountIndex).Email = emailString;
            System.out.println("Email changed successfully");
        }
        if (choice == 3) {
            System.out.println("Enter new password");
            String passwordString = scanner.next();
            database.accounts.get(database.accountIndex).Pass = passwordString;
            System.out.println("Password changed successfully");
        }
        if (choice == 4) {
            System.out.println("Enter new phone number");
            String phoneString = scanner.next();
            database.accounts.get(database.accountIndex).phoneNum = phoneString;
            System.out.println("Phone number changed successfully");
        }

    }

    public void viewdata() {
        System.out.println("    Your profile    ");
        System.out.println("Your Name:  " +  database.accounts.get(database.accountIndex).Name);
        System.out.println("Your Email:  " +  database.accounts.get(database.accountIndex).Email);
        System.out.println("Your Phone Number:  " +  database.accounts.get(database.accountIndex).phoneNum);
    }

    public void Login() {

        
        Repository database = Repository.getInstance();
        database.accountIndex = -1;

        System.out.println("Login Section");
        Scanner scanner = new Scanner(System.in);
        VisitorAccount inputLogin = new VisitorAccount();

        System.out.println("Enter your Email");
        inputLogin.Email = scanner.next();
        System.out.println("Enter your Password");
        inputLogin.Pass = scanner.next();

        for (int i = 0; i < database.accounts.size(); i++) 
        {
            if (inputLogin.Email.equals(database.accounts.get(i).Email)
                    && inputLogin.Pass.equals(database.accounts.get(i).Pass)) {
                database.accountIndex = i;
            }
        }
    }
    
    public VisitorAccount Signup() {

        System.out.println("Signup Section");
        Scanner scanner = new Scanner(System.in);

        VisitorAccount userInput = new VisitorAccount();
        System.out.println("Enter your name");
        userInput.Name = scanner.nextLine();
        System.out.println("Enter your Email");
        userInput.Email = scanner.nextLine();
        System.out.println("Enter your Password");
        userInput.Pass = scanner.nextLine();
        System.out.println("Enter your Phone number");
        userInput.phoneNum = scanner.next();
        return userInput;
        
    }
}

