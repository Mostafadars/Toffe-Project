public class Payment {
    public void payWithCash(double amount, Address address) {
        System.out.println("Delivery Will Go To Apartment No. " + address.getApartmentNumber() + " - Home No. " + address.getHomeNumber() + " - In " + address.getStreet() + " Street.");
        System.out.println("You Should Pay For Delivery Man " + amount + " EGP Cash");
    }
}
