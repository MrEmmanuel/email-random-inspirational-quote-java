import javax.mail.*;
import java.io.FileNotFoundException;
import java.util.Map;



public class Main {
    public static void main(String[] args) throws FileNotFoundException, MessagingException {

        Configuration conf = new Configuration();
        Email email = new Email();
        CreateSession session = new CreateSession();
        String emailAddress = args[0];

        Message message = session.createSession(conf.getServer(), conf.getPort(), conf.getLogin(), conf.getPassword(), emailAddress);
        email.sendEmail(message);
    }
}
