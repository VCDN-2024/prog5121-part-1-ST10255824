
package LoginAndRegistrationPortal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginAndRegistrationPortal {
    private static Map<String, String[]> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Login and Registration Portal");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
         
            //Gives the user the different options to chose from
            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Closing portal. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    

    private static void registerUser(Scanner scanner) {
        System.out.println("=== Registration ===");
        //Asks user for their first name
          System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        //Asks user for their last name
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        //Ask user for a username
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        //If statement to make sure the entered username meets the requirements

        if (!checkUserName(username)) {
            System.out.println("Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return;
        }
      //If statement to check that there is not more than 1 user with the same username
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose another one.");
            return;
        }
      //Ask user to enter a password
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
       // If statement to check if the users entered password follows the requirements
        if (!checkPasswordComplexity(password)) {
            System.out.println("Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return;
        }

      

        String[] userDetails = {password, firstName, lastName};
        users.put(username, userDetails);
        System.out.println("Registration successful for username: " + username);
    }

    private static boolean checkUserName(String username) {
        // Check if username contains an underscore and is no more than 5 characters long
        return username.length() <= 5 && username.contains("_");
    }

    private static boolean checkPasswordComplexity(String password) {
        //Checks if the passwords meets the requirements
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private static void loginUser(Scanner scanner) {
        System.out.println("=== Login ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        //Checks to see if the username is in the database
        if (!users.containsKey(username)) {
            
            System.out.println("Username not found. Please register first.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String[] userDetails = users.get(username);
        if (userDetails[0].equals(password)) {
            System.out.println("Login successful! Welcome, " + userDetails[1] + " " + userDetails[2] + "!");
        } else {
            System.out.println("Invalid password. Please try again.");
        }
    }
}
