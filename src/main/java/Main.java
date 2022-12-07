import javax.mail.*;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException, MessagingException {

        Email email = new Email();
        Session session = new Session();
        
        Message message = session.createSession(args[0]);
        email.sendEmail(message);
    }
}
