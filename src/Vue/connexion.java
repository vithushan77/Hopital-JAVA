package Vue;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;


import Manager.Manager;
import Model.Utilisateur;

public class connexion {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private String test;

	/**
	 * Launch the application.
	 */


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connexion window = new connexion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public connexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		textField = new JTextField();
		textField.setBounds(151, 27, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);



		JPasswordField password = new JPasswordField();
		password.setBounds(151, 77, 130, 26);
		frame.getContentPane().add(password);

		JLabel lblNewLabel = new JLabel("Mail/ Identifiant :");
		lblNewLabel.setBounds(19, 32, 120, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mot de passe :");
		lblNewLabel_1.setBackground(new Color(0, 191, 255));
		lblNewLabel_1.setBounds(19, 82, 103, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilisateur ut = new Utilisateur(0, textField.getText(),password.getText(), null, null, null);
				ut.setMail(textField.getText());
				ut.setMdp(password.getText());
				Manager ma = new Manager();
				test = ma.connexionuser(ut);
				System.out.println(test);
				if(test.equals("admin")) {
					admin ad = new admin();
					ad.run();
					frame.dispose();
				}
				if(test.equals("administratif")) {
					administratif adm = new administratif();
					adm.run();
					frame.dispose();
				}
				if(test.equals("administrateur")) {
					administrateur admi = new administrateur();
					admi.run();
					frame.dispose();
				}
				/*if(test.equals("infirmiere")) {
					infirmiere if = new infirmiere();
					if.run();
					frame.dispose();
				}*/
				else {
					JLabel lblNewLabel_2 = new JLabel("Email inexistant ou mot de passe incorrect !");
					lblNewLabel_2.setForeground(Color.RED);
					lblNewLabel_2.setBounds(19, 119, 262, 14);
					frame.getContentPane().add(lblNewLabel_2);
					frame.repaint();
					}
			}
		});
		btnNewButton.setBounds(293, 143, 117, 29);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Mot de passe oublié");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				motdepasseoublie mdp = new motdepasseoublie();
				mdp.run();
				frame.dispose();
				}
		});
		btnNewButton_1.setBounds(6, 143, 159, 29);
		frame.getContentPane().add(btnNewButton_1);


	}


}
