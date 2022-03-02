package Vue;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CreateEmail {
	static Session mailSession;
	static MimeMessage emailMessage;

	public static void createEmailMessage(String email, int nombre) throws AddressException, MessagingException {
		String[] toEmails = { email };
		System.out.println("Receviers who will receive the mail are ");

		for (int i = 0; i < toEmails.length; i++) {
			System.out.println(toEmails[i]);
		}
		
		String emailSubject = "Mot de passe oublié Java";
		String emailBody = "Veuillez saisir ce code pour pouvoir saisir un nouveau mot de passe : " + nombre;

		mailSession = Session.getDefaultInstance(SNMPSetup.emailProperties, null);
		emailMessage = new MimeMessage(mailSession);

		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}

		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");// for a html email
	}

}
