import java.util.Scanner;

public class ToffeeSystem {
    private Catalog catalog = new Catalog();
    private LoggedInUser loggedUser = new LoggedInUser();
    private int id = 1;

    public void CatalogItems()
    {
        Item item1 = new Item("Brittle Candy", 5, "Candies", "Candy", 50);
        Item item2 = new Item("Bon Bon", 10, "Diff", "Toffee", 50);
        Item item3 = new Item("Caramels", 15, "Diff", "Toffee", 50);
        Item item4 = new Item("Cotton Candy", 20, "Candies", "Candy", 50);
        Item item5 = new Item("Chocolate Bubble", 25, "Cabri", "Chocolate", 50);
        Item item6 = new Item("Moro", 30, "Cabri", "Chocolate", 50);
        Item item7 = new Item("Chewing Gum", 35, "Diff", "Toffee", 50);
        Item item8 = new Item("Sours", 40, "Diff", "Toffee", 50);
        Item item9 = new Item("Lollypop", 45, "Diff", "Toffee", 50);
        Item item10 = new Item("Candy Cane", 50, "Candies", "Candy", 50);
        Item item11 = new Item("Hard Candy", 55, "Candies", "Candy", 50);
        Item item12 = new Item("Gummie", 60, "Diff", "Toffee", 50);


        catalog.setItems(item1);
        catalog.setItems(item2);
        catalog.setItems(item3);
        catalog.setItems(item4);
        catalog.setItems(item5);
        catalog.setItems(item6);
        catalog.setItems(item7);
        catalog.setItems(item8);
        catalog.setItems(item9);
        catalog.setItems(item10);
        catalog.setItems(item11);
        catalog.setItems(item12);
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
                        loggedUser.login();
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