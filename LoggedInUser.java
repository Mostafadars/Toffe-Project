import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LoggedInUser extends User{

    private ArrayList<Order> orders = new ArrayList<Order>();
    private ShoppingCart shoppingCart;

    public LoggedInUser(String userName, String email, String password, String phone, Address address) {
        super(userName, email, password, phone, address);
    }

    public LoggedInUser(){}


    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setOrders(Order order) {
        this.orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public boolean verifyLogin(){return true;}

    public void choosePayMethod(){}

    public void addToShoppingCart(Item item) {
        shoppingCart = getShoppingCart();
        shoppingCart.addItems(item);
        System.out.println("Item added to the shopping cart.");
    }


    public void pay(double amount){
        Payment payment = new Payment();
        payment.payWithCash(amount);
        System.out.println("Payment completed. Order will be paid upon delivery.");
    }

    public void makeOrder() {
        ShoppingCart shoppingCart = getShoppingCart();
        ArrayList<Item> cartItems = shoppingCart.getItems();

        if (cartItems.isEmpty()) {
            System.out.println("Your shopping cart is empty. Add items before making an order.");
            return;
        }

        // Create a new order
        Order newOrder = new Order();
        newOrder.setBuyer(this);
        for (Item item : cartItems)
            newOrder.setItems(item);
        newOrder.setTotalPrice(calculateTotalPrice(cartItems));

        // Add the order to the user's order list
        ArrayList<Order> userOrders = getOrders();
        userOrders.add(newOrder);

        // Close the shopping cart and create a new one for the user
        ShoppingCart newShoppingCart = new ShoppingCart();
        setShoppingCart(newShoppingCart);

        // Perform the order payment
        pay(newOrder.getTotalPrice());

        // Close the order
        closeOrder(newOrder);

        System.out.println("Order placed successfully!");
    }

    private double calculateTotalPrice(ArrayList<Item> cartItems) {
        return 0;
    }


    public void closeOrder(Order order) {
        order.setOrderHistory("Delivered");
        System.out.println("Order closed. Thank you for shopping with us!");
    }
}
