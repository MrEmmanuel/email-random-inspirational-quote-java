import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static org.mockito.Mockito.*;

public class EmailTest {

    @Test
    @DisplayName("This should test if an email is sent at least once")
    void sendEmailTest() throws MessagingException {
        Email sendEmailMock = mock(Email.class);
        Properties propertiesMock = mock(Properties.class);
        Session session = Session.getInstance(propertiesMock, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("login", "password");
            }
        });
        Message message = new MimeMessage(session);
        sendEmailMock.sendEmail(message);
        verify(sendEmailMock, times(1)).sendEmail(message);
    }

}
