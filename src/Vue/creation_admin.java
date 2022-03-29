package Vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Manager.Manager;
import Model.Utilisateur;
import Model.Administrateur;

import javax.swing.JButton;

public class creation_admin {

	private JFrame frame;
	private JTextField textField_nom;
	private JTextField textField_prenom;
	private JTextField textField_mail;
	private JTextField textField_mdp;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					creation_admin window = new creation_admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public creation_admin() {
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
		
		JLabel lblNewLabel = new JLabel("Ajouter un administrateur");
		lblNewLabel.setBounds(155, 10, 137, 13);
		frame.getContentPane().add(lblNewLabel);
		
		textField_nom = new JTextField();
		textField_nom.setBounds(155, 33, 96, 19);
		frame.getContentPane().add(textField_nom);
		textField_nom.setColumns(10);
		
		textField_prenom = new JTextField();
		textField_prenom.setBounds(155, 62, 96, 19);
		frame.getContentPane().add(textField_prenom);
		textField_prenom.setColumns(10);
		
		textField_mail = new JTextField();
		textField_mail.setBounds(155, 91, 96, 19);
		frame.getContentPane().add(textField_mail);
		textField_mail.setColumns(10);
		
		textField_mdp = new JTextField();
		textField_mdp.setBounds(155, 120, 96, 19);
		frame.getContentPane().add(textField_mdp);
		textField_mdp.setColumns(10);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(155, 216, 85, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrateur adm = new Administrateur(0, textField_nom.getText(),textField_prenom.getText(),textField_mail.getText(),textField_mdp.getText(), "1");
				adm.setNom(textField_nom.getText());
				adm.setPrenom(textField_prenom.getText());
				adm.setMail(textField_mail.getText());
				adm.setMdp(textField_mdp.getText());
				Manager man = new Manager();
				man.connexionbdd();
				man.inscriptionadmin(adm);
				administrateur cra = new administrateur();
				cra.run();
				frame.dispose();

			}
		});
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.setBounds(10, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(48, 36, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setBounds(48, 65, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mail");
		lblNewLabel_3.setBounds(48, 94, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe");
		lblNewLabel_4.setBounds(48, 123, 66, 13);
		frame.getContentPane().add(lblNewLabel_4);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				administrateur cra = new administrateur();
				cra.run();
				frame.dispose();
				}
		});
	}
}
