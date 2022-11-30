import javax.mail.*;
import java.io.FileNotFoundException;
import java.util.Map;



public class Main {
    public static void main(String[] args) throws FileNotFoundException, MessagingException {

        Email email = new Email();
        CreateSession session = new CreateSession();

        Map<String, String> env = System.getenv();
        String login = env.get("SMTP_LOGIN");
        String server = env.get("SMTP_SERVER");
        String port = env.get("SMTP_PORT");
        String password = env.get("SMTP_PASSWORD");
        String emailAddress = args[0];

        Message message = session.createSession(server, port, login, password, emailAddress);
        email.sendEmail(message);
    }
}
