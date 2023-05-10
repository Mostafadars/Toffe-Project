import java.util.ArrayList;

public class LoggedInUser extends User{
    private String userName;
    private String email;
    private String password;
    private int phone;
    private Address address;
    private ArrayList<Order> orders = new ArrayList<Order>(null);
    private ShoppingCart shoppingCart;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
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

    public void makeOrder(){}

    public void addToShoppingCart(){}

    public void pay(){}
}
