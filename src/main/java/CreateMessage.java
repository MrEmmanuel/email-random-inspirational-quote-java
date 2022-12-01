import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;


public class CreateMessage {

    public static Message createMessage(Session session, String[] info) throws MessagingException {
        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(info[0]));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(info[1]));
        message.setSubject(info[2]);
        message.setText(info[3]);

        return message;
    }
    public static Properties setProperties(String server, String port, String login, String password){
        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", server);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.user", login);
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.ssl.trust", server);
        return properties;
    }
}
