// This is main class of the program. It creates an object of ToffeeSystem class and calls its menu method.

import javax.mail.MessagingException;

public class Main {
    public static void main(String args[]) throws MessagingException {
        ToffeeSystem toffeeSystem = new ToffeeSystem();
        toffeeSystem.menu();
    }
}
