import java.util.ArrayList;

public class ShoppingCart {
    private int cartId;
    private ArrayList<Item> items = new ArrayList<Item>(null);
    private LoggedInUser loggedInUser;
    private ArrayList<Order> orders = new ArrayList<Order>(null);

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCartId() {
        return cartId;
    }

    public void addItems(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public void setOrders(Order order) {
        this.orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void updateQuantity(int quantity){}

    public void showDetails(){}

    public void checkOut(){}

    public boolean clearCart(){return true;}
}
