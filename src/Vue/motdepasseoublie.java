package Vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Manager.Manager;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JButton;
import java.awt.Color;

public class motdepasseoublie {

	private JFrame frame;
	private JTextField textField;
	private int validationMail;
	private int nombre = 999;
	private int nombreRandom;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					motdepasseoublie window = new motdepasseoublie();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public motdepasseoublie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mot de passe oublié");
		lblNewLabel.setBounds(149, 10, 172, 13);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(167, 76, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(167, 130, 85, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mail = textField.getText();
				CreateEmail email = new CreateEmail();
				try {
					Random ran = new Random();
					nombreRandom = nombre + (int)(Math.random() * ((9999 - 5) + 1));
					System.out.println(nombreRandom);
					SNMPSetup.setMailServerProperties();
					email.createEmailMessage(mail, nombreRandom);
					SendEmail.sendEmail();
					Manager man = new Manager();
					man.UpdateVerifMdp(mail, nombreRandom);
					validationMail = 1;
					if(validationMail == 1) {
					JLabel lblNewLabel_1 = new JLabel("Un mail été envoyé verifiez vos spams.");
					lblNewLabel_1.setForeground(new Color(0, 128, 0));
					lblNewLabel_1.setBounds(89, 182, 275, 47);
					frame.getContentPane().add(lblNewLabel_1);
					frame.repaint();
					}
					
				} catch (AddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Saisiemotdepasseverif mdpv = new Saisiemotdepasseverif(mail);
				frame.dispose();
				
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.setBounds(10, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
	
	}

}
