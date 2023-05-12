import java.util.Scanner;

public class ToffeeSystem {
    private Catalog catalog = new Catalog();
    private LoggedInUser loggedUser = new LoggedInUser();
    private int id = 1;

    public void CatalogItems()
    {
        Item item1 = new Item("chocolate", 5, "none", "none", 20);
        Item item2 = new Item("toffee", 10, "none", "none", 20);
        Item item3 = new Item("candy", 15, "none", "none", 20);
        Item item4 = new Item("chocolate bar", 20, "none", "none", 20);
        Item item5 = new Item("cabri", 25, "none", "none", 20);
        Item item6 = new Item("moro", 30, "none", "none", 20);

        catalog.setItems(item1);
        catalog.setItems(item2);
        catalog.setItems(item3);
        catalog.setItems(item4);
        catalog.setItems(item5);
        catalog.setItems(item6);
    }

    public void menu() {
        System.out.println("#-------------------------------------------------------------------------#");
        System.out.println("\t\t\tWelcome In Toffee System\t\t\t");
        System.out.println("#-------------------------------------------------------------------------#");
        
        Scanner scanner = new Scanner(System.in);

        do {
            int choice;
            if(loggedUser.isLogged) {
                System.out.println("1. View Catalog");
                System.out.println("2. Make Orders");
                System.out.println("3. Show Customer Details");
                System.out.println("4. Log out");
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        CatalogItems();
                        catalog.viewCatalog(loggedUser);
                        break;
                    case 2:
                        loggedUser.makeOrder(id++);
                        break;
                    case 3:
                        loggedUser.showDetails();
                        break;
                    case 4:
                        loggedUser.logOut();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            else {
                System.out.println("1. View Catalog");
                System.out.println("2. Register");
                System.out.println("3. Login");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after reading the choice

                switch (choice) {
                    case 1:
                        CatalogItems();
                        catalog.showGoods();
                        break;
                    case 2:
                        loggedUser.register();
                        break;
                    case 3:
                        loggedUser.logIn();
                        break;
                    case 4:
                        System.out.println("Thank you for using Toffee System!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } while (true);
    }
}