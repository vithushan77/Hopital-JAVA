package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Model.Utilisateur;

import java.awt.Font;

public class ajoututilisateur {

	private JFrame frame;
	private JTextField textField_nom;
	private JTextField textField_prenom;
	private JTextField textField_mail;
	private JTextField textField_mdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajoututilisateur window = new ajoututilisateur();
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
	public ajoututilisateur() {
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
		
		JLabel lblNewLabel = new JLabel("Ajout utilisateur");
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.ITALIC));
		lblNewLabel.setBounds(161, 19, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(29, 62, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
	
		JLabel lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setBounds(29, 100, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mail");
		lblNewLabel_3.setBounds(29, 135, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mot de passe");
		lblNewLabel_4.setBounds(29, 173, 61, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_nom = new JTextField();
		textField_nom.setBounds(150, 57, 130, 26);
		frame.getContentPane().add(textField_nom);
		textField_nom.setColumns(10);
		
		textField_prenom = new JTextField();
		textField_prenom.setBounds(150, 95, 130, 26);
		frame.getContentPane().add(textField_prenom);
		textField_prenom.setColumns(10);
		
		textField_mail = new JTextField();
		textField_mail.setBounds(150, 130, 130, 26);
		frame.getContentPane().add(textField_mail);
		textField_mail.setColumns(10);
		
		textField_mdp = new JTextField();
		textField_mdp.setBounds(150, 168, 130, 26);
		frame.getContentPane().add(textField_mdp);
		textField_mdp.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Ajouter");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilisateur ajut = new Utilisateur();
				ajut.setNom(textField_nom.getText());
				ajut.setPrenom(textField_prenom.getText());
				ajut.setMail(textField_mail.getText());
				ajut.setMdp(textField_mdp.getText());

			}
		});
		btnNewButton_3.setBounds(296, 225, 117, 29);
		frame.getContentPane().add(btnNewButton_3);
	}

}
