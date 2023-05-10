import java.util.ArrayList;

public class Catalog {
    private ArrayList<Item> items = new ArrayList<Item>(null);

    public void setItems(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void showGoods() {
        for (Item item : items) {
            System.out.println("Name: " + item.getName());
            System.out.println("Brand: " + item.getBrand());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Category: " + item.getCategory());
            System.out.println("Discount: " + item.getDiscount());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("-----------------------");
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
