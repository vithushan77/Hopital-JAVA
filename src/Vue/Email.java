package Vue;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class Email {

	public static void main(String args[]) throws AddressException, MessagingException {
		SNMPSetup.setMailServerProperties();
		CreateEmail.createEmailMessage();
		SendEmail.sendEmail();
	}

}