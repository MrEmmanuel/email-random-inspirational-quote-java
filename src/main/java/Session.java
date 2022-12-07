import javax.mail.*;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Session {


    public Message createSession(String emailRecipient) throws MessagingException, FileNotFoundException {
        Configuration configuration = new Configuration();
        Properties properties = Content.setProperties(configuration.getServer(), configuration.getPort(), configuration.getLogin(), configuration.getPassword());
        javax.mail.Session session = javax.mail.Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(configuration.getLogin(), configuration.getPassword());
            }
        });
        session.setDebug(true);
        String login = configuration.getLogin();

        Message message = Content.createMessage(session, login, emailRecipient);

        return message;
    }
}
