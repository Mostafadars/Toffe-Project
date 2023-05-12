import java.util.ArrayList;

public class Order {
    private int id;
    private LoggedInUser buyer;
    private ArrayList<Item> items = new ArrayList<Item>();
    private String orderHistory;
    private double totalPrice;

    public Order(int id, LoggedInUser buyer, ArrayList<Item> items) {
        this.id = id;
        this.buyer = buyer;
        this.items = items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBuyer(LoggedInUser buyer) {
        this.buyer = buyer;
    }

    public LoggedInUser getBuyer() {
        return buyer;
    }

    public void setItems(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setOrderHistory(String orderHistory) {
        this.orderHistory = orderHistory;
    }

    public String getOrderHistory() {
        return orderHistory;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void previousOrder(){}

    public double calculateTotalPrice(ArrayList<Item> cartItems) {
        double totalPrice = 0.0;

        for (Item item : cartItems) {
            totalPrice += item.getPrice();
        }

        return totalPrice;
    }

    public boolean reOrder(){return true;}
}
