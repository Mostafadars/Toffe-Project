import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Scanner;


public class User {

    public ArrayList<LoggedInUser> userList = new ArrayList<LoggedInUser>();
    public boolean isLogged = false;

    public void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String userName = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter street: ");
        String street = scanner.nextLine();

        System.out.print("Enter home number: ");
        int homeNumber = scanner.nextInt();

        System.out.print("Enter apartment number: ");
        int apartmentNumber = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character after reading the apartment number

        if (!validateEmail(email)) {
            System.out.println("Invalid email . Please provide a valid email.");
            return;
        }

        // Validate phone number
        if (!validatePhoneNumber(phone)) {
            System.out.println("Invalid phone number. Please provide a valid phone number.");
            return;
        }

        Address address = new Address(street, homeNumber, apartmentNumber);
        LoggedInUser newUser = new LoggedInUser(userName, email, password, phone, address);

        userList.add(newUser);
        isLogged = true;

        System.out.println("Registration successful!\nYou Are Logged In Now.\n");
    }

    private boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private boolean validatePhoneNumber(String phone) {
        String phoneRegex = "^01[0125]\\d{8}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phone).matches();
    }


    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (LoggedInUser user : userList) {
            
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                isLogged = true;
                return;
            }
        }

        System.out.println("Invalid email or password. Please try again.");
        return;
    }


    public void viewCatalog(Catalog catalog) {
        catalog.showGoods();
    }

    // Implement Function LogOut , ask the user to if he want to log out or not , if he want make log out and return to the main menu , if not return to logged in menu again , Suggest another implementation
    public void logOut() {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        System.out.println("Are You Sure You Want To Log Out? (Y/N)");
        do {
            str = scanner.nextLine();
            if (str.equals("Y") || str.equals("y")) {
                isLogged = false;
                return;
            }
            else if (str.equals("N") || str.equals("n"))
                return;
        } while (true);
    }
}
