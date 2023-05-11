import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {
    private ArrayList<Item> items = new ArrayList<Item>();

    public void setItems(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void showGoods() {
        int num = 1;
        for (Item item : items) {
            System.out.println(num++);
            System.out.println(". Name: " + item.getName());
            System.out.println("Brand: " + item.getBrand());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Category: " + item.getCategory());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("--------------------------------");
        }
    }


    public void viewCatalog(LoggedInUser loggedUser) {
        if (loggedUser.isLogged) {
            String str = "";
            showGoods();
            System.out.println("Do You Want To Add To Shopping Cart? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            str = scanner.nextLine();  
            if(str.equals("Y") || str.equals("y")) {
                System.out.println("Enter The Number Of The Item You Want To Add To Shopping Cart");
                int num = scanner.nextInt();
                loggedUser.addToShoppingCart(items.get(num-1));
            }
            System.out.println("Back To Main Menu? (Y/N)");
            do {
                str = scanner.nextLine();
                if (str.equals("Y") || str.equals("y"))
                    return;
            } while (true);
        }
        else {
            showGoods();
        }
    }


    public boolean removeItem(){return true;}

    public Item searchByItem(String name){
        Item item = null;
        return item;
    }

    public void searchByCategory(String category){}

    public void searchByBrand(String brand){}

    public void itemDetails(){}

    
}
