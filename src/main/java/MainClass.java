import javax.mail.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;


public class MainClass {
    public static void main(String[] args) throws FileNotFoundException, MessagingException {
        Random random = new Random();
        SendEmail email = new SendEmail();
        Map<String, String> env = System.getenv();
        String login = env.get("SMTP_LOGIN");
        String server = env.get("SMTP_SERVER");
        String port = env.get("SMTP_PORT");
        String password = env.get("SMTP_PASSWORD");

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

        String to = args[0];
        String subject = "Random Inspirational Quotes.";
        String[] information = new String[]{login, to, subject, quote};
        Message message = CreateMessage.createMessage(session, information);

        EmailRandomInspirationalQuote randomEmail = new EmailRandomInspirationalQuote(email);
        randomEmail.sendEmail(message);
    }
}
