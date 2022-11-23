import javax.mail.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class CreateSession {

    Random random = new Random();

    public Message createSession(String server, String port, String login, String password, String to) throws MessagingException, FileNotFoundException {

        Properties properties = CreateMessage.setProperties(server, port, login, password);
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(login, password);
            }
        });
        session.setDebug(true);
        Quotes quotes = new Quotes("quotes.txt");
        quotes.readQuotesFromFile();
        List<String> newQuotes = quotes.getQuotes();
        int number = random.nextInt(11);
        String quote = newQuotes.get(number);

        String subject = "Random Inspirational Quotes.";
        String[] information = new String[]{login, to, subject, quote};
        Message message = CreateMessage.createMessage(session, information);

        return message;
    }
}
