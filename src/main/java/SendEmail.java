import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

public class SendEmail {

    public SendEmail(){
    }
    public void sendEmail(Message message) throws MessagingException {
        Transport.send(message);
    }
}
