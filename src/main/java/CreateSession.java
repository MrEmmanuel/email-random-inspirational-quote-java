import javax.mail.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class CreateSession {

    Random random = new Random();

    public Message createSession(String to) throws MessagingException, FileNotFoundException {
        Configuration conf = new Configuration();
        Properties properties = CreateMessage.setProperties(conf.getServer(), conf.getPort(), conf.getLogin(), conf.getPassword());
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(conf.getLogin(), conf.getPassword());
            }
        });
        session.setDebug(true);
        Quotes quotes = new Quotes("quotes.txt");
        quotes.readQuotesFromFile();
        List<String> newQuotes = quotes.getQuotes();
        int number = random.nextInt(11);
        String quote = newQuotes.get(number);

        String subject = "Random Inspirational Quotes.";
        String[] information = new String[]{conf.getLogin(), to, subject, quote};
        Message message = CreateMessage.createMessage(session, information);

        return message;
    }
}
