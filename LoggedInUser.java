import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LoggedInUser extends User{

    protected String userName;
    protected String email;
    protected String password;
    protected String phone;
    protected Address address = new Address();
    private ArrayList<Order> orders = new ArrayList<Order>();
    private ShoppingCart shoppingCart = new ShoppingCart();

    public LoggedInUser(){}

    public LoggedInUser(String userName, String email, String password, String phone, Address address) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

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

    public void addToShoppingCart(Item item) {
        shoppingCart.addItems(item);
        System.out.println("Item Added To The Shopping Cart.");
    }


    public void pay(double amount){
        Payment payment = new Payment();
        payment.payWithCash(amount, this.address);
        System.out.println("Payment Completed. Order Will Be Paid Upon Delivery.");
    }

    public void makeOrder(int id) {
        shoppingCart = getShoppingCart();
        ArrayList<Item> cartItems = shoppingCart.getItems();

        if (cartItems.isEmpty()) {
            System.out.println("Your Shopping Cart Is Empty. Add Items Before Making An Order.");
            return;
        }

        // Show Items In Orde
        int num = 1;
        System.out.println("You Order Has Items : ");
        for (Item item : cartItems) {
            System.out.println((num++) + ". " + item.getName());
        }

        // Create a new order
        Order newOrder = new Order(id, this, cartItems);
        newOrder.setTotalPrice(newOrder.calculateTotalPrice(cartItems));

        // Add the order to the user's order list
        ArrayList<Order> userOrders = getOrders();
        userOrders.add(newOrder);

        // Perform the order payment
        pay(newOrder.getTotalPrice());

        // Close the order
        closeOrder(newOrder);

        System.out.println("Order Placed Successfully!");
    }

    public void closeOrder(Order order) {
        order.setOrderHistory("Order Delivered");
        System.out.println("Order Closed. Thank You For Shopping With Us!");
        System.out.println("Signature : Toffee Shop");
    }

    public void showDetails() {
        System.out.println("Name : " + userName);
        System.out.println("Email : " + email);
        System.out.println("Phone : " + phone);
        System.out.println("Address : Apartment #" + address.getApartmentNumber() + " - Home #" + address.getHomeNumber() + " - " + address.getStreet() + " Street");
    }

    public void choosePayMethod(){}
}
