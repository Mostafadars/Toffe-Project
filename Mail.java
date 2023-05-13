import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {
    private static int code = (int)(Math.random() * 9000 + 1000);

    public Mail(){}

    public static int getCode() {
        return code;
    }

    public static void sendMail(String recepient) throws MessagingException {
        System.out.println("Preparing To Send Email");

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "ma7952057@gmail.com";
        String password = "pwayzpmnwmukaile";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient);

        Transport.send(message);
        System.out.println("Message Sent Successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));

            message.setSubject("Toffee Activation Code");
            message.setText("This Is Your Toffee Activation Code : " + getCode());
            return message;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
