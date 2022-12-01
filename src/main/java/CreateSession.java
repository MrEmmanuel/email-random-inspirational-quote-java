import javax.mail.*;
import java.io.FileNotFoundException;
import java.util.Properties;

public class CreateSession {


    public Message createSession(String emailRecipient) throws MessagingException, FileNotFoundException {
        Configuration configuration = new Configuration();
        Properties properties = CreateMessage.setProperties(configuration.getServer(), configuration.getPort(), configuration.getLogin(), configuration.getPassword());
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(configuration.getLogin(), configuration.getPassword());
            }
        });
        session.setDebug(true);
        String login = configuration.getLogin();

        Message message = CreateMessage.createMessage(session, login, emailRecipient);

        return message;
    }
}
