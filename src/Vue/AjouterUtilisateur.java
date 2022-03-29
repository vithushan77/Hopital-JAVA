package Vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Manager.Manager;
import Model.Administrateur;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AjouterUtilisateur {

	private JFrame frame;
	private JTextField textField_nom;
	private JTextField textField_prenom;
	private JTextField textField_mail;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_mdp;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					AjouterUtilisateur window = new AjouterUtilisateur();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public AjouterUtilisateur() {
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
		
		textField_nom = new JTextField();
		textField_nom.setBounds(150, 49, 96, 19);
		frame.getContentPane().add(textField_nom);
		textField_nom.setColumns(10);
		
		textField_prenom = new JTextField();
		textField_prenom.setBounds(150, 78, 96, 19);
		frame.getContentPane().add(textField_prenom);
		textField_prenom.setColumns(10);
		
		textField_mail = new JTextField();
		textField_mail.setBounds(150, 107, 96, 19);
		frame.getContentPane().add(textField_mail);
		textField_mail.setColumns(10);
		
		String s1[] = { "administrateur", "administratif", "patient", "infirmiere", "stock" }; 
		JComboBox comboBox = new JComboBox(s1);
		comboBox.setBounds(150, 165, 96, 21);
		frame.getContentPane().add(comboBox);
		
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(301, 232, 85, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrateur adm = new Administrateur(0, textField_nom.getText(),textField_prenom.getText(),textField_mail.getText(),textField_mdp.getText(), "1");
				adm.setNom(textField_nom.getText());
				adm.setPrenom(textField_prenom.getText());
				adm.setMail(textField_mail.getText());
				adm.setMdp(textField_mdp.getText());
				Object trucSelectionnee = comboBox.getSelectedItem();
				Manager man = new Manager();
				man.connexionbdd();
				man.inscriptionutilisateur(adm, trucSelectionnee);
				administrateur cra = new administrateur();
				cra.run();
				frame.dispose();

			}
		});
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.setBounds(10, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Utilisateur_vue cra = new Utilisateur_vue();
				cra.run();
				frame.dispose();
				}
		});
		
		JLabel lblNewLabel = new JLabel("Ajout utilisateur");
		lblNewLabel.setBounds(150, 10, 132, 13);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(49, 52, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setBounds(50, 81, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Mail");
		lblNewLabel_3.setBounds(50, 110, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_mdp = new JTextField();
		textField_mdp.setBounds(150, 136, 96, 19);
		frame.getContentPane().add(textField_mdp);
		textField_mdp.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe");
		lblNewLabel_4.setBounds(50, 139, 90, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Status");
		lblNewLabel_5.setBounds(50, 169, 45, 13);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
