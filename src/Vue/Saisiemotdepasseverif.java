package Vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Manager.Manager;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Saisiemotdepasseverif {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 * @param mail 
	 */
	/**
	 * Create the application.
	 */
	public Saisiemotdepasseverif(String mail) {
		initialize(mail);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String mail) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		textField = new JTextField();
		textField.setBounds(142, 97, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 48, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
				
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.setBounds(10, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Saisir code");
		lblNewLabel.setBounds(142, 10, 102, 13);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Code reçu :");
		lblNewLabel_1.setBounds(10, 51, 85, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Nouveau mdp :");
		lblNewLabel_2.setBounds(10, 100, 85, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(153, 215, 85, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager man = new Manager();
				String nouveauMdp = textField.getText();
				String code = textField_1.getText();
			String verif = man.getMdpVerif(mail, code, nouveauMdp);
			if(verif.equals("0")) {
				lblNewLabel_3 = new JLabel("Le code est incorrect !");
				lblNewLabel_3.setForeground(new Color(255, 0, 0));
				lblNewLabel_3.setBounds(51, 142, 244, 63);
				frame.getContentPane().add(lblNewLabel_3);
				frame.repaint();
			}
			else {
				connexion co = new connexion();
				frame.dispose();
			}
				
			}
		});
	}

}
