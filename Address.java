public class Address {
    private String street;
    private int homeNumber;
    private int apartmentNumber;

    public Address(String street, int homeNumber, int apartmentNumber) {
        this.street = street;
        this.homeNumber = homeNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }
}
