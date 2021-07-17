package pl.andus.MiniBox.Email;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class Functions {
    static Email email;

    public static void SendMail(String senderMail, String recieverMail, String subjectS, String messageS,
                                String serverS, Integer portS, String unameS, String passwdS) {
        email = EmailBuilder.startingBlank()
                .from(senderMail)
                .to(recieverMail)
                .withSubject(subjectS)
                .withPlainText(messageS)
                .buildEmail();
        MailerBuilder
                .withSMTPServer(serverS, portS, unameS, passwdS)
                .buildMailer()
                .sendMail(email);
    }
}
