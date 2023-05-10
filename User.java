import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Scanner;


public class User {
    private ArrayList<LoggedInUser> userList = new ArrayList<LoggedInUser>();
    protected String userName;
    protected String email;
    protected String password;
    protected String phone;
    protected Address address;

    public User(){}

    public User(String userName, String email, String password, String phone, Address address) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }


    public void register(String username, String email, String password, String phoneNumber, Address address) {
        // Validate email format
        if (validateEmail(email)) {
            System.out.println("Invalid email format. Please provide a valid email.");
            return;
        }

        // Validate phone number
        if (validatePhoneNumber(phoneNumber)) {
            System.out.println("Invalid phone number. Please provide a valid phone number.");
            return;
        }


        LoggedInUser newUser = new LoggedInUser(username, email, password, phoneNumber, address);

        userList.add(newUser);

        System.out.println("Registration successful!");
    }

    private boolean validateEmail(String email) {
        // Use regular expression pattern to validate email format
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private boolean validatePhoneNumber(String phone) {
        // Use regular expression pattern to validate phone number format
        String phoneRegex = "^01[0125]\\d{8}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phone).matches();
    }


    public void logIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        LoggedInUser logged = new LoggedInUser();

        logged.logIn(userName, password);

    }

    public void logIn(String email, String password) {
        for (LoggedInUser user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                // Perform further actions for a logged-in user, such as making an order, adding items to the shopping cart, or paying with cash.
                // Example: user.makeOrder();
                return;
            }
        }

        System.out.println("Invalid email or password. Please try again.");
    }


    public void viewCatalog() {
        // Add code to view the catalog here
    }
}
