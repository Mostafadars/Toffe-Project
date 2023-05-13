import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Scanner;

public class ToffeeSystem {
    public ArrayList<LoggedInUser> userList = new ArrayList<LoggedInUser>();
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
        Item item13 = new Item("Nuts Chocolate", 65, "Cabri", "Chocolate", 50);
        Item item14 = new Item("Caramel Chocolate", 70, "Cabri", "Chocolate", 50);
        Item item15 = new Item("Oreo Chocolate", 75, "Cabri", "Chocolate", 50);


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
        catalog.setItems(item13);
        catalog.setItems(item14);
        catalog.setItems(item15);
    }

    public void contactWithUS() {
        System.out.println("#-------------------------------------------------------------------------#");
        System.out.println("You Can Contact With Us ON This Number : 01234567890");
        System.out.println("And We Will Solve Your Problem As Fast As We Can.\nThanks.");
        System.out.println("#-------------------------------------------------------------------------#");
    }

    public void menu() throws MessagingException {
        System.out.println("#-------------------------------------------------------------------------#");
        System.out.println("\t\t\tWelcome In Toffee System\t\t\t");
        System.out.println("#-------------------------------------------------------------------------#");
        
        Scanner scanner = new Scanner(System.in);

        do {
            int choice;
            if(loggedUser.isLogged) {
                System.out.println("#-------------------------------------------------------------------------#");
                System.out.println("1. View Catalog");
                System.out.println("2. Make Orders");
                System.out.println("3. Show Customer Details");
                System.out.println("4. Search Item By Name");
                System.out.println("5. Search Item By Category");
                System.out.println("6. Search Item By Brand");
                System.out.println("7. Show Item Details");
                System.out.println("7. Show Item Details");
                System.out.println("8. Log out");
                System.out.println("#-------------------------------------------------------------------------#");
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
                        catalog.searchByItem();
                        break;
                    case 5:
                        catalog.searchByCategory();
                        break;
                    case 6:
                        catalog.searchByBrand();
                        break;
                    case 7:
                        catalog.itemDetails();
                        break;
                    case 8:
                        loggedUser.logOut();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            else {
                System.out.println("#-------------------------------------------------------------------------#");
                System.out.println("1. View Catalog");
                System.out.println("2. Register");
                System.out.println("3. Login");
                System.out.println("4. Contact US");
                System.out.println("5. Exit");
                System.out.println("#-------------------------------------------------------------------------#");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after reading the choice

                switch (choice) {
                    case 1:
                        CatalogItems();
                        catalog.showGoods();
                        break;
                    case 2:
                        loggedUser = loggedUser.register(userList);
                        if (loggedUser.isLogged)
                            userList.add(loggedUser);
                        break;
                    case 3:
                        loggedUser = loggedUser.login(userList);
                        break;
                    case 4:
                        contactWithUS();
                        break;
                    case 5:
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