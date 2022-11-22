import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static org.mockito.Mockito.*;

public class EmailRandomInspirationQuoteTest {

    @Test
    @DisplayName("This should test if an email is sent at least once")
    void sendEmailTest() throws MessagingException {
        SendEmail sendEmailMock = mock(SendEmail.class);
        Properties propertiesMock = mock(Properties.class);
        Session session = Session.getInstance(propertiesMock, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("login", "password");
            }
        });
        Message message = new MimeMessage(session);
        EmailRandomInspirationalQuote randomEmail = new EmailRandomInspirationalQuote(sendEmailMock);
        randomEmail.sendEmail(message);
        verify(sendEmailMock, times(1)).sendEmail(message);
    }

}
