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
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Name: " + item.getName());
            System.out.println("Brand: " + item.getBrand());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Category: " + item.getCategory());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("---------------------------------------------------------------------------");
        }
    }


    public void viewCatalog(LoggedInUser loggedUser) {
        if (loggedUser.isLogged) {
            String str = "";
            Scanner scanner = new Scanner(System.in);
            showGoods();

            System.out.println("Do You Want To Add To Shopping Cart? (Y/N)");
            str = scanner.nextLine();
            if(str.equals("Y") || str.equals("y")) {
                System.out.println("Enter The Number Of The Item You Want To Add To Shopping Cart");
                int num = scanner.nextInt();
                loggedUser.addToShoppingCart(items.get(num - 1));
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

    public void searchByItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Item Name: ");
        String name = scanner.nextLine();

        System.out.println(name + " Item :");
        int num = 1;
        for (Item item : items) {
            if (item.getName().equals(name)){
                System.out.println("Item : " + item.getName() + ", Price : " + item.getPrice());
                num++;
            }
        }
        if (num == 1) {
            System.out.println("No Items In This Brand");
            return;
        }
        return;
    }

    public void searchByCategory(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Category Name: ");
        String category = scanner.nextLine();

        System.out.println(category + " Category :");
        int num = 1;
        for (Item item : items) {
            if (item.getCategory().equals(category)){
                System.out.println("Item " + (num++) + " : " + item.getName() + ", Price : " + item.getPrice());
            }
        }
        if (num == 1) {
            System.out.println("No Items In This Category");
            return;
        }
        return;
    }

    public void searchByBrand(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Brand Name: ");
        String brand = scanner.nextLine();

        System.out.println(brand + " Brand :");
        int num = 1;
        for (Item item : items) {
            if (item.getBrand().equals(brand)){
                System.out.println("Item " + (num++) + " : " + item.getName() + ", Price : " + item.getPrice());
            }
        }
        if (num == 1) {
            System.out.println("No Items In This Brand");
            return;
        }
        return;
    }

    public void itemDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();

        for (Item item : items) {
            if (item.getName().equals(itemName)){
                System.out.println("Name: " + item.getName());
                System.out.println("Brand: " + item.getBrand());
                System.out.println("Price: " + item.getPrice());
                System.out.println("Category: " + item.getCategory());
                System.out.println("Quantity: " + item.getQuantity());
                System.out.println("---------------------------------------------------------------------------");
                break;
            }
        }
        return;
    }

    public boolean removeItem(){return true;}

}
