import javax.mail.Message;
import javax.mail.MessagingException;

public class EmailRandomInspirationalQuote {

    private SendEmail email;
    public EmailRandomInspirationalQuote(SendEmail sendEmail) {
        this.email = sendEmail;
    }

    public void sendEmail(Message message) throws MessagingException {
        this.email.sendEmail(message);
    }


}
