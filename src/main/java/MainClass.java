import javax.mail.Authenticator;
import javax.mail.Session;
import java.util.Map;
import java.util.Properties;

public class MainClass {
    public static void main(String[] args){
        //MessageTransport transport = new MessageTransport();
        SendEmail email = new SendEmail();

        Map<String, String> env = System.getenv();
        String login = env.get("SMTP_LOGIN");
        String server = env.get("SMTP_SERVER");
        String port = env.get("SMTP_PORT");
        String password = env.get("SMTP_PASSWORD");

        Properties prop = setProperties(server, port, login, password);
        Session session = Session.getInstance(prop, new Authent icator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(login, password);
            }
        });
        session.setDebug(true);

        Quotes quotes = new Quotes("quotes.txt");
        quotes.readQuotesFile();
        List<String> theQuotes = quotes.getQuotes();
        String quote = theQuotes.get(0);

        String to = args[0];
        String subject = "Random Inspirational Quotes.";
        String[] info = new String[]{login, to, subject, quote};
        Message message = createMessage(session, info);

        RandomEmail randomEmail = new RandomEmail(emailEngine);
        randomEmail.sendEmail(message);
    }


    private static Message createMessage(Session session, String[] info) throws MessagingException {
        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(info[0]));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(info[1]));
        message.setSubject(info[2]);
        String msg = info[3];
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        message.setContent(multipart);

        return message;
    }

    public static Properties setProperties(String server, String port, String login, String password){
        Properties prop = System.getProperties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", server);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.user", login);
        prop.put("mail.smtp.password", password);
        prop.put("mail.smtp.ssl.trust", server);
        return prop;
    }

    }
}
