import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Scanner;


public class User {

    //public ArrayList<LoggedInUser> userList = new ArrayList<LoggedInUser>();
    public boolean isLogged = false;

    public LoggedInUser register(ArrayList<LoggedInUser> userList) throws MessagingException {
        Scanner scanner = new Scanner(System.in);
        Mail mail = new Mail();

        System.out.println("#-------------------------------------------------------------------------#");
        System.out.println("\t\t\t\t\tSign Up Form\t\t\t\n");
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

        LoggedInUser newUser = new LoggedInUser();
        if (!validateEmail(email)) {
            System.out.println("Invalid email . Please provide a valid email.");
            return newUser;
        }

        if (!checkEmail(email, userList)) {
            System.out.println("This Email Already Exists.");
            return newUser;
        }

        // Validate phone number
        if (!validatePhoneNumber(phone)) {
            System.out.println("Invalid phone number. Please provide a valid phone number.");
            return newUser;
        }

        if (sendEmail(email)) {
            System.out.print("Enter Email Verification Code: ");
            int code = scanner.nextInt();

            if (code == mail.getCode()) {
                System.out.println("Accepted Code Verification");

                Address address = new Address(street, homeNumber, apartmentNumber);
                newUser = new LoggedInUser(userName, email, password, phone, address);

                //userList.add(newUser);
                newUser.isLogged = true;

                System.out.println("Registration successful!\nYou Are Logged In Now.\n");
                System.out.println("#-------------------------------------------------------------------------#");
                return newUser;
            }
        }

        System.out.println("Registration Field!\n");
        System.out.println("#-------------------------------------------------------------------------#");
        return newUser;

    }

    private boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private boolean checkEmail(String email, ArrayList<LoggedInUser> userList) {
        for (LoggedInUser user : userList) {
            if (user.getEmail().equals(email))
                return false;
        }
        return true;
    }

    private boolean validatePhoneNumber(String phone) {
        String phoneRegex = "^01[0125]\\d{8}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phone).matches();
    }

    public boolean sendEmail(String email) throws MessagingException {
        Mail.sendMail(email);
        return true;
    }


    public LoggedInUser login(ArrayList<LoggedInUser> userList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("#-------------------------------------------------------------------------#");
        System.out.println("\t\t\t\t\tLogin\t\t\t\n");

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (LoggedInUser user : userList) {
            
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                System.out.println("#-------------------------------------------------------------------------#");
                user.isLogged = true;
                return user;
            }
        }

        LoggedInUser user = new LoggedInUser();
        System.out.println("Invalid email or password. Please try again.");
        System.out.println("#-------------------------------------------------------------------------#");
        return user;
    }

    public void viewCatalog(Catalog catalog) {
        catalog.showGoods();
    }

    public void logOut() {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        System.out.println("#-------------------------------------------------------------------------#");
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
