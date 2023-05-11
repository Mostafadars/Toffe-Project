public class Payment {
    public void payWithCash(double amount, Address address) {
        System.out.println("Delivery Will Go To " + address.getApartmentNumber() + "-" + address.getHomeNumber() + "-" + address.getStreet());
        System.out.println("You Should Pay For Dlivery Man " + amount + " EGP Cash");
    }
}
