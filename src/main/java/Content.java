import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;


public class Content {

    private static Random random = new Random();

    public static Message createMessage(Session session, String login, String emailRecipient) throws MessagingException, FileNotFoundException {

        Quotes quotes = new Quotes("quotes.txt");
        quotes.readQuotesFromFile();
        List<String> newQuotes = quotes.getQuotes();
        int number = random.nextInt(11);
        String quote = newQuotes.get(number);
        String subject = "Random Inspirational Quotes.";

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(login));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(emailRecipient));
        message.setSubject(subject);
        message.setText(quote);

        return message;
    }
    public static Properties setProperties(String server, String port, String login, String password){
        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", server);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.user", login);
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.ssl.trust", server);
        return properties;
    }
}
